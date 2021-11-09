package com.github.teamofstudents.tosp_03_arena;
// import java.awt.Rectangle;

// import javax.swing.JFrame;
// import java.awt.geom.Point2D;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import ch.qos.logback.classic.Level;
// import ch.qos.logback.classic.Logger;

public class App {

    public static void main(String[] args) {

        System.out.println("Hello");

        Arena myArena = new Arena(1500, 1000);

        myArena.run();

        // int test = 5;
        
        // Logger logger = (Logger) LoggerFactory.getLogger(App.class);
        // logger.setLevel(Level.ALL);
        // logger.error("Error");
        // logger.warn("warning");
        // logger.info("Hello World {}", test);
        // logger.debug("debug");
        // logger.trace("trace");
        
//         Logger root = (Logger)LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
//         root.setLevel(Level.ALL);



        
        System.out.println("Bye");
    }
}
