package com.github.teamofstudents.tosp_03_arena;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.geom.Point2D;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

class DrawPanel extends JPanel implements KeyListener {

    private Logger logger = (Logger) LoggerFactory.getLogger(DrawPanel.class);

    // Rectangle mr = new Rectangle(500, 500, 100, 100);
    Point displayPosition = new Point(500, 500);
    ArrayList<Drone> droneList;
    ArrayList<Waypoint> waypointList;
    RaceTrackMission raceTrackMission;
    private Drone manualDrone_1;
    private Drone manualDrone_2;

    public DrawPanel(ArrayList<Drone> droneList, ArrayList<Waypoint> waypointList, RaceTrackMission raceTrackMission) {
        this.droneList = droneList;
        this.waypointList = waypointList;
        this.raceTrackMission = raceTrackMission;
        addKeyListener(this);
        this.setFocusable(true);
        
        for (Drone drone : droneList) {
            if (drone.getName() == "ManualDrone_1") {
                manualDrone_1 = drone;
            }
            if (drone.getName() == "ManualDrone_2") {
                manualDrone_2 = drone;
            }
        }
        logger.setLevel(Level.DEBUG);
    }

  /*  
  public boolean isFocusTraversable() {
    return true;
  }*/

    public void keyTyped(KeyEvent e) {
        // logger.debug("KeyTyped: {}", e.getKeyChar()  == KeyEvent.CHAR_UNDEFINED ? "Kein Unicode-Character gedr\u00FCckt!" : e.getKeyChar() + " gedr\u00FCckt!");
        
        // System.out.println("KeyTyped: ");
        // if(e.getKeyChar() == KeyEvent.CHAR_UNDEFINED){
        //     System.out.println("Kein Unicode-Character gedr\u00FCckt!");
        // }else{
        //     System.out.println(e.getKeyChar() + " gedr\u00FCckt!");
        // }
        // System.out.println("---");
    }
    public void keyPressed(KeyEvent e) {
        // logger.debug("Taste: {}, Code: {}, Tastenposition: {}", e.getKeyChar(), e.getKeyCode(), e.getKeyLocation());

        switch (e.getKeyCode()) {
            case 65:    //a
                if(manualDrone_1 != null) manualDrone_1.manualDroneControl(Drone.COMMAND_LEFT_10);
                break;
            case 68:    //d
                if(manualDrone_1 != null) manualDrone_1.manualDroneControl(Drone.COMMAND_RIGHT_10);
                break;
            case 87:    //w
                if(manualDrone_1 != null) manualDrone_1.manualDroneControl(Drone.COMMAND_THRUST_INCREASE);
                break;
            case 83:    //s
                if(manualDrone_1 != null) manualDrone_1.manualDroneControl(Drone.COMMAND_THRUST_DECREASE);
                break;
            case 81:    //q
                if(manualDrone_1 != null) manualDrone_1.manualDroneControl(Drone.COMMAND_TOGGLE_CONTROL);
                break;
            
            case 37:    //arrow left
                if(manualDrone_2 != null) manualDrone_2.manualDroneControl(Drone.COMMAND_LEFT_10);
                break;
            case 39:    //arrow right
                if(manualDrone_2 != null) manualDrone_2.manualDroneControl(Drone.COMMAND_RIGHT_10);
                break;
            case 38:    //arrow up
                if(manualDrone_2 != null) manualDrone_2.manualDroneControl(Drone.COMMAND_THRUST_INCREASE);
                break;
            case 40:    //arrow down
                if(manualDrone_2 != null) manualDrone_2.manualDroneControl(Drone.COMMAND_THRUST_DECREASE);
                break;
            case 17:    //Ctrl right
                if(manualDrone_2 != null) manualDrone_2.manualDroneControl(Drone.COMMAND_TOGGLE_CONTROL);
                break;
        
                                
            default:
            logger.info("Taste ohne Zuweisung gedrückt: {}, Code: {}, Tastenposition: {}", e.getKeyChar(), e.getKeyCode(), e.getKeyLocation());
                break;
        }

    }

    public void keyReleased(KeyEvent e) {
        // logger.debug("KeyReleased: Taste: {}, Code: {}, \n---", e.getKeyChar(), e.getKeyCode());  
    }

