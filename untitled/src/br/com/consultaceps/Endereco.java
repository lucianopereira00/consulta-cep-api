package br.com.consultaceps;

public record Endereco(String cep, String localidade, String uf) {

    @Override
    public String toString() {
        return """
            CEP : %s
            LOCALIDADE : %s
            ESTADO : %s
            """.formatted(cep, localidade, uf);
    }


}
