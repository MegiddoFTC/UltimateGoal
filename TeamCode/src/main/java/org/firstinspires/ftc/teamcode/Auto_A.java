package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//@Disabled
@Autonomous(name="Auto_A")
public class Auto_A extends DefaultAuto {

    @Override
    public void runOpMode() {
        super.init_auto();
        waitForStart();

        telemetry.addData("status", "start");
        telemetry.update();


       // turn(20);
        robot.gyroTurn(0.2,90);
/*
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
        sleep(350);
        toppPower(0);
        sleep(                                                                                                                                                          200);
        toppPower(1);
        sleep(300);
        pumpPower(1);
        sleep(1600);
        shootPower(0);
        toppPower(0);
        pumpPower(0);


        //woblle #A

        sleep(50);
        move_foreword(50);
        meconum(-65);
        turnWoblle(0.6);
        sleep(300);
        openWoblle();
        sleep(600);
      //  move_foreword(-50);










*/
        while (opModeIsActive()) {


            //turn(100);
        }
    }
}
