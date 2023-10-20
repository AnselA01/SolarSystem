package SolarSystem;

import Body.*;

import java.awt.Toolkit;
import java.awt.Dimension;

public class SolarSystemDriver {
    SolarSystem solarSystemCanvas;
    Star star;
    Planet[] planets;

    /**
    * Initializes and displays a basic static or animated picture of the solar system.
    *
    * @param animateOrbit flag to animate the orbit of bodies
    * */
    public  void initializeSystem(boolean animateOrbit) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.solarSystemCanvas = new SolarSystem(screenSize.width, screenSize.height);

        // Set star and planets variables
        this.star = new Star();
        this.initializePlanets();

        // Orbit animation
        while (animateOrbit) {
            this.drawSystem();
        }
        this.drawSystem();
    }

    private void initializePlanets() {
        this.planets = new Planet[Planet.PlanetList.values().length];

        int index = 0;
        for (Planet.PlanetList planetName : Planet.PlanetList.values()) {
            Planet planetObject = Planet.create(planetName);
            this.planets[index] = planetObject;
            index++;
        }
    }

    private void drawPlanet(Planet planet) {
        planet.setAngleToParent(planet.getAngleToParent() + planet.getVelocity());
        this.solarSystemCanvas.drawSolarObject(
                planet.getDistanceToParent(),
                planet.getAngleToParent(),
                planet.getDiameter(),
                planet.getColor());
    }

    private void drawStar() {
        this.solarSystemCanvas.drawSolarObject(
                0,
                0,
                this.star.getDiameter(),
                this.star.getColor());
        this.star.drawSmileyFace(this.solarSystemCanvas); // :)
    }

    private void drawMoons(Planet parentPlanet) {
        // Can only draw one level of moons atm because apparently moons can have moons
        int moonCount = 0; // used to equally position each moon on the orbit path
        for (Moon moon : parentPlanet.getMoons()) {
            moonCount++;
            // Update angle and draw new position
            moon.setAngleToParent(moon.getAngleToParent() + moon.getVelocity());
            this.solarSystemCanvas.drawSolarObjectAbout(
                    ((double) parentPlanet.getDiameter() / 2) + 5,
                    moonCount * ((double) 360 / parentPlanet.getNumberOfChildren()) + moon.getAngleToParent(),
                    moon.getDiameter(),
                    moon.getColor(),
                    parentPlanet.getDistanceToParent(),
                    parentPlanet.getAngleToParent());
        }
    }

    private void drawSystem() {
        this.drawStar();
        for (Planet planet : this.planets) {
            this.drawPlanet(planet);
            this.drawMoons(planet);
        }
        this.solarSystemCanvas.finishedDrawing();
    }
}