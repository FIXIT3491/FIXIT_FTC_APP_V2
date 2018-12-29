package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.hardware.adafruit.AdafruitBNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorDigitalTouch;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.RC;
import org.firstinspires.ftc.teamcode.newhardware.Motor;
import org.firstinspires.ftc.teamcode.opmodesupport.AutoOpMode;
import org.firstinspires.ftc.teamcode.robots.Armstrong;
//import org.firstinspires.inspection.RcInspectionActivity;

@Autonomous
public class ArmstrongTest extends AutoOpMode {
    @Override

    public void runOp() throws InterruptedException {
        //init phase
        Armstrong armstrong = new Armstrong();





        // Send telemetry message to signify robot waiting;
        //telemetry.addData("Status", "Resetting Encoders");    //
        //telemetry.update();



        telemetry.addData("Status", "Initialized");






        waitForStart();
        //this is after the driver presses play
        telemetry.addData("Status", "Play");





//        while (opModeIsActive()) {
//            if (armstrong.digitalTouch.getState()) {
//                telemetry.addData("status", "not");
//            } else {
//                telemetry.addData("sa", "touched");
//            }
//
//        }

        armstrong.reverseDriveSystem();
        armstrong.imuTurnR(90, 0.5);


       // telemetry.addData('dklgjl', armstrong.driveL.getCurrentPosition());





//        armstrong.imuTurnR(180, 0.3);
//        while (opModeIsActive()) {
//            Orientation orient = armstrong.imu.getAngularOrientation();
//            telemetry.addData("first angle", orient.firstAngle)
//;
        }

//        while (opModeIsActive()){
//        RC.t.addData("LEFT", armstrong.motorL.getPosition());
//        RC.t.addData("RIGHT", armstrong.motorR.getPosition());
//        }


//
//        armstrong.forward(0.1);
//        sleep(500);
//        armstrong.stop();
//        sleep(100);
//        armstrong.forward(0.5);
//        sleep(500);
//        armstrong.stop();
//        sleep(100);
//        armstrong.forward(1);
//        sleep(500);
//        armstrong.stop();

            //armstrong.turnL(0.5);
            // sleep(250);

//

//        while (opModeIsActive()) {
//            Orientation orient = armstrong.imu.getAngularOrientation();
//
//            telemetry.addData("first angle",orient.firstAngle);
//            telemetry.addData("second angle", orient.secondAngle);
//            telemetry.addData("third angle", orient.thirdAngle);
//            telemetry.update();
//            sleep(10);
//        }
//


            //sleep(10);
            //armstrong.3(10);
            //sleep(1000);


        }

