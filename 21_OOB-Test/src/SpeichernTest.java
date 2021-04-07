// Titel:          OODB-Test
// Autor:          Marco Bontognali
// Firma:          ABB TS
// Beschreibung:   Objekte in OODB verwalten.
//                 Verwendet db4o-7.4.71.12224-java5.jar.

import com.db4o.Db4o;
import com.db4o.ObjectContainer;

class SpeichernTest {
  public static void main(String[] args) {

    // DB erstellen (legt File "Adressen.db4o" an)
    ObjectContainer db = Db4o.openFile("Adressen.db4o");

    // Objekte erzeugen
    Address kunde1 = new Address("Hans", "Meier");
    Address kunde2 = new Address("Vreni", "Huber");
    Address kunde3 = new Address("Fritz", "Huber");
    
    // Objekte speichern
    db.store(kunde1);
    db.store(kunde2);
    db.store(kunde3);

    // DB schliessen
    db.close();

    System.out.println("Objekte gespeichert.");
  }
}
