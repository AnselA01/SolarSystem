package Body;

public class Moon extends OrbitingBody {
    public Moon() {
        this.angleToParent = 0;
        this.velocity = 2;
        this.diameter = 5;
        this.numberOfChildren = 0;
        this.color = "GRAY";
    }
    @SuppressWarnings("unused")
    public Moon(int angleToParent, int velocity, int diameter, int numberOfChildren, String color) {
        this.angleToParent = angleToParent;
        this.velocity = velocity;
        this.numberOfChildren = numberOfChildren;
        this.color = color;
    }
}
