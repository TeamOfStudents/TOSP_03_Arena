package com.github.teamofstudents.tosp_03_arena.DroneLogic;

import java.awt.geom.Point2D;

import com.github.teamofstudents.tosp_03_arena.CommandSet;
import com.github.teamofstudents.tosp_03_arena.Drone;
import com.github.teamofstudents.tosp_03_arena.Waypoint;

public abstract class DroneLogic {

    private Drone drone;
    
    
    protected Point2D.Double getLocation(){
        
        return drone.getLocationFromDroneLogic();
    }

    protected CommandSet getCommandSet(){
        return drone.getCommandSet();
    }

/*
    public Drone getDrone() {
        return drone;
    }
*/
    public void setDrone(Drone drone) {
        this.drone = drone;
    }



    public abstract CommandSet calculateNewCommand(double timeIndex, Waypoint wayPoint);
}
