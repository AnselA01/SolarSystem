import SolarSystem.*;

/**
 *  The solar system project implements a basic solar system.
 *
 * @author Ansel Alldredge
 * **/

public class SolarSystemMain  {
    public static void main(String[] args) {
        SolarSystemDriver solarSystemBuilder = new SolarSystemDriver();
        solarSystemBuilder.initializeSystem(true);
    }
}