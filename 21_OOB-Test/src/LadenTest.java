// Titel:          OODB-Test
// Autor:          Marco Bontognali
// Firma:          ABB TS
// Beschreibung:   Objekte in OODB verwalten.
//                 Verwendet db4o-7.4.71.12224-java5.jar.

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.List;

class LadenTest {
  public static void main(String[] args) {
    System.out.println("Lade Objekte:");

    // DB öffnen
    ObjectContainer db = Db4o.openFile("Adressen.db4o");

    // Alle Objekte der Klasse Address laden
    List<Address> adressen = db.query(Address.class);
    showResult(adressen);

    // Alle Address-Objekte mit Namen = Huber laden
    Address muster = new Address(null, "Huber");
    ObjectSet result = db.queryByExample(muster);
    showResult(result);
    
    // DB schliessen
    db.close();
  }

  // ObjectSet ausgeben
  public static void showResult(List result) {
    System.out.println("Anzahl:" + result.size());
    for (Object o : result) {
      System.out.println(o);
    }
  }
}
