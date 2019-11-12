package org.firstinspires.ftc.teamcode.robots;

import android.graphics.Paint;
import android.hardware.Sensor;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.RC;
import org.firstinspires.ftc.teamcode.newhardware.FXTCRServo;
import org.firstinspires.ftc.teamcode.newhardware.FXTSensors.DigitalColourSensor;
import org.firstinspires.ftc.teamcode.newhardware.FXTSensors.FXTAnalogUltrasonicSensor;
import org.firstinspires.ftc.teamcode.newhardware.FXTServo;
import org.firstinspires.ftc.teamcode.newhardware.Motor;
import org.firstinspires.ftc.teamcode.roboticslibrary.TaskHandler;
import org.opencv.photo.CalibrateRobertson;
import com.qualcomm.robotcore.hardware.ColorSensor;


public class Joules  {
    private Motor FrontRight;
    private Motor FrontLeft;
    private Motor BackRight;
    private Motor BackLeft;
    private String VEER_CHECK_TASK_KEY = "Joules.VEERCHECK";

    //arm servoes
    private FXTServo Foundation1;
    private FXTServo Foundation2;
    private FXTServo StoneMover;
    //arm motor

    //Capstone
    private FXTServo Capstone;

    public int STONESTATE;
    private float GEAR_RATIO = 1/2;

    public Joules(){
        // don't know if we need super();
        //Motors!!
        FrontRight = new Motor("FrontRight");
        FrontLeft = new Motor("FrontLeft");
        BackRight = new Motor("BackRight");
        BackLeft = new Motor("BackLeft");


        Foundation1 = new FXTServo("Foundation1");
        Foundation2 = new FXTServo("Foundation2");

        Capstone = new FXTServo("Capstone");

        StoneMover = new FXTServo("StoneMover");


        FrontRight.setMinimumSpeed(0.1);
        FrontLeft.setMinimumSpeed(0.1);
        BackRight.setMinimumSpeed(0.1);
        BackLeft.setMinimumSpeed(0.1);
    }

    //Robot driving
    public void DriveForward(double speed){
        TaskHandler.pauseTask(VEER_CHECK_TASK_KEY);
        FrontLeft.setPower(-speed);
        FrontRight.setPower(speed);
        BackLeft.setPower(-speed);
        BackRight.setPower(speed);
    }
    public void DriveBackward(double speed){
        TaskHandler.pauseTask(VEER_CHECK_TASK_KEY);
        FrontLeft.setPower(speed);
        FrontRight.setPower(-speed);
        BackLeft.setPower(speed);
        BackRight.setPower(-speed);

    }
    public void StrafeLeft(double speed){
        TaskHandler.pauseTask(VEER_CHECK_TASK_KEY);
        FrontLeft.setPower(speed);
        FrontRight.setPower(speed);
        BackLeft.setPower(-speed);
        BackRight.setPower(-speed);
    }
    public void StrafeRight(double speed){
        TaskHandler.pauseTask(VEER_CHECK_TASK_KEY);
        FrontLeft.setPower(-speed);
        FrontRight.setPower(-speed);
        BackLeft.setPower(speed);
        BackRight.setPower(speed);
    }
    public void TurnLeft(double speed){
        TaskHandler.pauseTask(VEER_CHECK_TASK_KEY);
        FrontLeft.setPower(-speed);
        FrontRight.setPower(-speed);
        BackLeft.setPower(-speed);
        BackRight.setPower(-speed);

    }
    public void TurnRight(double speed){
        TaskHandler.pauseTask(VEER_CHECK_TASK_KEY);
        FrontLeft.setPower(speed);
        FrontRight.setPower(speed);
        BackLeft.setPower(speed);
        BackRight.setPower(speed);
    }
    public void Stop(){
        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);
    }

    //Capstone
    public void CapDown(){
        Capstone.setPosition(0.1);
    }
    public void CapUp(){
        Capstone.setPosition(0.9);
    }


    //foundation
    public void FoundationDrop(){
        Foundation1.setPosition(0.2);
        Foundation2.setPosition(0.2);
    }
    public void FoundationGrab(){
        Foundation1.setPosition(0.45);
        Foundation2.setPosition(0.45);
    }

    public void StoneDown(){
        StoneMover.setPosition(0.2);
    }
    public void StoneUp(){
        StoneMover.setPosition(1);
    }




}
