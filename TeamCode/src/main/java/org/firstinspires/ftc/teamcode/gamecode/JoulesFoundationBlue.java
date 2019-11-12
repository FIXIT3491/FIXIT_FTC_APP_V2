package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.opmodesupport.AutoOpMode;
import org.firstinspires.ftc.teamcode.robots.Joules;

@Autonomous
public class JoulesFoundationBlue extends AutoOpMode {
    public void runOp() throws InterruptedException {
        Joules joules = new Joules();

        telemetry.addData("Status", "initialized");
        waitForStart();


        joules.DriveBackward(0.5);
        sleep(1500);
        joules.Stop();

        joules.FoundationGrab();
        sleep(2000);
        joules.Stop();




    }


}
