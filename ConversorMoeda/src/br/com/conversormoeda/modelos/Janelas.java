package br.com.conversormoeda.modelos;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Janelas {
	InforMoeda moedas = new InforMoeda("USD", "Dólar", 146, "Estados Unidos");
	
	public void  getValor() {
		System.out.printf("%s", "Digite o Valor a ser convertido $: ");		
	}
	
	public void getMoedaOrigem() {
		System.out.printf("%n%s", "Digite o Código da Moeda de Origem: ");		
	}
	
	public void getMoedaDestino() {
		System.out.printf("%n%s", "Digite o Código da Moeda de Destino: ");
	}		
	
	public void showTable(ArrayList<InforMoeda> moedaList) {
			System.out.printf("%29s%n", "PRINCIPAIS MOEDAS DO MUNDO.");
			System.out.printf("┌%-5s┬%-6s┬%-10s┐%n", "──────", "───────", "───────────────");
			System.out.printf("%s%5s%2s%5s%3s%12s%4s%n","|", "Code", "|", "Base", "|", "País Origem","|");
			System.out.printf("├%-5s┼%-5s┼%-10s┤%n", "──────", "───────", "───────────────");	
			
			for(InforMoeda i : moedaList) {
				System.out.printf("%s%4s%3s%7s%s%15s%s%n","|",i.getCurrencyCode(),"|",i.getBase(),"|",i.getPaisOrigem(),"|");
			}
			
			System.out.printf("└%-5s┴%-6s┴%-10s┘%n", "──────", "───────", "───────────────");			
	}	
	
					
	public void showBanner(double valor, String code, String moedaDestino, ConsultaRate consult, List<InforMoeda> moedaList) throws ParseException {
		System.out.printf("%n%55s", "*** Resultado da conversão de moedas! ***");
		System.out.printf("%n%s%n", "╭───────────────────────────────────────────────────────────────────╮");
		System.out.printf("%s%16s%s%18s%15s%5s%n", "|","Pais Origem: ", moedas.countryConsultation(moedaList, code) , "Pais Destino:", moedas.countryConsultation(moedaList, moedaDestino),"|");
		System.out.printf("%s%31s%35s%2s%n", "|","╭───────────────────────────╮", "╭──────────────────────────────╮","|");
		System.out.printf("%s%3s%10s%-7.2f%s%3s%2s %s %s%-7.2f%s%s%2s%2s%n", "|","|","Valor $: ",valor , "Code: ", consult.getBaseCode(),"|","\u2192" ,"|Conversão $: ",consult.taxaDeCambio(valor, moedaDestino) , "Code: ", consult.getMoedaDestino(moedaDestino),"|","|");
		System.out.printf("%s%31s%35s%2s%n", "|","╰───────────────────────────╯", "╰──────────────────────────────╯","|");
		System.out.printf("%s%41s%27s%n", "|","Data da consulta:","|");
		System.out.printf("%s%47s%21s%n", "|","╭──────────────────────────╮", "|");
		System.out.printf("%s%20s%21s%6s%21s%n","|","|", consult.showTimeLastUpdate().substring(0, 16),"|","|");
		System.out.printf("%s%47s%21s%n", "|","╰──────────────────────────╯", "|");
		System.out.printf("%s%n%n", "╰───────────────────────────────────────────────────────────────────╯");				
		//	Menu de opções 
		System.out.printf("%50s%n", "SISTEMA COTAÇÃO TAXA DE CÂMBIO");
		System.out.printf("%50s", "------------------------------");
		System.out.printf("%n%55s%n", "┌───────────────────────────────────────┐");
		System.out.printf("%15s%26s%14s", "|", "MENU DE OPÇÕES", "|");
		System.out.printf("%n%15s%s%s%n", "├", "───────────────────────────────────────","┤");
		System.out.printf("%15s%25s%15s%n", "|", "1 - Sair do Sistema", "|");
		System.out.printf("%15s%33s%7s", "|", "2 - Nova Conversão de Moeda", "|");
		System.out.printf("%n%15s%s%s%n", "└", "───────────────────────────────────────", "┘");
		System.out.printf("%39s", "DIGITE SUA OPÇÃO: ");

	}
		
	//	baloões de mensagens
	public String speechBubbles() {
		StringBuilder bubbles = new StringBuilder();

		bubbles.append(String.format("%s%n", "Baloões de Mensagens:"));
		bubbles.append(String.format("%s", "---------------------"));
		bubbles.append(String.format("%n%s%n", "╭─────────────────────────────────────────────────────────╮"));
		bubbles.append(String.format("%s%56s%2s%n", "|","Olá meu nome é TaxaC e vou te da informações importantes", "|"));
		bubbles.append(String.format("%s%45s%13s", "|","sobre o \"Sistema Cotação de Taxa de Câmbio\".", "|"));
		bubbles.append(String.format("%n%s%n", "╰──v──────────────────────────────────────────────────────╯"));
		bubbles.append(String.format("%72s%n", "╭───────────────────────────────────────╮"));
		bubbles.append(String.format("%32s%38s%2s%n", "|","O sistema vai te pedir 3 informações:", "|"));
		bubbles.append(String.format("%32s%28s%12s%n", "|","1-O valor a ser convertido;", "|"));
		bubbles.append(String.format("%32s%37s%3s%n", "|","2-O currencyCode da moeda de origem;", "|"));
		bubbles.append(String.format("%32s%38s%2s", "|","3-O currencyCode da moeda de destino;", "|"));
		bubbles.append(String.format("%n%72s%n", "╰────────────────────────────────────v──╯"));
		bubbles.append(String.format("%s%n", "╭──────────────────────────────────────────────────╮"));
		bubbles.append(String.format("%s%49s%2s%n", "|","A qualquer momento você pode consultar as moedas", "|"));
		bubbles.append(String.format("%s%49s%2s%n", "|","e suas informções no menu principal do sistema.", "|"));
		bubbles.append(String.format("%s%n", "╰──v───────────────────────────────────────────────╯"));
		bubbles.append(String.format("%89s%n", "╭────────────────────────────────────────────────────────╮"));
		bubbles.append(String.format("%32s%53s%2s%n", "|","Só é possivel fazer a conversão usando as 10 principais", "|"));
		bubbles.append(String.format("%32s%49s%8s", "|","moedas do mundo como mostra na tabela de moedas.", "|"));
		bubbles.append(String.format("%n%89s%n", "╰─────────────────────────────────────────────────────v──╯"));
		bubbles.append(String.format("%s%n", "╭──────────────────────────────────────╮"));
		bubbles.append(String.format("%s%37s%2s%n", "|","Digite ENTER para entrar no sistema.", "|"));
		bubbles.append(String.format("%s", "╰──v───────────────────────────────────╯"));	
		
		return bubbles.toString();

	}
	
	public void menuMain() {
		System.out.printf("%35s%n", "SISTEMA COTAÇÃO TAXA DE CÂMBIO");
		System.out.printf("%35s", "------------------------------");
		System.out.printf("%n%s%n", "┌───────────────────────────────────────┐");
		System.out.printf("%s%26s%14s", "|", "MENU DE OPÇÕES", "|");
		System.out.printf("%n%s%n", "├───────────────────────────────────────┤");
		System.out.printf("%s%30s%10s%n", "|", "1 - Sair do Sistema", "|");
		System.out.printf("%s%30s%10s", "|", "2 - Converter Moeda", "|");
		System.out.printf("%n%s%n", "└───────────────────────────────────────┘");
		System.out.printf("%s", "DIGITE SUA OPÇÃO: ");	
	}	

	public void messageExit() {
		System.out.printf("%n%70s%n", "╭─────────────────────────────────────────────────────────────────────╮");
		System.out.printf("%s%53s%2s%n", "|","Obrigado por usar nosso sistema de cotação de moedas! Até a próxima.", "|");
		System.out.printf("%70s%n", "╰──────────────────────────────────────────────────────────────────v──╯");
		
	}
	
	public void currencyCodeInvalid() {
		System.out.printf("%51s%n", "╭──────────────────────────────────────────────────╮");
		System.out.printf("%s%49s%1s%n", "|","Código da moeda não encontrado, Digite Novamente!.", "|");
		System.out.printf("%51s%n", "╰───────────────────────────────────────────────v──╯");
	}
	
	public void currencyCodeEqual() {
		System.out.printf("%51s%n", "╭─────────────────────────────────────────────────────────────────────────────╮");
		System.out.printf("%s%49s%2s%n", "|","Digite uma Moeda de Origem diferente da Moeda de Destino, Digite Novamente!.", "|");
		System.out.printf("%51s", "╰──────────────────────────────────────────────────────────────────────────v──╯");
		
	}
	
	public void InvalidOption() {
		System.out.printf("%n%51s%n", "╭─────────────────────────────────────────────────────────────────────────────╮");
		System.out.printf("%s%49s%2s%n", "|","Opção invalida por favor informar uma opção valida, Digite Novamente!.", "|");
		System.out.printf("%51s%n%n", "╰──────────────────────────────────────────────────────────────────────────v──╯");		
	}
	
	public void InvalidCharacter() {
		System.out.printf("%51s%n", "╭────────────────────────────────────────────────────────────────────────────╮");
		System.out.printf("%s%74s%3s%n", "|", "Caractere não permitido, você devi digitar um número, Digite Novamente!.", "|");
		System.out.printf("%51s%n", "╰─────────────────────────────────────────────────────────────────────────v──╯");		
	}
}    										  
