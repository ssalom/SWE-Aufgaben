import ch.abbts.model.*;

class TouchSensor {
    private String name;
    private int port;

    public TouchSensor(String name, int port) {
        setName(name);
        setPort(port);
    }

    private boolean isPressed() {
        return Model.in.isPressed(this.port);
    }

    public void waitForPressed() {
        while (!isPressed()) {
            Util.delay(100);
        }
    }


    public String toString() {
        return this.getName() + "  am Port " + this.getPort();
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
}
