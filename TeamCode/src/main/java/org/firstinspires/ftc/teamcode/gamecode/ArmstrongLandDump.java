package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.opmodesupport.AutoOpMode;
import org.firstinspires.ftc.teamcode.robots.Armstrong;
@Autonomous
public class ArmstrongLandDump extends AutoOpMode {
    @Override

    public void runOp() throws InterruptedException {
        //init phase
        Armstrong armstrong = new Armstrong();
        armstrong.wallUp();
        telemetry.addData("Status", "Initialized");
        waitForStart();
        //this is after the driver presses play
        armstrong.lifterUp();
        sleep(8000);
        armstrong.lifterStop();

        armstrong.unlatch();
        sleep(1000);

        armstrong.backward(0.5);
        sleep(600);
        armstrong.motorL.stop();
        armstrong.motorR.stop();

        armstrong.wallDown();
        sleep(1000);
        telemetry.addData("Status", "WallDown");

        armstrong.stop();






    }
}
