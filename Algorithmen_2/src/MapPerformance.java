import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapPerformance {

  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    long time;
    long duration;
    for (int i = 0; i <= 1000000; i++) {
      map.put(Integer.toString(i), "New Entry " + Integer.toString(i));
    }

    System.out.println("Neues Objekt einfügen");
    time = System.nanoTime();
    map.put("1000001" , "New Entry 1000001");
    duration = (System.nanoTime() - time) / 1000;
    System.out.println(duration);

    System.out.println("Objekt löschen.");
    time = System.nanoTime();
    map.remove("500000");
    duration = (System.nanoTime() - time) / 1000;
    System.out.println(duration);

    System.out.println("Objekt lesen.");
    time = System.nanoTime();
    map.get("700432");
    duration = (System.nanoTime() - time) / 1000;
    System.out.println(duration);

    System.out.println("Objekt schreiben.");
    time = System.nanoTime();
    map.replace("700432", "Replaced Entry 700432");
    duration = (System.nanoTime() - time) / 1000;
    System.out.println(duration);

    map = new LinkedHashMap<>();
    System.out.println("Neues Objekt einfügen");
    time = System.nanoTime();
    map.put("1000001" , "New Entry 1000001");
    duration = (System.nanoTime() - time) / 1000;
    System.out.println(duration);

    System.out.println("Objekt löschen.");
    time = System.nanoTime();
    map.remove("500000");
    duration = (System.nanoTime() - time) / 1000;
    System.out.println(duration);

    System.out.println("Objekt lesen.");
    time = System.nanoTime();
    map.get("700432");
    duration = (System.nanoTime() - time) / 1000;
    System.out.println(duration);

    System.out.println("Objekt schreiben.");
    time = System.nanoTime();
    map.replace("700432", "Replaced Entry 700432");
    duration = (System.nanoTime() - time) / 1000;
    System.out.println(duration);
  }
}
