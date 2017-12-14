package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.opmodesupport.AutoOpMode;
import org.firstinspires.ftc.teamcode.robots.Felix;

/**
 * Created by Aila on 2017-12-10.
 */

@Autonomous
public class FelixSimpleAuto extends AutoOpMode {

    private Felix felix = null;

    @Override
    public void runOp() throws InterruptedException {

        felix = new Felix();

        waitForStart();

        felix.holdGlyph();
        sleep(1000);
        felix.releaseGlyph();
        sleep(1000);

        felix.imuTurnR(90, 0.4);
        sleep(1000);

        felix.forwardDistance(100, 0.4);
        sleep(1000);
    }
}
