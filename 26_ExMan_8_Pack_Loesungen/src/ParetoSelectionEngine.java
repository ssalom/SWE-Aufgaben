/*
 * Projekt: ExpeditionManager
 * Firma:   ABB TS
 * Autor:   M. Bontognali
 *
 * Beschreibung: 
 * Packt die Gegenstände unter Einhaltung der Limite mit folgendem Algorithmus:
 * 1. Mit kleiner Auswahl von Gegenständen beginnen. 
 * 2. Pareto-optimale Punkte bestimmen. 
 * 3. Alle nicht Pareto-optimalen Punkte löschen.
 * 4. Nächster Gegenstand hinzunehmen.
 * 5. Weiter bei 2. bis alle Gegenstände verwendet wurden.
 * 6. Punkt der maximalen Kapazität bestimmen.
 * 7. Punkt = gesuchte Packungskombination.
 */

import java.util.Comparator;

public class ParetoSelectionEngine {

  public String getName() {
    return "Pareto";
  }
  
  public Container pack(Container allItems, int limit) {
    Combinations combinations = createFirstCombination();
    combinations = process(allItems, combinations);
    return searchBestContainer(combinations, limit);
  }
  
  private Combinations createFirstCombination() {
    ParetoContainer firstContainer = new ParetoContainer();
    firstContainer.add(new Item("Empty", 0, 0));
    firstContainer.setParetoOptimal();
    Combinations combinations = new Combinations();
    combinations.add(firstContainer);
    return combinations;
  }
  
  private Combinations process(Container allItems, Combinations combinations) {
    for (Item item : allItems.getItems()) {
      Combinations combinationsCopy = combinations.clone();
      add(item, combinationsCopy);
      combinations.add(combinationsCopy);
      sort(combinations);
      detectParetoOptimizedContainers(combinations);
      removeNonParetoOptimizedContainers(combinations);
//      System.out.println(combinations);
//      System.out.println("--------------------------");
    }
    return combinations;
  }
  
  private void add(Item item, Combinations combinationsCopy) {
    for(Container container : combinationsCopy.getContainers()) {
      container.add(item);
    }
  }
  
  private void sort(Combinations combinations) {
    combinations.getContainers().sort( Comparator.comparingInt(Container::getWeight) );
  }

  private void detectParetoOptimizedContainers(Combinations combinations) {
    int maxProfit = combinations.getContainers().get(0).getProfit();
    for(int i = 1; i < combinations.getContainers().size(); i++) {
      ParetoContainer container = (ParetoContainer)combinations.getContainers().get(i);
      if(container.getProfit() > maxProfit) {
        container.setParetoOptimal();
        maxProfit = container.getProfit();
      }
    }
  }

  private void removeNonParetoOptimizedContainers(Combinations combinations) {
    for(int i = 0; i < combinations.getContainers().size(); i++) {
      ParetoContainer container = (ParetoContainer)combinations.getContainers().get(i);
      if(!container.isParetoOptimal()) {
        combinations.getContainers().remove(i);
        //System.out.println("--> remove NonParetoOptimizedContainer");
      }
    }
  }
  
  private Container searchBestContainer(Combinations combinations, int limit) {
    int maxProfit = 0;
    Container bestPackedContainer = new Container();
    for(Container container : combinations.getContainers()) {
      if(container.getWeight() > limit) {
        break;
      }
      if(container.getProfit() > maxProfit) {
        bestPackedContainer = container;
        maxProfit = container.getProfit();
      }
    }
    removeEmptyItem(bestPackedContainer);
    return bestPackedContainer;
  }
  
  private void removeEmptyItem(Container container) {
    if(container.size() > 0) {
      container.getItems().remove(0);
    }
  }
  
  class ParetoContainer extends Container {
    private boolean paretoOptimal;

    public ParetoContainer() {
      super();
    }

    public ParetoContainer(String name) {
      super(name);
    }
    
    public void setParetoOptimal() {
      paretoOptimal = true;
    }
  
    public boolean isParetoOptimal() {
      return paretoOptimal;
    }
    
    public String toString() {
      StringBuilder text = new StringBuilder(1000);
      text.append(super.toString());
      text.append("\t" + paretoOptimal);
      return text.toString();
    }  
    
    public ParetoContainer clone() {
      ParetoContainer container = new ParetoContainer(super.getName());
      for(Item item : super.getItems()) {
        container.add(item.clone());
      }
      return container;
    }
  }
}
