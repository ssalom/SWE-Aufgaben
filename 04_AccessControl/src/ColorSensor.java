public class ColorSensor extends Sensor{
    private String color;

    public ColorSensor(String name, int port, String color) {
        super(name, port);
        setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
