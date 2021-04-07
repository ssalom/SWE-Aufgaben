// Titel:          Jahrgang sortieren
// Autor:          Marco Bontognali
// Firma:          ABB TS
// Beschreibung:   Sortieren von Objekten mit Comparator.

class Person {
  private String name;
  private int jahrgang;

  public Person(String name, int jahrgang) {
    this.name = name;
    this.jahrgang = jahrgang;
  }

  public int getJahrgang() {
    return jahrgang;
  }

  @Override
  public String toString() {
    return "Person{" + "name=" + name + ", jahrgang=" + jahrgang + '}';
  }
}
