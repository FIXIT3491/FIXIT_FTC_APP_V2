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
        sleep(11000);
        armstrong.lifterStop();

        armstrong.unlatch();
        sleep(1000);

        armstrong.Downwall();
        sleep(100);

        armstrong.backward(0.5);
        sleep(2200);
        armstrong.stop();

        armstrong.markDown();
        sleep(1000);
        telemetry.addData("Status", "WallDown");

        sleep(1110);

        armstrong.imuTurnR(30, 0.5);
        armstrong.stop();
        sleep(200);


//
        armstrong.backward(0.5);
        sleep(2250);



        armstrong.stop();




    }
}
