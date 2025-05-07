package br.com.conversorDeMoedas.moedas;

import java.util.List;

public class NumeroParaCodigo {
    private final List<String> codigosMoedas = List.of(
            "USD", "EUR", "GBP", "JPY", "CHF", "CAD", "AUD",
            "CNY", "NZD", "HKD", "BRL", "MXN", "ARS", "XOF", "INR"
    );

    public String pegaCodigo(int escolha) {
        return codigosMoedas.get(escolha - 1);
    }
}
