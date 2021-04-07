// Titel:          Jahrgang sortieren
// Autor:          Marco Bontognali
// Firma:          ABB TS
// Beschreibung:   Sortieren von Objekten mit Comparator.

import java.util.Comparator;

class JahrgangComparator implements Comparator {
  public int compare(Object person1, Object person2) {
    int jahrgang1 = ((Person)person1).getJahrgang();
    int jahrgang2 = ((Person)person2).getJahrgang();
    return Integer.compare(jahrgang1, jahrgang2);
  }
}
