/**
 * Zeigt die Verwendung eines Konstruktors.
 * 
 * @author  Marco Bontognali 
 * @version 1.0
 */

class Raumschiff {
  private String name;
  private int besatzung;
  private static int objectCount;
  
  // Konstruktor
  public Raumschiff(String name, int besatzung) {
    this.name = name;
    this.besatzung = besatzung;
    objectCount++;
  }
  
  public void starten() {
    System.out.println(besatzung + " steigen ein");
    System.out.println("Tueren schliessen");      
    System.out.println(name + " startet");
  }

  public static int getObjectCount() {
    return objectCount;
  }

}


