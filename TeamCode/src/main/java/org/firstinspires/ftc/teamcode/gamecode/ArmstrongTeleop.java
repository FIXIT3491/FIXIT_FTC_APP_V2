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
        double leftPower;
        double rightPower;
        double slowleft;
        double slowright;
        leftPower  = gamepad1.left_stick_y;
        rightPower = gamepad1.right_stick_y;
        slowleft = gamepad1.left_stick_y/2;
        slowright = gamepad1.right_stick_y/2;





        if (joy1.rightTrigger()){
            telemetry.addData("Status", "Slow Mode");
            armstrong.driveL(slowleft);
            armstrong.driveR(slowright);
            telemetry.addData("slow left", slowleft);
            telemetry.addData("Slow right", slowright);

       }
       if (!joy1.rightTrigger()){
            armstrong.driveL(gamepad1.left_stick_y);
            armstrong.driveR(rightPower);
        }

        // normal speed


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

        //marker

        if(joy2.buttonY()){
            armstrong.wallUp();
        }
        else if(joy2.buttonA()){
            armstrong.wallDown();
        }


    }
}
