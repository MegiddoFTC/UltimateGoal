package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

//@Disabled
@Autonomous(name="Auto_A")
public class Auto_A extends DefaultAuto {

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

        // move to #A

        move_foreword(350,0.7);
        gyroTurn(0.2,0);
        sleep(100);
        meconum(30,0.7);

        //put wobble

        turnWoblle(0.9);
        turnWoblle(0.6);
        sleep(1300);
        openWoblle();
        sleep(400);
        gyroTurn(0.2,0);
        sleep(200);

        //move to power shot point

        move_foreword(-50,1);
        gyroTurn(0.2,0);
        sleep(200);
        meconum(146,0.5);
        sleep(50);
        gyroTurn(0.2,0);
        sleep(1000);

        //power shot

        powerShoot();

        //take wobble #2

        gyroTurn(0.2,0);
        //turn(180,0.7);
        move_foreword(-255,0.7);
        gyroTurn(0.2,0);
        sleep(200);
        turnWoblle(0.41);
        openWoblle();
        meconum(-68,0.5);
        sleep(405);
        closeWoblle();
        sleep(800);

        //put wobble #2 in #A and parking in white line

        turnWoblle(0.7);
        turn(-30,0.7);
        move_foreword(330,1);
        openWoblle();



        while (opModeIsActive()) {
        }
    }


}
