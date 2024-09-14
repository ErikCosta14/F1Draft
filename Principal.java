package game;

import java.util.Scanner;
import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		Random aletorio = new Random();
		
		
		teclado.close();

	}
	
	//Função para limpar a tela
	static void limpaTela(int cod) {
		
		if(cod == 1) {
			for (int i = 0; i < 500; i++) {
				System.out.println("");
			}
		}
		else {
			for (int i = 0; i < 15; i++) {
				System.out.println("");
			}
		}
		
	}
	
	//Função para escolher o carro
	static String carro(String carro) {
		
		String nome;
		int atributos[] = new int[5];
		int mediaAtrib;
		
		//A variável carro é analizada para determinar qual foi escolhida e atribuir os atributos no vetor
		switch (carro) {
			case "ASTON MARTIN":
				nome = "Aston Martin";
				atributos[0] = 4; //Aerodinâmica
				atributos[1] = 7; //Motor
				atributos[2] = 7; //Velocidade
				atributos[3] = 5; //Eficiência no DRS
				atributos[4] = 6; //Eficiência no ERS
				
				mediaAtrib = media(atributos);
				
				break;
			case "ALPINE":
				nome = "Alpine";
				atributos[0] = 3; //Aerodinâmica
				atributos[1] = 5; //Motor
				atributos[2] = 4; //Velocidade
				atributos[3] = 4; //Eficiência no DRS
				atributos[4] = 6; //Eficiência no ERS
				
				mediaAtrib = media(atributos);
				
				break;
			case "FERRARI":
				nome = "Ferrari";
				atributos[0] = 7; //Aerodinâmica
				atributos[1] = 8; //Motor
				atributos[2] = 8; //Velocidade
				atributos[3] = 6; //Eficiência no DRS
				atributos[4] = 8; //Eficiência no ERS
				
				mediaAtrib = media(atributos);
				
				break;
			case "HAAS":
				nome = "Haas";
				atributos[0] = 6; //Aerodinâmica
				atributos[1] = 7; //Motor
				atributos[2] = 7; //Velocidade
				atributos[3] = 6; //Eficiência no DRS
				atributos[4] = 6; //Eficiência no ERS
				
				mediaAtrib = media(atributos);
				
				break;
			case "MCLAREN":
				nome = "McLaren";
				atributos[0] = 8; //Aerodinâmica
				atributos[1] = 8; //Motor
				atributos[2] = 9; //Velocidade
				atributos[3] = 7; //Eficiência no DRS
				atributos[4] = 9; //Eficiência no ERS
				
				mediaAtrib = media(atributos);
				
				break;
			case "MERCEDES":
				nome = "Mercedes";
				atributos[0] = 7; //Aerodinâmica
				atributos[1] = 7; //Motor
				atributos[2] = 7; //Velocidade
				atributos[3] = 9; //Eficiência no DRS
				atributos[4] = 10; //Eficiência no ERS
				
				mediaAtrib = media(atributos);
				
				break;
			case "REDBULL":
				nome = "RedBull";
				atributos[0] = 9; //Aerodinâmica
				atributos[1] = 10; //Motor
				atributos[2] = 9; //Velocidade
				atributos[3] = 10; //Eficiência no DRS
				atributos[4] = 8; //Eficiência no ERS
				
				mediaAtrib = media(atributos);
				
				break;
			case "SAUBER":
				nome = "Sauber";
				atributos[0] = 4; //Aerodinâmica
				atributos[1] = 3; //Motor
				atributos[2] = 4; //Velocidade
				atributos[3] = 6; //Eficiência no DRS
				atributos[4] = 2; //Eficiência no ERS
				
				mediaAtrib = media(atributos);
				
				break;
			case "VCARB":
				nome = "VICARB";
				atributos[0] = 6; //Aerodinâmica
				atributos[1] = 7; //Motor
				atributos[2] = 6; //Velocidade
				atributos[3] = 6; //Eficiência no DRS
				atributos[4] = 5; //Eficiência no ERS
				
				mediaAtrib = media(atributos);
				
				break;
			case "WILLIANS":
				nome = "Willians";
				atributos[0] = 5; //Aerodinâmica
				atributos[1] = 6; //Motor
				atributos[2] = 6; //Velocidade
				atributos[3] = 7; //Eficiência no DRS
				atributos[4] = 5; //Eficiência no ERS
				
				mediaAtrib = media(atributos);
				break;
				
			default:
				nome = "";
				mediaAtrib = 0;
				
				break;
		}
		
		//Retorna apenas se o carro for válido
		if (nome != "" && mediaAtrib > 0) {
			return nome + ";" + atributos[0] + ";" + atributos[1] + ";" + atributos[2] + ";" + atributos[3]
					+ ";" + atributos[4] + ";" + mediaAtrib;
		}
		else {
			return "Carro inválido";
		}
	
	}
	
	//calcula a média dos atributos
	static int media (int media[]) {
		
		int mediaTot = 0;
		
		for (int i = 0; i < media.length; i++) {
			mediaTot += media[i];
		}
		
		mediaTot /= media.length;
		
		return mediaTot;
		
	}
	
	//Definindo os pilotos
	static String pilotos (String piloto) {
		
		String nome;
		int atributos[] = new int[5];
		int mediaAtrib;
		
		switch (piloto) {			
			case "ALONSO":
				nome = "Fernando Alonso";
				atributos[0] = 7; //Suavidade
				atributos[1] = 6; //Tempo de resposta
				atributos[2] = 5; //Controle emocional
				atributos[3] = 9; //Agressividade
				atributos[4] = 8; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "STROLL":
				nome = "Lance Stroll";
				atributos[0] = 6; //Suavidade
				atributos[1] = 4; //Tempo de resposta
				atributos[2] = 5; //Controle emocional
				atributos[3] = 7; //Agressividade
				atributos[4] = 2; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "GASLY":
				nome = "Pierre Gasly";
				atributos[0] = 7; //Suavidade
				atributos[1] = 8; //Tempo de resposta
				atributos[2] = 5; //Controle emocional
				atributos[3] = 7; //Agressividade
				atributos[4] = 6; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "DOOHAN":
				nome = "Jack Doohan";
				atributos[0] = 6; //Suavidade
				atributos[1] = 4; //Tempo de resposta
				atributos[2] = 5; //Controle emocional
				atributos[3] = 6; //Agressividade
				atributos[4] = 6; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "LECLERC":
				nome = "Charles Leclerc";
				atributos[0] = 9; //Suavidade
				atributos[1] = 7; //Tempo de resposta
				atributos[2] = 7; //Controle emocional
				atributos[3] = 6; //Agressividade
				atributos[4] = 8; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "HAMILTON":
				nome = "Lewis Hamilton";
				atributos[0] = 8; //Suavidade
				atributos[1] = 7; //Tempo de resposta
				atributos[2] = 9; //Controle emocional
				atributos[3] = 9; //Agressividade
				atributos[4] = 9; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "BEARMAN":
				nome = "Oliver Bearman";
				atributos[0] = 4; //Suavidade
				atributos[1] = 5; //Tempo de resposta
				atributos[2] = 5; //Controle emocional
				atributos[3] = 5; //Agressividade
				atributos[4] = 6; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "OCON":
				nome = "Esteban Ocon";
				atributos[0] = 6; //Suavidade
				atributos[1] = 4; //Tempo de resposta
				atributos[2] = 3; //Controle emocional
				atributos[3] = 8; //Agressividade
				atributos[4] = 4; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "NORRIS":
				nome = "Lando Norris";
				atributos[0] = 8; //Suavidade
				atributos[1] = 9; //Tempo de resposta
				atributos[2] = 8; //Controle emocional
				atributos[3] = 7; //Agressividade
				atributos[4] = 7; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "PIASTRI":
				nome = "Oscar Piastri";
				atributos[0] = 7; //Suavidade
				atributos[1] = 7; //Tempo de resposta
				atributos[2] = 9; //Controle emocional
				atributos[3] = 8; //Agressividade
				atributos[4] = 8; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "RUSSEL":
				nome = "George Russel";
				atributos[0] = 7; //Suavidade
				atributos[1] = 7; //Tempo de resposta
				atributos[2] = 8; //Controle emocional
				atributos[3] = 8; //Agressividade
				atributos[4] = 9; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "ANTONELLI":
				nome = "Kimi Antonelli";
				atributos[0] = 6; //Suavidade
				atributos[1] = 5; //Tempo de resposta
				atributos[2] = 5; //Controle emocional
				atributos[3] = 6; //Agressividade
				atributos[4] = 6; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "VERSTAPPEN":
				nome = "Max Verstappen";
				atributos[0] = 8; //Suavidade
				atributos[1] = 10; //Tempo de resposta
				atributos[2] = 7; //Controle emocional
				atributos[3] = 10; //Agressividade
				atributos[4] = 8; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "HULKENBERG":
				nome = "Nico Hulkenberg";
				atributos[0] = 7; //Suavidade
				atributos[1] = 7; //Tempo de resposta
				atributos[2] = 6; //Controle emocional
				atributos[3] = 8; //Agressividade
				atributos[4] = 8; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "BORTOLETO":
				nome = "Gabriel Bortoleto";
				atributos[0] = 7; //Suavidade
				atributos[1] = 7; //Tempo de resposta
				atributos[2] = 9; //Controle emocional
				atributos[3] = 7; //Agressividade
				atributos[4] = 8; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "TSUNODA":
				nome = "Yuki Tsunoda";
				atributos[0] = 7; //Suavidade
				atributos[1] = 6; //Tempo de resposta
				atributos[2] = 3; //Controle emocional
				atributos[3] = 6; //Agressividade
				atributos[4] = 7; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "LAWSOM":
				nome = "Liam Lawsom";
				atributos[0] = 7; //Suavidade
				atributos[1] = 6; //Tempo de resposta
				atributos[2] = 8; //Controle emocional
				atributos[3] = 6; //Agressividade
				atributos[4] = 8; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "ALBON":
				nome = "Alexander Albon";
				atributos[0] = 7; //Suavidade
				atributos[1] = 8; //Tempo de resposta
				atributos[2] = 8; //Controle emocional
				atributos[3] = 6; //Agressividade
				atributos[4] = 5; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "SAINZ":
				nome = "Carlos Sainz";
				atributos[0] = 8; //Suavidade
				atributos[1] = 7; //Tempo de resposta
				atributos[2] = 9; //Controle emocional
				atributos[3] = 9; //Agressividade
				atributos[4] = 7; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			default:
				nome = "";
				mediaAtrib = 0;
				
				break;
		}
		
		//Retorna apenas se o piloto for válido
		if (nome != "" && mediaAtrib > 0) {
			return nome + ";" + atributos[0] + ";" + atributos[1] + ";" + atributos[2] + ";" + atributos[3]
					+ ";" + atributos[4] + ";" + mediaAtrib;
		}
		else {
			return "Piloto inválido";
		}
		
	}
	
	//Função para definir as informações dos circuitos
	static String circuito (String circuito) {
		
		String nome;
		int infoCirc[] = new int [4];
		
		switch (circuito) {
			case "BRASIL":
				nome = "GP de São Paulo";
				
				infoCirc[0] = 71; //Número de voltas
				infoCirc[1] = 15; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 50; //Chance de chuva leve
				infoCirc[3] = 20; //Chance de chuva pesada
				
				break;
			case "BAHREIN":
				nome = "GP do Bahrein";
				
				infoCirc[0] = 57; //Número de voltas
				infoCirc[1] = 20; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 10; //Chance de chuva leve
				infoCirc[3] = 2; //Chance de chuva pesada
				
				break;
			case "INGLATERRA":
				nome = "GP de Silverstone";
				
				infoCirc[0] = 51; //Número de voltas
				infoCirc[1] = 15; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 44; //Chance de chuva leve
				infoCirc[3] = 25; //Chance de chuva pesada
				
				break;
			case "AUSTRIA":
				nome = "RB Ring";
				
				infoCirc[0] = 71; //Número de voltas
				infoCirc[1] = 25; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 30; //Chance de chuva leve
				infoCirc[3] = 15; //Chance de chuva pesada
				
				break;
			case "ESPANHA":
				nome = "GP de Barcelona";
				
				infoCirc[0] = 66; //Número de voltas
				infoCirc[1] = 33; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 30; //Chance de chuva leve
				infoCirc[3] = 13; //Chance de chuva pesada
				
				break;
			case "MONACO":
				nome = "GP de Monte Carlo";
				
				infoCirc[0] = 78; //Número de voltas
				infoCirc[1] = 80; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 75; //Chance de chuva leve
				infoCirc[3] = 10; //Chance de chuva pesada
				
				break;
			case "BELGICA":
				nome = "GP de Spa";
				
				infoCirc[0] = 44; //Número de voltas
				infoCirc[1] = 44; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 55; //Chance de chuva leve
				infoCirc[3] = 25; //Chance de chuva pesada
				
				break;
			case "ITALIA":
				nome = "GP de Monza";
				
				infoCirc[0] = 53; //Número de voltas
				infoCirc[1] = 10; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 25; //Chance de chuva leve
				infoCirc[3] = 10; //Chance de chuva pesada
				
				break;
			case "EMILIA-ROMAGNHA":
				nome = "Enzo e Dino Ferrari";
				
				infoCirc[0] = 63; //Número de voltas
				infoCirc[1] = 50; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 30; //Chance de chuva leve
				infoCirc[3] = 6; //Chance de chuva pesada
				
				break;
			case "JAPAO":
				nome = "GP de Suzuka";
				
				infoCirc[0] = 53; //Número de voltas
				infoCirc[1] = 60; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 70; //Chance de chuva leve
				infoCirc[3] = 17; //Chance de chuva pesada
				
				break;
			default:
				nome = "";
				
				infoCirc[0] = 0;
				infoCirc[1] = 0;
				
				break;
		}
		
		//Retorna apenas se o circuito estiver disponível
		if (nome != "" && infoCirc[0] != 0) {
			return  nome + ";" + infoCirc[0] + ";" + infoCirc[1] + ";" + infoCirc[2] + ";" + infoCirc[3];
		}
		else {
			return "Este circuito não está disponível!!";
		}
		
	}
	
	static String chefes (String chefe) {
		
		String nome;
		int atrbChefe[] = new int [4];
		int mediaAtrb;
		
		switch (chefe) {
			case "HORNER":
				nome = "Christian Horner";
				
				atrbChefe[0] = 7; //Liderança
				atrbChefe[1] = 8; //Estratégia
				atrbChefe[2] = 6; //Gestão de pessoas
				atrbChefe[3] = 8; //Apelo patrocinio
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "WOLFF":
				nome = "Toto Wolff";
				
				atrbChefe[0] = 9; //Liderança
				atrbChefe[1] = 7; //Estratégia
				atrbChefe[2] = 8; //Gestão de pessoas
				atrbChefe[3] = 9; //Apelo patrocinio
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "VANSSEUR":
				nome = "Frédéric Vasseur";
				
				atrbChefe[0] = 7; //Liderança
				atrbChefe[1] = 6; //Estratégia
				atrbChefe[2] = 8; //Gestão de pessoas
				atrbChefe[3] = 7; //Apelo patrocinio
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "BROWN":
				nome = "Zak Brown";
				
				atrbChefe[0] = 9; //Liderança
				atrbChefe[1] = 7; //Estratégia
				atrbChefe[2] = 9; //Gestão de pessoas
				atrbChefe[3] = 10; //Apelo patrocinio
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "KRACK":
				nome = "Mike Krack";
				
				atrbChefe[0] = 6; //Liderança
				atrbChefe[1] = 7; //Estratégia
				atrbChefe[2] = 6; //Gestão de pessoas
				atrbChefe[3] = 5; //Apelo patrocinio
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "FAMIN":
				nome = "Bruno Famin";
				
				atrbChefe[0] = 5; //Liderança
				atrbChefe[1] = 4; //Estratégia
				atrbChefe[2] = 2; //Gestão de pessoas
				atrbChefe[3] = 4; //Apelo patrocinio
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "VOWLES":
				nome = "James Vowles";
				
				atrbChefe[0] = 6; //Liderança
				atrbChefe[1] = 5; //Estratégia
				atrbChefe[2] = 6; //Gestão de pessoas
				atrbChefe[3] = 5; //Apelo patrocinio
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "MEKIES":
				nome = "Laurent Mekies";
				
				atrbChefe[0] = 6; //Liderança
				atrbChefe[1] = 4; //Estratégia
				atrbChefe[2] = 5; //Gestão de pessoas
				atrbChefe[3] = 4; //Apelo patrocinio
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "BRAVI":
				nome = "Alunni Bravi";
				
				atrbChefe[0] = 5; //Liderança
				atrbChefe[1] = 3; //Estratégia
				atrbChefe[2] = 4; //Gestão de pessoas
				atrbChefe[3] = 2; //Apelo patrocinio
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "KOMATSU":
				nome = "Ayao Komatsu";
				
				atrbChefe[0] = 5; //Liderança
				atrbChefe[1] = 7; //Estratégia
				atrbChefe[2] = 6; //Gestão de pessoas
				atrbChefe[3] = 6; //Apelo patrocinio
				
				mediaAtrb = media(atrbChefe);
				
				break;
			default:
				nome = "";
				atrbChefe[0] = 0;
				mediaAtrb = 0;
				
				break;
		}
		
		if ((nome != "") && (atrbChefe[0] != 0)) {
			return nome + ";" + atrbChefe[0] + ";" + atrbChefe[1] + ";" + atrbChefe[2] + ";" + atrbChefe[3] 
				 + ";" + mediaAtrb;
		}
		else {
			return "Chefe de equipe invalido!!";
		}
		
	}
	
}
