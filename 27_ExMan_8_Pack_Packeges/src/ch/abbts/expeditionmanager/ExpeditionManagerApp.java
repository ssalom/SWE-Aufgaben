package ch.abbts.expeditionmanager;/*
 * Projekt: ExpeditionManager
 * Firma:   ABB TS
 * Autor:   M. Bontognali
 *
 * Beschreibung: 
 * Verschiedene Pack-Algorithmen.
 * Die jeweilige SelectionEngine muss im Code aktiviert werden!
 */

import ch.abbts.expeditionmanager.selectionengines.ParetoSelectionEngine;

class ExpeditionManagerApp {
  public static void main(String[] args) {
    Container allItems = new Container("Atlantik");
    allItems.add(new Item("Taucherblei", 9, 50));
    allItems.add(new Item("Anzug", 3, 60));
    allItems.add(new Item("Sauerstoff", 12, 80));
    allItems.add(new Item("Proviant", 14, 20));
    allItems.add(new Item("Proviant", 5, 95));
    allItems.add(new Item("Beleuchtung", 8, 75));
    System.out.println(allItems);
    
    //ch.abbts.exman.engines.SimpleSelectionEngine engine = new ch.abbts.exman.engines.SimpleSelectionEngine();
//    ch.abbts.exman.engines.HeavyFirstSelectionEngine engine = new ch.abbts.exman.engines.HeavyFirstSelectionEngine();
//    ch.abbts.exman.engines.ProfitDensityFirstSelectionEngine engine = new ch.abbts.exman.engines.ProfitDensityFirstSelectionEngine();
//    ch.abbts.exman.engines.AllCombinationsSelectionEngine engine = new ch.abbts.exman.engines.AllCombinationsSelectionEngine();
    ParetoSelectionEngine engine = new ParetoSelectionEngine();
    
    System.out.println("Packen mit " + engine.getName());
    int limit = 20;
    System.out.println("Limite " + limit + " kg");
    Container selectedItems = engine.pack(allItems, limit);
    selectedItems.setName("gepackt");
    System.out.println(selectedItems);
  }
}
