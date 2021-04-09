package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="DriveTest")
public class TestDrive extends Default {

    @Override
    public void loop() {
        if (gamepad1.left_bumper || gamepad1.dpad_left) {
            driveLeft();
        } else if (gamepad1.right_bumper || gamepad1.dpad_right) {
            driveRight();
        } else {
            powerDriveMotors(-gamepad1.left_stick_y, -gamepad1.right_stick_y);
        }


        if (gamepad1.right_trigger > 0) {//mpEnter on/off
            pumpPower(-30);

        } else if (gamepad1.left_trigger > 0.1) {
            pumpPower(30);
        } else {
            pumpPower(0);
        }

        if (gamepad1.a){
            shootPower(1);
            toppPower(1);

        } else if (gamepad1.b){
            shootPower(0);
            toppPower(0);

        }
    }
}
