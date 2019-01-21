package org.firstinspires.ftc.teamcode.robots;

import com.qualcomm.hardware.adafruit.AdafruitBNO055IMU;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.lynx.LynxEmbeddedIMU;
import com.qualcomm.robotcore.hardware.DigitalChannel;

import org.firstinspires.ftc.teamcode.RC;
import org.firstinspires.ftc.teamcode.newhardware.FXTCRServo;
import org.firstinspires.ftc.teamcode.newhardware.FXTServo;
import org.firstinspires.ftc.teamcode.newhardware.Motor;


public class Armstrong extends Robot {


    private Motor lifter;
    private FXTServo marker;
    private FXTServo latch;
    public LynxEmbeddedIMU imu;
    private float GEAR_RATIO = 32/16;
    public float MOTOR_SPEED;
    public float MOTOR_SPEED_PAST;
    public float AVR_MOTOR_DIFF;
    //public DigitalChannel digitalTouch;
    public Motor CollectMotor;

    private FXTCRServo leftCollectServo;
    private FXTCRServo rightCollectServo;



    //private long lift;
    public Armstrong() {
        super();
        lifter = new Motor("lifter");
        marker = new FXTServo("marker");
        latch = new FXTServo("latch");
     // new motors and servos
        CollectMotor = new Motor("CollectMotor");

        leftCollectServo = new FXTCRServo("leftCollectServo");
        rightCollectServo = new FXTCRServo("rightCollectServo");
        //digitalTouch = RC.h.get(DigitalChannel.class, "sensor_digital");
        //digitalTouch.setMode(DigitalChannel.Mode.INPUT);



        wheelDiameter = wheelDiameter * GEAR_RATIO;


        //lift = 8000;

        BNO055IMU.Parameters params = new BNO055IMU.Parameters();
        params.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        params.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;

        imu = (LynxEmbeddedIMU) RC.h.get(BNO055IMU.class, "imu");
        imu.initialize(params);

        markUp();


    }


    //setting modes for sweeper


    //setting direction for lifter
    public void lifterUp(){
        lifter.setPower(-1);
    }
    public void lifterDown(){ lifter.setPower(1); }
    public void lifterStop(){lifter.setPower(0); }

    //setting position for marker servo
    public void markUp() {marker.setPosition(0.45);}
    public void markDown() {marker.setPosition(0);}

    //setting latch
    public void unlatch() {latch.setPosition(0.2);}
    public void setLatch() {latch.setPosition(0.8);}




    public void collectServoLeftDown(){leftCollectServo.setPower(-0.7);}
    public void collectServoRightDown(){rightCollectServo.setPower(0.7);}

    public void collectServoLeftUp(){leftCollectServo.setPower(0.7);}
    public void collectServoRightUp(){rightCollectServo.setPower(-0.7);}

    public void collectServoRightStop() {rightCollectServo.setPower(0);}
    public void collectServoLeftStop() {leftCollectServo.setPower(0);}

    public void collectServoLeftSlow() {leftCollectServo.setPower(0.05);}
    public void collectServoRightSlow() {rightCollectServo.setPower(-0.05);}

    public void armup() {CollectMotor.setPower(0.2);}
    public void armdown() {CollectMotor.setPower(-0.2);}
    public void armstop() {CollectMotor.setPower(0);}

    //setting IMU
    public double getAngle() {return -imu.getAngularOrientation().firstAngle;}

    public long DOWNDISTANCE = 1000;

    //Set Wall-E position




}
