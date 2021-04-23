package ch.abbts.expeditionmanager;/*
 * Projekt: ExpeditionManager
 * Firma:   ABB TS
 * Autor:   M. Bontognali
 *
 * Beschreibung: 
 * Ein ch.abbts.exman.entities.Container verwaltet mehrere Items.
 * Die Werte der Methoden getWeight() und getProfit() könnte man als 
 * Instanzvariablen zwischenspeichern um die Performance zu optimieren.
 */

import java.util.*;

public class Container {
  private String name;
  private List<Item> items;
  
  public Container() {
    this("Unbekannt");
  }
  
  public Container(String name) {
    this.name = name;
    items = new ArrayList<>();
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public void add(Item item) {
    items.add(item);
  }
  
  public Item getItem(int index) {
    return items.get(index);
  }
  
  public List<Item> getItems() {
    return items;
  }
  
  public int size() {
    return items.size();
  }

  public int getWeight() {
    int weight = 0;
    for(Item item : items) {
      weight += item.getWeight();
    }
    return weight;
  }

  public int getProfit() {
    int profit = 0;
    for(Item item : items) {
      profit += item.getProfit();
    }
    return profit;
  }
  
  public String toString() {
    StringBuilder text = new StringBuilder(1000);
    text.append("ch.abbts.exman.entities.Container " + name + ": ");
    for(Item item : items) {
      text.append(item.toString() + "; ");
    }
    text.append("Total: " + getWeight() + "kg\t" + getProfit() + "CHF");
    return text.toString();
  }  
  
  public Container clone() {
    Container container = new Container(name);
    for(Item item : items) {
      container.add(item.clone());
    }
    return container;
  }
}
