import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetPerformance {
  public static void main(String[] args) {
    Set<String> set = new HashSet<>();
    long time;
    long duration;

    for (int i = 0; i <= 1000000; i++) {
      set.add(Integer.toString(i));
    }

    System.out.println("Neues Objekt einfügen");
    time = System.nanoTime();
    set.add("1000001");
    duration = (System.nanoTime() - time) / 1000;
    System.out.println(duration);

    System.out.println("Objekt löschen.");
    time = System.nanoTime();
    set.remove("500000");
    duration = (System.nanoTime() - time) / 1000;
    System.out.println(duration);

    System.out.println("Objekt lesen.");
    time = System.nanoTime();
    set.contains("700432");
    duration = (System.nanoTime() - time) / 1000;
    System.out.println(duration);


    set = new LinkedHashSet<>();
    for (int i = 0; i <= 1000000; i++) {
      set.add(Integer.toString(i));
    }

    System.out.println("Neues Objekt einfügen");
    time = System.nanoTime();
    set.add("1000001");
    duration = (System.nanoTime() - time) / 1000;
    System.out.println(duration);

    System.out.println("Objekt löschen.");
    time = System.nanoTime();
    set.remove("500000");
    duration = (System.nanoTime() - time) / 1000;
    System.out.println(duration);

    System.out.println("Objekt lesen.");
    time = System.nanoTime();
    set.contains("700432");
    duration = (System.nanoTime() - time) / 1000;
    System.out.println(duration);
  }
}
