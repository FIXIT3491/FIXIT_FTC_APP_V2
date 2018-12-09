package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.opmodesupport.TeleOpMode;
import org.firstinspires.ftc.teamcode.robots.Armstrong;
@TeleOp


public class ArmstrongTeleop extends TeleOpMode {
    Armstrong armstrong;
    @Override
    public void initialize() {

        armstrong = new Armstrong();

        telemetry.addData("Status", "Initialized");
    }


    @Override
    public void loopOpMode() {


        if (joy1.rightTrigger()){
            telemetry.addData("Status", "Slow Mode");
            armstrong.driveL(gamepad1.left_stick_y/4);
            armstrong.driveR(gamepad1.right_stick_y/4);
            telemetry.addData("slow left", gamepad1.left_stick_y);
            telemetry.addData("Slow right", gamepad1.right_stick_y);

        }

        if (joy1.leftTrigger()){
            telemetry.addData("Status", "Reverse");
            armstrong.driveR(-gamepad1.left_stick_y);
            armstrong.driveL(-gamepad1.right_stick_y);
        }

        if (!joy1.leftTrigger()){
            if (!joy1.rightTrigger()) {
                telemetry.addData("Status", "Normal Driving");
                armstrong.driveL(gamepad1.left_stick_y);
                armstrong.driveR(gamepad1.right_stick_y);
            } //if !rightTrigger
        } // If !leftTrigger




        //lifter
        if (joy2.rightBumper()) {
            armstrong.lifterUp();
        }
        else if(joy2.rightTrigger()){
            armstrong.lifterDown();
        }
        else {
            armstrong.lifterStop();
        }


        //latcher
        if (joy2.leftBumper()) {
            armstrong.setLatch();
        }
        else if (joy2.leftTrigger()){
            armstrong.unlatch();
        }




        //markera and wall
        if(joy2.buttonY()){
            armstrong.markUp();
        }
        else if(joy2.buttonA()){
            armstrong.markDown();
        }



        //SWEEP
        if (joy2.buttonB()){
            armstrong.SweepPush();
        }
        if (joy2.buttonX()){
            armstrong.SweepPull();
        }
        else{
            armstrong.SweepStop();
        }


        //Wall-E!!!





    }
}

