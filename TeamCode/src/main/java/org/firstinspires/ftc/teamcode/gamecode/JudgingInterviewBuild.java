package org.firstinspires.ftc.teamcode.gamecode;

import android.speech.tts.TextToSpeech;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RC;
import org.firstinspires.ftc.teamcode.opmodesupport.LinearTeleOpMode;
import org.firstinspires.ftc.teamcode.robots.Armstrong;
import org.firstinspires.ftc.teamcode.robots.Fermion;
@TeleOp
public class JudgingInterviewBuild extends LinearTeleOpMode implements TextToSpeech.OnInitListener{

    TextToSpeech text;
    Armstrong armstrong;
    public void initialize() {

        text = new TextToSpeech(RC.c(), this);
        armstrong = new Armstrong();
    }
    @Override


    public void loopOpMode() {
        if (joy1.buttonA()) {
            text.speak("Hello judges!" +
                    "My name is Armstrong, and I’m going to show you my mechanisms."+
                    "First off, my drive base, I zoom around with a six wheel drive base, geared two-to-one." +
                    "My front and back wheels are omni and my middle are standard tetrix wheels." +
                    "Now you may have guessed already from my name, I have a super strong arm used for lifting myself, I bet Neil Armstrong couldn’t beat my pull-up skills."
                    + "This strength comes from a rack and pinion device geared with a worm gear.", TextToSpeech.QUEUE_FLUSH, null);
            while (opModeIsActive() && text.isSpeaking()) {
                idle();
            }
            armstrong.lifterUp();

            text.speak("And it raises expectations.", TextToSpeech.QUEUE_FLUSH, null);
            while (opModeIsActive() && text.isSpeaking()) {
                idle();
            }
            armstrong.lifterStop();

            text.speak("Next my latch. I use a one-eighty servo for this dandy device.", TextToSpeech.QUEUE_FLUSH, null);
            while (opModeIsActive() && text.isSpeaking()) {
                idle();
            }
            armstrong.unlatch();
            text.speak("I use the circular motion and transform it to linear motion." +
                    "It’s pretty effective if I do say so myself.", TextToSpeech.QUEUE_FLUSH, null);
            while (opModeIsActive() && text.isSpeaking()) {
                idle();
            }
            armstrong.setLatch();


             text.speak("Now to collect minerals. I have here some handy hair scratchers, but not for scratching my beautiful robot hairs." +
                        "These along with my two scoring arms are used to snatch up minerals and score them into the lander." +
                        "The arms are geared and use torque to reach either side of Armstrong.", TextToSpeech.QUEUE_FLUSH, null);
             while (opModeIsActive() && text.isSpeaking()) {
                 idle();
             }
             armstrong.armup();

             text.speak("Wheeeeee!", TextToSpeech.QUEUE_FLUSH, null);
             while (opModeIsActive() && text.isSpeaking()) {
                idle();
             }
             armstrong.armstop();


        }



    }

    @Override

    public void stopOpMode() {text.stop();

    }

    @Override
    public void onInit(int status) {
        RC.t.addData("Talking", "Enabled");
    }


}
