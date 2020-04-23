package guimaraes.joao.h2mysql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowWordController {

    @GetMapping("/")
    public String index(){
        return "Seja bem vindo ao Sistema!";
    }
}
