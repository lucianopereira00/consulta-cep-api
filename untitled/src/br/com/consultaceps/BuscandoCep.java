package br.com.consultaceps;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpPrincipal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscandoCep {

    public Endereco buscaEndereco(String cep) throws IOException, InterruptedException {
        URI endereco = URI.create("https://viacep.com.br/ws/"+ cep + "/json/");
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(endereco)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(),Endereco.class);

        } catch (Exception e) {
            throw new RuntimeException("Não foi possível concluir a busca," +
                    "Por favor reveja os dados inseridos.");
        }
    }

}