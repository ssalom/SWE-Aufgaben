/**
 * Zeigt die Verwendung eines Konstruktors.
 * 
 * @author Marco Bontognali 
 * @version 1.0
 */
class Test {
  public static void main(String args[]) {
    System.out.println("Anzahl Raumschiffe: " + Raumschiff.getObjectCount());

    System.out.println("1. Raumschiff erzeugen..."); 
    Raumschiff orion = new Raumschiff("Orion", 4);
    orion.starten();

    System.out.println("Anzahl Raumschiffe: " + Raumschiff.getObjectCount());

    System.out.println("\n2. Raumschiff erzeugen..."); 
    Raumschiff sirius = new Raumschiff("Sirius", 8);
    sirius.starten();

    System.out.println("Anzahl Raumschiffe: " + Raumschiff.getObjectCount());
  }
}

