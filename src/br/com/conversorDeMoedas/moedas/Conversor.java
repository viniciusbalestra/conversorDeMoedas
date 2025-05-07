package br.com.conversorDeMoedas.moedas;


import java.text.DecimalFormat;

public class Conversor {
    private double conversao;


    public Conversor(Moeda moeda) {
        this.conversao = moeda.conversion_rate();
    }

    public double converte(double valor) {
        double valorConvertido = valor * this.conversao;
        return valorConvertido;
    }
}
