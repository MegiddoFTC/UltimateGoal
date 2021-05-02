package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.ArrayList;
import java.util.List;

public class DefaultMotors extends LinearOpMode {



        protected DcMotor rearLeft  ;
        protected DcMotor frontLeft ;
        protected DcMotor rearRight ;
        protected DcMotor frontRight;

        protected DcMotor pumpMotor;
        protected DcMotor shootMotor;
        protected DcMotor feedMotor;
        // protected DcMotor wobMotor; // woblle motor
        //protected DcMotor pumpMotor2;

        protected Servo woblleServo;
        protected Servo woblleLift1Servo;
        protected Servo woblleLift2Servo;

        protected final List<Double> woblle_states = new ArrayList<>();
        protected static int woblle_state = 0;
        protected final List<Double> woblle_grab_states = new ArrayList<>();
        protected static int woblle_grab_state = 0;

        MegiddoGamepad Gamepad1 = new MegiddoGamepad();
        MegiddoGamepad Gamepad2 = new MegiddoGamepad();

        @Override
        public void runOpMode() {
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
            setDriveRunMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            setDriveRunMode(DcMotor.RunMode.RUN_USING_ENCODER);

//        woblleServo.setPosition(1);
//        setWoblleLift(1);

            setDriveZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
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
            // wobMotor.setZeroPowerBehavior(zeroPowerBehavior);
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
            // wobMotor.setMode(runMode);
            //pumpMotor2.setMode(runMode);
        }

        protected void driveLeft() {
            powerDriveMotors(-1, 1, -1, 1);
        }

        protected void driveRight() {
            powerDriveMotors(1, -1, 1, -1);
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

        protected  void woblleServo (double position){
            woblleServo.setPosition(position);
        }

        protected void setWoblleLift(double position) {
            woblleLift1Servo.setPosition(position);
            woblleLift2Servo.setPosition(position);
        }

        protected void liftWoblle() {
            setWoblleLift(woblle_states.get(
                    woblle_state = Util.clamp(woblle_state+1, 0, woblle_states.size()-1)));
        }

        protected void lowerWoblle() {
            setWoblleLift(woblle_states.get(
                    woblle_state = Util.clamp(woblle_state-1, 0, woblle_states.size()-1)));
        }

        protected void openWoblle() {
            woblleServo.setPosition(woblle_grab_states.get(
                    woblle_grab_state = Util.clamp(woblle_grab_state+1, 0, woblle_grab_states.size()-1)));
        }

        protected void closeWoblle() {
            woblleServo.setPosition(woblle_grab_states.get(
                    woblle_grab_state = Util.clamp(woblle_grab_state-1, 0, woblle_grab_states.size()-1)));
        }

}