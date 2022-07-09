package dev.codes.controller;

import dev.codes.model.TodoData;
import dev.codes.service.TodoItemService;
import dev.codes.service.TodoItemServiceImpl;
import dev.codes.util.Mappings;
import dev.codes.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {

    // == fields ==
    private final TodoItemServiceImpl todoItemService;

    @Autowired
    public TodoItemController(TodoItemServiceImpl todoItemService)
    {
        this.todoItemService = todoItemService;
    }
    // == model attributes ==
    @ModelAttribute
    public TodoData todoData(){
        return todoItemService.getData();
    }

    //https://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }
}
