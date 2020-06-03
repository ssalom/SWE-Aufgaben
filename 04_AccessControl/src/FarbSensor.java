public class FarbSensor {
    private String name;
    private int port;
    private String color;

    public FarbSensor(String name, int port, String color) {
        setName(name);
        setPort(port);
        setColor(color);
    }

    public void colorToString () {
        System.out.println(this.getName() + "  am Port " + this.getPort());
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
