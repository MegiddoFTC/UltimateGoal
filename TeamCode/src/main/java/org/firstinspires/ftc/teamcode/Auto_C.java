package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//@Disabled
@Autonomous(name="Auto_C")
public class Auto_C extends DefaultAuto {

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



        move_foreword(300,1);
        //setpower(0.5);
        sleep(50);
        //meconum(100);
        turn(16,0.5);
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
        turn(-16,1);
       // gyroTurn(0.1,1);


        //rings down


      //  move_foreword(-100,0.7);
        sleep(100);
       // meconum(-50,0.7);
        leftArm_Down();
       // setpower(0.7);
        shootPower(0.63);
        move_foreword(-290,0.7);
        arms_restart();

        //shoot 2

        sleep(100);
        meconum(80,0.7);
        //gyroTurn(0.18,1);
        pumpPower(1);
        move_foreword(50,0.7);
        sleep(200);
        //gyroTurn(0.18,1);
        toppPower(1);
        sleep(1200);
        toppPower(0);
        shootPower(0.76);
        sleep(200);
        move_foreword(245,1);
        move_foreword(-22,1);
        gyroTurn(0.18,1);
        toppPower(1);
        sleep(2400);
        toppPower(0);


        //woblle #C



        move_foreword(340,1);
        meconum(-50,1);

        //setpower(0.7);
        //meconum(50,0.7);
        //gyroTurn(0.1,1);
        turnWoblle(0.6);
        sleep(300);
        openWoblle();
        sleep(600);
        move_foreword(-240,1);
        shootPower(0);
        pumpPower(0);


        while (opModeIsActive()) {


        }
    }
}