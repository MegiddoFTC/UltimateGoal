package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public abstract class Default extends OpMode {

    protected DcMotor rearLeft  ;
    protected DcMotor frontLeft ;
    protected DcMotor rearRight ;
    protected DcMotor frontRight;

    protected DcMotor pumpMotor;
    protected DcMotor shootMotor;
    protected DcMotor feedMotor;
    //protected DcMotor pumpMotor2;

    int powerMecan = 35;
    int pumpLeverEnter =0;
    int pumpLeverOut = 0;

    @Override
    public void init() {
        rearLeft  = hardwareMap.get(DcMotor.class, "RearLeft");
        frontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        rearRight = hardwareMap.get(DcMotor.class, "RearRight");
        frontRight= hardwareMap.get(DcMotor.class, "FrontRight");
        pumpMotor = hardwareMap.get(DcMotor.class, "PumpMotor");
        //pumpMotor2 = hardwareMap.get(DcMotorEx.class, "PumpMotor2");
        shootMotor = hardwareMap.get(DcMotor.class,"shootMotor");
        feedMotor = hardwareMap.get(DcMotor.class,"ToppMotor");

        rearLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        rearRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);

        pumpMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        feedMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        //pumpMotor2.setDirection(DcMotorSimple.Direction.FORWARD);
        shootMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        setDriveRunMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setDriveRunMode(DcMotor.RunMode.RUN_USING_ENCODER);


        setDriveZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        resetStartTime();
    }

    protected void stopMotors() {
        powerDriveMotors(0);
    } //call to stop robot

    protected void powerDriveMotors(double power) {
        powerDriveMotors(power, power);
    } // stop robot

    protected void powerDriveMotors(double left, double right) { // call to set power
        powerDriveMotors(left, left, right, right);
    }

    protected void powerDriveMotors(double RLeft, double FLeft, double RRight, double FRight) { // set power
        rearLeft.setPower(-RLeft)   ;
        frontLeft.setPower(-FLeft)  ;
        rearRight.setPower(-RRight) ;
        frontRight.setPower(-FRight);
    }

    protected void setDriveZeroPowerBehavior(DcMotor.ZeroPowerBehavior zeroPowerBehavior) {
        rearLeft.setZeroPowerBehavior(zeroPowerBehavior)  ;
        frontLeft.setZeroPowerBehavior(zeroPowerBehavior) ;
        rearRight.setZeroPowerBehavior(zeroPowerBehavior) ;
        frontRight.setZeroPowerBehavior(zeroPowerBehavior);
        pumpMotor.setZeroPowerBehavior(zeroPowerBehavior) ;
        shootMotor.setZeroPowerBehavior(zeroPowerBehavior);
        feedMotor.setZeroPowerBehavior(zeroPowerBehavior);
        //pumpMotor2.setZeroPowerBehavior(zeroPowerBehavior);
    }

    protected void setDriveRunMode(DcMotor.RunMode runMode) {
        rearLeft.setMode(runMode)  ;
        frontLeft.setMode(runMode) ;
        rearRight.setMode(runMode) ;
        frontRight.setMode(runMode);
        pumpMotor.setMode(runMode) ;
        shootMotor.setMode(runMode);
        feedMotor.setMode(runMode);
        //pumpMotor2.setMode(runMode);
    }

    protected void driveLeft() {
        powerDriveMotors(-powerMecan, powerMecan, -powerMecan, powerMecan);
    }

    protected void driveRight() {
        powerDriveMotors(powerMecan, -powerMecan, powerMecan, -powerMecan);
    }

    protected void pumpPower(double pumpPower) { //set power in the pump motor
        //pumpMotor.setPower(pumpPower);
        pumpMotor.setPower(pumpPower);
    }
    protected  void shootPower(double shootPower){
        shootMotor.setPower(shootPower);
    }
    protected  void  toppPower(double toppPower){
        feedMotor.setPower(toppPower);
    }
}


