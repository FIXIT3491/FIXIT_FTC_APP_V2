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

        joules.DriveForward(gamepad1.left_stick_y*-2);
        joules.StrafeLeft(gamepad1.left_stick_x*-2);
        joules.TurnLeft(gamepad1.right_stick_x*2);

        //gamepad 1 right stick is not working rn

        joules.Wrist.setPower(gamepad2.left_stick_y);
        joules.ArmMotor.setPower(gamepad2.right_stick_y/2);

        if (joy2.buttonX()){
            joules.CapUp();
        }
        if (joy2.buttonB()){
            joules.CapDown();
        }

        if (joy2.buttonY()){
            joules.ArmXOut();
        }
        if (joy2.buttonA()){
            joules.ArmXIn();
        } else {
            joules.ArmXStop();
        }


        if (joy2.rightTrigger()){
            joules.ClawGrab();
        }
        if (joy2.rightBumper()){
            joules.ClawDrop();
        }

        if (joy2.leftTrigger()){
            joules.FoundationGrab();
        }
        if (joy2.leftBumper()){
            joules.FoundationDrop();
        }
    }
}
