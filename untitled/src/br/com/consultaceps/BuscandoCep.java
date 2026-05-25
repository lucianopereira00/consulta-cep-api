package br.com.consultaceps;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscandoCep {

    public Endereco buscaEndereco(String cep) throws IOException, InterruptedException {
        URI endereco = URI.create("https://viacep.com.br/ws/"+ cep + "/json/"); //API USADA
        try { //TENTE RODAR ISSO
            HttpClient client = HttpClient.newHttpClient(); //CRIA UM HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(endereco)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if(response.body().contains("\"erro\"")) {
                throw new Exception("Erro ao pesquisar CEP!");
            }else {
                System.out.println("Pesquisa relizada! Confira o resultado:");
            }
            //ESSE BLOCO DE CODIGO ↑ ENTREGA A RESPOSTA DA PESQUISA EM JSON

            //E ESSE RETURN ↓ CONVERTE O JSON EM OBJETO JAVA USANDO GSON PRA FICAR "BONITINHO"
            return new Gson().fromJson(response.body(),Endereco.class);
            //Lê: "RETORNA UM NOVO GSON CONVERTENDO O CORPO DA RESPOSTA
            //DE ACORDO COM A CLASSE RECORD Endereco"

        } catch (Exception e) {
            throw new RuntimeException("\nNão foi possível concluir a busca," +
                    " por favor reveja os dados inseridos.");
        }
    }

}