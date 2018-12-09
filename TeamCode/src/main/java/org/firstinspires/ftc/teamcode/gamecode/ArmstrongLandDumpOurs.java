package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.opmodesupport.AutoOpMode;
import org.firstinspires.ftc.teamcode.robots.Armstrong;

@Autonomous
public class ArmstrongLandDumpOurs extends AutoOpMode {
    @Override

    public void runOp() throws InterruptedException {
        //init phase
        Armstrong armstrong = new Armstrong();
        armstrong.markUp();
        telemetry.addData("Status", "Initialized");
        waitForStart();
        //this is after the driver presses play
        armstrong.lifterUp();
        sleep(10000);
        armstrong.lifterStop();

        armstrong.unlatch();
        sleep(1000);

        armstrong.backward(0.5);
        sleep(2000);
        armstrong.stop();

        armstrong.markDown();
        sleep(1000);
        telemetry.addData("Status", "WallDown");

        sleep(1000);

        armstrong.turnR(0.5);
        sleep(550);
        armstrong.motorL.stop();
        armstrong.motorR.stop();
        sleep(200);


//
        armstrong.backward(0.5);
        sleep(2250);



        armstrong.stop();


// to park turn 200 and forwards 30002

//change the other programs based on these ones the ones without land

    }
}
