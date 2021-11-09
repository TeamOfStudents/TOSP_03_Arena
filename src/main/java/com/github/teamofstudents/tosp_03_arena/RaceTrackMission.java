package com.github.teamofstudents.tosp_03_arena;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.geom.Point2D;


public class RaceTrackMission {
    private ArrayList<Waypoint> wayPointList;
    private ArrayList<Drone> droneList;
    private HashMap <Drone, Waypoint> nextWaypointMap = new HashMap<>();
    // private int requiredMaxDistance = 50;

    public RaceTrackMission(ArrayList<Waypoint> wayPointList, ArrayList<Drone> droneList) {
        this.wayPointList = wayPointList;
        this.droneList = droneList;
        for (Drone drone : droneList) {
            nextWaypointMap.put(drone, wayPointList.get(0));
        }
    }
    
    public Waypoint getNextWayPoint(Drone drone){
        Waypoint nextWaypoint = nextWaypointMap.get(drone);
        Point2D.Double position = drone.getLocation();

        if (position.distance(nextWaypoint) < nextWaypoint.getRadius()) {
            if (wayPointList.indexOf(nextWaypoint) + 1 < wayPointList.size()) {
                nextWaypointMap.put(drone, wayPointList.get(wayPointList.indexOf(nextWaypoint)+1));
            } else {
                nextWaypointMap.put(drone, wayPointList.get(0));
            }
            
            drone.changeCredits(100);
        }
        

        return nextWaypointMap.get(drone);
    }

    /*------ Getters / Setters -----------------*/

    public HashMap<Drone, Waypoint> getNextWaypointMap() {
        return nextWaypointMap;
    }

    public void setNextWaypointMap(HashMap<Drone, Waypoint> nextWaypointMap) {
        this.nextWaypointMap = nextWaypointMap;
    }


    
}
