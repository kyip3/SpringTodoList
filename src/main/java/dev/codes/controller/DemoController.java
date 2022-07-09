package dev.codes.controller;

import dev.codes.service.DemoService;
import dev.codes.service.DemoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Slf4j
@Controller //indication that is a web controller. for scanning request mapping annotation
public class DemoController {

    // == fields ==
    private final DemoServiceImpl demoService;

    // == constructors ==
    @Autowired
    public DemoController(DemoServiceImpl demoService){
        this.demoService = demoService;
    }

    // == methods ==

    //http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    //http://localhost:8080/todo-list/welcome
    @GetMapping("welcome")
    public String welcome(Model model, @RequestParam String name) {


        model.addAttribute("user",name);
        log.info("model = {} ", model);

        //prefix + name + suffix
        //WEB-INF/view/welcome.jsp
        return "welcome";
    }

    // == model attributes ==
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("Welcome message called");
        return demoService.getWelcomeMessage();

    }

    @ModelAttribute("welcomeUser")
    public String welcomeUser(){
        log.info("Welcome user called");
        return demoService.getHelloMessage("Tim");

    }
}
