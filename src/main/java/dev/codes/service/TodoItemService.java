package dev.codes.service;

import dev.codes.model.TodoData;
import dev.codes.model.TodoItem;
import lombok.NonNull;

public interface TodoItemService {

    public void addItem(@NonNull TodoItem toAdd);
    public void removeItem(int id);
    public TodoItem getItem(int id);
    public void updateItem(@NonNull TodoItem toUpdate);
    public TodoData getData();
}
