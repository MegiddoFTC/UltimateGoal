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



        move_foreword(280,1);
       // setpower(0.7);
        sleep(50);
        meconum(90,1);
        gyroTurn(0.18,-1);
        //setpower(1);
        sleep(100);
        toppPower(1);
        sleep(450);
        toppPower(0);
        sleep(                                                                                                                                                          200);
        toppPower(1);
        sleep(300);
        pumpPower(1);
        sleep(1800);
        shootPower(0);
        toppPower(0);
        pumpPower(0);


        //woblle #B
        sleep(50);
        move_foreword(180,1);
        meconum(120,1);
        turnWoblle(0.6);
        sleep(450);
        openWoblle();
        sleep(600);



        //pump ring

        turn(205,1);
        //gyroTurn(0.18,180);
        sleep(200);
        move_foreword(200,1);
        meconum(120,1);
        pumpPower(1);
        move_foreword(80,1);
        pumpPower(0);
        shootPower(0.75);
        turn(-195,1);

        //shoot 2

        move_foreword(100,1);
        sleep(200);
        toppPower(1);
        pumpPower(1);
        sleep(1500);
        toppPower(0);
        shootPower(0);
        pumpPower(0);
        move_foreword(60,1);

        while (opModeIsActive()) {


        }
    }
}
