package org.firstinspires.ftc.teamcode.gamecode;

import org.firstinspires.ftc.teamcode.opmodesupport.AutoOpMode;
import org.firstinspires.ftc.teamcode.robots.Armstrong;


public class BangBang extends AutoOpMode {

    private int followdist;
    @Override
    public void runOp() throws InterruptedException {
        Armstrong armstrong = new Armstrong();
        followdist = 3000;
        waitForStart();
        while (opModeIsActive()) {


            if (armstrong.ultrasonic.getDistance() > 700) {
                //NOte to self, check
                armstrong.forward(0.3);
                sleep(100);
                armstrong.stop();
                break;
            }
            if (armstrong.ultrasonic.getDistance() < 3100){
                armstrong.slantforward(0.3, 0.2);
            }
            if (armstrong.ultrasonic.getDistance() > 3200){
                armstrong.slantforward(0.2, 0.3);
            }
        }
    }
}
