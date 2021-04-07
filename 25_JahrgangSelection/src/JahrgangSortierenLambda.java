// Titel:          Jahrgang sortieren
// Autor:          Marco Bontognali
// Firma:          ABB TS
// Beschreibung:   Sortieren von Objekten mit Lambda-Ausdruck.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class JahrgangSortierenLambda {
  public static void main(String[] args) {
    List<Person> mitglieder = new ArrayList<>();
    mitglieder.add(new Person("Fritz", 1995));
    mitglieder.add(new Person("Anna", 1997));
    mitglieder.add(new Person("Hans", 1990));
    mitglieder.add(new Person("Vreni", 1992));
    
    System.out.println(mitglieder);
    mitglieder.sort( Comparator.comparingInt(Person::getJahrgang) );
    System.out.println(mitglieder);
    mitglieder.sort( Comparator.comparingInt(Person::getJahrgang).reversed() );
    System.out.println(mitglieder);

    // Alternative Variante
    mitglieder.sort(
      (person1, person2) -> Integer.compare(person1.getJahrgang(),
                                            person2.getJahrgang())
    );
    System.out.println(mitglieder);
  }
}
