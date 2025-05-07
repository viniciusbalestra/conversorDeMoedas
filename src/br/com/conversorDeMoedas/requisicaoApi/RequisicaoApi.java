package br.com.conversorDeMoedas.requisicaoApi;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequisicaoApi {

    public String requisicao(String moedaInicial, String moedaFinal)  {

        try {
            // Setting URL
            String url_str = "https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/"+ moedaInicial + "/" + moedaFinal;

            // Making Request
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            return jsonobj.toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
