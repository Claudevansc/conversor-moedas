package br.com.conversormoeda.modelos;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConsultaRate {
	String timeLast = "";
	Date lastUpdateDate = new Date();
	List<String> currency = new ArrayList<String>();
	JsonObject jsonObject = new JsonObject();
	
	public void buscaMoeda(String code){
		String apiUrl = "https://v6.exchangerate-api.com/v6/927c089e9f45b2cc94b04a23/latest/" + code;
		
		try {
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(apiUrl))
		      .GET()
		      .header("Accept", "Application/json")
		      .build();		
		
		
			HttpResponse<String> response = HttpClient
					  .newHttpClient()
					  .send(request, HttpResponse.BodyHandlers.ofString());
			
			if (response.statusCode() == 200) {
				
				// Obtendo a resposta como string
                String jsonString = response.body();

                // Convertendo a resposta para um objeto JsonObject (usando GSON)
                jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();                 
                
                //Obtendo dados de uma objeto.            
                JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
                currency = new ArrayList<>(conversionRates.keySet());                                 
			}
					
		} catch(Exception e) {
			throw new RuntimeException("Não conseguir obter o endereço aparti dessa Rate.");
		}
		
	}
	
	public String getBaseCode() {
		String baseCurrency = "";
	    if (jsonObject != null && jsonObject.has("base_code")) {
	        baseCurrency = jsonObject.get("base_code").getAsString();
	    } else {
	        System.out.println("Chave 'base_code' não encontrada ou jsonObject é nulo.");
	    }
	    
	    return baseCurrency;
	}
	
	public String getMoedaDestino(String moedaDestino) {
		for(int i = 0; i < currency.size(); i++) {
        	if(currency.get(i).equals(moedaDestino)) {
        		return moedaDestino;
            }        	            
        }
		
		return "null";
	}
	
	public double taxaDeCambio(Double valor, String moedaDestino) {
		// Obtendo as taxas de câmbio
        JsonObject exchangeRates = jsonObject.getAsJsonObject("conversion_rates");
		double taxaCambio = exchangeRates.get(moedaDestino).getAsDouble();
		double valorConvertido = valor * taxaCambio;
		
		return valorConvertido;
	}
	
	public String showTimeLastUpdate() throws ParseException {
		if (jsonObject != null && jsonObject.has("time_last_update_utc")) {
	        timeLast = jsonObject.get("time_last_update_utc").getAsString();
	    }
		
		return timeLast;
	}
	
}
