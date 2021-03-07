package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public abstract class DefaultAuto extends Default {

    @Override
    public void init() {
        super.init();

        setDriveRunMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    protected void move_foreword(double cm) {
        frontLeft.setTargetPosition((int)Util.cm2ticks(cm));
        rearLeft.setTargetPosition((int)Util.cm2ticks(cm));
        frontRight.setTargetPosition((int)Util.cm2ticks(cm));
        rearRight.setTargetPosition((int)Util.cm2ticks(cm));
        while (isBusy());
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
