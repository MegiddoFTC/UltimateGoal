package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

//@Disabled
//@Autonomous(name="Auto_A_red")
public class Auto_A_red extends DefaultAuto {

    @Override
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

        move_foreword(375, 0.7);

        openWoblle();
        sleep(100);

        //move to power shot point

        move_foreword(-85, 0.8);
        gyroTurn(0.3, 0);
        sleep(200);
        meconum(160, 0.4);
        turn(1,0.5);
        gyroTurn(0.3, 0);
        sleep(100);

        //power shot


        //shoot #1

        toppPower(1);
        sleep(160);
        toppPower(0);
        //sleep(100);

        // move to power shoot #2

        meconum(50,0.35);
          sleep(50);
        //turn(-1,1);
        //gyroTurn(0.25,0);
        sleep(90);

        // shoot #2k

        toppPower(1);
        sleep(850);
        toppPower(0);
        //shootPower(0.56);

        // move to power shoot #3

        pumpPower(1);
        meconum(40,0.35);
        turn(1,1);
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
        move_foreword(-100,0.75);
        //sleep(100);
        gyroTurn(0.25,0);
        sleep(90);
        //turn_minus_90();
        turn(-60,1);
        turnWoblle(0.6);
        meconum(-105,0.6);
        //move_foreword(-130,0.8);
        //meconum(-20,0.6);
        closeWoblle();
        sleep(350);
        turn(20,1);
        move_foreword(290,1);
        turn(40,1);
        openWoblle();
        turnWoblle(0);
        sleep(300);



        while (opModeIsActive()) {
        }
    }


}
