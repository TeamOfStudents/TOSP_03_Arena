package com.github.teamofstudents.tosp_03_arena;

import java.awt.geom.Point2D;

public class Waypoint extends Point2D.Double {

    private String name;
    private int value;
    private int radius = 50;

    public Waypoint(String name, double x, double y,  int value) {
        super(x, y);
        this.name = name;
        this.value = value;
    }


    
    public Waypoint(String name, double x, double y, int value, int radius) {
        super(x, y);
        this.name = name;
        this.value = value;
        this.radius = radius;
    }



    public int getRadius() {
        return radius;
    }



    public void setRadius(int radius) {
        this.radius = radius;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Point2D.Double getLocation() {
        return new Point2D.Double(super.x, super.y);
    }

}
