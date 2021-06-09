package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//@Disabled
//@Autonomous(name="Auto_B_red")
public class Auto_B_red extends DefaultAuto {

    @Override
    public void runOpMode() {
        super.init_auto();
        waitForStart();

        telemetry.addData("status", "start");
        telemetry.update();



        restart_high();

        //high shoot point
        move_foreword(280, 0.7    );
        meconum(73,0.6);
        turn(1,1);
        gyroTurn(0.2,0);
        //high shot
        sleep(50);

        highShoot();

       // wobble 1
        shootPower(0);
        move_foreword(130,0.7);
        sleep(50);
        turn90();
        sleep(50);
        openWoblle();
        sleep(100);

        // move to wob #2

        turn90();
        sleep(50);

        pumpPower(1);
        toppPower(1);
        sleep(100);
        toppPower(0);
        move_foreword(270,0.6);

        pumpPower(0);
        //meconum(-30,0.8);
        turn(33,0.6);
        //sleep(100);
        turnWoblle(0.6);
        meconum(-20,0.8);
        sleep(50);
        closeWoblle();
        sleep(550);
        //turnWoblle(0.6);
        //sleep(100);
        shootPower(0.55);
        turn(163,0.8);
        pumpPower(1);
        move_foreword(150,0.7);
        //sleep(50);
        //gyroTurn(0.2,0);
        sleep(50);
        toppPower(1);
        sleep(1000);
        pumpPower(0);
        toppPower(0);
        move_foreword(120,1);
        //sleep(100);
        turn(60,1);
        //sleep(50);
        openWoblle();
        turnWoblle(0);
        move_foreword(-15,1);
        sleep(1000);
        //meconum(50,1);


        //gyroTurn(0.2,180);


        }
    }

