package br.com.conversorDeMoedas.principal;

import br.com.conversorDeMoedas.moedas.Conversor;
import br.com.conversorDeMoedas.moedas.Moeda;
import br.com.conversorDeMoedas.moedas.NumeroParaCodigo;
import br.com.conversorDeMoedas.requisicaoApi.RequisicaoApi;
import com.google.gson.Gson;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main conversorApp = new Main();
        conversorApp.executarConversao();
    }

    public void executarConversao() {
        RequisicaoApi requisicaoApi = new RequisicaoApi();
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();
        NumeroParaCodigo numeroParaCodigo = new NumeroParaCodigo();

        int escolhaMoedaInicialNumero = -1;
        int escolhaMoedaFinalNumero;

        while (escolhaMoedaInicialNumero < 1 || escolhaMoedaInicialNumero > 15) {
            exibirMenuMoedas();
            System.out.print("Escolha a moeda que você possui (número): ");
            escolhaMoedaInicialNumero = scanner.nextInt();
        }

        System.out.print("Quanto você possui dessa moeda? ");
        double valorASerConvertido = scanner.nextDouble();

        exibirMenuMoedas();
        System.out.print("Para qual moeda deseja converter (número): ");
        escolhaMoedaFinalNumero = scanner.nextInt();

        String codigoMoedaInicial = numeroParaCodigo.pegaCodigo(escolhaMoedaInicialNumero);
        String codigoMoedaFinal = numeroParaCodigo.pegaCodigo(escolhaMoedaFinalNumero);

        String jsonResposta = requisicaoApi.requisicao(codigoMoedaInicial, codigoMoedaFinal);
        Moeda moeda = gson.fromJson(jsonResposta, Moeda.class);

        // Cria uma nova instância de Conversor a cada conversão com os dados da Moeda
        Conversor conversor = new Conversor(moeda);
        double valorConvertido = conversor.converte(valorASerConvertido);
        double valorFinalFormatado = conversor.converte(valorConvertido);

        System.out.printf("$%.2f %s equivalem a $%.2f %s%n",
                valorASerConvertido, codigoMoedaInicial, valorFinalFormatado, codigoMoedaFinal);

        scanner.close();
    }

    private void exibirMenuMoedas() {
        System.out.println("""
                Escolha uma das opções de moeda (número):
                1. Dólar Americano (USD)
                2. Euro (EUR)
                3. Libra Esterlina (GBP)
                4. Iene Japonês (JPY)
                5. Franco Suíço (CHF)
                6. Dólar Canadense (CAD)
                7. Dólar Australiano (AUD)
                8. Yuan Chinês (CNY)
                9. Dólar Neozelandês (NZD)
                10. Dólar de Hong Kong (HKD)
                11. Real Brasileiro (BRL)
                12. Peso Mexicano (MXN)
                13. Peso Argentino (ARS)
                14. Franco CFA Ocidental (XOF)
                15. Rupia Indiana (INR)
                """);
    }
}