package com.github.teamofstudents.tosp_03_arena.DroneLogic;

// import java.awt.Color;
import java.awt.geom.Point2D;
// import java.awt.Point;
// import java.util.ArrayList;

import com.github.teamofstudents.tosp_03_arena.Arena;
import com.github.teamofstudents.tosp_03_arena.CommandSet;
import com.github.teamofstudents.tosp_03_arena.Waypoint;

public class BasicDroneLogic extends DroneLogic {

    public CommandSet calculateNewCommand(double timeIndex, Waypoint waypoint) {
        double requiredHeading;
        Point2D.Double position = super.getLocation();

       
        // if (position.distance(waypoint) < 50) {
            
        // }
        requiredHeading = Arena.calcRotationAngleInDegrees(position, waypoint);

        // System.out.println(firstWaypoint);
        // System.out.println(this.getLocation());
       

        return new CommandSet((int) requiredHeading, 1);
    }
}