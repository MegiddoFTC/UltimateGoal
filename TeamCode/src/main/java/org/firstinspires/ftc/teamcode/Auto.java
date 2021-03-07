package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="AutoTest")
public class Auto extends DefaultAuto {

    @Override
    public void start() {
        move_foreword(100);
        move_foreword(-100);
    }
}
