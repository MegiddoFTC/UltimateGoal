package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;
import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import android.graphics.Color;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.JavaUtil;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Robot extends LinearOpMode{

    BNO055IMU imu;
    Orientation angles;
    static final double     HEADING_THRESHOLD       = 1 ;
    static final double     P_TURN_COEFF            = 0.1;
    static final double     P_DRIVE_COEFF           = 0.15;
    protected DcMotor rearLeft  ;
    protected DcMotor frontLeft ;
    protected DcMotor rearRight ;
    protected DcMotor frontRight;

    protected DcMotor shootMotor2;
    protected DcMotor pumpMotor;
    protected DcMotor shootMotor;
    protected DcMotor feedMotor;
    // protected DcMotor wobMotor; // woblle motor
    //protected DcMotor pumpMotor2;

    protected Servo woblleServo;
    protected Servo woblleLift1Servo;
    protected Servo woblleLift2Servo;
    protected Servo rightArm;
    protected Servo leftArm;

    protected final List<Double> woblle_states = new ArrayList<>();
    protected static int woblle_state = 0;
    protected final List<Double> woblle_grab_states = new ArrayList<>();
    protected static int woblle_grab_state = 0;

    @Override
    public void runOpMode(){

    }

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
        rightArm = hardwareMap.servo.get("rightArm");
        leftArm = hardwareMap.servo.get("leftArm");

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json";
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        //telemetry.addData("frontLeft", frontLeft);
        //telemetry.update();

        rearLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        rearRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);

        woblleServo.setDirection(Servo.Direction.FORWARD);
        rightArm.setDirection(Servo.Direction.FORWARD);
        leftArm.setDirection(Servo.Direction.FORWARD);

        //wobMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        pumpMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        feedMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        //pumpMotor2.setDirection(DcMotorSimple.Direction.FORWARD);
        shootMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        shootMotor2.setDirection(DcMotorSimple.Direction.FORWARD);


        //setDriveRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //setDriveRunMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //frontLeft.setTargetPosition(0);
        //rearLeft.setTargetPosition(0);
        //frontRight.setTargetPosition(0);
        //rearRight.setTargetPosition(0);
        //setDriveRunMode(DcMotor.RunMode.RUN_USING_ENCODER);

//        woblleServo.setPosition(1);
//        setWoblleLift(1);

        //setDriveZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
