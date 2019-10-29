package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.opmodesupport.TeleOpMode;
import org.firstinspires.ftc.teamcode.robots.Joules;

@TeleOp
public class JoulesTeleOp extends TeleOpMode {
    Joules joules;

    @Override
    public void initialize() {
        joules = new Joules();
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loopOpMode() {
        if (joy1.buttonA()){
            joules.DriveForward(0.5);}
        joules.Stop();

        if(joy1.buttonB()){
            joules.StrafeLeft(0.5);
        }
        joules.Stop();

        if (joy1.buttonY()){
            joules.TurnLeft(0.5);
        }
        joules.Stop();


        //joules.DriveForward(gamepad1.right_stick_y);
        //joules.StrafeLeft(gamepad1.right_stick_x);

    }
}
