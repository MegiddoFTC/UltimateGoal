package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.teamcode.vison.RingPipeLine;


@Autonomous(name="1. B[main]",group = "blue",preselectTeleOp = "DriveTest")

public class finalAuto_blue_main extends DefaultAuto {

    private final RingPipeLine ringPipeLine = new RingPipeLine(Alliance.Blue);
    private int rings;

    @Override
    public void runOpMode() {

        super.init_auto();
        camera.setPipeline(ringPipeLine);

        boolean stop = false;

        telemetry.addData("time", this::getRuntime);

        telemetry.addData("orange pixels", () -> ringPipeLine.orange_pixels);
        telemetry.update();
        while (opModeIsActive()) {
            telemetry.update();
        }
        waitForStart();

        telemetry.addData("status", "start");
        telemetry.update();

        imu.startAccelerationIntegration(new Position(), new Velocity(), 1000);

        rings = ringPipeLine.getRings();
        telemetry.addData("rings", () -> rings);
        telemetry.update();

        switch (rings) {
            case 0:
                wobell_A();
                break;
            case 1:
                wobell_B();
                break;
            case 4:
                wobell_C();
                break;
        }
    }

    private void wobell_A() {

        restart_power_blue();
        sleep(100);
        // move to #A

        move_foreword(300, 0.7);
        //gyroTurn(0.2,0);
        //sleep(100);
        //meconum(10,0.7);

        //put wobble

        //turnWoblle(0.9);
        // turnWoblle(0.6);
        //sleep(150);
        //  openWoblle();
        //sleep(200);
        //gyroTurn(0.2,0);
        //sleep(200);

        //move to power shot point

        //move_foreword(-75, 0.8);
        //gyroTurn(0.3, 0);
        sleep(100);
        turn(120,0.8);
        sleep(100);
        openWoblle();
        sleep(200);
        turn(-120,0.8);
        sleep(150);
        gyroTurn(0.25,0);
        sleep(80);
        meconum(-160, 0.4);
        turn(-1,0.5);
        gyroTurn(0.3, 0);
        sleep(100);
        closeWoblle();
        turnWoblle(1);

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
        gyroTurn(0.25,0);
        sleep(50);

        // shoot #3
        toppPower(1);
        sleep(900);
        pumpPower(0);
        toppPower(0);

        sleep(90);
        shootPower(0);

        // turn(150,0.8);
        move_foreword(-100,0.8);
        //sleep(100);
        //gyroTurn(0.2,0);
        sleep(90);
        //turn_minus_90();
        turn(-155,1);
        turnWoblle(0.6);
        openWoblle();
        meconum(-100,0.6);
        //move_foreword(-130,0.8);
        //meconum(-20,0.6);
        closeWoblle();
        sleep(350);
        move_foreword(-270,1);
        turn(-75,1);
        //move_foreword(-50,1);
        openWoblle();
        turnWoblle(0);
        meconum(70,1);
        while (opModeIsActive()) {
        }

    }

    private void wobell_B() {

        restart_high();

        //high shoot point
        move_foreword(280, 0.65    );
        meconum(-73,0.6);
        turn(-1,1);
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
        turn(115    ,0.6);
        //sleep(100);
        turnWoblle(0.6);
        meconum(-20,0.8);
        sleep(50);
        closeWoblle();
        sleep(550);
        //turnWoblle(0.6);
        //sleep(100);
        shootPower(0.55);
        turn(85,0.8);
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
        while (opModeIsActive()) {
        }
    }

    private void wobell_C() {
        //restart
        restart_high();

        //shoot 1


        move_foreword(300, 0.8);
        //setpower(0.5);
        sleep(50);
        //meconum(100);
        //gyroTurn(0.2,0);
        turn(-14, 0.5);
        sleep(200);
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
        move_foreword(-205,0.6);
        //shootPower(0.45);
        //sleep(200);
        arms_restart();
        meconum(-70 ,0.7);
        pumpPower(1);
        move_foreword(35,0.3);
        sleep(850);
        toppPower(1);
        sleep(480);
        toppPower(0);
        shootPower(0.5);
        move_foreword(72 ,0.3);
        sleep(90);
        pumpPower(0);
        move_foreword(90,0.8);
        //turn(1,1);
        gyroTurn(0.2,0);
        sleep(50);


        highShoot();
        turn(10, 1);
        pumpPower(1);
        move_foreword(330, 1);
        //sleep(200);
        turn(                 123 , 1);
        openWoblle();
        sleep(150);
        // move_foreword(-200,1);
        pumpPower(0);
        turnWoblle(0);
        sleep(1000000000);
        //rings down



        while (opModeIsActive()) {


        }
    }}