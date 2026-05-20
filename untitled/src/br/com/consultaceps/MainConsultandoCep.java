package br.com.consultaceps;

import java.io.IOException;
import java.util.Scanner;

public class MainConsultandoCep {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        BuscandoCep buscandoCep = new BuscandoCep();

        String mensagem = """
                == Busca e consulta de CEPs ==\n
                Digite um CEP válido:
                """;
        System.out.println(mensagem);
        var cep = scanner.nextLine();
        try {
            Endereco novoEndereco = buscandoCep.buscaEndereco(cep);
            System.out.println(novoEndereco);
            GerandoArquivoCep gerador = new GerandoArquivoCep();
            gerador.salvaArquivoCep(novoEndereco);

        }catch (IOException | RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a busca");
        }
    }
}
