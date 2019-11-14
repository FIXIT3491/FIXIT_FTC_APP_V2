package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.opmodesupport.AutoOpMode;
import org.firstinspires.ftc.teamcode.robots.Joules;
import com.qualcomm.robotcore.hardware.ColorSensor;
import org.firstinspires.ftc.teamcode.RC;

@Autonomous
public class ColourSensorTes extends AutoOpMode {
    public void runOp() throws InterruptedException {
        Joules joules = new Joules();
        ColorSensor colorSensor;

        telemetry.addData("Status", "initialized");
        colorSensor = hardwareMap.colorSensor.get("color");

        waitForStart();
        while (opModeIsActive()) {
            //RC.t.addData("bLUE", colorSensor.blue());
            //RC.t.addData("rED", colorSensor.red());
            //RC.t.addData("Green", colorSensor.green());
            //RC.t.addData("Luminosity", colorSensor.alpha());
            //RC.t.addData("combined colour value", colorSensor.argb());

            while (colorSensor.argb() < 10){
                joules.DriveBackward(0.5);
            }
            if (colorSensor.argb() > 10) {
                RC.t.addData("True");
                while (colorSensor.red() > 20) {
                    joules.DriveBackward(0.3);
                    RC.t.addData("backwards");
                }
                joules.Stop();
                RC.t.addData("stop");
                //here add the skystone grabber to go down
            }
        }
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
