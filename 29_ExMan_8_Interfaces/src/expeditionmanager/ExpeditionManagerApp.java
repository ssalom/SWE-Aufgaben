/*
 * Projekt: ExpeditionManager
 * Firma:   ABB TS
 * Autor:   M. Bontognali
 *
 * Beschreibung: 
 * Verschiedene Pack-Algorithmen in einem Java-Package.
 * Die jeweilige SelectionEngine muss im Code aktiviert werden!
 */
package expeditionmanager;

import expeditionmanager.selectionengines.*;

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



    SelectionEngine engine = new SimpleSelectionEngine();
    System.out.println("Packen mit " + engine.getName());
    int limit = 20;
    System.out.println("Limite " + limit + " kg");
    Container selectedItems = engine.pack(allItems, limit);
    selectedItems.setName("gepackt");
    System.out.println(selectedItems);

    engine = new HeavyFirstSelectionEngine();
    System.out.println("Packen mit " + engine.getName());
    limit = 20;
    System.out.println("Limite " + limit + " kg");
    selectedItems = engine.pack(allItems, limit);
    selectedItems.setName("gepackt");
    System.out.println(selectedItems);

    engine = new ProfitDensityFirstSelectionEngine();
    System.out.println("Packen mit " + engine.getName());
    limit = 20;
    System.out.println("Limite " + limit + " kg");
    selectedItems = engine.pack(allItems, limit);
    selectedItems.setName("gepackt");
    System.out.println(selectedItems);

    engine = new AllCombinationsSelectionEngine();
    System.out.println("Packen mit " + engine.getName());
    limit = 20;
    System.out.println("Limite " + limit + " kg");
    selectedItems = engine.pack(allItems, limit);
    selectedItems.setName("gepackt");
    System.out.println(selectedItems);

    engine = new ParetoSelectionEngine();
    System.out.println("Packen mit " + engine.getName());
    limit = 20;
    System.out.println("Limite " + limit + " kg");
    selectedItems = engine.pack(allItems, limit);
    selectedItems.setName("gepackt");
    System.out.println(selectedItems);

  }
}
