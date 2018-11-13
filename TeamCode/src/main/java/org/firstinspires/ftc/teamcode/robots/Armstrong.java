package org.firstinspires.ftc.teamcode.robots;

import com.qualcomm.hardware.adafruit.AdafruitBNO055IMU;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.lynx.LynxEmbeddedIMU;

import org.firstinspires.ftc.teamcode.RC;
import org.firstinspires.ftc.teamcode.newhardware.FXTServo;
import org.firstinspires.ftc.teamcode.newhardware.Motor;


public class Armstrong extends Robot {

    private Motor lifter;
    private FXTServo marker;
    private FXTServo latch;
    private Motor driveL;
    private Motor driveR;
    public LynxEmbeddedIMU imu;

    public Armstrong() {
        super();
        lifter = new Motor("lifter");
        marker = new FXTServo("marker");
        driveR = new Motor("driveR");
        driveL = new Motor("driveL");
        latch = new FXTServo("latch");
        BNO055IMU.Parameters params = new BNO055IMU.Parameters();
        params.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        params.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;

        imu = (LynxEmbeddedIMU) RC.h.get(BNO055IMU.class, "imu");
        imu.initialize(params);


    }

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
    public void wallDown() {marker.setPosition(0.75);}

    public void unlatch() {latch.setPosition(0.5);}
    public void setLatch() {latch.setPosition(0.8);}

    //setting IMU turn
    public void IMUTurnLeft(double degrees, double speed){

    }

}
