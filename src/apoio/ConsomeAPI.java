/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apoio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author leonardo.bourscheid
 */
public class ConsomeAPI {

    public static String obterDados(String endereco) {

        try {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        
        return response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao consumir API:");
            e.printStackTrace();
            return null;
        }
        
    }

}
