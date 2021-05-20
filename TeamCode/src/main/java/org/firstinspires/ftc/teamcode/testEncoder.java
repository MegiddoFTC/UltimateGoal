package org.firstinspires.ftc.teamcode;

    import android.util.Pair;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="testEncoder")
public class testEncoder extends OpMode {
    //double time = Double.MAX_VALUE;


    DcMotor left;
    DcMotor right;

    @Override
    public void init() {
        left = hardwareMap.dcMotor.get("shootMotor");
        right = hardwareMap.dcMotor.get("shootMotor2");

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void loop() {

        if (gamepad1.a){
            left.setPower(0.1);
        }else if (gamepad1.x){

            right.setPower(0.1);
        }else if (gamepad1.b){
            left.setPower(0);
            right.setPower(0);
        }

        telemetry.addData("left", left.getCurrentPosition());
        telemetry.addData("right", right.getCurrentPosition());

        telemetry.update();
    }

}

