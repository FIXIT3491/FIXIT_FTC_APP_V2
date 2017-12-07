package org.firstinspires.ftc.teamcode.gamecode;

import org.firstinspires.ftc.teamcode.opmodesupport.TeleOpMode;
import org.firstinspires.ftc.teamcode.robots.Felix;

/**
 * Created by Aila on 2017-12-06.
 */

public class FelixTeleOp extends TeleOpMode {

    private Felix bot;

    boolean reverse = false;

    @Override
    public void initialize() {
        bot = new Felix();
        bot.stop();
    }

    @Override
    public void loopOpMode() {
        double driveLeft = joy1.y1();
        double driveRight = joy1.y2();

        double glifter = -gamepad2.right_stick_y;
        double hands = Math.abs(gamepad2.left_trigger);

        bot.driveL.setPower(driveLeft);
        bot.driveR.setPower(driveRight);

        if (joy1.buttonX() && !reverse){
            reverse = true;
        }
        else if (joy1.buttonX() && reverse){
            reverse = false;
        }

        if (joy1.rightTrigger() | joy1.leftTrigger()){
            bot.driveL.setPower(0.4 * driveLeft);
            bot.driveR.setPower(0.4 * driveLeft);
        }

        if (reverse) {
            bot.driveL.setPower(-driveLeft);
            bot.driveR.setPower(-driveRight);
        }

        bot.glifter.setPower(glifter);

        if (hands > 0.1) {
            bot.handL.setPower(-0.9);
            bot.handR.setPower(0.9);
        }
        else {
            bot.handL.setPower(0.7);
            bot.handR.setPower(-0.7);
        }
    }
}
