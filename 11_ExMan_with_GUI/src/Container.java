import java.util.ArrayList;
import java.util.List;

public class Container {
    private String name;
    private List<Item> items = new ArrayList<>();

    public Container(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public void clearContainer () {
        items = new ArrayList<>();
    }

    public int size() {
        return items.size();
    }

    public int getWeight() {
        int totalWeight = 0;

        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public int getProfit() {
        int totalProfit = 0;

        for (Item item : items) {
            totalProfit += item.getProfit();
        }
        return totalProfit;
    }

    public String toString () {
        StringBuilder itemsString = new StringBuilder();

        for (Item item : items) {
            itemsString.append(item.toString());
            itemsString.append(", ");
        }

        return "Der Container " + name + " hat folgende items: " + itemsString;
    }

}
