package org.firstinspires.ftc.teamcode;

    import android.util.Pair;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
    import com.qualcomm.robotcore.hardware.DcMotorSimple;
    import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="testWobble")
public class testWobble extends OpMode {
    //double time = Double.MAX_VALUE;


    Servo left;
    Servo right;

    @Override
    public void init() {
        left = hardwareMap.servo.get("WoblleLift1Servo");
        right = hardwareMap.servo.get("WoblleLift2Servo");


        left.setDirection(Servo.Direction.FORWARD);
        right.setDirection(Servo.Direction.REVERSE );
    }

    @Override
    public void loop() {

        if (gamepad1.a) {
            right.setPosition(0.6);
        }  if (gamepad1.x){
            right.setPosition(1);

    }
        if (gamepad1.b){
            right.setPosition(0);
        }
}}
