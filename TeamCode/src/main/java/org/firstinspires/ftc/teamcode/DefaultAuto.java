package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import java.sql.ResultSet;
import java.util.Base64;

public abstract class DefaultAuto extends LinearOpMode {
    private Robot robot;


    private int state = 0;

    public void init_auto() {
        robot = new Robot(hardwareMap);

//        robot.frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        robot.rearRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        robot.frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        robot.rearLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        robot.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);




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

    public void move_foreword(double cm) {
        state++;
//        int newTargetForRight;
//        int newTargetForLeft;
//        int newTargetBackRight;
//        int newTargetBackLeft;
//
//        newTargetForRight =  frontRight.getCurrentPosition()+
//        newTargetForLeft =


//           frontLeft.setTargetPosition(frontLeft.getCurrentPosition());


//            setDriveZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            robot.frontLeft.setTargetPosition(robot.frontLeft.getCurrentPosition() + (int)Util.cm2ticks(-cm));
            robot.rearLeft.setTargetPosition(robot.rearLeft.getCurrentPosition() + (int)Util.cm2ticks(-cm));
            robot.frontRight.setTargetPosition(robot.frontRight.getCurrentPosition() + (int)Util.cm2ticks(-cm));
            robot.rearRight.setTargetPosition(robot.rearRight.getCurrentPosition() + (int)Util.cm2ticks(-cm));

//            rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

//            robot.frontLeft.setPower(Math.abs(1));
//            robot.rearLeft.setPower(Math.abs(1));
//            robot.frontRight.setPower(Math.abs(1));
//            robot.rearRight.setPower(Math.abs(1));

            while (isBusy()) {
                telemetry.addData("time", getRuntime());
                telemetry.addData("state", state);
                telemetry.addData("FL", robot.frontLeft.getCurrentPosition());
                telemetry.update();
            }

//            robot.frontLeft.setPower(Math.abs(0));
//            robot.rearLeft.setPower(Math.abs(0));
//            robot.frontRight.setPower(Math.abs(0));
//            robot.rearRight.setPower(Math.abs(0));

//            frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            rearLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);;
//            frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            rearRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



    }

    protected void turn(double cm){
        robot.frontLeft.setTargetPosition((int)Util.cm2ticks(-cm));
        robot.rearLeft.setTargetPosition((int)Util.cm2ticks(-cm));
        robot.frontRight.setTargetPosition((int)Util.cm2ticks(cm));
        robot.rearRight.setTargetPosition((int)Util.cm2ticks(cm));


        robot.rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (isBusy());
    }
    //protected void PumpOnEnter(){
        //pumpPower(1);
    //}

    protected boolean isBusy() {
        return robot.frontLeft.isBusy() || robot.rearLeft.isBusy() || robot.frontRight.isBusy() || robot.rearRight.isBusy();
    }
}
