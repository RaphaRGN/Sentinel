package com.raphael_projetos.sentinel.Controllers;

import com.raphael_projetos.sentinel.Entity.Alert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController {

        @PostMapping("/")
        public Alert createAlert(@RequestBody Alert alert){

            return alert;

        }

}
