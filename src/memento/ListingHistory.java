package memento;

import java.util.Stack;

public class ListingHistory {
    private Stack<ListingMemento> history = new Stack<>();

    public void save(ListingMemento memento) {
        history.push(memento);
    }

    public ListingMemento undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}

