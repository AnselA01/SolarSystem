package SolarSystem;

import Body.*;

import java.awt.Toolkit;
import java.awt.Dimension;
import java.nio.channels.AsynchronousByteChannel;

public class SolarSystemDriver {
    private static final int NUMBER_OF_ASTEROIDS = 500;

    SolarSystem solarSystemCanvas;
    Star star;
    Planet[] planets;
    Asteroid[] asteroids;

    /**
    * Initializes and displays a basic static or animated picture of the solar system.
     * Many of the draw and initialize functions could be consolidated?
    *
    * @param animateOrbit flag to animate the orbit of bodies
    * */
    public  void initializeSystem(boolean animateOrbit) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.solarSystemCanvas = new SolarSystem(screenSize.width / 2, screenSize.height);

        // Initialize bodies
        this.star = new Star();
        this.initializePlanets();
        this.initializeAsteroids();

        // Start orbit animation
        while (animateOrbit) {
            this.drawSystem();
        }
        this.drawSystem(); // if not animateOrbit, only draw once.
    }

    /**
     * Initialize planets array with new Planet objects.
     * */
    private void initializePlanets() {
        this.planets = new Planet[Planet.PlanetList.values().length];

        int index = 0;
        for (Planet.PlanetList planetName : Planet.PlanetList.values()) {
            Planet planetObject = Planet.create(planetName);
            this.planets[index] = planetObject;
            index++;
        }
    }
    /**
     * Initialize asteroids array with new Asteroid objects.
     * */
    private void initializeAsteroids() {
        this.asteroids = new Asteroid[this.NUMBER_OF_ASTEROIDS];
        for (int i = 0; i < this.NUMBER_OF_ASTEROIDS; i++) {
            this.asteroids[i] = new Asteroid();
        }
    }
    /**
     * Draw asteroids around the sun.
     * */
    private void drawAsteroids() {
        int asteroidCount = 0;
        for (Asteroid asteroid : this.asteroids) {
            asteroidCount++;
            // Update angle and draw new position
            asteroid.setAngleToParent(asteroid.getAngleToParent() + asteroid.getVelocity());
            this.solarSystemCanvas.drawSolarObject(
                    asteroid.getDistanceToParent(),
                    asteroidCount * ((double) 360 / this.NUMBER_OF_ASTEROIDS) + asteroid.getAngleToParent(),
                    asteroid.getDiameter(),
                    asteroid.getColor());
        }
    }

    /**
     * Draw all planets in the planets array.
     * */
    private void drawPlanets() {
        for (Planet planet : this.planets) {
            this.drawPlanet(planet);
            this.drawMoons(planet);
        }
    }

    /**
     * Draw a single planet
     * @param planet Planet object.
     * */
    private void drawPlanet(Planet planet) {
        planet.setAngleToParent(planet.getAngleToParent() + planet.getVelocity());
        this.solarSystemCanvas.drawSolarObject(
                planet.getDistanceToParent(),
                planet.getAngleToParent(),
                planet.getDiameter(),
                planet.getColor());
    }
    @SuppressWarnings("unused")
    private void drawRing(Planet planet) {

    }

    /**
     * Draw a star in the middle of the canvas.
     * */
    private void drawStar() {
        this.solarSystemCanvas.drawSolarObject(
                0,
                0,
                this.star.getDiameter(),
                this.star.getColor());
        this.star.drawSmileyFace(this.solarSystemCanvas); // :)
    }

    /**
     * Draw a planet's moons
     * @param parentPlanet the planet whose moons to draw.
     * */
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


     /**
      * Call draw functions for each body.
      * */
    private void drawSystem() {
        this.drawStar();
        this.drawPlanets();
        this.drawAsteroids();
        this.solarSystemCanvas.finishedDrawing();

    }
}