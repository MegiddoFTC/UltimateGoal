package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//@Disabled
@Autonomous(name="AutoTest")
public class Auto extends DefaultAuto {

    @Override
    public void runOpMode() {
        super.init_auto();
        waitForStart();

        telemetry.addData("status", "start");
        telemetry.update();

        closeWoblle();
        arms_restart();
        sleep(800);
        shootPower(0.875);
         leftArm_Down();
       // move_foreword(313);
        leftArm_UP();
        turn(4);
      //  turn(14);
        sleep(2000);
        toppPower(1);
        sleep(1000);
        pumpPower(1);
        sleep(2000);
        shootPower(0);
        toppPower(0);
        pumpPower(0);

    //    ^^^^^^^^^^^
        //yery reashon

        turn(-14.5);
       move_foreword(50);
       meconum(25);
       turnWoblle(0.6);
       sleep(300);
        openWoblle();
        sleep(500);
        move_foreword(68);
        turn(200);
        sleep(100);
        meconum(-65);
        sleep(100);

        //^^^^^^^^^^^^
        //woblle reason

        pumpPower(1);
        setpower(0.53);
        move_foreword(100);
        sleep(300);
        toppPower(1);
        sleep(350);
        toppPower(0);
        move_foreword(75);
        pumpPower(-1);
        setpower(1);
        pumpPower(0);
        sleep(200);
        shootPower(0.775);
        turn(-200);
        move_foreword(73);
        sleep(350);
        toppPower(1);
        sleep(400);
        pumpPower(1);
        sleep(2000);
        pumpPower(0);
        toppPower(0);
        shootPower(0);
        move_foreword(60);

       // setpower(0.5);
        //move_foreword(100);



        while (opModeIsActive()) {


            //turn(100);
        }
    }
}
