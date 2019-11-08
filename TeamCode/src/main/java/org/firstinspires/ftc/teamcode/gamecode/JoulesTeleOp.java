package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.sun.tools.javac.util.Position;

import org.firstinspires.ftc.teamcode.RC;
import org.firstinspires.ftc.teamcode.opmodesupport.TeleOpMode;
import org.firstinspires.ftc.teamcode.robots.Joules;

@TeleOp
public class JoulesTeleOp extends TeleOpMode {
    Joules joules;

    @Override
    public void initialize() {
        joules = new Joules();
        joules.CapDown();
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loopOpMode() {

        joules.DriveBackward(gamepad1.left_stick_y*2);
        joules.StrafeRight(gamepad1.left_stick_x*2);
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

        //arm extention
        if (joy2.buttonY()){
            joules.ArmXOut();
        } else if (joy2.buttonA()){
            joules.ArmXIn();
        }
        else {
            joules.ArmXStop();
        }


        if (joy2.rightTrigger()){
            joules.ClawGrab();
            //joules.Claw.setPosition((joules.Claw.getPosition()-0.1));
            //RC.t.addData("Current claw position!", joules.Claw.getPosition());
            //RC.t.addData("Claw postion", (joules.Claw.getPosition()-0.1));
        }
        if (joy2.rightBumper()){
            joules.ClawDrop();
            //if (joules.Claw.getPosition() == 0  1);
            //joules.Claw.setPosition(joules.Claw.getPosition()+0.2);
            //RC.t.addData("current claw position", joules.Claw.getPosition());
            //RC.t.addData("claws postiont", (joules.Claw.getPosition()+0.1));
            //maybe add a sleep?
        }

        if (joy2.buttonDown()){
            joules.Claw.setPosition(0.6);
        }

        if (joy2.leftTrigger()){
            joules.FoundationGrab();
        }
        else if (joy2.leftBumper()){
            joules.FoundationDrop();
        }
    }
}
