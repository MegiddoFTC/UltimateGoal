package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.DefaultAuto;

//@Disabled
//@Autonomous(name="Auto_B_blue")
public class auto_B_blue extends DefaultAuto {

    @Override
    public void runOpMode() {
        super.init_auto();
        waitForStart();

        telemetry.addData("status", "start");
        telemetry.update();



        restart_high();

        //high shoot point
        move_foreword(280, 1);
        meconum(-73,0.6);
        turn(-1,1);
        gyroTurn(0.35,0);
        //high shot
        sleep(150);

        toppPower(1);
        sleep(450);
        toppPower(0);
        sleep(400);
        toppPower(1);
        sleep(300);
        pumpPower(1);
        sleep(1800);
       // shootPower(0);
        toppPower(0);
        pumpPower(0);
        // wobble 1
        //shootPower(0);
        move_foreword(130,0.9);
        sleep(100);
        turn90();
        sleep(120);
        openWoblle();
        sleep(120);

        // move to wob #2

        turn(100,0.5);
        sleep(250);
        // turn(2,0.2);
        //  gyroTurn(0.2,180);

        //gyroTurn(0.15,180);
        //meconum(-30,0.6);
        pumpPower(1);
        toppPower(1);
        sleep(100);
        toppPower(0);
        move_foreword(270,0.90);

        pumpPower(0);
        //meconum(-30,0.8);
        turn(110,0.6);
        sleep(50);
        turnWoblle(0.6);
        meconum(-23,0.8);
        sleep(50);
        closeWoblle();
        sleep(450);
        turnWoblle(0.55);
        turn(90,0.8);
        move_foreword(150,1);
        pumpPower(1);
        toppPower(1);
        sleep(800);
        toppPower(0);
        move_foreword(120,1);
        turn(80,1);
        openWoblle();
        turnWoblle(0);
sleep(1000);
        //gyroTurn(0.2,180);


    }
}
