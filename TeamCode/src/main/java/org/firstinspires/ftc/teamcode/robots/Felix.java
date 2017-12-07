package org.firstinspires.ftc.teamcode.robots;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Aila on 2017-12-06.
 */

public class Felix extends Robot {

    public DcMotor driveL = null;
    public DcMotor driveR = null;
    public DcMotor glifter = null;

    public Servo jewelL = null;
    public Servo jewelR = null;

    public CRServo handL = null;
    public CRServo handR = null;

    public BNO055IMU imu = null;
    public ColorSensor colourSensor = null;

    public static final double WHEEL_SIZE = 4.0;

    public static final double LEFT_JEWEL_UP = 0.5;
    public static final double LEFT_JEWEL_DOWN = 1;
    public static final double RIGHT_JEWEL_UP = 0.5;
    public static final double RIGHT_JEWEL_DOWN = 0.0;

    HardwareMap hwmap = null;

    public Felix() {}

    public void init (HardwareMap ahwMap) {
        hwmap = ahwMap;

        driveL = hwmap.get(DcMotor.class, "driveL");
        driveR = hwmap.get(DcMotor.class, "driveR");
        glifter = hwmap.get(DcMotor.class, "glifter");
        driveL.setDirection(DcMotorSimple.Direction.REVERSE);
        driveR.setDirection(DcMotorSimple.Direction.FORWARD);

        driveL.setPower(0);
        driveR.setPower(0);
        glifter.setPower(0);

        driveL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        driveR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        glifter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        jewelL = hwmap.get(Servo.class, "jewelL");
        jewelR = hwmap.get(Servo.class, "jewelR");

        jewelL.setPosition(LEFT_JEWEL_UP);
        jewelR.setPosition(RIGHT_JEWEL_UP);

        handL = hwmap.get(CRServo.class, "handL");
        handR = hwmap.get(CRServo.class, "handR");

        handL.setPower(-0.1);
        handR.setPower(0.1);

        imu = hwmap.get(BNO055IMU.class, "imu");
        colourSensor = hwmap.get(ColorSensor.class, "colourSensor");
    }

    public void holdGlyph () {
        handL.setPower(0.7);
        handR.setPower(-0.7);
    }

    public void releaseGlyph () {
        handL.setPower(-0.7);
        handR.setPower(0.7);
    }

}
