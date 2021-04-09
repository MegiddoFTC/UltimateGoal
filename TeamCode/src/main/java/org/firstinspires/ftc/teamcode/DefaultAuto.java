package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public abstract class DefaultAuto extends Default {

    @Override
    public void init() {
        telemetry.addData("status", "init");
        telemetry.update();
        super.init();
        frontLeft.setTargetPosition(0);
        rearLeft.setTargetPosition(0);
        frontRight.setTargetPosition(0);
        rearRight.setTargetPosition(0);
        setDriveRunMode(DcMotor.RunMode.RUN_TO_POSITION);
        powerDriveMotors(1);
    }

    protected void move_foreword(double cm) {
        frontLeft.setTargetPosition((int)Util.cm2ticks(cm));
        rearLeft.setTargetPosition((int)Util.cm2ticks(cm));
        frontRight.setTargetPosition((int)Util.cm2ticks(cm));
        rearRight.setTargetPosition((int)Util.cm2ticks(cm));
        while (isBusy());
    }

    protected void turn(double cm){
        frontLeft.setTargetPosition((int)Util.cm2ticks(-cm));
        rearLeft.setTargetPosition((int)Util.cm2ticks(-cm));
        frontRight.setTargetPosition((int)Util.cm2ticks(cm));
        rearRight.setTargetPosition((int)Util.cm2ticks(cm));
        while (isBusy());
    }
    protected void PumpOnEnter(){
        pumpPower(1);
    }

    protected boolean isBusy() {
        return frontLeft.isBusy() || rearLeft.isBusy() || frontRight.isBusy() || rearRight.isBusy();
    }

    @Override
    public abstract void start();

    @Override
    public void loop() {
        requestOpModeStop();
    }
}
