/*
 * Projekt: ExpeditionManager
 * Firma:   ABB TS
 * Autor:   M. Bontognali
 *
 * Beschreibung: 
 * Container werden in einer Tabelle in MySQL gespeichert. 
 * Verwendet die Bibliothek mysql-connector-java-8.0.11.jar.
 * 
 * Einrichten der Datenbank:
 * create database expedition;
 * use expedition;
 * CREATE TABLE tabContainer
 * (
 *   container VARCHAR(50) NOT NULL,
 *   item VARCHAR(50) NOT NULL,
 *   weight INTEGER,
 *   profit INTEGER
 * );
 * 
 * Achtung: 
 * MySQL Server muss in Betrieb sein.
 */


import java.sql.*;
import java.util.*;

public class RDB {
  private final String PROTOCOL = "jdbc:mysql";
  private final String HOST = "localhost";
  private final int PORT = 3306;
  private final String DATABASE = "expedition";
  private final String OPTIONS = "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
  private final String URL = PROTOCOL + "://" + HOST + ":" + PORT + "/" + DATABASE + "?" + OPTIONS;
  private final String USER = "application";
  private final String PASSWORD = "geheim";
  
  private Connection connection;
  
  public RDB() {
    try {
      connection = DriverManager.getConnection(URL, USER, PASSWORD);
    } 
    catch (Exception ex) {
      ex.printStackTrace();
    }
  } 

  // Speichert ein Container in der DB
  //   Bsp.: INSERT INTO tabContainer (
  //           container,
  //           item,
  //           weight,
  //           profit
  //         )
  //         VALUES (
  //           'Himalaya',
  //           'Sauerstoffflasche',
  //           '4',
  //           '350'
  //         )
  public void save(Container container) {
    try {
      Statement stmt = connection.createStatement();
      for(Item item : container.getItems()) {
        stmt.executeUpdate("INSERT INTO tabContainer (" +
                             "container, " +
                             "item, " +
                             "weight, " +
                             "profit) " + 
                           "VALUES (" +
                             "\'" + container.getName() + "\', " + 
                             "\'" + item.getName() + "\', " + 
                             "\'" + item.getWeight() + "\', " + 
                             "\'" + item.getProfit() + "\')");
      }
    } 
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  // Ladet einen Container aus der DB
  // SELECT * FROM tabContainer WHERE container = 'Himalaya'
  public Container load(String name) {
    Container container = new Container(name);
    try {
      Statement stmt = connection.createStatement();
      String query = "SELECT * FROM tabContainer WHERE container = \'" + name + "\'";
      ResultSet resultSet = stmt.executeQuery(query); 
      while( resultSet.next() ) {
        Item item = new Item(resultSet.getString("item"),
                             resultSet.getInt("weight"),
                             resultSet.getInt("profit"));
        container.add(item);
      }
    } 
    catch (Exception ex) {
      ex.printStackTrace();
    }
    return container;
  }

  // Ladet alle Containernamen aus der DB. Mehrfachresultate werden eliminiert.
  // SELECT DISTINCT container FROM tabContainer
  public List<String> getContainerNames() {
    List<String> containerNames = new ArrayList<>();
    try {
      Statement stmt = connection.createStatement();
      String query = "SELECT DISTINCT container FROM tabContainer";
      ResultSet resultSet = stmt.executeQuery(query); 
      while( resultSet.next() ) {
        containerNames.add(resultSet.getString("container"));
      }
    } 
    catch (Exception ex) {
      ex.printStackTrace();
    }
    return containerNames;
  }
} 
