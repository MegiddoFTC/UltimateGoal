package org.firstinspires.ftc.teamcode;

import android.util.Pair;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="DriveTest")
public class TestDrive extends Default {
    //double time = Double.MAX_VALUE;


    @Override
    public void start() {
        woblleServo(0.2);
    }

    @Override
    public void loop() {

        Gamepad1.update(gamepad1);
        Gamepad2.update(gamepad2);
        
        if (gamepad1.left_bumper || gamepad1.dpad_left) { //mecanum
            driveLeft();
        } else if (gamepad1.right_bumper || gamepad1.dpad_right) {
            driveRight();
        } else {
            arcadeControl(gamepad1.right_stick_y,-gamepad1.right_stick_x,-gamepad1.left_stick_x);
            //powerDriveMotors(-gamepad1.left_stick_y, -gamepad1.right_stick_y);
        }

        if (gamepad2.right_trigger > 0.1) {//pump motor Enter on/off
            pumpPower(30);
        } else if (gamepad2.left_trigger > 0.1) {
            pumpPower(-30);
        } else {
            pumpPower(0);
        }
        if (gamepad2.a){
            shootPower(0.86);
        }
        else if (gamepad2.x){
            shootPower(0.58);

            //time = getRuntime();
        } else if (gamepad2.b){ //stop shoot and topp motors
            shootPower(0);
            //toppPower(0);
            //time = Double.MAX_VALUE;
        }

        if (gamepad2.right_bumper  ){
            toppPower(0.73);
        } else if(gamepad2.left_bumper){
            toppPower(-0.73);
        } else {
            toppPower(0);
        }

        if (Gamepad2.dpad_up_Pressed()) {
            liftWoblle();
        } else if (Gamepad2.dpad_down_Pressed()) {
            lowerWoblle();
        }

        if (Gamepad2.dpad_left_Pressed()) {
            openWoblle();
        } else if (Gamepad2.dpad_right_Pressed()) {
            closeWoblle();
        }


        if(gamepad1.left_trigger > 0.1){
            driveLeft_slow();
        }
         else if  (gamepad1.right_trigger > 0.1){
            driveRight_slow();
        }
        /*if (gamepad2.y) {
            pressCount +=1;
            if (pressCount == 1) {
                press = 1;
                pressCount = 0;
            }

        }

        if ((press==1)&&(lever==0)){
            armsDown();
            lever = 1;
            press = 0;
        }else if ((press ==1) && (lever == 1)) {
            armsUp();
            lever =0;
            press = 0;
        }*/

        if (gamepad2.left_stick_y > 0.1){
            armsDown();
        }else  if (gamepad2.left_stick_y > -0.1){
            armsUp();
        }


        telemetry.addData("ShootMotor",shootMotor.getPower());
        telemetry.addData("Woblle state", new Pair<>
                (woblle_state, woblle_states.get(woblle_state)));
        telemetry.addData("Woblle Grab state", new Pair<>
                (woblle_grab_state, woblle_grab_states.get(woblle_grab_state)));
        telemetry.update();
    }




    @Override
    public void stop() {
        time = Double.MAX_VALUE;
    }

    void arcadeControl(double y,double x,double spin){

        powerDriveMotors((-1*(spin+y)/1.2)+x,(-1*(spin+y)/1.2)-x,((spin-y)/1.2)-x,((spin-y)/1.2)+x);
    }

}

