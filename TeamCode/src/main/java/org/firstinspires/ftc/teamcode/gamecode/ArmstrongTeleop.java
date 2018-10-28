package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.opmodesupport.TeleOpMode;
import org.firstinspires.ftc.teamcode.robots.Armstrong;

@TeleOp
public class ArmstrongTeleop extends TeleOpMode {
    Armstrong armstrong;
    @Override
    public void initialize() {
        armstrong = new Armstrong();
    }

    @Override
    public void loopOpMode() {
        armstrong.driveR(joy1.y2());
        armstrong.driveL(joy1.y1());

        if (joy2.rightBumper() == true) {
            armstrong.lifterUp();
        }
        else if(joy2.rightTrigger() == true){
            armstrong.lifterDown();
        }
        else {
            armstrong.lifterStop();
        }

        if (joy2.leftBumper() == true) {
            armstrong.wallUp();
        }
        else if (joy2.leftTrigger() == true){
            armstrong.wallDown();
        }

    }
}
