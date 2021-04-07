/*
 * Titel: RDB-Test
 * Firma: ABB TS
 * Autor: M. Bontognali
 *
 * Beschreibung: 
 * Objekte via JDBC in MySQL DB speichern. 
 * Verwendet die Bibliothek mysql-connector-java-8.0.21.jar.
 * 
 * Einrichten der Datenbank:
 * create database people;
 * use people;
 * CREATE TABLE tabPerson
 * (
 *   name VARCHAR(50) NOT NULL,
 *   age INTEGER
 * );
 * 
 * Achtung: 
 * MySQL Server muss in Betrieb sein.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class SpeichernTest {
  public static void main(String[] args) {
    final String PROTOCOL = "jdbc:mysql";
    final String HOST = "localhost";
    final int PORT = 3306;
    final String DATABASE = "people";
    final String OPTIONS = "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    final String URL = PROTOCOL + "://" + HOST + ":" + PORT + "/" + DATABASE + "?" + OPTIONS;
    final String USER = "application";
    final String PASSWORD = "geheim";
    
    // Objekt erstellen
    Person person = new Person("Vreni", 22);
    
    try {
      // Verbindung zur DB herstellen
      Connection connection;
      connection = DriverManager.getConnection(URL, USER, PASSWORD);
      
      // Statement erzeugen
      Statement statement = connection.createStatement();
      
      // Objekt in DB speichern
      statement.executeUpdate("INSERT INTO tabPerson (" +
                                "name, " +
                                "age) " + 
                              "VALUES (" +
                                "\'" + person.getName() + "\', " + 
                                "\'" + person.getAge() + "\')");
      
      System.out.println("Objekt in DB gespeichert.");
    } 
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
