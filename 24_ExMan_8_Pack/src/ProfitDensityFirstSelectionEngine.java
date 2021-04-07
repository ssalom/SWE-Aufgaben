import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProfitDensityFirstSelectionEngine extends Engine{
    public ProfitDensityFirstSelectionEngine(String name) {
        super(name);
    }

    @Override
    public Container pack(Container allItems, int limit) {
        Container selectedItems = new Container();
        List<Item> items = allItems.getItems();
        items.sort(Comparator.comparingDouble(Item::getProfitDensity).reversed());

        items.forEach(item -> {
            if ((selectedItems.getWeight() + item.getWeight()) <= limit) {
                selectedItems.add(item);
            }
        });

        return selectedItems;
    }
}
