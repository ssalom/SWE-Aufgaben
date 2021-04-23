/*
 * Projekt: ExpeditionManager
 * Firma:   ABB TS
 * Autor:   M. Bontognali
 *
 * Beschreibung: 
 * Packt die Gegenstände unter Einhaltung der Limite mit folgendem Algorithmus:
 * 1. Generiere alle möglichen Kombinationen.
 * 2. Suche den Container mit der besten Kombination.
 * 
 * Kombinationen werden mit einer Binärzahl abgebildet. 
 * Beispiel mit zwei Gegenständen:
 * 00: keine Gegenstände werden mitgenommen. 
 * 01: Gegenstand1 wird mitgenommen. 
 * 10: Gegenstand2 wird mitgenommen.  
 * 11: alle Gegenstände werden mitgenommen. 
 *
 * Achtung: 
 * Ab 22 Gegenständen wird dieser Algorithmus speicherintensiv.
 */
package expeditionmanager.selectionengines;

import expeditionmanager.*;

public class AllCombinationsSelectionEngine implements SelectionEngine{
  
  public String getName() {
    return "AllCombinations";
  }
  
  public Container pack(Container allItems, int limit) {
    Combinations combinations = generateAllCombinations(allItems);
    return searchBestContainer(combinations, limit);
  }
  
  private Combinations generateAllCombinations(Container allItems) {
    Combinations combinations = new Combinations();
    int max = (int) Math.pow(2, allItems.size());
    
    for (int counter = 0; counter < max; counter++) {
      combinations.add(generateSingleCombination(allItems, counter));
    }
    return combinations;
  }
  
  private Container generateSingleCombination(Container allItems, int counter) {
    Container singleCombination = new Container();
    String binary = toBinary(counter, allItems.size());
    //System.out.println(binary);
    
    binary = reverse(binary);
    
    for (int position = 0; position < binary.length(); position++) {
      if(binary.charAt(position) == '1') {
        singleCombination.add(allItems.getItem(position));
      }
    }
    //System.out.println(singleCombination);
    return singleCombination;
  }
  
  private String toBinary(int counter, int digits) {
    String binary = Integer.toBinaryString(counter);
    int i = 0; 
    while(binary.length() < digits) { // mit Nullen fuellen
      binary = "0" + binary;
      i++;
    }
    return binary;
  }
  
  private String reverse(String text) {
    StringBuilder sb = new StringBuilder(text);
    return sb.reverse().toString();
  }
  
  private Container searchBestContainer(Combinations combinations, int limit) {
    Container bestPackedContainer = new Container();
    int maxProfit = 0;
    
    for (Container container : combinations.getContainers()) {
      if(container.getWeight() > limit) {
        continue;
      }
      if(container.getProfit() > maxProfit) {
        maxProfit = container.getProfit();
        bestPackedContainer = container;
      }
    }
    return bestPackedContainer;
  }
}
