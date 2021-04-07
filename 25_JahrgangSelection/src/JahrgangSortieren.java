// Titel:          Jahrgang sortieren
// Autor:          Marco Bontognali
// Firma:          ABB TS
// Beschreibung:   Sortieren von Objekten mit Comparator.

import java.util.*;

class JahrgangSortieren {
  public static void main(String[] args) {
    List<Person> mitglieder = new ArrayList<>();
    mitglieder.add(new Person("Fritz", 1995));
    mitglieder.add(new Person("Anna", 1997));
    mitglieder.add(new Person("Hans", 1990));
    mitglieder.add(new Person("Vreni", 1992));
    
    System.out.println(mitglieder);
    mitglieder.sort(new JahrgangComparator());
    System.out.println(mitglieder);
  }
}
