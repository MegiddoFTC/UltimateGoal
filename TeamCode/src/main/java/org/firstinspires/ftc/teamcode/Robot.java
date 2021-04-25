package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Hardware;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    protected DcMotor rearLeft  ;
    protected DcMotor frontLeft ;
    protected DcMotor rearRight ;
    protected DcMotor frontRight;

    protected DcMotor pumpMotor;
    protected DcMotor shootMotor;
    protected DcMotor shootMotor2;
    protected DcMotor feedMotor;
    // protected DcMotor wobMotor; // woblle motor
    //protected DcMotor pumpMotor2;

    protected Servo woblleServo;
    protected Servo woblleLift1Servo;
    protected Servo woblleLift2Servo;

    public Robot(HardwareMap hardwareMap) {
        rearLeft  = hardwareMap.get(DcMotor.class, "RearLeft");
        frontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        rearRight = hardwareMap.get(DcMotor.class, "RearRight");
        frontRight= hardwareMap.get(DcMotor.class, "FrontRight");
        pumpMotor = hardwareMap.get(DcMotor.class, "PumpMotor");
        //pumpMotor2 = hardwareMap.get(DcMotorEx.class, "PumpMotor2");
        shootMotor = hardwareMap.get(DcMotor.class,"shootMotor");
        feedMotor = hardwareMap.get(DcMotor.class,"ToppMotor");
        //wobMotor = hardwareMap.get(DcMotor.class,"wobMotor");
        woblleServo = hardwareMap.servo.get("WoblleServo");
        woblleLift1Servo = hardwareMap.servo.get("WoblleLift1Servo");
        woblleLift2Servo = hardwareMap.servo.get("WoblleLift2Servo");
        shootMotor2 = hardwareMap.get(DcMotor.class,"shootMotor2");


        //telemetry.addData("frontLeft", frontLeft);
        //telemetry.update();

        rearLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        rearRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);

        woblleServo.setDirection(Servo.Direction.FORWARD);
        //wobMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        pumpMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        feedMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        //pumpMotor2.setDirection(DcMotorSimple.Direction.FORWARD);
        shootMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        shootMotor2.setDirection(DcMotorSimple.Direction.FORWARD);


        //setDriveRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //setDriveRunMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setTargetPosition(0);
        rearLeft.setTargetPosition(0);
        frontRight.setTargetPosition(0);
        rearRight.setTargetPosition(0);
        //setDriveRunMode(DcMotor.RunMode.RUN_USING_ENCODER);

//        woblleServo.setPosition(1);
//        setWoblleLift(1);

        //setDriveZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
}
