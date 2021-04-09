package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Disabled
@Autonomous(name="AutoTest")
public class Auto extends DefaultAuto {

    @Override
    public void start() {
        telemetry.addData("status", "start");
        telemetry.update();
        move_foreword(10);
//        move_foreword(-50);
//        pumpPower(1);
//        move_foreword(100);
//        pumpPower(0);
//        turn(100);
    }

    @Override
    public void loop() {
        telemetry.addData("status", "loop");
        telemetry.update();
    }
}
