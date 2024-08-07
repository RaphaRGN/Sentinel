package com.raphael_projetos.sentinel.Controllers;

import com.raphael_projetos.sentinel.Entity.Alert;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class SentinelController {

        @PostMapping("/")
        @SendTo("/ws-receiver")
        public Alert Send(@RequestBody Alert alert){

            return alert;

        }
}
