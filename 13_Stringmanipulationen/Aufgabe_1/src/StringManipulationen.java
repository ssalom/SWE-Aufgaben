/*
 * Titel: StringManipulationen
 * Firma: ABB TS
 * Autor: Marco Bontognali

 * Aufgabenstellung:   
 *
 * myString1 bis myString5 sollen manipuliert und dann
 * dem resultString zugewiesen werden. Die Manipulation
 * soll dem originalString entsprechen. (Dies wird mit 
 * den Methoden toUpperCase(), toLowerCase(), trim() 
 * und replace() realisiert).
 * 
 * Anschliessend sollen die Manipulation mit equals() und
 * endsWith() überprüft werden.
 */

class StringManipulationen {
  public static void main(String[] args) {
    String myString1 = "Heute ";
    String myString2 = "XRBEITEN";
    String myString3 = "wir   ";
    String myString4 = "   mit"; 
    String myString5 = "Strings.";
    
    String resultString = "";
    String originalString = "HEUTE arbeiten wir mit Strings. ";

    resultString = myString1.toUpperCase().trim() + " ";
    resultString += myString2.toLowerCase().replace("x", "a") + " ";
    resultString += myString3.trim() + " ";
    resultString += myString4.trim() + " ";
    resultString += myString5 + " ";

    System.out.println(originalString.equals(resultString));


  }
}
