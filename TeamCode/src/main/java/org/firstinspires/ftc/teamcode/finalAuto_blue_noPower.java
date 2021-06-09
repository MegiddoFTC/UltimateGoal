package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.DefaultAuto;
import org.firstinspires.ftc.teamcode.vison.RingPipeLine;


@Autonomous(name="2. B[noPower]",group = "blue",preselectTeleOp = "DriveTest")

public class finalAuto_blue_noPower extends DefaultAuto {

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

        restart_high();
        sleep(100);
        // move to #A

        move_foreword(300, 0.65);

        //move to power shot point

        //move_foreword(-75, 0.8);
        //gyroTurn(0.3, 0);
        sleep(100);
        turn(120,0.6);
        sleep(200);
        openWoblle();
        sleep(300);
        turn(-120,0.6);
        sleep(100);
        gyroTurn(0.25,0);
        sleep(80);
        meconum(-65, 0.4);
        turn(-1,0.5);
        gyroTurn(0.3, 0);
        sleep(100);


        highShoot();

        shootPower(0);
        sleep(90);
        move_foreword(-130,0.65);
        turn(-73,0.7);
        turnWoblle(0.6);
        meconum(-60,0.6);
        closeWoblle();
        sleep(300);
        turn(-127 ,0.7);
        sleep(100);
        move_foreword(-270,1);
        sleep(70);
        meconum(-50,1);
      //  turn90();
        openWoblle();
        turnWoblle(0);
        meconum(50,1);
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
        turn(105    ,0.6);
        //sleep(100);
        turnWoblle(0.6);
        meconum(-20,0.8);
        sleep(50);
        closeWoblle();
        sleep(550);
        //turnWoblle(0.6);
        //sleep(100);
        shootPower(0.55);
        turn(95,0.8);
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
        restart_high_C();

        //shoot 1


        move_foreword(285, 0.8);
        //setpower(0.5);
        sleep(50);
        //meconum(100);
        gyroTurn(0.2, 0);
        turn(-14, 0.5);
        sleep(100);
        //setpower(1);
        highShoot();
        turn(-14, 1);
        shootPower(0);
        rightArm_Down();
        //turn(-15.5, 1);
        //gyroTurn(0.2,0);
        //   gyroTurn(0.18,1);
        // move_foreword(250,0.8);
        meconum(-30, 0.7);
        move_foreword(-170, 0.6);
        //shootPower(0.45);
        //sleep(200);
        arms_restart();
        meconum(-70, 0.7);
        pumpPower(1);
        move_foreword(35, 0.3);
        sleep(1200);
        toppPower(1);
        sleep(400);
        toppPower(0);
        shootPower(0.48);
        move_foreword(60, 0.3);
        sleep(20);
        pumpPower(0);
        move_foreword(105, 0.8);
        turn(34, 1);
        // turn(-1,1);
        //gyroTurn(0.3,0);
        //sleep(200);


        highShoot();
        turn(10, 1);
        pumpPower(1);
        move_foreword(330, 1);
        //sleep(200);
        turn(150, 1);
        openWoblle();
        sleep(150);
        // move_foreword(-200,1);
        pumpPower(0);
        turnWoblle(0);
        sleep(1000000000);
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
    }}