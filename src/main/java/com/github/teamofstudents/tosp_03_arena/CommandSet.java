package com.github.teamofstudents.tosp_03_arena;

public class CommandSet {

    private int heading;
    private double thrust;

    /**
     * A set of commands to communicate the instructions from the DroneLogic
     * @param heading ordered heading in degrees, this is the direction in which thrust will be applied, permitted values [0 - 360], values out of range are converted
     * @param thrust ordered thrust, given in %/100, permitted values are [0 - 1], values out of range will be converted to the closest allowed value (0 or 1)
     */
    public CommandSet(int heading, double thrust) {
        this.heading = (heading % 360 + 360) % 360;
        this.thrust = thrust < 0 ? 0 : (thrust > 1 ? 1 : thrust);
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public double getThrust() {
        return thrust;
    }

    public void setThrust(double thrust) {
        this.thrust = thrust;
    }

}
