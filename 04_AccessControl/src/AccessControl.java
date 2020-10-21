import ch.abbts.model.*;
import java.awt.Color;

public class AccessControl {

    public static void main(String[] args) {
        Control control = new Control();
        TouchSensor touch1 = new TouchSensor("Taste 1", 3);
        control.add(touch1);

        TouchSensor touch2 = new TouchSensor("Taste 2", 4);
        control.add(touch2);

        control.add(new ColorSensor("Farbsensor", 2, "green"));

        control.work();
    }
}
