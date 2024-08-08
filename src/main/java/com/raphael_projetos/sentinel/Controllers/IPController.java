package com.raphael_projetos.sentinel.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.stream.Collectors;

@Controller
public class IPController {

    @PostMapping("/receiver")
    public String iphandler(RequestParam("file") Multipartfile file){

        if(file.isEmpty()){

            return "Erro no recebimento dos IP's";
        }
        try(BufferedReader reader =
         new BufferedReader(new InputStreamReader(file.getInputStream))){
            list<String> ips = reader.lines().collect(Collectors.toList());
            sendMessageToIps(ips);
        }

        catch(Exception e){
            return "Erro no recenbimento de IP's";
        }
    }
    private void sendMessagesToIps(List<String> ips) {
        // Itera sobre cada IP e envia uma mensagem
        for (String ip : ips) {
            sendMessage(ip, "Sua mensagem aqui");
        }
    }

    private void sendMessage(String ip, String message) {
        // Cria uma instância do RestTemplate para enviar requisições HTTP
        RestTemplate restTemplate = new RestTemplate();
        // Constrói a URL para enviar a mensagem ao IP
        String url = "http://" + ip + "/endpoint"; // Altere para o endpoint real

        // Configura os cabeçalhos da requisição
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // Cria a entidade da requisição com a mensagem e cabeçalhos
        HttpEntity<String> requestEntity = new HttpEntity<>(message, headers);

        try {
            // Envia a requisição POST para o URL especificado
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

            // Verifica se a resposta indica sucesso
            if (response.getStatusCode().is2xxSuccessful()) {
                System.out.println("Mensagem enviada para " + ip + ": " + message);
            } else {
                System.out.println("Falha ao enviar mensagem para " + ip + ". Código de status: " + response.getStatusCode());
            }
        } catch (Exception e) {
            e.printStackTrace(); // Imprime o stack trace da exceção
            System.out.println("Erro ao enviar mensagem para " + ip);
        }
    }
}

}
