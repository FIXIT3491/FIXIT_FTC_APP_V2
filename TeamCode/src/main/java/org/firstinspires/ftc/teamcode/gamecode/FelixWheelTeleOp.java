package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.opmodesupport.TeleOpMode;
import org.firstinspires.ftc.teamcode.robots.Felix;

/**
 * Created by Aila on 2017-12-06.
 */

@TeleOp
public class FelixWheelTeleOp extends TeleOpMode {

    private Felix bot;

    boolean reverse = false;

    @Override
    public void initialize() {
        bot = new Felix();
//        bot.init(hardwareMap);
        bot.stop();
    }

    @Override
    public void loopOpMode() {
        double driveLeft = joy1.y1();
        double driveRight = joy1.y2();

        double hands = gamepad2.left_trigger;

        if (joy1.rightTrigger()) {
            driveLeft = driveLeft * 0.4;
            driveRight = driveRight * 0.4;
        }

        if (joy1.leftTrigger()) {
            driveLeft = driveLeft * -1;
            driveRight = driveRight * -1;
        }

        bot.driveL(driveLeft);
        bot.driveR(driveRight);

        bot.wheelL.setPower(joy2.y1());
        bot.wheelR.setPower(joy2.y2());

        if (joy2.rightBumper()) {
            bot.glifter.setPower(1);
        } else if (joy2.rightTrigger()) {
            bot.glifter.setPower(-1);
        } else {
            bot.glifter.setPower(0);
        }//else


        if (joy2.y1() > 0.1) {
            bot.jewelL.setPosition(1);
        }
        if (joy2.y1() < -0.1) {
            bot.jewelL.setPosition(0.2);
        }
    }
}
