package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.opmodesupport.AutoOpMode;
import org.firstinspires.ftc.teamcode.robots.Armstrong;
@Autonomous
public class ArmstrongDump extends AutoOpMode {
    @Override

    public void runOp() throws InterruptedException {
        //init phase
        Armstrong armstrong = new Armstrong();
        armstrong.wallUp();
        telemetry.addData("Status", "Initialized");
        waitForStart();
        //this is after the driver presses play

        armstrong.backward(0.5);
        sleep(500);

        armstrong.wallDown();
        sleep(20);





    }
}
