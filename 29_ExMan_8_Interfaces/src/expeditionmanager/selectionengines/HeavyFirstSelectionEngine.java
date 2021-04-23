/*
 * Projekt: ExpeditionManager
 * Firma:   ABB TS
 * Autor:   M. Bontognali
 *
 * Beschreibung: 
 * Packt die Gegenstände unter Einhaltung der Limite mit folgendem Algorithmus:
 * 1. Sortiere alle Gegenstände nach Gewicht.
 * 2. Beginne mit dem schwersten Gegenstand.
 * 3. Falls Limite nicht erreicht: nehme Gegenstand zur Packung hinzu.
 *    Falls Limite erreicht:       lasse Gegenstand weg.
 * 4. Wiederhole mit dem nächst leichteren Gegenstand bis alle geprüft sind.
 */
package expeditionmanager.selectionengines;

import expeditionmanager.*;
import java.util.Comparator;

public class HeavyFirstSelectionEngine implements SelectionEngine{

  public String getName() {
    return "HeavyFirst";
  }
  
  public Container pack(Container allItems, int limit) {
    sort(allItems);
    return select(allItems, limit);
  }

  private void sort(Container container) {
    container.getItems().sort( Comparator.comparingInt(Item::getWeight).reversed() );
  }
  
  private Container select(Container container, int limit) {
    Container selectedItems = new Container();
    for(Item item : container.getItems()) {
      if(selectedItems.getWeight() + item.getWeight() <= limit) {
        selectedItems.add(item);
      }
    }
    return selectedItems;
  }
}
