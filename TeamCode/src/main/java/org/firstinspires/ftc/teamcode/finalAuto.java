package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.commandftc.RobotUniversal;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.teamcode.DefaultAuto;
import org.firstinspires.ftc.teamcode.subsystems.VisionSubsystem;


@Autonomous(name="finalAuto")

public class finalAuto extends DefaultAuto {

    protected VisionSubsystem vision;

    private int rings;

    @Override
    public void runOpMode() {
        RobotUniversal.telemetry = telemetry;
        RobotUniversal.opMode = this;
        RobotUniversal.hardwareMap = hardwareMap;

        vision = new VisionSubsystem();

        vision.set_for_autonomous();

        super.init_auto();
        boolean stop = false;

        telemetry.addData("time", this::getRuntime);

        telemetry.addData("orange pixels", vision::getOrangePixels);
        telemetry.update();
        while (opModeIsActive()){
//            vision = new VisionSubsystem();
//            vision.set_for_autonomous();
//            telemetry.addData("time", this::getRuntime);
//            telemetry.addData("orange pixels", vision::getOrangePixels);
            telemetry.update();
        }
        waitForStart();

        telemetry.addData("status", "start");
        telemetry.update();

        imu.startAccelerationIntegration(new Position(), new Velocity(), 1000);

        rings = vision.count_rings();
        telemetry.addData("rings", () -> rings);
        telemetry.update();

        while (opModeIsActive()) {
            telemetry.addData("Runtime", "%.03f", getRuntime());
            telemetry.update();
            telemetry.update();
            break;
        }

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
        //restart
        shootPower(0.75);
        closeWoblle();
        arms_restart();
        sleep(400);


        //shoot 1



        move_foreword(290,1);
        // setpower(0.7);
        sleep(50);
        meconum(85,0.7);
        gyroTurn(0.2,-1);
        //   setpower(1);
        sleep(800);
        toppPower(1);
        sleep(600);
        toppPower(0);
        sleep(800);
        toppPower(1);
        sleep(600);
        pumpPower(1);
        sleep(2000);
        shootPower(0);
        toppPower(0);
        pumpPower(0);


        //woblle #A

        sleep(50);
        move_foreword(50,1);
        meconum(-65,1);
        turnWoblle(0.6);
        sleep(300);
        openWoblle();
        sleep(600);
        //  move_foreword(-50);

        //dance
        while (opModeIsActive()){
            turn(20,0.5);
            leftArm_Down();
            rightArm_Down();
            sleep(200);
            arms_restart();
            turn(-20,0.6);
            leftArm_Down();
            rightArm_Down();
            sleep(100);
            arms_restart();
        }


        while (opModeIsActive()) {


            //turn(100);
        }
    }

    private void wobell_B() {

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
        move_foreword(200,1);
        meconum(120,1);
        turnWoblle(0.6);
        sleep(300);
        openWoblle();
        sleep(600);



        //pump ring

        turn(205,1);
        //gyroTurn(0.18,180);
        sleep(200);
        move_foreword(220,1);
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

    private void wobell_C() {
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
        gyroTurn(0.18,1);


        //rings down


        //  move_foreword(-100,0.7);
        sleep(100);
        // meconum(-50,0.7);
        leftArm_Down();
        // setpower(0.7);
        shootPower(0.65);
        move_foreword(-290,0.7);
        arms_restart();

        //shoot 2

        sleep(100);
        meconum(80,0.7);
        //gyroTurn(0.18,1);
        pumpPower(1);
        move_foreword(65,0.7);
        sleep(200);
        //gyroTurn(0.18,1);
        toppPower(1);
        sleep(1600);
        toppPower(0);
        shootPower(0.76);
        sleep(200);
        move_foreword(245,0.6);
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
        //sleep(600);
        move_foreword(-240,1);
        shootPower(0);
        pumpPower(0);


        while (opModeIsActive()) {


        }
    }
}
