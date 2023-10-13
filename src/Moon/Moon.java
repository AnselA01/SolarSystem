package Moon;

import Planet.Planet;

public class Moon {
    Planet parent;
    Moon(Planet par) {
        this.parent = par;
    }
}
