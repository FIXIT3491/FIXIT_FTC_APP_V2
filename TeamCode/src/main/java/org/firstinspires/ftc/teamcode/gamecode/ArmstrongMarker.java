package org.firstinspires.ftc.teamcode.gamecode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.teamcode.RC;
import org.firstinspires.ftc.teamcode.opmodesupport.AutoOpMode;
import org.firstinspires.ftc.teamcode.robots.Armstrong;

import java.util.List;

public class ArmstrongMarker extends AutoOpMode {
    public static final int LEFT = 1;
    public static final int CENTER = 2;
    public static final int RIGHT = 3;
    public static int mineralOri;
    private static final String TFOD_MODEL_ASSET = "RoverRuckus.tflite";
    private static final String LABEL_GOLD_MINERAL = "Gold Mineral";
    private static final String LABEL_SILVER_MINERAL = "Silver Mineral";
    private static final String VUFORIA_KEY = "ATU9MNz/////AAABmdp9yZ8JdEGjpiGfxU8g64YjAQPwRcIIIqytyWu9HmjEkTELwI1JsCtkFv/I4k2S8KXjgWFB61R+GwLPvY3T1EyQmpV/UFfaSEqcJLpT++NbMjv5JkXg3JG92Ga+RnHYS3WaTBgRZexhqar4QNK4exrzUQUJjy2ntF2Afb+ENqH4glLQW85aM0BA4+8WMjcplpZ5WbhJ82ruz0ikcpy8bffFnhd+pN1/xficoB/Szcx5lt1SmKzVjbYkktmVd8qS6qGd8yVH1DydPQlP6njcUDllIc1a3oAO5zmWTFoxfaknDOm2bXka6V2Qht6pD7pl1tSP3vgeCZPM0fKSowfy0MoFVzsuuBvwqloB4Obt4NDT";
    private VuforiaLocalizer vuforia;
    public TFObjectDetector tfod;

    @Override
    public void runOp() throws InterruptedException {
        //this is what was in init Vuforia
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();
        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraName = hardwareMap.get(WebcamName.class, "Webcam 1");
        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);
        //init Tensor Flow
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Pzarameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_GOLD_MINERAL, LABEL_SILVER_MINERAL);

       //init armstrong
        Armstrong armstrong = new Armstrong();

        if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
            initTfod();
        } else {
            telemetry.addData("Sorry!", "This device is not compatible with TFOD");
        }

        // Everything is initialized!
        telemetry.addData(">", "Press Play to start tracking");
        telemetry.update();
        waitForStart();
        // set mineral  = 1, 2 or 3
        clearTimer(1); //timer for how long to wait to find all 3 minerals
        clearTimer(2); //timer for how long to lower with the lift

        if (opModeIsActive()) {
            if (tfod != null) {
                tfod.activate();
            }

            while (opModeIsActive()) {
                if (tfod != null) {
                    // getUpdatedRecognitions() will return null if no new information is available since
                    // the last time that call was made.
                    List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                    if (updatedRecognitions != null) {
                        telemetry.addData("# Object Detected", updatedRecognitions.size());
                        if (updatedRecognitions.size() == 3) {
                            int goldMineralX = -1;
                            int silverMineral1X = -1;
                            int silverMineral2X = -1;
                            for (Recognition recognition : updatedRecognitions) {
                                if (recognition.getLabel().equals(LABEL_GOLD_MINERAL)) {
                                    goldMineralX = (int) recognition.getLeft();
                                } else if (silverMineral1X == -1) {
                                    silverMineral1X = (int) recognition.getLeft();
                                } else {
                                    silverMineral2X = (int) recognition.getLeft();
                                }
                            }
                            if (goldMineralX != -1 && silverMineral1X != -1 && silverMineral2X != -1) {
                                if (goldMineralX < silverMineral1X && goldMineralX < silverMineral2X) {
                                    telemetry.addData("Gold Mineral Position", "Left");
                                    mineralOri = LEFT;
                                    break;
                                } else if (goldMineralX > silverMineral1X && goldMineralX > silverMineral2X) {
                                    telemetry.addData("Gold Mineral Position", "Right");
                                    mineralOri = RIGHT;
                                    break;
                                } else {
                                    telemetry.addData("Gold Mineral Position", "Center");
                                    mineralOri = CENTER;
                                    break;
                                }
                            }
                        }
                        telemetry.update();

                        if (updatedRecognitions != null) {
                            if (updatedRecognitions.size() < 3) {
                                if (getSeconds(1) > 4) {
                                    armstrong.markDown();
                                    sleep(1000);
                                    //RC.t.addData("playing middle program anyways");
                                }//time
                            }//size
                        }//size null
                    }//null
                }
            }
        }

        if (tfod != null) {
            tfod.shutdown();
        }
        // lower the robot
        while (armstrong.magnetSensor.getState()) {
            telemetry.addData("Digital Touch", "Is Not Pressed");
            armstrong.lifterUp();
            armstrong.collectServoLeftSlow();
            armstrong.collectServoRightSlow();
            RC.t.addData(System.currentTimeMillis());
            //new untested
            if (getRuntime() > 1000){
                armstrong.unlatch();
                armstrong.lifterStop();
                armstrong.collectServoLeftStop();
                armstrong.collectServoRightStop();

                break;
            }
        }
        if (!armstrong.magnetSensor.getState()){
            telemetry.addData("Digital Touch", "Is Pressed");
            armstrong.unlatch();
        }
        //go forwards a li''l bit
        armstrong.forwardDistance(300,0.5);
        //lower depending on mineral
        if (mineralOri == LEFT){
            armstrong.LeftSample();
        }
        else if (mineralOri == CENTER){
            armstrong.MiddleSample();
        }
        else if (mineralOri == RIGHT){
            armstrong.RightSample();
        }
        //sample
        armstrong.forwardDistance(200, 0.5);
        //marker
        armstrong.markDown();
        sleep(1000);
        telemetry.addData("status","wall down");
        //crater
        //add bang-bang here
    }

}
