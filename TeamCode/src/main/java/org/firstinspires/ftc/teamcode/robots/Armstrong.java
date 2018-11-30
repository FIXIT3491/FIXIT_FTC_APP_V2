package org.firstinspires.ftc.teamcode.robots;

import com.qualcomm.hardware.adafruit.AdafruitBNO055IMU;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.lynx.LynxEmbeddedIMU;

import org.firstinspires.ftc.teamcode.RC;
import org.firstinspires.ftc.teamcode.newhardware.FXTServo;
import org.firstinspires.ftc.teamcode.newhardware.Motor;


public class Armstrong extends Robot {
    private Motor sweeper;
    private Motor lifter;
    private FXTServo marker;
    private FXTServo latch;
    public LynxEmbeddedIMU imu;
    private float GEAR_RATIO = 32/16;
    //private long lift;
    public Armstrong() {
        super();
        lifter = new Motor("lifter");
        marker = new FXTServo("marker");
        latch = new FXTServo("latch");
        sweeper = new Motor("sweeper");


        wheelDiameter = wheelDiameter * GEAR_RATIO;


        //lift = 8000;

        BNO055IMU.Parameters params = new BNO055IMU.Parameters();
        params.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        params.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;

        imu = (LynxEmbeddedIMU) RC.h.get(BNO055IMU.class, "imu");
        imu.initialize(params);

        wallUp();
    }


    //setting modes for sweeper
    public void SweepPush() {sweeper.setPower(1);}
    public void SweepPull() {sweeper.setPower(-1);}
    public void SweepStop() {sweeper.setPower(0);}


    //setting direction for lifter
    public void lifterUp(){
        lifter.setPower(-1);
    }
    public void lifterDown(){ lifter.setPower(1); }
    public void lifterStop(){
        lifter.setPower(0);
    }

    //setting position for marker servo
    public void wallUp() {marker.setPosition(0.20);}
    public void wallDown() {marker.setPosition(0.8);}

    public void unlatch() {latch.setPosition(0.45);}
    public void setLatch() {latch.setPosition(0.9);}

    public double getAngle() {return -imu.getAngularOrientation().firstAngle;}


    public long DOWNDISTANCE = 1000;

    //setting IMU turn
    public void IMUTurnLeft(double degrees, double speed){


    }

}
