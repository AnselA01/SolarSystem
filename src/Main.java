import Star.Star;

public class Main {

    public static void main(String[] args) {
        SolarSystem solarSystem = new SolarSystem(750, 750);

        int earthAngle = 20;
        int marsAngle = 30;
        int moonAngle = 0;

        while(true) {
            // Sun is always in the same spot
            solarSystem.drawSolarObject(50, 0, 100, "YELLOW");

            // Earth
            solarSystem.drawSolarObject(200, earthAngle, 25, "BLUE");
            earthAngle = earthAngle == 360 ? 0 : earthAngle + 1;

            // Moon
            solarSystem.drawSolarObjectAbout(30, moonAngle, 10, "WHITE", 200, earthAngle);
            moonAngle = moonAngle == 360 ? 0 : moonAngle + 1;

            // Mars
            solarSystem.drawSolarObject(325, marsAngle, 20, "RED");
            marsAngle = marsAngle == 360 ? 0 : marsAngle + 1;


            // clear canvas on every angle change
            solarSystem.finishedDrawing();
        }
    }
}