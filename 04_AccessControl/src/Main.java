import ch.abbts.model.*;

public class Main {

    public static void main(String[] args) {
        TouchSensor touch1 = new TouchSensor("Taste 1", 3);
        TouchSensor touch2 = new TouchSensor("Taste 2", 4);
        //TouchSensor touch1 = new TouchSensor();
        //TouchSensor touch2 = new TouchSensor();

        touch1.setName("Taste 1");
        touch1.setPort(3);

        touch2.setName("Taste 2");
        touch2.setPort(4);

        touch1.toString();
        touch2.toString();

        //System.out.println(touch1.isPressed());
       // System.out.println(touch2.isPressed());

        System.out.println("Vor Pressed...");
        touch1.waitForPressed();
        System.out.println("Nach Pressed...");
    }
}
