package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//@Disabled
@Autonomous(name="Auto_C_red")
public class Auto_C_red extends DefaultAuto {

    @Override
    public void runOpMode() {
        super.init_auto();
        waitForStart();

        telemetry.addData("status", "start");
        telemetry.update();


        //restart
        restart_high();

        //shoot 1


        move_foreword(300, 0.72);
        //setpower(0.5);
        sleep(50);
        //meconum(100);
        //gyroTurn(0.2,0);
        turn(14, 0.5);
        sleep(200);
        //setpower(1);
        highShoot();
        turn(14,1);
        shootPower(0);
        leftArm_Down();
        //turn(-15.5, 1);
        //gyroTurn(0.2,0);
        //   gyroTurn(0.18,1);
        // move_foreword(250,0.8);
        meconum(30,0.7);
        move_foreword(-205,0.6);
        //shootPower(0.45);
        //sleep(200);
        arms_restart();
        meconum(70 ,0.7);
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
        turn(-10,1);
        // pumpPower(1);
        move_foreword(335,1);
        //sleep(200);
        openWoblle();
        sleep(150);
        move_foreword(-200,1);
        pumpPower(0);
        //rings down


        while (opModeIsActive()) {


        }
    }
}