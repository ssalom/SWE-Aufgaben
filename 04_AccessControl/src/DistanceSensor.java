public class DistanceSensor extends Sensor{

    private double distance;

    public DistanceSensor(String name, int port, double distance) {
        super(name, port);
        setDistance(distance);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
