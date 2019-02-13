package org.firstinspires.ftc.teamcode.gamecode;

import org.firstinspires.ftc.teamcode.opmodesupport.AutoOpMode;
import org.firstinspires.ftc.teamcode.robots.Armstrong;

public class BangBang extends AutoOpMode {
    @Override
    public void runOp() throws InterruptedException {
        Armstrong armstrong = new Armstrong();

        waitForStart();
        if (armstrong.ultrasonic.getDistance() > 1500){
            //armstrong.
        }
    }
}
