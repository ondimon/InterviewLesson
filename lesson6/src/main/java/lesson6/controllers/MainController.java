package lesson6.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping({"","/"})
    public String indexGet(){
        return "hello get";
    }

    @PostMapping({"","/"})
    public String indexPost(){
        return "hello post";
    }
}
