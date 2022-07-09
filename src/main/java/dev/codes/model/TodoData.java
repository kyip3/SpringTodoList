package dev.codes.model;

import lombok.Data;
import lombok.NonNull;

import java.util.*;

@Data
public class TodoData {

    // == fields ==
    private static int idValue = 1;

    //final to make this class immutable. this list cant be changed
    private final List<TodoItem> items = new ArrayList<>();

    private TodoData() {

    }

    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem toAdd) {
        //increment id
        toAdd.setId(idValue++);
        items.add(toAdd);
    }

    public void removeItem(int id) {
        ListIterator<TodoItem> iterator = items.listIterator();
        while (iterator.hasNext()) {
            TodoItem item = iterator.next();
            if (item.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem(int id) {
        ListIterator<TodoItem> iterator = items.listIterator();
        while (iterator.hasNext()) {
            TodoItem item = iterator.next();
            if (item.getId() == id)
                return item;
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdate) {
        ListIterator<TodoItem> iterator = items.listIterator();

        while (iterator.hasNext()) {
            TodoItem item = iterator.next();
            if (item.equals(toUpdate)) {
                iterator.set(toUpdate);
                break;
            }
        }
    }


}
