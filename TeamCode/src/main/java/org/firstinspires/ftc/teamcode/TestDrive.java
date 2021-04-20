package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="DriveTest")
public class TestDrive extends Default {
    //double time = Double.MAX_VALUE;


    @Override
    public void loop() {
        if (gamepad1.left_bumper || gamepad1.dpad_left) { //mecanum
            driveLeft();
        } else if (gamepad1.right_bumper || gamepad1.dpad_right) {
            driveRight();
        } else {
            arcadeControl(gamepad1.right_stick_y,-gamepad1.right_stick_x,-gamepad1.left_stick_x);
        }

        telemetry.addData("ShootMotor",shootMotor.getPower());
        telemetry.update();

        if (gamepad2.right_trigger > 0) {//pump motor Enter on/off
            pumpPower(-30);
        } else if (gamepad2.left_trigger > 0.1) {
            pumpPower(30);
        } else {
            pumpPower(0);
        }

        if (gamepad2.a){
            shootPower(1);

            //time = getRuntime();
        } else if (gamepad2.b){ //stop shoot and topp motors
            shootPower(0);
            //toppPower(0);
            //time = Double.MAX_VALUE;
        }

        if (gamepad2.x) {
            wobServoPosition = 0.3; //woblle enter

            woblleServo();


        }
        if (gamepad2.y){
            wobServoPosition = 0.0; //close woblle
            woblleServo();
        }

        if (gamepad2.right_bumper  ){
            toppPower(1);
        } else if(gamepad2.left_bumper){
            toppPower(-1);
        } else
            toppPower(0);
        }

        //if (getRuntime() - time > 2) { //delay time = 2
        //    toppPower(1);
        //}




    @Override
    public void stop() {
        time = Double.MAX_VALUE;
    }

    void arcadeControl(double y,double x,double spin){
        powerDriveMotors((-1*(spin+y)/1.2)-x,(-1*(spin+y)/1.2)+x,((spin+-y)/1.2)-x,((spin+-y)/1.2)+x);
    }

}

