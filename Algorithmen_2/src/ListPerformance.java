import java.util.ArrayList;
import java.util.List;

public class ListPerformance {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    long time;
    long duration;

    for (int i = 0; i <= 1000000; i++) {
      list.add(Integer.toString(i));
    }

    System.out.println("Neues Objekt an Position 10 einfügen.");
    time = System.nanoTime();
      list.add(10, "10");
    duration = (System.nanoTime() - time) / 1000;
    System.out.println(duration);

    System.out.println("Objekt an Position 10 löschen.");
    time = System.nanoTime();
    list.remove(10);
    duration = (System.nanoTime() - time) / 1000;
    System.out.println(duration);

    System.out.println("Objekt an Position 500'000 lesen.");
    time = System.nanoTime();
    list.get(500000);
    duration = (System.nanoTime() - time) / 1000;
    System.out.println(duration);

    System.out.println("Objekt an Position 500'000 schreiben.");
    time = System.nanoTime();
    list.set(500000, "New 500'000");
    duration = (System.nanoTime() - time) / 1000;
    System.out.println(duration);

  }

}
