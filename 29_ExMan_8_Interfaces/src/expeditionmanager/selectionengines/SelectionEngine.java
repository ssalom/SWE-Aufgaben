package expeditionmanager.selectionengines;

import expeditionmanager.Container;

public interface SelectionEngine {

    public String getName();
    public Container pack(Container allItems, int limit);
}
