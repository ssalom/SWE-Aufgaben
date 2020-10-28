import java.util.ArrayList;
import java.util.List;

public class Datenstrukturen1 {


  public static void main(String[] args) {
    List<String> list = new ArrayList<>();

    list.add("a");
    list.add("b");
    list.add("c");

    System.out.println(list);
    System.out.println(list.get(1));
    list.set(0, "x");
    System.out.println(list);
    list.add(0,"y");
    list.remove(2);



  }
}
