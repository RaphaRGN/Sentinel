package com.raphael_projetos.sentinel.Controllers;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

import java.awt.*;
import java.net.URI;

public class DesktopController {

    @Bean
    public ApplicationListener<WebServerInitializedEvent> onWebServerReady() {
        return event -> {
            String url = "http://localhost:" + event.getWebServer().getPort();
            openBrowser(url);
        };
    }

    private static void openBrowser(String url) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Awt Desktop is not supported!");
        }
    }
}
