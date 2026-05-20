package br.com.consultaceps;

public class ErroNaBusca extends RuntimeException {
    public ErroNaBusca(String message) {
        super(message);
    }
}
