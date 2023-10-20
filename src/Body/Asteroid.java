package Body;

public class Asteroid extends OrbitingBody {
    public Asteroid() {
        this.diameter = (int) (Math.random() * 2) + 4;
        this.color = "GRAY";
        this.distanceToParent = (int) (Math.random() * 26) + 175;
        this.velocity = 0.125;
        this.numberOfChildren = 0;
    }
}
