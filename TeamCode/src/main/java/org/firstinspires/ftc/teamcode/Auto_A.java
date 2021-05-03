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




      //  gyroTurn(0.1,2);



        //restart
     shootPower(0.75);
     closeWoblle();
     arms_restart();
     sleep(400);


        //shoot 1



        move_foreword(300,1);
       // setpower(0.7);
        sleep(50);
        meconum(100,0.7);
        gyroTurn(0.15,1);
     //   setpower(1);
        sleep(100);
        toppPower(1);
        sleep(600);
        toppPower(0);
        sleep(800);
        toppPower(1);
        sleep(600);
        pumpPower(1);
        sleep(1600);
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











        while (opModeIsActive()) {


            //turn(100);
        }
    }


}
