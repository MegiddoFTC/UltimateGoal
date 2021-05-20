package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Locale;

public abstract class DefaultAuto extends LinearOpMode {

    BNO055IMU imu;
    Orientation angles;


    static final double COUNTS_PER_MOTOR_REV = 2240;
    static final double WHEEL_DIAMETER_MM = 75;
    static final double DRIVE_GEAR_REDUCTION = 15;
    static final double     HEADING_THRESHOLD       = 0 ;
    static final double     P_TURN_COEFF            = 0.1;
    static final double     P_DRIVE_COEFF           = 0.15;
//    protected Robot robot;
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
    /*protected final List<Double> woblle_states = new ArrayList<>();
    protected static int woblle_state = 0;
    protected final List<Double> woblle_grab_states = new ArrayList<>();
    protected static int woblle_grab_state = 0;
    */

    public void init_auto() {
        rearLeft  = (DcMotorEx)hardwareMap.get(DcMotor.class, "RearLeft");
        frontLeft = (DcMotorEx)hardwareMap.get(DcMotor.class, "FrontLeft");
        rearRight = (DcMotorEx)hardwareMap.get(DcMotor.class, "RearRight");
        frontRight= (DcMotorEx)hardwareMap.get(DcMotor.class, "FrontRight");
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
        shootMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        shootMotor2.setDirection(DcMotorSimple.Direction.REVERSE);

        rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        shootMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        shootMotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        shootMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shootMotor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        /*
        woblle_states.add(0.0);
        woblle_states.add(0.2);
        woblle_states.add(0.35);
        woblle_states.add(1.0);

        woblle_grab_states.add(0.0);
        woblle_grab_states.add(0.2);
        woblle_grab_states.add(1.0);
*/
//        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        rearRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        rearLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rearRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rearLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json";
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
        composeTelemetry();

    }

    protected void setpower(double power){
        frontLeft.setPower(power);
        rearLeft.setPower(power);
        frontRight.setPower(power);
        rearRight.setPower(power);


    }

    public void move_foreword(double cm, double speed) {
        if(opModeIsActive()) {
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + (int) Util.cm2ticks(-cm));
            rearLeft.setTargetPosition(rearLeft.getCurrentPosition() + (int) Util.cm2ticks(-cm));
            frontRight.setTargetPosition(frontRight.getCurrentPosition() + (int) Util.cm2ticks(-cm));
            rearRight.setTargetPosition(rearRight.getCurrentPosition() + (int) Util.cm2ticks(-cm));

            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            frontLeft.setPower(Math.abs(speed));
            rearLeft.setPower(Math.abs(speed));
            frontRight.setPower(Math.abs(speed));
            rearRight.setPower(Math.abs(speed));

            while (isBusy()) ;

            frontLeft.setPower(0);
            rearLeft.setPower(0);
            frontRight.setPower(0);
            rearRight.setPower(0);

            frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rearLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rearRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            telemetry.update();
        }
    }

    protected void shootPower(double power){
        shootMotor.setPower(power);
        shootMotor2.setPower(power);
    }

    protected void toppPower(double power){
        feedMotor.setPower(power);
    }
    protected void pumpPower(double power){
        pumpMotor.setPower(power);
    }


    protected void turn(double cm,double speed){

        if (opModeIsActive()) {
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + (int) Util.cm2ticks(cm));
            rearLeft.setTargetPosition(rearLeft.getCurrentPosition() + (int) Util.cm2ticks(cm));
            frontRight.setTargetPosition(frontRight.getCurrentPosition() + (int) Util.cm2ticks(-cm));
            rearRight.setTargetPosition(rearRight.getCurrentPosition() + (int) Util.cm2ticks(-cm));

            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            frontLeft.setPower(Math.abs(speed));
            rearLeft.setPower(Math.abs(speed));
            frontRight.setPower(Math.abs(speed));
            rearRight.setPower(Math.abs(speed));

            while (isBusy()) ;

            frontLeft.setPower(0);
            rearLeft.setPower(0);
            frontRight.setPower(0);
            rearRight.setPower(0);

            frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rearLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rearRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            telemetry.update();
        }
    }
    //protected void PumpOnEnter(){
        //pumpPower(1);
    //}
    protected void turnWoblle(double degris){
        woblleLift1Servo.setPosition(degris);
        woblleServo.setPosition(degris);
        while (isBusy());
    }

    protected void closeWoblle() {
        woblleServo.setPosition(1);

    }

    public void openWoblle() {
        woblleServo.setPosition(0);

    }

    protected boolean isBusy() {
        return frontLeft.isBusy() || rearLeft.isBusy() || frontRight.isBusy() || rearRight.isBusy();
    }

    public void meconum(double cm,double speed) {


        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + (int)Util.cm2ticks(cm));
        rearLeft.setTargetPosition(rearLeft.getCurrentPosition() + (int)Util.cm2ticks(-cm));
        frontRight.setTargetPosition(frontRight.getCurrentPosition() + (int)Util.cm2ticks(-cm));
        rearRight.setTargetPosition(rearRight.getCurrentPosition() + (int)Util.cm2ticks(cm));

        while (isBusy() && opModeIsActive());


        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(Math.abs(speed));
        rearLeft.setPower(Math.abs(speed));
        frontRight.setPower(Math.abs(speed));
        rearRight.setPower(Math.abs(speed));

        while (isBusy()) ;

        frontLeft.setPower(0);
        rearLeft.setPower(0);
        frontRight.setPower(0);
        rearRight.setPower(0);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rearLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rearRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


    protected void move_slow(double cm){
        frontLeft.setPower(0.6);
        rearLeft.setPower(0.6);
        frontRight.setPower(0.6);
        rearRight.setPower(0.6);


    }

    protected void leftArm_Down(){
        leftArm.setPosition(0.92);

    }

    protected void leftArm_UP(){
        leftArm.setPosition(0.6);

    }

    protected void arms_restart(){
        rightArm.setPosition(0.5);
        leftArm.setPosition(0.6);

    }
    protected void rightArm_Down(){
        rightArm.setPosition(-0.98);

    }
    public void gyroTurn (  double speed, double angle) {
        while (opModeIsActive() && !onHeading(speed, angle, P_TURN_COEFF)) {
            telemetry.update();

        }
        while (isBusy() && opModeIsActive());

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

        if (Math.abs(error) == HEADING_THRESHOLD) {
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

        int robotError;

        robotError = (int)targetAngle - (int)angles.firstAngle;
        while (robotError > 180)  robotError -= 360;
        while (robotError <= -180) robotError += 360;
        return robotError;
    }


    public double getSteer(double error, double PCoeff) {
        return Range.clip(-error * PCoeff, -1, 1);
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


    protected void restart_high(){
        shootPower(0.75);
        closeWoblle();
        arms_restart();
        sleep(400);
    }

    protected void restart_power(){
        shootPower(0.5);
        closeWoblle();
        arms_restart();
        sleep(400);
    }

    protected void powerShoot(){


        //shoot #1

        toppPower(1);
        sleep(200);
        toppPower(0);
        sleep(100);

        // move to power shoot #2

        meconum(50,0.3);
        gyroTurn(0.2,0);
        sleep(100);

        // shoot #2

        toppPower(1);
        sleep(1200);
        toppPower(0);
        shootPower(0.56);
        // move to power shoot #3

        meconum(40,0.3);
        gyroTurn(0.2,0);
        sleep(200);

        // shoot #3

        pumpPower(1);
        toppPower(1);
        sleep(3500);
        pumpPower(0);
        toppPower(0);
        shootPower(0);
        gyroTurn(0.2,0);

    }





}
