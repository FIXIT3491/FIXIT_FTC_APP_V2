package org.firstinspires.ftc.teamcode.gamecode;

import org.firstinspires.ftc.teamcode.opmodesupport.AutoOpMode;
import org.firstinspires.ftc.teamcode.robots.Armstrong;

public class Armstrongdriveauto extends AutoOpMode {
    @Override

    public void runOp() throws InterruptedException {
        //init phase
        Armstrong armstrong = new Armstrong();
        armstrong.wallUp();
        waitForStart();
        //this is after the driver presses play
        armstrong.lifterDown();
        sleep(90);
    }
}
