package com.raphael_projetos.sentinel.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {


    @GetMapping("/")
    public String home(){

        return "index";
    }
    @GetMapping("/admin")
    public String admin(){

        return "index";

    }
}
