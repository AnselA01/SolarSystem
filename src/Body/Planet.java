package Body;

public class Planet extends OrbitingBody {
    public enum PlanetList {
        MERCURY,
        VENUS,
        EARTH,
        MARS,
        SATURN,
        JUPITER,
        URANUS,
        NEPTUNE
    }
    Moon[] moons;

    public static Planet create(PlanetList planet) {
        return switch (planet) {
            case MERCURY -> new Planet(15, "GRAY", Math.random() * 360, 70, 2, 0);
            case VENUS -> new Planet(25, "#CD780F",Math.random() * 360, 100, 1.75, 0);
            case EARTH -> new Planet(25, "#465A3E",Math.random() * 360, 120, 1.5, 1);
            case MARS -> new Planet(20, "#F6805A",Math.random() * 360, 150, 1.25, 2);
            case JUPITER -> new Planet(40, "#DDCBA8",Math.random() * 360, 230, 1, 3);
            case SATURN -> new Planet(35, "#CAC096",Math.random() * 360, 280, 0.75, 2);
            case URANUS -> new Planet(30, "#13CFD1",Math.random() * 360, 350, 0.5, 2);
            case NEPTUNE -> new Planet(30, "#3F6CF7",Math.random() * 360, 400, 0.25, 2);
        };
    }
    public Planet(int diameter, String color, double angleToParent, int distanceToParent, double velocity, int numberOfChildren) {
        this.diameter = diameter;
        this.color = color;
        this.angleToParent = angleToParent;
        this.distanceToParent = distanceToParent;
        this.velocity = velocity;
        this.numberOfChildren = numberOfChildren;
        this.moons = new Moon[numberOfChildren];

        for (int i = 0; i < numberOfChildren; i++) {
            this.moons[i] = new Moon();
        }
    }

    public Moon[] getMoons() { return this.moons; }
}
