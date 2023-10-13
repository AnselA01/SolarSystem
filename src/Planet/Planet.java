package Planet;

import Star.Star;

import java.awt.*;

public class Planet {
    int diameter;
    int angle;
    Color color;

    Planet(int diam, int ang, Color col) {
        this.diameter = diam;
        this.angle = ang;
        this.color = col;
    }
}
