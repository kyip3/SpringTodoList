package dev.codes.controller;

import dev.codes.model.TodoData;
import dev.codes.model.TodoItem;
import dev.codes.service.TodoItemServiceImpl;
import dev.codes.util.AttributeNames;
import dev.codes.util.Mappings;
import dev.codes.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
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

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false,defaultValue = "-1") int id,
                              Model model){

        log.info("editing id = {}", id);
        TodoItem todoItem = todoItemService.getItem(id);
        if(todoItem == null)
        {
            todoItem = new TodoItem("","", LocalDate.now());
        }
        model.addAttribute(AttributeNames.TODO_ITEM,todoItem);
        return ViewNames.ADD_ITEM;
    }
    //this method will call after we submit the form
    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        log.info("todo item from = {}",todoItem);

        if(todoItem.getId() ==0) {
            todoItemService.addItem(todoItem);
        } else{
            todoItemService.updateItem(todoItem);
        }

        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam("id") int id){
        log.info("deleting item {}",id);
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam("id") int id, Model model){
        log.info("view item {}",id);
        TodoItem item = todoItemService.getItem(id);
        model.addAttribute(item);
        return ViewNames.VIEW_ITEM;
    }
}
