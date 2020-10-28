public class Sensor {
  protected String name;
  protected int port;


  public Sensor(String name, int port) {

    this.name = name;
    this.port = port;
  }

  public String getName() {
    return name;
  }
}

