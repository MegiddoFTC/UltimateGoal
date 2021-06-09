package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
//@Autonomous(name="Auto_A_blue")

public class auto_A_blue extends DefaultAuto {


    public void runOpMode() {
        super.init_auto();
        boolean stop = false;
        waitForStart();

        telemetry.addData("status", "start");
        telemetry.update();

        imu.startAccelerationIntegration(new Position(), new Velocity(), 1000);

        while (opModeIsActive()) {
            telemetry.addData("Runtime", "%.03f", getRuntime());
            telemetry.update();
            telemetry.update();
            break;
        }
        restart_power();
        sleep(100);
        // move to #A

        move_foreword(300, 0.65);

        //move to power shot point

        //move_foreword(-75, 0.8);
        //gyroTurn(0.3, 0);
        sleep(100);
        turn90();
        sleep(150);
        openWoblle();
        sleep(200);
        turn_minus_90();
        sleep(150);
        gyroTurn(0.25,0);
        sleep(80);
        meconum(-160, 0.4);
        turn(-1,0.5);
        gyroTurn(0.3, 0);
        sleep(100);

        //power shot


        //shoot #1

        toppPower(1);
        sleep(160);
        toppPower(0);
        //sleep(100);

        // move to power shoot #2

        meconum(-50,0.35);
        //  sleep(50);
        turn(-1,1);
        //gyroTurn(0.25,0);
        sleep(90);

        // shoot #2k

        toppPower(1);
        sleep(850);
        toppPower(0);
        //shootPower(0.56);

        // move to power shoot #3

        pumpPower(1);
        meconum(-40,0.35);
        turn(-1,1);
        //sleep(50);
        //gyroTurn(0.25,0);
        sleep(50);

        // shoot #3
        toppPower(1);
        sleep(900);
        pumpPower(0);
        toppPower(0);
        shootPower(0);

        sleep(90);
       // turn(150,0.8);
        move_foreword(-100,0.8);
        //sleep(100);
        //gyroTurn(0.2,0);
        sleep(90);
        //turn_minus_90();
        turn(-155,1);
        turnWoblle(0.6);
        meconum(-100,0.6);
        //move_foreword(-130,0.8);
        //meconum(-20,0.6);
        closeWoblle();
        sleep(350);
        move_foreword(-250,1);
        turn(-80,1);
        //move_foreword(-50,1);
        openWoblle();
        turnWoblle(1);
        meconum(70,1);
        while (opModeIsActive()) {
        }






    }
}