package br.com.conversorDeMoedas.moedas;

public class Conversor {
    private final double conversao;


    public Conversor(Moeda moeda) {
        this.conversao = moeda.conversion_rate();
    }

    public double converte(double valor) {
        return valor * this.conversao;
    }
}
