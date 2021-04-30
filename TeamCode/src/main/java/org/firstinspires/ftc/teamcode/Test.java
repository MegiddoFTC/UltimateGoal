package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import java.util.function.DoubleFunction;

@Disabled
public class Test extends LinearOpMode {
    protected DcMotor rearLeft  ;
    protected DcMotor frontLeft ;
    protected DcMotor rearRight ;
    protected DcMotor frontRight;

    @Override
    public void runOpMode() {
        rearLeft  = hardwareMap.get(DcMotor.class, "RearLeft");
        frontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        rearRight = hardwareMap.get(DcMotor.class, "RearRight");
        frontRight= hardwareMap.get(DcMotor.class, "FrontRight");


        rearLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        rearRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);

        rearRight.setTargetPosition(0);
        frontRight.setTargetPosition(0);
        rearLeft.setTargetPosition(0);
        frontLeft.setTargetPosition(0);

//        DoubleFunction a = () -> 1.0;



        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMode(DcMotor.RunMode.RUN_TO_POSITION);



        rearRight.setPower(1);
        frontRight.setPower(1);
        rearLeft.setPower(1);
        frontLeft.setPower(1);

        waitForStart();

        forward(1000);

        sleep(2000);

        forward(-1000);
    }

    private void setMode(DcMotor.RunMode runMode) {
        frontLeft.setMode(runMode);
        frontRight.setMode(runMode);
        rearLeft.setMode(runMode);
        rearRight.setMode(runMode);
    }

    private void forward(double distance) {
        frontRight.setTargetPosition((int)(frontRight.getCurrentPosition() + distance));
        frontLeft.setTargetPosition((int)(frontLeft.getCurrentPosition() + distance));
        rearRight.setTargetPosition((int)(rearRight.getCurrentPosition() + distance));
        rearLeft.setTargetPosition((int)(rearLeft.getCurrentPosition() + distance));

        while (isBusy())
            ;
    }

    private boolean isBusy() {
        return frontRight.isBusy() || frontLeft.isBusy() || rearRight.isBusy() || rearLeft.isBusy();
    }
}
