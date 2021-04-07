/*
 * Titel: RDB-Test
 * Firma: ABB TS
 * Autor: M. Bontognali
 *
 * Beschreibung: 
 * Objekte via JDBC von MySQL DB laden.  
 * Verwendet die Bibliothek mysql-connector-java-8.0.11.jar.
 *
 * Achtung: 
 * MySQL Server muss in Betrieb sein.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

class LadenTest {
  public static void main(String[] args) {
    final String PROTOCOL = "jdbc:mysql";
    final String HOST = "localhost";
    final int PORT = 3306;
    final String DATABASE = "people";
    final String OPTIONS = "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    final String URL = PROTOCOL + "://" + HOST + ":" + PORT + "/" + DATABASE + "?" + OPTIONS;
    final String USER = "application";
    final String PASSWORD = "geheim";
    
    try {
      // Verbindung zur DB herstellen
      Connection connection;
      connection = DriverManager.getConnection(URL, USER, PASSWORD);
      
      // Statement erzeugen
      Statement statement = connection.createStatement();
      
      // Zeilen aus DB laden
      ResultSet data = statement.executeQuery("SELECT * FROM tabPerson"); 
      
      // Liste erstellen
      List<Person> list = new ArrayList<>();
      
      // Zeilen in Objekte umwandeln und der Liste hinzufügen
      while( data.next() ) {
        Person person = new Person();
        person.setName( data.getString("name") );
        person.setAge( data.getInt("age") );
        list.add(person);
      }
      
      // Liste ausgeben
      System.out.println(list);
    } 
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
