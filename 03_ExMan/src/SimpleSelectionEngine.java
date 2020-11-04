public class SimpleSelectionEngine {

    public String getName() {
        return "Simple";
    }

    public Container pack(Container allItems, int limit) {
        Container selectedItems = new Container(allItems.getName());
        for(Item item : allItems.getItems()) {
            if(selectedItems.getWeight() + item.getWeight() <= limit) {
                selectedItems.addItem(item);
            }
      else {
                break;
            }
        }
        return selectedItems;
    }
}