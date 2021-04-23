package ch.abbts.expeditionmanager;/*
 * Projekt: ExpeditionManager
 * Firma:   ABB TS
 * Autor:   M. Bontognali
 *
 * Beschreibung: 
 * Die Klasse ch.abbts.exman.entities.Item bildet einen Gegenstand ab.
 */

public class Item {
  private String name;
  private int weight;
  private int profit;
  
  public Item(String name, int weight, int profit) {
    this.name = name;
    this.weight = weight;
    this.profit = profit;
  }
  
  public String getName() {
    return name;
  }

  public int getWeight() {
    return weight;
  }

  public int getProfit() {
    return profit;
  }
  
  public String toString() {
    return name + ": " + weight + "kg, " + profit + "CHF";
  }
  
  public Item clone() {
    return new Item(name, weight, profit);
  }
}