/*
    protected void stopMotors() {
        powerDriveMotors(0);
    } //call to stop robot

    protected void powerDriveMotors(double power) {
        powerDriveMotors(power, power);
    } // stop robot
    protected void powerDriveMotors(double left, double right) { // call to set power
        powerDriveMotors(left, left, right, right);
    }
*/
  /*  protected void powerDriveMotors(double RLeft, double FLeft, double RRight, double FRight) { // set power
        rearLeft.setPower(-RLeft)   ;
        frontLeft.setPower(-FLeft)  ;
        rearRight.setPower(-RRight) ;
        frontRight.setPower(-FRight);
    }*/


    public void setDriveZeroPowerBehavior(DcMotor.ZeroPowerBehavior zeroPowerBehavior) {
        rearLeft.setZeroPowerBehavior(zeroPowerBehavior)  ;
        frontLeft.setZeroPowerBehavior(zeroPowerBehavior) ;
        rearRight.setZeroPowerBehavior(zeroPowerBehavior) ;
        frontRight.setZeroPowerBehavior(zeroPowerBehavior);
//        pumpMotor.setZeroPowerBehavior(zeroPowerBehavior) ;
//        shootMotor.setZeroPowerBehavior(zeroPowerBehavior);
//        feedMotor.setZeroPowerBehavior(zeroPowerBehavior);
        // wobMotor.setZeroPowerBehavior(zeroPowerBehavior);
        //pumpMotor2.setZeroPowerBehavior(zeroPowerBehavior);
    }

    public void setDriveRunMode(DcMotor.RunMode runMode) {
        rearLeft.setMode(runMode);
        frontLeft.setMode(runMode);
        rearRight.setMode(runMode);
        frontRight.setMode(runMode);
    }

    /*public void driveLeft() {
        powerDriveMotors(1, -1, -1, 1);
    }

    public void driveRight() {
        powerDriveMotors(-1, 1, 1, -1);
    }
    */
    public void pumpPower(double pumpPower) { //set power in the pump motor
        //pumpMotor.setPower(pumpPower);
        pumpMotor.setPower(pumpPower);
    }
    public  void shootPower(double shootPower){
        shootMotor.setPower(shootPower);
        shootMotor2.setPower(shootPower);
    }
    public  void  toppPower(double toppPower){
        feedMotor.setPower(toppPower);
    }

    public  void woblleServo (double position){
        woblleServo.setPosition(position);
    }

    public void setWoblleLift(double position) {
        woblleLift1Servo.setPosition(position);
        woblleLift2Servo.setPosition(position);
    }

    public void liftWoblle() {
        setWoblleLift(woblle_states.get(
                woblle_state = Util.clamp(woblle_state+1, 0, woblle_states.size()-1)));
    }

    public void lowerWoblle() {
        setWoblleLift(woblle_states.get(
                woblle_state = Util.clamp(woblle_state-1, 0, woblle_states.size()-1)));
    }

    public void gyroTurn (  double speed, double angle) {
        while (opModeIsActive() && !onHeading(speed, angle, P_TURN_COEFF)) {
            telemetry.update();

        }
    }

    public void gyroHold( double speed, double angle, double holdTime) {
        ElapsedTime holdTimer = new ElapsedTime();
        holdTimer.reset();
        while (opModeIsActive() && (holdTimer.time() < holdTime)) {
            onHeading(speed, angle, P_TURN_COEFF);
            telemetry.update();
        }

        frontRight.setPower(0);
        frontLeft.setPower(0);
        rearRight.setPower(0);
        rearLeft.setPower(0);

    }

    boolean onHeading(double speed, double angle, double PCoeff) {
        double error;
        double steer;
        boolean onTarget = false;
        double leftSpeed;
        double rightSpeed;

        error = getError(angle);

        if (Math.abs(error) <= HEADING_THRESHOLD) {
            steer = 0.0;
            leftSpeed  = 0.0;
            rightSpeed = 0.0;
            onTarget = true;
        }else {
            steer = getSteer(error, PCoeff);
            rightSpeed  = speed * steer;
            leftSpeed   = -rightSpeed;
        }
        frontLeft.setPower(leftSpeed);
        frontRight.setPower(rightSpeed);
        rearLeft.setPower(leftSpeed);
        rearRight.setPower(rightSpeed);
        telemetry.addData("Target", "%5.2f", angle);
        telemetry.addData("Err/St", "%5.2f/%5.2f", error, steer);
        telemetry.addData("Speed.", "%5.2f:%5.2f", leftSpeed, rightSpeed);
        return onTarget;
    }


    public double getError(double targetAngle) {

        double robotError;

        robotError = targetAngle - angles.firstAngle;
        while (robotError > 180)  robotError -= 360;
        while (robotError <= -180) robotError += 360;
        return robotError;
    }


    public double getSteer(double error, double PCoeff) {
        return Range.clip(error * PCoeff, -1, 1);
    }

    void composeTelemetry() {

        telemetry.addAction(new Runnable() {
            @Override
            public void run() {
                angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
            }
        });
        telemetry.addLine()
                .addData("status", new Func<String>() {
                    @Override
                    public String value() {
                        return imu.getSystemStatus().toShortString();
                    }
                })
                .addData("calib", new Func<String>() {
                    @Override
                    public String value() {
                        return imu.getCalibrationStatus().toString();
                    }
                });

        telemetry.addLine()
                .addData("heading", new Func<String>() {
                    @Override
                    public String value() {
                        return formatAngle(angles.angleUnit, angles.firstAngle);
                    }
                })
                .addData("roll", new Func<String>() {
                    @Override
                    public String value() {
                        return formatAngle(angles.angleUnit, angles.secondAngle);
                    }
                })
                .addData("pitch", new Func<String>() {
                    @Override
                    public String value() {
                        return formatAngle(angles.angleUnit, angles.thirdAngle);
                    }
                });
    }

    String formatAngle(AngleUnit angleUnit, double angle) {
        return formatDegrees(AngleUnit.DEGREES.fromUnit(angleUnit, angle));
    }

    String formatDegrees(double degrees){
        return String.format(Locale.getDefault(), "%.1f", AngleUnit.DEGREES.normalize(degrees));
    }




}
