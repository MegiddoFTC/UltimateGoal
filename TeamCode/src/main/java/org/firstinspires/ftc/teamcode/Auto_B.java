package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//@Disabled
@Autonomous(name="Auto_B")
public class Auto_B extends DefaultAuto {

    @Override
    public void runOpMode() {
        super.init_auto();
        waitForStart();

        telemetry.addData("status", "start");
        telemetry.update();


        //restart
        shootPower(0.75);
        closeWoblle();
        arms_restart();
        sleep(400);


        //shoot 1



        move_foreword(300);
        setpower(0.7);
        sleep(50);
        meconum(100);
        setpower(1);
        sleep(100);
        toppPower(1);
        sleep(450);
        toppPower(0);
        sleep(                                                                                                                                                          200);
        toppPower(1);
        sleep(300);
        pumpPower(1);
        sleep(1600);
        shootPower(0);
        toppPower(0);
        pumpPower(0);


        //woblle #B
        sleep(50);
        move_foreword(180);
        meconum(80);
        turnWoblle(0.6);
        sleep(300);
        openWoblle();
        sleep(600);



        //pump ring

       // meconum(-45);
        turn(205);
        sleep(200);
        //pumpPower(1);
        move_foreword(200);
        meconum(100);
pumpPower(1);
move_foreword(80);
pumpPower(0);
shootPower(0.75);
        turn(-195);
        move_foreword(100);
        sleep(200);
        toppPower(1);
        pumpPower(1);
        sleep(1500);
toppPower(0);
shootPower(0);
pumpPower(0);
move_foreword(60);

        while (opModeIsActive()) {


        }
    }
}
