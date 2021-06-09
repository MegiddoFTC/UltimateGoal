package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
@Autonomous(name="3. B[line2]",group = "blue",preselectTeleOp = "DriveTest")

public class finalAuto_blue_2 extends DefaultAuto {


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
        restart_power_2();
        sleep(100);
        meconum(-50,0.4);
        sleep(150);
        turn(-1,1);
        gyroTurn(0.2,0);
        sleep(150);
        move_foreword(300, 0.5);
        sleep(100);
        gyroTurn(0.2,0);
        sleep(200);
        toppPower(1);
        sleep(200);
        toppPower(0);
        sleep(200);
        gyroTurn(0.2,4.5);
        sleep(200);
        toppPower(1);
        sleep(700);
        toppPower(0);
        pumpPower(1);
        gyroTurn(0.2,-5);
        sleep(200);
        toppPower(1);
        sleep(700);
        toppPower(0);
        pumpPower(0);
        move_foreword(50,1);
        gyroTurn(0.2,0);






    }
}