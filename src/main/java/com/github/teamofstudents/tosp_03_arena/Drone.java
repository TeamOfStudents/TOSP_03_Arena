package com.github.teamofstudents.tosp_03_arena;
import java.awt.Color;
import java.awt.geom.Point2D;
// import java.awt.geom.Point2D.Double;
// import java.util.ArrayList;

import com.github.teamofstudents.tosp_03_arena.DroneLogic.DroneLogic;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;


public class Drone {

    private Logger logger = (Logger) LoggerFactory.getLogger(Drone.class);

    public static final String COMMAND_THRUST_INCREASE = "COMMAND_THRUST+";
    public static final String COMMAND_THRUST_DECREASE = "COMMAND_THRUST-";
    public static final String COMMAND_LEFT_10 = "COMMAND_LEFT_10";
    public static final String COMMAND_RIGHT_10 = "COMMAND_RIGHT_10";
    public static final String COMMAND_TOGGLE_CONTROL = "COMMAND_TOGGLE_CONTROL";

    public static final String CONTROL_TYPE_AUTO = "AUTO";
    public static final String CONTROL_TYPE_MANUAL = "MANUAL";

    
    private String name;
    private Color mycolor;
    private DroneLogic droneLogic;
    private Point2D.Double position = new Point2D.Double(100.0, 100.0);
    private CommandSet commandSet = new CommandSet(180, 0.1);
    private int credits = 0;
    private String controlType = CONTROL_TYPE_AUTO;
    

    /** actual speed above ground in m/s */
    private double groundSpeed;

    /** actual direction of movement of drone in relation to the surface, given in degrees [0-360] */ 
    private double groundTrack;

    // private double currentHeading;

    /**  drone mass in kg */
    private int mass = 20;

    /** available horizontal thrust in Newton */ 
    private int thrustHorizontal = 1000;

    /** Coefficient of Drag from front/ German: Cw Wert */
    private double cDfront = 0.2;


    // private double cDcross = 0.2;



    /**
     * Cross Section Area of Drone in m²
     * <p>
     * used to determine the drag force Fd
     */
    private double crossSectionAreaFwd = 1; // in m²

    // private double crossSectionAreaCross = 1; // in m²

    

    public Drone(String name, DroneLogic droneLogic, Point2D.Double position, Color mycolor) {
        this.name = name;
        this.position = position;
        this.mycolor = mycolor;
        this.droneLogic = droneLogic;

        logger.setLevel(Level.INFO);
        // logger.setLevel(Level.DEBUG);
        // logger.setLevel(Level.TRACE);
    }


    /*------ Methoden -----------------*/


    public void translate(double dx, double dy) {
        position.setLocation(position.x + dx, position.y + dy);
    }

    public Point2D.Double getAccelerationVector(){
        double thrustSpeedChange = thrustHorizontal * commandSet.getThrust() / mass;
        return Arena.vectorEndPoint(commandSet.getHeading(), thrustSpeedChange);
    }

    public void calculateNewCommand(double timeIndex, Waypoint wayPoint) {
        if (controlType == CONTROL_TYPE_AUTO){
            commandSet = droneLogic.calculateNewCommand(timeIndex, wayPoint);    
        }
        
    }

    public void changeCredits(int delta) {
        credits = credits + delta;
    }

    public void manualDroneControl(String order) {
        int commandedHeading = commandSet.getHeading();
        double commandedThrust = commandSet.getThrust();
        switch (order) {
            case Drone.COMMAND_THRUST_INCREASE:
                commandSet = new CommandSet(commandedHeading, commandedThrust + 0.1);
                break;
            case Drone.COMMAND_THRUST_DECREASE:
                commandSet = new CommandSet(commandedHeading, commandedThrust - 0.1);
                break;
            case Drone.COMMAND_LEFT_10:
                commandSet = new CommandSet(commandedHeading - 10, commandedThrust);
                break;
            case Drone.COMMAND_RIGHT_10:
                commandSet = new CommandSet(commandedHeading + 10, commandedThrust);
                break;
            case Drone.COMMAND_TOGGLE_CONTROL:
                if (controlType == CONTROL_TYPE_AUTO) {
                    controlType = CONTROL_TYPE_MANUAL;
                } else {
                    controlType = CONTROL_TYPE_AUTO;
                }
                break;
            default:
                logger.warn("Drone received non existing order! (manualDroneControl");
                break;
        }
        
    }

    /*------ Getters / Setters -----------------*/





    public String getControlType() {
        return controlType;
    }


    public void setControlType(String controlType) {
        this.controlType = controlType;
    }

    


    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }


    
    public CommandSet getCommandSet() {
        return commandSet;
    }

    public void setCommandSet(CommandSet commandSet) {
        this.commandSet = commandSet;
    }



    public double getcDfront() {
        return cDfront;
    }

    public double getCrossSectionAreaFwd() {
        return crossSectionAreaFwd;
    }
/*
    public double getCurrentHeading() {
        return currentHeading;
    }

    public void setCurrentHeading(double currentHeading) {
        this.currentHeading = currentHeading;
    }
*/
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public double getGroundTrack() {
        return groundTrack;
    }

    public void setGroundTrack(double groundTrack) {
        this.groundTrack = groundTrack;
    }

    public int getMass() {
        return mass;
    }

    // public void setMass(int mass) {
    //     this.mass = mass;
    // }

    public int getThrustHorizontal() {
        return thrustHorizontal;
    }

    // public void setThrustHorizontal(int thrustHorizontal) {
    //     this.thrustHorizontal = thrustHorizontal;
    // }

    public int getLatestCommandHeading() {
        return commandSet.getHeading();
    }

    // public int getLatestCommandSpeed() {
    //     return latestCommandSpeed;
    // }

    public double getLatestCommandThrust() {
        return commandSet.getThrust();
    }

    public double getGroundSpeed() {
        return groundSpeed;
    }

    public void setGroundSpeed(double groundSpeed) {
        this.groundSpeed = groundSpeed;
    }

    public Color getMycolor() {
        return mycolor;
    }

    public void setMycolor(Color mycolor) {
        this.mycolor = mycolor;
    }

    public double getX() {
        return position.getX();
    }

    public double getY() {
        return position.getY();
    }

    public Point2D.Double getLocation() {
        return position;
    }

    public Point2D.Double getLocationFromDroneLogic() {
        credits -= 10;
        return position;
    }

    public void setLocation(double x, double y) {
        position.setLocation(x, y);
    }


}
