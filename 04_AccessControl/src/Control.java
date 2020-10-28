import ch.abbts.model.Model;
import ch.abbts.model.Util;
import java.util.ArrayList;

public class Control {
  private ArrayList<TouchSensor> sensors;
  private ColorSensor color;
  private DistanceSensor distance;

  public Control() {
    this.sensors = new ArrayList<>();
  }

  public void add (TouchSensor touch) {
    this.sensors.add(touch);
  }
  public void add (ColorSensor color) {
    this.color  = color;
  }
  public void add (DistanceSensor distance) {
    this.distance  = distance;
  }

  public void work ()  {
    while(true) {
      for (TouchSensor touch : sensors) {
        if (touch.isPressed()) {
          System.out.println(touch);
        }
      }
      Util.delay(1000);
      Model.out.setDisplay(color.getName());
      Model.out.setDisplay(color.getColor());
    }

  }


}
