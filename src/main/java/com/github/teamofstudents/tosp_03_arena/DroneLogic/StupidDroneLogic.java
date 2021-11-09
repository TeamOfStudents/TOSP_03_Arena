package com.github.teamofstudents.tosp_03_arena.DroneLogic;

import com.github.teamofstudents.tosp_03_arena.CommandSet;
import com.github.teamofstudents.tosp_03_arena.Waypoint;

public class StupidDroneLogic extends DroneLogic{
    /*
    public StupidDroneLogic(Drone drone) {
        super(drone);
    }
*/
    public CommandSet calculateNewCommand(double timeIndex, Waypoint waypoint) {

        //double requiredThrust = 1;
        //int requiredHeading = 90;

        double requiredThrust = (timeIndex % 10) / 10;
        int requiredHeading = (int) timeIndex * -20 + 180;

               
        if (timeIndex > 30) {
            // requiredThrust = 0;
        }

        return new CommandSet(requiredHeading, requiredThrust);

    }
}
