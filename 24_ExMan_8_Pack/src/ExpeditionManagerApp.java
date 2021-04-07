/*
 * Projekt: ExpeditionManager
 * Firma:   ABB TS
 * Autor:   M. Bontognali
 *
 * Beschreibung: 
 * Diese Klasse dient als Vorlage für weitere Pack-Algorithmen.
 */

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

    int limit = 20;
    System.out.println("Limite " + limit + " kg");

    SimpleSelectionEngine engine = new SimpleSelectionEngine("ProfitDensityFirstSelectionEngine");
    HeavyFirstSelectionEngine heavyFirstSelectionEngine = new HeavyFirstSelectionEngine("HeavyFirstSelectionEngine");
    ProfitDensityFirstSelectionEngine profitDensityFirstSelectionEngine = new ProfitDensityFirstSelectionEngine("ProfitDensityFirstSelectionEngine");
    // Todo: Hier soll eine Engine von Ihnen erzeugt werden
    
    System.out.println("Packen mit " + engine.getName());

    Container selectedItems = engine.pack(allItems, limit);
    selectedItems.setName("gepackt");
    System.out.println(selectedItems);


    System.out.println("Packen mit " + heavyFirstSelectionEngine.getName());
    selectedItems = heavyFirstSelectionEngine.pack(allItems, limit);
    selectedItems.setName("gepackt");
    System.out.println(selectedItems);

    System.out.println("Packen mit " + profitDensityFirstSelectionEngine.getName());
    selectedItems = profitDensityFirstSelectionEngine.pack(allItems, limit);
    selectedItems.setName("gepackt");
    System.out.println(selectedItems);
  }
}
