package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.opmodesupport.AutoOpMode;
import org.firstinspires.ftc.teamcode.robots.Joules;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.teamcode.RC;

@Autonomous
public class ColourSensorTes extends AutoOpMode {
    public void runOp() throws InterruptedException {
        Joules joules = new Joules();
        ColorSensor colorSensor;
        ColorSensor colorSensorDown;
        DistanceSensor StoneDist;
        int STONESTATE = 0;
        int STRAFESTATE = 0;

        telemetry.addData("Status", "initialized");
        colorSensor = hardwareMap.colorSensor.get("colour");
        colorSensorDown = hardwareMap.colorSensor.get("ColourDown");
        StoneDist = hardwareMap.get(DistanceSensor.class, "Distance");
        int a = 1;
        int i = 1;

        waitForStart();
        while (opModeIsActive()) {
            if (STONESTATE == 0) {
                if (i == 1) {
                    joules.StrafeLeft(0.4);
                    sleep(2200);
                    joules.Stop();
                    i += 1;
                }
                joules.DriveBackward(0.5); //go fast
                if (colorSensorDown.blue() > 330) {// if detect blue line
                    STONESTATE = 1;
                }
            }

            if (STONESTATE == 1) {// if detect red line
                RC.t.addData("Stone State", STONESTATE);
                //drive backwards fast
                if (a == 1) {
                    RC.t.addData("little forwards");
                    joules.DriveBackward(0.5);
                    sleep(1000);
                    a = a + 1; //makes this loop happen once
                }
                joules.DriveBackward(0.4);
                if (StoneDist.getDistance(DistanceUnit.MM) < 300) {//if detect row of stones
                    STONESTATE = 2;
                }


            }
            if (STONESTATE == 2) { //if detect row  of stones
                RC.t.addData("Stone State", STONESTATE);
                joules.Stop();
                //drive backwards medium
                if (STRAFESTATE == 0) {
                    joules.Stop();
                    joules.DriveBackward(0.2);
                    if (StoneDist.getDistance(DistanceUnit.MM) > 60) {
                        STRAFESTATE = 1;
                    } else if (colorSensor.alpha() < 145) { //if detect skystones
                        joules.Stop();
                        STONESTATE = 3;
                    }

                }

                if (STRAFESTATE == 1) {
                    joules.Stop();
                    joules.StrafeLeft(0.3);
                    if (StoneDist.getDistance(DistanceUnit.MM) < 60) {
                        STRAFESTATE = 0;
                    }
                }
                if (STONESTATE == 3) {
                    joules.StoneDown();
                    sleep(3000);
                    joules.StoneStop();
                    joules.StrafeRight(0.3);
                    sleep(1500);
                    joules.Stop();
                    STONESTATE = 4;
                }
                if (STONESTATE == 4) {
                    RC.t.addData("blue", colorSensorDown.blue());
                    joules.DriveForward(0.2);
                    if (colorSensorDown.blue() > 330) {// if detect blue line
                        RC.t.addData("blueee", colorSensorDown.blue());
                        STONESTATE = 5;
                    }
                }

                if (STONESTATE == 5) {
                    if (i == 1) {
                        joules.DriveForward(0.5);
                        sleep(1000);
                        joules.StoneUp();
                        sleep(2000);
                        joules.StoneStop();
                        joules.Stop();
                        i += 1;
                    }
                }




            }
        }

    }
}
