package br.com.conversormoeda.modelos;

import java.util.List;

public class InforMoeda {
	private String currencyCode;
	private String base;
	private int indice;
	private String paisOrigem;		
		
	public InforMoeda(String currencyCode, String base, int indice, String paisOrigem) {
		super();
		this.currencyCode = currencyCode;
		this.base = base;
		this.indice = indice;
		this.paisOrigem = paisOrigem;
	}	

	public String getCurrencyCode() {
		return currencyCode;
	}

	public String getBase() {
		return base;
	}

	public int getIndice() {
		return indice;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}	

	@Override
	public String toString() {
		return "InforMoeda [currencyCode=" + currencyCode + ", base=" + base + ", indice=" + indice + ", paisOrigem="
				+ paisOrigem + "]";
	}
	
	public String countryConsultation(List<InforMoeda> moedaList, String pais) {
		for(int i = 0; i < moedaList.size(); i++) {
			if(moedaList.get(i).getCurrencyCode().equals(pais)) {
				return moedaList.get(i).getPaisOrigem();
			} 
		}
		return null;
		
	}
	
	public boolean consultCorrencyCode(List<InforMoeda> moedaList, String currencyCode) {
		for(int i = 0; i < moedaList.size(); i++) {
			if(moedaList.get(i).currencyCode.equals(currencyCode.toUpperCase())) {
				return true;
			}		
		}		
		return false;	
	}
	
	
}
