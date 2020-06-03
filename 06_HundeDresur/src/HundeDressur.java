// Projekt:        HundeDressur 6
// Thema:          Methodenaufrufe
// Autor:          Marco Bontognali
// Firma:          ABB TS
// Beschreibung:   Methodenaufrufe innerhalb der Klasse Hund

class HundeDressur {
  public static void main(String[] args) {
    Hund fido = new Hund();
    fido.setGewicht(4);

    Hund bello = new Hund();
    bello.setGewicht(12);

    fido.gibLaut(2);
    bello.gibLaut(4);
  }
}