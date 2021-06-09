package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//@Disabled
//@Autonomous(name="Auto_C_blue`")
public class auto_C_blue extends DefaultAuto {

    @Override
    public void runOpMode() {
        super.init_auto();
        waitForStart();

        telemetry.addData("status", "start");
        telemetry.update();


        //restart
        restart_high_C();

        //shoot 1


        move_foreword(285, 0.8);
        //setpower(0.5);
        sleep(50);
        //meconum(100);
        gyroTurn(0.2,0);
        turn(-14, 0.5);
        sleep(100);
        //setpower(1);
        highShoot();
        turn(-14,1);
        shootPower(0);
        rightArm_Down();
        //turn(-15.5, 1);
        //gyroTurn(0.2,0);
        //   gyroTurn(0.18,1);
        // move_foreword(250,0.8);
        meconum(-30,0.7);
        move_foreword(-170,0.6);
        //shootPower(0.45);
        //sleep(200);
        arms_restart();
        meconum(-70 ,0.7);
        pumpPower(1);
        move_foreword(35,0.3);
        sleep(1200);
        toppPower(1);
        sleep(400);
        toppPower(0);
        shootPower(0.48);
        move_foreword(60,0.3);
        sleep(20);
        pumpPower(0);
        move_foreword(105,0.8);
        turn(34,1);
       // turn(-1,1);
        //gyroTurn(0.3,0);
        //sleep(200);


        highShoot();
        turn(10,1);
        pumpPower(1);
        move_foreword(330,1);
        //sleep(200);
        turn(150,1);
        openWoblle();
        sleep(150);
       // move_foreword(-200,1);
        pumpPower(0);
        turnWoblle(0);
        sleep(1000000000   );
        //rings down

/*
        //  move_foreword(-100,0.7);
        sleep(100);
        // meconum(-50,0.7);
        leftArm_Down();
        // setpower(0.7);
        //shootPower(0.46);
        move_foreword(-290, 0.8);
        arms_restart();
        gyroTurn(0.2,0);

        //shoot 2

        sleep(100);
        meconum(80, 0.7);
        turn(2,0.6);
        gyroTurn(0.2,0);
        //gyroTurn(0.18,1);
        pumpPower(1);
        move_foreword(65, 0.6);
        sleep(200);
        //gyroTurn(0.18,1);
        toppPower(0.7);
        sleep(1400);
        toppPower(0);
        //shootPower(0.76);
        sleep(200);
        move_foreword(245, 0.6);
        move_foreword(-22, 1);
        gyroTurn(0.2, 0);
        toppPower(1);
        sleep(2400);
        toppPower(0);


        //woblle #C


        move_foreword(310, 1);
        //meconum(-50,1);

        //setpower(0.7);
        //meconum(50,0.7);
        //gyroTurn(0.1,1);
        //turnWoblle(0.6);
        sleep(200);
        openWoblle();
        sleep(100);
        move_foreword(-240, 1);
        shootPower(0);
        pumpPower(0);

*/
        while (opModeIsActive()) {


        }
    }
}