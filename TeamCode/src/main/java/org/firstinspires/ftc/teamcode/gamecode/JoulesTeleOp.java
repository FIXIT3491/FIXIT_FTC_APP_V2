package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RC;
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
        if (joy1.buttonA()) {
            joules.DriveForward(0.5);
        }
        joules.Stop();

        if(joy1.buttonB()){
            joules.StrafeLeft(0.5);
        }
        joules.Stop();

        if (joy1.buttonY()){
            joules.TurnLeft(0.5);
        }
        joules.Stop();

        if (joy1.buttonA()){
            joules.DriveBackward(0.5);}
        joules.Stop();

        if(joy1.buttonB()){
            joules.StrafeRight(0.5);
        }
        joules.Stop();

        if (joy1.buttonY()) {
            joules.TurnRight(0.5);
        }
        joules.Stop();

        joules.DriveForward(gamepad1.left_stick_y*1.5);
        joules.StrafeLeft(gamepad1.left_stick_x*1.5);
        joules.TurnLeft(gamepad1.right_stick_x*1.5);

        //gamepad 1 right stick is not working rn

    }
}
