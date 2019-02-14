package org.firstinspires.ftc.teamcode.gamecode;

import org.firstinspires.ftc.teamcode.newhardware.FXTSensors.FXTAnalogUltrasonicSensor;
import org.firstinspires.ftc.teamcode.opmodesupport.AutoOpMode;
import org.firstinspires.ftc.teamcode.robots.Armstrong;

public class UltrasonicTest extends AutoOpMode {
    @Override
    public void runOp() throws InterruptedException {
        Armstrong armstrong = new Armstrong();
        FXTAnalogUltrasonicSensor ultrasonic = new FXTAnalogUltrasonicSensor("ultrasonic");


        telemetry.addData("Status", "Initialized");


        waitForStart();
        //this is after the driver presses play
        telemetry.addData("Status", "Play");

        //Actual test stuff
        while (opModeIsActive()){

            telemetry.addData("ultrasonic", Math.round(ultrasonic.getDistance()));}


    }
}