    @Override
    protected void paintComponent(Graphics g1) {

        Graphics2D g = (Graphics2D) g1;
        super.paintComponent(g);
        // g.drawLine(mr.x, mr.y, mr.width, mr.height);
        for (Drone drone : droneList) {

            drawDrone(g, drone);
        }
        for (Waypoint waypoint : waypointList) {
            
            drawWaypoint(g, waypoint);
        }
        

        // mickey(g, mr);
    }

    

    private void drawWaypoint(Graphics2D g, Waypoint waypoint) {
        displayPosition.setLocation(translateToDisplayCoordinates(waypoint.getLocation()));
        g.setColor(Color.BLACK);
        int lineCount;
        String[] infoText = { 
            waypoint.getName(),
            "Value: " + waypoint.getValue(),
            "Target"
        };
        for (lineCount = 0; lineCount < infoText.length; lineCount++) {
            g.drawString(infoText[lineCount], displayPosition.x, displayPosition.y + lineCount * 12);
        }
        int size = 10;
        
        HashMap<Drone, Waypoint> nextWaypointMap = raceTrackMission.getNextWaypointMap();
        for (Drone drone : droneList) {
            if (nextWaypointMap.get(drone) == waypoint) {
                g.setColor(drone.getMycolor());
                // displayPosition.setLocation(translateToDisplayCoordinates(nextWaypointMap.get(drone).getLocation()));
                g.fillRect(displayPosition.x, displayPosition.y + (lineCount - 1) * 12 + 2, size, size);
                lineCount++;
            }   
        }
        
        // paint radius
        displayPosition.setLocation(translateToDisplayCoordinates(waypoint.getLocation()));
        g.setColor(Color.BLACK);
        int radius = waypoint.getRadius();
        size = radius * 2;
        g.drawOval(displayPosition.x - radius, displayPosition.y - radius, size, size);
    }

    public void drawDrone(Graphics2D g, Drone drone) {
        int size = 10;
        int halfSize = size / 2;
        int vectorLength = 5;
        g.setColor(drone.getMycolor());
        displayPosition.setLocation(translateToDisplayCoordinates(drone.getLocation()));
        g.fillOval(displayPosition.x - halfSize, displayPosition.y - halfSize, size, size);
        String[] infoText = { 
            "Speed: " + (int) drone.getGroundSpeed(),
            "Track: " + (int) drone.getGroundTrack() + " HDG: " + (int) drone.getLatestCommandHeading(),
            "Credits: " + drone.getCredits() ,
            drone.getControlType(),
            drone.getName()
        };
        for (int i = 0; i < infoText.length; i++) {
            g.drawString(infoText[i], displayPosition.x, displayPosition.y + i * 12);
        }

        // g.drawString(infoText[0], displayPosition.x, displayPosition.y);
        // g.drawString(infoText[1], displayPosition.x, displayPosition.y + 12);
        Point2D.Double lineTarget = translateToDisplayCoordinates(
                new Point2D.Double(drone.getLocation().x + drone.getAccelerationVector().x * vectorLength,
                        drone.getLocation().y + drone.getAccelerationVector().y * vectorLength));
        // int lineTargetX = (int) (displayPosition.x + lineTarget.x * vectorLength);
        // int lineTargetY = (int) (displayPosition.y + lineTarget.y * vectorLength);
        g.drawLine(displayPosition.x, displayPosition.y, (int) lineTarget.x, (int) lineTarget.y);

    }

    private Point2D.Double translateToDisplayCoordinates(Point2D.Double point) {
        int height = getSize().height;
        return new Point2D.Double(point.x, height - point.y);

    }

    // public void boxOval(Graphics g, Rectangle bb) {
    // g.fillOval(bb.x, bb.y, bb.width, bb.height);
    // }

    // public void mickey(Graphics g, Rectangle bb) {
    // boxOval(g, bb);

    // int dx = bb.width / 2;
    // int dy = bb.height / 2;
    // Rectangle half = new Rectangle(bb.x, bb.y, dx, dy);

    // half.translate(-dx / 2, -dy / 2);
    // boxOval(g, half);

    // half.translate(dx * 2, 0);
    // boxOval(g, half);
    // }
}
