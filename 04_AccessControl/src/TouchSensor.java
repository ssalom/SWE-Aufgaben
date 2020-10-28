import ch.abbts.model.*;

class TouchSensor extends Sensor {

    public TouchSensor(String name, int port) {
        super(name, port);
    }

    public boolean isPressed() {
        return Model.in.isPressed(this.port);
    }

    public void waitForPressed() {
        while (!isPressed()) {
            Util.delay(100);
        }
    }

    @Override
    public String toString() {
        return name + "  am Port " + port;
    }
}
