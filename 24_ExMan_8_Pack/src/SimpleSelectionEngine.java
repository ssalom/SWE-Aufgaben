/*
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

public class SimpleSelectionEngine extends Engine {

  public SimpleSelectionEngine(String name) {
    super(name);
  }

  @Override
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
