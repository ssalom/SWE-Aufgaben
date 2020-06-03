public class DistanzSensor {
    private String name;
    private int port;
    private double distance;

    public DistanzSensor(String name, int port, double distance) {
        setName(name);
        setPort(port);
        setDistance(distance);
    }

    public void distanceToString() {
        System.out.println(this.getName() + "  am Port " + this.getPort() + " hat die Distanz " + this.getDistance());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        if (port >= 1 && port <=4) {
            this.port = port;
        } else {
            System.out.println(port + " ungültige Portnummer");
            System.exit(1);
        }
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
