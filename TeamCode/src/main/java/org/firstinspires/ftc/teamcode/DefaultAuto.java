package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public abstract class DefaultAuto extends LinearOpMode {
    protected Robot robot;

    protected final List<Double> woblle_states = new ArrayList<>();
    protected static int woblle_state = 0;
    protected final List<Double> woblle_grab_states = new ArrayList<>();
    protected static int woblle_grab_state = 0;




    private int state = 0;

    public void init_auto() {
        robot = new Robot(hardwareMap);


        robot.woblle_states.add(0.0);
        robot.woblle_states.add(0.2);
        robot.woblle_states.add(0.35);
        robot.woblle_states.add(1.0);

        robot.woblle_grab_states.add(0.0);
        robot.woblle_grab_states.add(0.2);
        robot.woblle_grab_states.add(1.0);

//        robot.frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        robot.rearRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        robot.frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        robot.rearLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        setDriveZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        robot.frontLeft.setTargetPosition(0);
        robot.rearLeft.setTargetPosition(0);
        robot.frontRight.setTargetPosition(0);
        robot.rearRight.setTargetPosition(0);

        robot.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.frontLeft.setPower(1);
        robot.rearLeft.setPower(1);
        robot.frontRight.setPower(1);
        robot.rearRight.setPower(1);




    }

    protected void setpower(double power){
        robot.frontLeft.setPower(power);
        robot.rearLeft.setPower(power);
        robot.frontRight.setPower(power);
        robot.rearRight.setPower(power);


    }


    protected void setDriveZeroPowerBehavior(DcMotor.ZeroPowerBehavior zeroPowerBehavior) {
        robot.rearLeft.setZeroPowerBehavior(zeroPowerBehavior);
        robot.frontLeft.setZeroPowerBehavior(zeroPowerBehavior);
        robot.rearRight.setZeroPowerBehavior(zeroPowerBehavior);
        robot.frontRight.setZeroPowerBehavior(zeroPowerBehavior);
    }

    public void move_foreword(double cm) {
        state++;



        robot.frontLeft.setTargetPosition(robot.frontLeft.getCurrentPosition() + (int)Util.cm2ticks(-cm));
            robot.rearLeft.setTargetPosition(robot.rearLeft.getCurrentPosition() + (int)Util.cm2ticks(-cm));
            robot.frontRight.setTargetPosition(robot.frontRight.getCurrentPosition() + (int)Util.cm2ticks(-cm));
            robot.rearRight.setTargetPosition(robot.rearRight.getCurrentPosition() + (int)Util.cm2ticks(-cm));

            while (isBusy() && opModeIsActive());

    }

    protected void shootPower(double power){
        robot.shootMotor.setPower(power);
        robot.shootMotor2.setPower(power);
    }

    protected void toppPower(double power){
        robot.feedMotor.setPower(power);
    }
    protected void pumpPower(double power){
        robot.pumpMotor.setPower(power);
    }


    protected void turn(double cm){
        robot.frontLeft.setTargetPosition(robot.frontLeft.getCurrentPosition() + (int)Util.cm2ticks(cm));
        robot.rearLeft.setTargetPosition(robot.rearLeft.getCurrentPosition() + (int)Util.cm2ticks(cm));
        robot.frontRight.setTargetPosition(robot.frontRight.getCurrentPosition() + (int)Util.cm2ticks(-cm));
        robot.rearRight.setTargetPosition(robot.rearRight.getCurrentPosition() + (int)Util.cm2ticks(-cm));
        while (isBusy());

    }
    //protected void PumpOnEnter(){
        //pumpPower(1);
    //}
    protected void turnWoblle(double degris){
        robot.woblleLift1Servo.setPosition(degris);
        robot.woblleServo.setPosition(degris);
        while (isBusy());
    }

    protected void closeWoblle() {
        robot.woblleServo.setPosition(1);

    }

    public void openWoblle() {
        robot.woblleServo.setPosition(0);

    }

    protected boolean isBusy() {
        return robot.frontLeft.isBusy() || robot.rearLeft.isBusy() || robot.frontRight.isBusy() || robot.rearRight.isBusy();
    }

    public void meconum(double cm) {
        state++;

        robot.frontLeft.setTargetPosition(robot.frontLeft.getCurrentPosition() + (int)Util.cm2ticks(cm));
        robot.rearLeft.setTargetPosition(robot.rearLeft.getCurrentPosition() + (int)Util.cm2ticks(-cm));
        robot.frontRight.setTargetPosition(robot.frontRight.getCurrentPosition() + (int)Util.cm2ticks(-cm));
        robot.rearRight.setTargetPosition(robot.rearRight.getCurrentPosition() + (int)Util.cm2ticks(cm));

        while (isBusy() && opModeIsActive());

    }

    protected void move_slow(double cm){
        robot.frontLeft.setPower(0.6);
        robot.rearLeft.setPower(0.6);
        robot.frontRight.setPower(0.6);
        robot.rearRight.setPower(0.6);


    }

    protected void leftArm_Down(){
        robot.leftArm.setPosition(0.975);

    }

    protected void leftArm_UP(){
        robot.leftArm.setPosition(0.6);

    }

    protected void arms_restart(){
        robot.rightArm.setPosition(0.5);
    }


}
