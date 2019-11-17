package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.RC;
import org.firstinspires.ftc.teamcode.opmodesupport.AutoOpMode;
import org.firstinspires.ftc.teamcode.robots.Joules;

@Autonomous
public class Joulestest extends AutoOpMode {
    public void runOp() throws InterruptedException {
        Joules joules = new Joules();
        ColorSensor colorSensor;
        ColorSensor colorSensorDown;
        DistanceSensor StoneDist;
        int STRAFESTATE = 0;
        int STONESTATE = 0;
        int i = 1;

        telemetry.addData("Status", "initialized");
        colorSensor = hardwareMap.colorSensor.get("colour");
        colorSensorDown = hardwareMap.colorSensor.get("ColourDown");
        StoneDist = hardwareMap.get(DistanceSensor.class, "Distance");
        waitForStart();
        while(opModeIsActive()){
        RC.t.addData("blue", colorSensorDown.blue());}
//        while (opModeIsActive()) {
//            if (STONESTATE == 3) {
//                joules.StoneDown();
//                sleep(2500);
//                joules.StoneStop();
//                joules.StrafeRight(0.3);
//                sleep(1500);
//                joules.Stop();
//                STONESTATE = 4;
//            }
//            if (STONESTATE == 4) {
//                joules.DriveForward(0.5);
//                if (colorSensorDown.blue() > 330) {// if detect blue line
//                    STONESTATE = 5;
//                }
//
//                if (STONESTATE == 5) {
//                    if (i == 1) {
//                        joules.DriveForward(0.5);
//                        sleep(1000);
//                        joules.StoneUp();
//                        sleep(2000);
//                        joules.StoneStop();
//                        joules.Stop();
//                        i += 1;
//                    }
//                }
//
//            }
//        }

//       while (opModeIsActive()) {
//           RC.t.addData("Stone dist", StoneDist.getDistance(DistanceUnit.MM));
//           RC.t.addData("STRAFESTATE", STRAFESTATE);
//       }
//            //RC.t.addData("bLUE", colorSensor.blue());
//            RC.t.addData("rED", colorSensorDown.red());
//            //RC.t.addData("Green", colorSensor.green());
//               RC.t.addData("Luminosity", colorSensor.alpha());}
//            RC.t.addData("Distance", StoneDist.getDistance(DistanceUnit.MM));}
//
////            while (colorSensor.argb() < 10){
////                joules.DriveBackward(0.5);
////            }
////            if (colorSensor.argb() > 10) {
////                RC.t.addData("True");
////                while (colorSensor.red() > 20) {
////                    joules.DriveBackward(0.3);
////                    RC.t.addData("backwards");
////                }
////                joules.Stop();
////                RC.t.addData("stop");
////                //here add the skystone grabber to go down
////            }
//        }
        //maybe change to a double pronged 1f statment
        //if (argb sees a block and if red is small

//        while (colorSensor.alpha()>100){
//            joules.DriveBackward(0.3);
//            RC.t.addData("diving backwards");
//            }
//        joules.StoneDown();
//        sleep(1000);
//        joules.StrafeRight(0.2);
//        sleep(3000);
//        joules.Stop();
//        }

        //        while (opModeIsActive()) {
//            //RC.t.addData("bLUE", colorSensor.blue());
//            RC.t.addData("rED", colorSensorDown.red());
//            //RC.t.addData("Green", colorSensor.green());
//            //RC.t.addData("Luminosity", colorSensor.alpha());
//            //RC.t.addData("combined colour value", colorSensor.argb());
//
////            while (colorSensor.argb() < 10){
////                joules.DriveBackward(0.5);
////            }
////            if (colorSensor.argb() > 10) {
////                RC.t.addData("True");
////                while (colorSensor.red() > 20) {
////                    joules.DriveBackward(0.3);
////                    RC.t.addData("backwards");
////                }
////                joules.Stop();
////                RC.t.addData("stop");
////                //here add the skystone grabber to go down
////            }
//        }
            //maybe change to a double pronged 1f statment
            //if (argb sees a block and if red is small

//        while (colorSensor.alpha()>100){
//            joules.DriveBackward(0.3);
//            RC.t.addData("diving backwards");
//            }
//        joules.StoneDown();
//        sleep(1000);
//        joules.StrafeRight(0.2);
//        sleep(3000);
//        joules.Stop();
//        }

    }
}
