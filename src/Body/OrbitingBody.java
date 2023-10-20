package Body;

public class OrbitingBody extends AbstractBody {
    int distanceToParent;
    double angleToParent;
    double velocity;
    int numberOfChildren;

    public int getDistanceToParent() {
        return this.distanceToParent;
    }

    @SuppressWarnings("unused")
    // TODO: Elliptic orbits
    public void setDistanceToParent(int distance) {
        this.distanceToParent = distance;
    }

    public double getVelocity() { return this.velocity; }

    @SuppressWarnings("unused")
    // TODO: Elliptic orbits
    public void setVelocity(double velocity) { this.velocity = velocity; }

    public double getAngleToParent() { return this.angleToParent; }

    public void setAngleToParent(double angle) { this.angleToParent = angle; }

    public int getNumberOfChildren() { return this.numberOfChildren; }
}
