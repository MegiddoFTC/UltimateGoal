package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public abstract class Default extends OpMode {

    protected DcMotor rearLeft;
    protected DcMotor frontLeft;
    protected DcMotor rearRight;
    protected DcMotor frontRight;

    @Override
    public void init() {
        rearLeft = hardwareMap.dcMotor.get("RearLeft");
        frontLeft = hardwareMap.dcMotor.get("FrontLeft");
        rearRight = hardwareMap.dcMotor.get("RearRight");
        frontRight = hardwareMap.dcMotor.get("FrontRight");

        rearLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        rearRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);

        setDriveRunMode(DcMotor.RunMode.RUN_USING_ENCODER);

        setDriveZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    protected void stopMotors() {
        powerMotors(0);
    }

    protected void powerMotors(double power) {
        powerMotors(power, power);
    }

    protected void powerMotors(double left, double right) {
        powerMotors(left, left, right, right);
    }

    protected void powerMotors(double RLeft, double FLeft, double RRight, double FRight) {
        rearLeft.setPower(RLeft);
        frontLeft.setPower(FLeft);
        rearRight.setPower(RRight);
        frontRight.setPower(FRight);
    }

    protected void setDriveZeroPowerBehavior(DcMotor.ZeroPowerBehavior zeroPowerBehavior) {
        rearLeft.setZeroPowerBehavior(zeroPowerBehavior);
        frontLeft.setZeroPowerBehavior(zeroPowerBehavior);
        rearRight.setZeroPowerBehavior(zeroPowerBehavior);
        frontRight.setZeroPowerBehavior(zeroPowerBehavior);
    }

    protected void setDriveRunMode(DcMotor.RunMode runMode) {
        rearLeft.setMode(runMode);
        frontLeft.setMode(runMode);
        rearRight.setMode(runMode);
        frontRight.setMode(runMode);
    }

    protected void driveLeft() {
        powerMotors(1, -1, -1, 1);
    }

    protected void driveRight() {
        powerMotors(-1, 1, 1, -1);
    }
}
