package br.com.conversormoeda.driver;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.conversormoeda.modelos.ConsultaRate;
import br.com.conversormoeda.modelos.InforMoeda;
import br.com.conversormoeda.modelos.Janelas;
import br.com.conversormoeda.modelos.ScreenCleaners;

public class DriverApp {

	public static void main(String[] args) throws ParseException {
		String moedaOrigem = "";
		double valor = 0.0;
		int opcao = 0;
		String enter = "";
		boolean entradaValida = false;
		String moedaDestino = "";
		Janelas janela = new Janelas();
		ConsultaRate consult = new ConsultaRate();
		ScreenCleaners clean = new ScreenCleaners();
		Scanner input = new Scanner(System.in);
		InforMoeda moedas = new InforMoeda("USD", "Dólar", 146, "Estados Unidos");
		List<InforMoeda> moedaList = new ArrayList<InforMoeda>();
		{
			moedaList.add(new InforMoeda("USD", "Dólar ", 146, "Estados Unidos"));
			moedaList.add(new InforMoeda("EUR", "Euro  ", 42, "Zona do Euro  "));
			moedaList.add(new InforMoeda("JPY", "Iene  ", 70, "Japão         "));
			moedaList.add(new InforMoeda("GBP", "Libra ", 46, "Reino Unido   "));
			moedaList.add(new InforMoeda("CHF", "Franco", 27, "Suíça         "));
			moedaList.add(new InforMoeda("BRL", "Real  ", 25, "Brasil        "));
			moedaList.add(new InforMoeda("AUD", "Dólar ", 8, "Austrália     "));
			moedaList.add(new InforMoeda("ZAR", "Rand  ", 159, "África do Sul "));
			moedaList.add(new InforMoeda("CNY", "Yuan  ", 29, "China         "));
			moedaList.add(new InforMoeda("ARS", "Peso  ", 7, "Argentina     "));
		}		
				
		String imgBubbles = janela.speechBubbles();
		
		System.out.println(imgBubbles);
		enter = input.nextLine();
		clean.clearConsoleBubbles();
		
		while(opcao != 1) {
			if(opcao == 0) {
			janela.menuMain();
//			clean.clearConsoleMenuMain();
			opcao = input.nextInt();
			}

			switch (opcao) {
				case 1: {
					janela.messageExit();						
					break;				 
				}
				case 2: {
					clean.clearConsoleshowTable(); 		// NESTA POSIÇÃO CONFIGURADO PARA TELA CHEIA.
					janela.showTable((ArrayList<InforMoeda>) moedaList); 	
//					clean.clearConsoleshowTable(); 		// NESTA POSIÇÃO CONFIGURADO PARA TELA NORMAL.

					while (!entradaValida) {
						janela.getValor();
						try {
							valor = input.nextDouble();
							entradaValida = true;
						} catch (InputMismatchException e) {
							janela.InvalidCharacter();
							input.next();
						}
					}					
					
					entradaValida = false;
					janela.getMoedaOrigem();
					moedaOrigem = input.next();
					if(moedas.consultCorrencyCode(moedaList, moedaOrigem)) {
						consult.buscaMoeda(moedaOrigem);
					}

					while(!moedas.consultCorrencyCode(moedaList, moedaOrigem)) {
						janela.currencyCodeInvalid();
						janela.getMoedaOrigem();
						moedaOrigem = input.next();
						if(moedas.consultCorrencyCode(moedaList, moedaOrigem)) {
							consult.buscaMoeda(moedaOrigem);
						}
					}

					janela.getMoedaDestino();
					moedaDestino = input.next();
					while(moedaOrigem.equals(moedaDestino)) {
						janela.currencyCodeEqual();
						janela.getMoedaDestino();	
						moedaDestino = input.next();
					}					

					while(!moedas.consultCorrencyCode(moedaList, moedaDestino)) {	
						janela.currencyCodeInvalid();
						janela.getMoedaDestino();
						moedaDestino = input.next();
					}
					
					clean.clearConsoleMoedaDestino();

					janela.showBanner(valor, moedaOrigem.toUpperCase(), moedaDestino.toUpperCase(), consult, moedaList);
					opcao = input.nextInt();

					if(opcao == 1) {
						janela.messageExit();	
					}

					break;	
				}
				default:
					janela.InvalidOption();
			}
		}	
	
	}	
}
