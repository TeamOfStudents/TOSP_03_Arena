package com.github.teamofstudents.tosp_03_arena.DroneLogic;

// import java.awt.Color;
import java.awt.geom.Point2D;

import com.github.teamofstudents.tosp_03_arena.CommandSet;
import com.github.teamofstudents.tosp_03_arena.Waypoint;

public class LessStupidDroneLogic extends DroneLogic {

    /*
     * public LessStupidDrone(String name, Point2D.Double position, Color mycolor) {
     * super(name, position, mycolor); // TODO Auto-generated constructor stub }
     */

    public CommandSet calculateNewCommand(double timeIndex, Waypoint waypoint) {
        double requiredHeading;
        Point2D.Double position = super.getLocation();

        Waypoint firstWaypoint = waypoint;
        // requiredHeading = calcRotationAngleInDegrees(this.getLocation(),
        // firstWaypoint);
        // System.out.println(requiredHeading);

        // System.out.println(firstWaypoint);
        // System.out.println(this.getLocation());
        double dX = firstWaypoint.x - position.getX();
        double dY = firstWaypoint.y - position.getY();

        if (Math.abs(dX) > Math.abs(dY)) {
            if (dX > 0) {
                requiredHeading = 90;
            } else {
                requiredHeading = 270;
            }
        } else {
            if (dY > 0) {
                requiredHeading = 0;
            } else {
                requiredHeading = 180;
            }

        }

        return new CommandSet((int) requiredHeading, 1);

    }

}
