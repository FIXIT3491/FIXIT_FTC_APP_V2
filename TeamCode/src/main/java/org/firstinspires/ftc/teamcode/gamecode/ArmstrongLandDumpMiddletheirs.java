package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.opmodesupport.AutoOpMode;
import org.firstinspires.ftc.teamcode.robots.Armstrong;

@Autonomous
public class ArmstrongLandDumpMiddletheirs extends AutoOpMode {
    @Override

    public void runOp() throws InterruptedException {
        //init phase
        Armstrong armstrong = new Armstrong();
        armstrong.markUp();
        telemetry.addData("Status", "Initialized");
        waitForStart();
        //this is after the driver presses play
        armstrong.lifterUp();
        armstrong.collectServoLeftSlow();
        armstrong.collectServoRightSlow();
        sleep(11000);
        armstrong.lifterStop();

        armstrong.unlatch();
        armstrong.armup();
        sleep(250);
        armstrong.armstop();

        armstrong.forward(0.5);
        sleep(2200);
        armstrong.stop();

        armstrong.markDown();
        sleep(1000);
        telemetry.addData("Status", "WallDown");

        sleep(1110);


        armstrong.turnL(0.3);
        sleep(808);

//
        armstrong.forward(0.5);
        sleep(2200);

        armstrong.markDown();



        armstrong.stop();




    }
}
