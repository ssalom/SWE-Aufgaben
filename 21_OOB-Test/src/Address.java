// Titel:          OODB-Test
// Autor:          Marco Bontognali
// Firma:          ABB TS
// Beschreibung:   Adress-Klasse.

class Address {
  private String firstName;
  private String lastName;
  
  public Address(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String toString() {
    return firstName + " " + lastName;
  }
}
