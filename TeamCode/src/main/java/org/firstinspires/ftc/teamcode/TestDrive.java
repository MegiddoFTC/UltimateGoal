package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="DriveTest")
public class TestDrive extends Default {

    @Override
    public void loop() {
        if (gamepad1.left_bumper || gamepad1.dpad_left) {
            driveLeft();
        }
        else if (gamepad1.right_bumper || gamepad1.dpad_right) {
            driveRight();
        }


        powerMotors(- gamepad1.left_stick_y, - gamepad1.right_stick_y);

        if (gamepad1.a ) { //pump
            pumpPower(1);
        }
        else if (gamepad1.b){
            pumpPower(-1);
        }

    }
}
