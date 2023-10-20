package Body;

import SolarSystem.SolarSystem;

public class Star extends AbstractBody {
    public Star() {
        this.diameter = 100;
        this.color = "YELLOW";
    }

    /**
     * :)
     *
     * @param solarSystem the SolarSystem where to draw the face
     * */
    public void drawSmileyFace(SolarSystem solarSystem) {
        // Mouth
        solarSystem.drawSolarObject(2, 0, this.diameter * 0.5, "BLACK");
        solarSystem.drawSolarObject(0, 0, this.diameter * 0.5, this.color);
        solarSystem.drawSolarObject(30, 65, 20, this.color);
        solarSystem.drawSolarObject(30, 295, 20, this.color);

        // Cheeks
        solarSystem.drawSolarObject(30, 80, 15, "#F5A700");
        solarSystem.drawSolarObject(30, 280, 15, "#F5A700");

        // Eyes
        solarSystem.drawSolarObject(15, 120, 17, "BLACK");
        solarSystem.drawSolarObject(15, 240, 17, "BLACK");

        solarSystem.drawSolarObject(14, 120, 17, this.color);
        solarSystem.drawSolarObject(14, 240, 17, this.color);

        solarSystem.drawSolarObject(22, 250, 7, this.color);
        solarSystem.drawSolarObject(9, 215, 7, this.color);
        solarSystem.drawSolarObject(22, 110, 7, this.color);
        solarSystem.drawSolarObject(9, 145, 7, this.color);
    }

}
