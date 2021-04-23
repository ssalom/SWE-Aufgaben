package ch.abbts.expeditionmanager.selectionengines;/*
 * Projekt: ExpeditionManager
 * Firma:   ABB TS
 * Autor:   M. Bontognali
 *
 * Beschreibung: 
 * Packt die Gegenstände unter Einhaltung der Limite mit folgendem Algorithmus:
 * 1. Beginne mit dem ersten Gegenstand.
 * 2. Falls Limite nicht erreicht: nehme Gegenstand zur Packung hinzu.
 *    Falls Limite erreicht:       lasse Gegenstand weg.
 * 3. Wiederhole mit dem nächsten Gegenstand bis die Limite erreicht ist.
 */

import ch.abbts.expeditionmanager.Container;
import ch.abbts.expeditionmanager.Item;

public class SimpleSelectionEngine {

  public String getName() {
    return "Simple";
  }
  
  public Container pack(Container allItems, int limit) {
    Container selectedItems = new Container();
    for(Item item : allItems.getItems()) {
      if(selectedItems.getWeight() + item.getWeight() <= limit) {
        selectedItems.add(item);
      }
      else {
        break;
      }
    }
    return selectedItems;
  }
}
