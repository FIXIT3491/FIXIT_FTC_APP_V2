package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
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
        leftPower  = gamepad1.left_stick_y;
        rightPower = gamepad1.right_stick_y;


        if (joy1.rightTrigger()== true) {
            telemetry.addData("Status", "Slow Mode");
            armstrong.driveL(leftPower * 0.4);
            armstrong.driveR(rightPower * 0.4);
        }
        //slow Button
        else{
            armstrong.driveL(leftPower);
            armstrong.driveR(rightPower);
        }
        // normal speed


        //lifter
        if (joy2.rightBumper() == true) {
            armstrong.lifterUp();
        }
        else if(joy2.rightTrigger() == true){
            armstrong.lifterDown();
        }
        else {
            armstrong.lifterStop();
        }


        //latcher
        if (joy2.leftBumper() == true) {
            armstrong.setLatch();
        }
        else if (joy2.leftTrigger() == true){
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
