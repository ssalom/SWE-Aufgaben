import ch.abbts.model.*;

public class TouchSensor {
    String name;
    int port;

    public TouchSensor(String name, int port) {
        this.name = name;
        this.port = port;
    }

    boolean isPressed() {
        return Model.in.isPressed(this.port);
    }

    void waitForPressed() {
        while (!isPressed()) {
            Util.delay(100);
        }
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
        this.port = port;
    }
}
