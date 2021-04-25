package org.firstinspires.ftc.teamcode;

public final class Util {
    static final double R = inc2cm(3);

    static double ticks2cm(double ticks) {
        return ticks * 2 * Math.PI * R / 2400;
    }

    static double cm2ticks(double cm) {
        return cm / 2 / Math.PI / R * 28 * 20;
    }

    static double inc2cm(double inc) {
        return inc * 2.54;
    }

    static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
}
