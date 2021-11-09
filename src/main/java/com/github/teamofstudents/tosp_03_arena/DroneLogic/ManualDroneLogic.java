package com.github.teamofstudents.tosp_03_arena.DroneLogic;

import com.github.teamofstudents.tosp_03_arena.CommandSet;
import com.github.teamofstudents.tosp_03_arena.Waypoint;

public class ManualDroneLogic extends DroneLogic{
    /*
    public StupidDroneLogic(Drone drone) {
        super(drone);
    }
*/
    public CommandSet calculateNewCommand(double timeIndex, Waypoint waypoint) {

        return super.getCommandSet();

    }
}
