package game;

import java.util.Scanner;
import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		Random aleatorio = new Random();
		//vetores para atribuir os códigos deacesso dos vetores de banco de dados
		String circuitos[] = {"BRASIL", "BAHREIN", "INGLATERRA", "AUSTRIA", "ESPANHA", "MONACO", "BELGICA", "ITALIA", "EMILIA-ROMAGNHA", "JAPAO"};
		String carros[] = {"ASTON MARTIN", "ALPINE", "FERRARI", "HAAS", "MCLAREN", "MERCEDES", "REDBULL", "SAUBER", "VCARB", "WILLIANS"};
		String chefes[] = {"HORNER", "WOLFF", "VANSSEUR", "BROWN", "KRACK", "FAMIN", "VOWLES", "MEKIES", "BRAVI", "KOMATSU"};
		String pilotos[] = {"ALONSO", "STROLL", "GASLY", "DOOHAN", "LECLERC", "HAMILTON", "BEARMAN", "OCON", "NORRIS", "PIASTRI",
				"RUSSEL", "ANTONELLI", "VERSTAPPEN", "PEREZ", "HULKENBERG", "BORTOLETO", "TSUNODA", "LAWSOM", "ALBON", "SAINZ"};
		String circJogo[];
		String confgCirc;
		boolean menu;
		boolean circVal;
		int opcPrinc;
		int tmnMostr;
		int numCirc;
		
		menu = true; //Iniciando o menu
		
		while(menu) {
			limpaTela(2);
			System.out.println("|=======================================================|");
			System.out.println("|===================MENU PRINCIPAL======================|");
			System.out.println("|=======================================================|");
			System.out.println("|                     1 - JOGAR                         |");
			System.out.println("|                     2 - SAIR                          |");
			System.out.println("|=======================================================|");
			System.out.print(" Digite a opção que deseja(Apenas números): ");
			opcPrinc = teclado.nextInt();
			
			switch(opcPrinc) {
				case 1:
					limpaTela(2);
					//Iniciando o game
					System.out.println("|=======================================================|");
					System.out.println("|================FASE DE CONFIGURAÇÃO===================|");
					System.out.println("|=======================================================|");
					
					System.out.println("|===============Circuitos disponíveis===================|");
					tmnMostr = 0;
					for (int i = 0; i < circuitos.length; i++) {
						tmnMostr += (circuitos[i].length() + 1);
						tmnMostr = limitMenu(tmnMostr);
						
						System.out.printf(" %s;", circuitos[i]);
					}
					//pedindo o jogador para selecionar os circuitos que deseja jogar
					System.out.println();
					System.out.println("|=======================================================|");
					System.out.println("|=Digite os circuitos que você deseja igual ao exemplo:=|");
					System.out.println("|            exp: Brasil;Italia;...(sem espaços)        |");
					System.out.println("|=======================================================|");
					System.out.print(" Digite aqui: ");
					confgCirc = teclado.next();
					
					circJogo = confgCirc.split(";"); //separando em um vetor os circuitos
					circVal = true;
					
					//conferindo se o circuito é válido
					for (int i = 0; i < circJogo.length; i++) {
						circJogo[i] = circJogo[i].toUpperCase();
						
						if (circuito(circJogo[i]).equals("")) {
							System.out.printf("\n O circuito %s não está disponível! Reinicie o jogo!\n", circJogo[i]);
							circVal = false;
							break;
						}
						else {
							circVal = true;
						}
					}
					
					if(circVal == false) {
						break;
					}else {
						numCirc = circJogo.length; //Definindo quantos circuitos terão no jogo
						
						//Mostrando os players disponiveis para aquele jogo
						limpaTela(1);
						System.out.println("|=======================================================|");
						System.out.println("|=================Opcões de piloto 1====================|");
						System.out.println("|  NOME | SUA | TEMP RESP | EMO | AGRE | TRB EQP | OVR  |");
						select(1);
						
						System.out.println("|=================Opcões de piloto 2====================|");
						System.out.println("|  NOME | SUA | TEMP RESP | EMO | AGRE | TRB EQP | OVR  |");
						select(1);
					}
					
					break;
				case 2:
					limpaTela(1);
					System.out.println("|=======================================================|");
					System.out.println("|====================JOGO FECHADO=======================|");
					System.out.println("|=======================================================|");
					limpaTela(2);
					
					//Finalizando o jogo
					menu = false;
					break;
				default:
					limpaTela(1);
					//Caso a opção não exista no menu, pedindo para escolher uma diferente
					System.out.println("|=======================================================|");
					System.out.println("|========OPÇÃO INVALIDA ESCOLHA UMA DIFERENTE===========|");
					System.out.println("|=======================================================|");
					break;
			}
		}
		
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
	
	//Função para definir o tamanho do menu
	static int limitMenu(int tmn) {
		
		final int tamMenu = 57;
		
		if(tmn >= tamMenu) {
			tmn = 0;
			System.out.println("");
		}
		
		return tmn;
		
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
				atributos[4] = 9; //Eficiência no ERS
				
				mediaAtrib = media(atributos);
				
				break;
			case "REDBULL":
				nome = "RedBull";
				atributos[0] = 8; //Aerodinâmica
				atributos[1] = 9; //Motor
				atributos[2] = 8; //Velocidade
				atributos[3] = 7; //Eficiência no DRS
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
			return "";
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
				nome = "Alonso";
				atributos[0] = 7; //Suavidade
				atributos[1] = 6; //Tempo de resposta
				atributos[2] = 5; //Controle emocional
				atributos[3] = 9; //Agressividade
				atributos[4] = 8; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "STROLL":
				nome = "Stroll";
				atributos[0] = 6; //Suavidade
				atributos[1] = 4; //Tempo de resposta
				atributos[2] = 5; //Controle emocional
				atributos[3] = 7; //Agressividade
				atributos[4] = 2; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "GASLY":
				nome = "Gasly";
				atributos[0] = 7; //Suavidade
				atributos[1] = 8; //Tempo de resposta
				atributos[2] = 5; //Controle emocional
				atributos[3] = 7; //Agressividade
				atributos[4] = 6; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "DOOHAN":
				nome = "Doohan";
				atributos[0] = 6; //Suavidade
				atributos[1] = 4; //Tempo de resposta
				atributos[2] = 5; //Controle emocional
				atributos[3] = 6; //Agressividade
				atributos[4] = 6; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "LECLERC":
				nome = "Leclerc";
				atributos[0] = 9; //Suavidade
				atributos[1] = 7; //Tempo de resposta
				atributos[2] = 7; //Controle emocional
				atributos[3] = 6; //Agressividade
				atributos[4] = 8; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "HAMILTON":
				nome = "Lewis";
				atributos[0] = 8; //Suavidade
				atributos[1] = 7; //Tempo de resposta
				atributos[2] = 9; //Controle emocional
				atributos[3] = 9; //Agressividade
				atributos[4] = 9; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "BEARMAN":
				nome = "Bearman";
				atributos[0] = 4; //Suavidade
				atributos[1] = 5; //Tempo de resposta
				atributos[2] = 5; //Controle emocional
				atributos[3] = 5; //Agressividade
				atributos[4] = 6; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "OCON":
				nome = "Ocon";
				atributos[0] = 6; //Suavidade
				atributos[1] = 4; //Tempo de resposta
				atributos[2] = 3; //Controle emocional
				atributos[3] = 8; //Agressividade
				atributos[4] = 4; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "NORRIS":
				nome = "Norris";
				atributos[0] = 8; //Suavidade
				atributos[1] = 9; //Tempo de resposta
				atributos[2] = 8; //Controle emocional
				atributos[3] = 7; //Agressividade
				atributos[4] = 7; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "PIASTRI":
				nome = "Piastri";
				atributos[0] = 7; //Suavidade
				atributos[1] = 7; //Tempo de resposta
				atributos[2] = 9; //Controle emocional
				atributos[3] = 8; //Agressividade
				atributos[4] = 8; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "RUSSEL":
				nome = "Russel";
				atributos[0] = 7; //Suavidade
				atributos[1] = 7; //Tempo de resposta
				atributos[2] = 8; //Controle emocional
				atributos[3] = 8; //Agressividade
				atributos[4] = 9; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "ANTONELLI":
				nome = "Kimi";
				atributos[0] = 6; //Suavidade
				atributos[1] = 5; //Tempo de resposta
				atributos[2] = 5; //Controle emocional
				atributos[3] = 6; //Agressividade
				atributos[4] = 6; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "VERSTAPPEN":
				nome = "Max";
				atributos[0] = 8; //Suavidade
				atributos[1] = 9; //Tempo de resposta
				atributos[2] = 7; //Controle emocional
				atributos[3] = 9; //Agressividade
				atributos[4] = 8; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "PEREZ":
				nome = "Perez";
				atributos[0] = 7; //Suavidade
				atributos[1] = 5; //Tempo de resposta
				atributos[2] = 7; //Controle emocional
				atributos[3] = 6; //Agressividade
				atributos[4] = 9; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "HULKENBERG":
				nome = "Nico";
				atributos[0] = 7; //Suavidade
				atributos[1] = 7; //Tempo de resposta
				atributos[2] = 6; //Controle emocional
				atributos[3] = 8; //Agressividade
				atributos[4] = 8; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "BORTOLETO":
				nome = "Gabriel";
				atributos[0] = 7; //Suavidade
				atributos[1] = 7; //Tempo de resposta
				atributos[2] = 9; //Controle emocional
				atributos[3] = 7; //Agressividade
				atributos[4] = 8; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "TSUNODA":
				nome = "Yuki";
				atributos[0] = 7; //Suavidade
				atributos[1] = 6; //Tempo de resposta
				atributos[2] = 3; //Controle emocional
				atributos[3] = 6; //Agressividade
				atributos[4] = 7; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "LAWSOM":
				nome = "Lawsom";
				atributos[0] = 7; //Suavidade
				atributos[1] = 6; //Tempo de resposta
				atributos[2] = 8; //Controle emocional
				atributos[3] = 6; //Agressividade
				atributos[4] = 8; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "ALBON":
				nome = "Albon";
				atributos[0] = 7; //Suavidade
				atributos[1] = 8; //Tempo de resposta
				atributos[2] = 8; //Controle emocional
				atributos[3] = 6; //Agressividade
				atributos[4] = 5; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "SAINZ":
				nome = "Sainz";
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
			return "";
		}
		
	}
	
	//Função para definir as informações dos circuitos
	static String circuito (String circuito) {
		
		String nome;
		int infoCirc[] = new int [5];
		
		switch (circuito) {
			case "BRASIL":
				nome = "GP de São Paulo";
				
				infoCirc[0] = 71; //Número de voltas
				infoCirc[1] = 15; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 50; //Chance de chuva leve
				infoCirc[3] = 20; //Chance de chuva pesada
				infoCirc[4] = 1;  //Paradas perfeitas
				
				break;
			case "BAHREIN":
				nome = "GP do Bahrein";
				
				infoCirc[0] = 57; //Número de voltas
				infoCirc[1] = 20; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 10; //Chance de chuva leve
				infoCirc[3] = 2; //Chance de chuva pesada
				infoCirc[4] = 2;  //Paradas perfeitas
				
				break;
			case "INGLATERRA":
				nome = "GP de Silverstone";
				
				infoCirc[0] = 51; //Número de voltas
				infoCirc[1] = 15; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 44; //Chance de chuva leve
				infoCirc[3] = 25; //Chance de chuva pesada
				infoCirc[4] = 1;  //Paradas perfeitas
				
				break;
			case "AUSTRIA":
				nome = "RB Ring";
				
				infoCirc[0] = 71; //Número de voltas
				infoCirc[1] = 25; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 30; //Chance de chuva leve
				infoCirc[3] = 15; //Chance de chuva pesada
				infoCirc[4] = 1;  //Paradas perfeitas
				
				break;
			case "ESPANHA":
				nome = "GP de Barcelona";
				
				infoCirc[0] = 66; //Número de voltas
				infoCirc[1] = 33; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 30; //Chance de chuva leve
				infoCirc[3] = 13; //Chance de chuva pesada
				infoCirc[4] = 2;  //Paradas perfeitas
				
				break;
			case "MONACO":
				nome = "GP de Monte Carlo";
				
				infoCirc[0] = 78; //Número de voltas
				infoCirc[1] = 80; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 75; //Chance de chuva leve
				infoCirc[3] = 10; //Chance de chuva pesada
				infoCirc[4] = 1;  //Paradas perfeitas
				
				break;
			case "BELGICA":
				nome = "GP de Spa";
				
				infoCirc[0] = 44; //Número de voltas
				infoCirc[1] = 44; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 55; //Chance de chuva leve
				infoCirc[3] = 25; //Chance de chuva pesada
				infoCirc[4] = 3;  //Paradas perfeitas
				
				break;
			case "ITALIA":
				nome = "GP de Monza";
				
				infoCirc[0] = 53; //Número de voltas
				infoCirc[1] = 10; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 25; //Chance de chuva leve
				infoCirc[3] = 10; //Chance de chuva pesada
				infoCirc[4] = 1;  //Paradas perfeitas
				
				break;
			case "EMILIA-ROMAGNHA":
				nome = "Enzo e Dino Ferrari";
				
				infoCirc[0] = 63; //Número de voltas
				infoCirc[1] = 50; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 30; //Chance de chuva leve
				infoCirc[3] = 6; //Chance de chuva pesada
				infoCirc[4] = 2;  //Paradas perfeitas
				
				break;
			case "JAPAO":
				nome = "GP de Suzuka";
				
				infoCirc[0] = 53; //Número de voltas
				infoCirc[1] = 60; //Chance de SafetyCar em porcentagem
				infoCirc[2] = 70; //Chance de chuva leve
				infoCirc[3] = 17; //Chance de chuva pesada
				infoCirc[4] = 1;  //Paradas perfeitas
				
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
			return "";
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
				atrbChefe[4] = 7; //Desempenho em corrida
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "WOLFF":
				nome = "Toto Wolff";
				
				atrbChefe[0] = 9; //Liderança
				atrbChefe[1] = 7; //Estratégia
				atrbChefe[2] = 8; //Gestão de pessoas
				atrbChefe[3] = 9; //Apelo patrocinio
				atrbChefe[4] = 8; //Desempenho em corrida
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "VANSSEUR":
				nome = "Frédéric Vasseur";
				
				atrbChefe[0] = 7; //Liderança
				atrbChefe[1] = 6; //Estratégia
				atrbChefe[2] = 8; //Gestão de pessoas
				atrbChefe[3] = 7; //Apelo patrocinio
				atrbChefe[4] = 8; //Desempenho em corrida
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "BROWN":
				nome = "Zak Brown";
				
				atrbChefe[0] = 9; //Liderança
				atrbChefe[1] = 7; //Estratégia
				atrbChefe[2] = 9; //Gestão de pessoas
				atrbChefe[3] = 10; //Apelo patrocinio
				atrbChefe[4] = 9; //Desempenho em corrida
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "KRACK":
				nome = "Mike Krack";
				
				atrbChefe[0] = 6; //Liderança
				atrbChefe[1] = 7; //Estratégia
				atrbChefe[2] = 6; //Gestão de pessoas
				atrbChefe[3] = 5; //Apelo patrocinio
				atrbChefe[4] = 6; //Desempenho em corrida
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "FAMIN":
				nome = "Bruno Famin";
				
				atrbChefe[0] = 5; //Liderança
				atrbChefe[1] = 4; //Estratégia
				atrbChefe[2] = 2; //Gestão de pessoas
				atrbChefe[3] = 4; //Apelo patrocinio
				atrbChefe[4] = 3; //Desempenho em corrida
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "VOWLES":
				nome = "James Vowles";
				
				atrbChefe[0] = 6; //Liderança
				atrbChefe[1] = 5; //Estratégia
				atrbChefe[2] = 6; //Gestão de pessoas
				atrbChefe[3] = 5; //Apelo patrocinio
				atrbChefe[4] = 6; //Desempenho em corrida
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "MEKIES":
				nome = "Laurent Mekies";
				
				atrbChefe[0] = 6; //Liderança
				atrbChefe[1] = 4; //Estratégia
				atrbChefe[2] = 5; //Gestão de pessoas
				atrbChefe[3] = 4; //Apelo patrocinio
				atrbChefe[4] = 3; //Desempenho em corrida
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "BRAVI":
				nome = "Alunni Bravi";
				
				atrbChefe[0] = 5; //Liderança
				atrbChefe[1] = 3; //Estratégia
				atrbChefe[2] = 4; //Gestão de pessoas
				atrbChefe[3] = 2; //Apelo patrocinio
				atrbChefe[4] = 2; //Desempenho em corrida
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "KOMATSU":
				nome = "Ayao Komatsu";
				
				atrbChefe[0] = 5; //Liderança
				atrbChefe[1] = 7; //Estratégia
				atrbChefe[2] = 6; //Gestão de pessoas
				atrbChefe[3] = 6; //Apelo patrocinio
				atrbChefe[4] = 7; //Desempenho em corrida
				
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
			return "";
		}
		
	}
	
	static void select (int indice) {
		
		Random aleatorio = new Random();
		String pilotos[] = {"ALONSO", "STROLL", "GASLY", "DOOHAN", "LECLERC", "HAMILTON", "BEARMAN", "OCON", "NORRIS", "PIASTRI",
				"RUSSEL", "ANTONELLI", "VERSTAPPEN", "PEREZ", "HULKENBERG", "BORTOLETO", "TSUNODA", "LAWSOM", "ALBON", "SAINZ"};
		String atrbPilo[];
		String confgPilo;
		int numPil;
		int tmnAtrb;
		int numFoi[];
		
		if (indice == 1) {
			numFoi = new int[3];
			
			for (int i = 1; i <= 3; i++) {
				numPil = aleatorio.nextInt(1, 20);
				
				for (int j = 0; j < numFoi.length; j++) {
					if (numFoi[j] != 0) {
						if (numFoi[j] == numPil) {
							numPil = aleatorio.nextInt(1, 20);
							j = -1;
						}
					}
				}
				confgPilo = pilotos(pilotos[numPil - 1]);
				atrbPilo = confgPilo.split(";");
				
				for (int j = 0; j < atrbPilo.length; j++) {
					System.out.print("|");
					tmnAtrb = 0;
					
					if (j == 0) {
						tmnAtrb += atrbPilo[j].length();
						System.out.printf("%s", atrbPilo[j]);
						while (tmnAtrb < 7) {
							System.out.print(" ");
							tmnAtrb++;
						}
					}
					else if (j == 1) {
						System.out.print("  ");
						System.out.printf("%s", atrbPilo[j]);
						System.out.print("  ");
					}
					else if (j == 2) {
						System.out.print("     ");
						System.out.printf("%s", atrbPilo[j]);
						System.out.print("     ");
					}
					else if (j == 3) {
						System.out.print("  ");
						System.out.printf("%s", atrbPilo[j]);
						System.out.print("  ");
					}
					else if (j == 4) {
						System.out.print("  ");
						System.out.printf("%s", atrbPilo[j]);
						System.out.print("   ");
					}
					else if (j == 5) {
						System.out.print("    ");
						System.out.printf("%s", atrbPilo[j]);
						System.out.print("    ");
					}
					else {
						System.out.print("  ");
						System.out.printf("%s", atrbPilo[j]);
						System.out.print("   ");
					}
				}
				System.out.println("|");
			}
		}
		
	}
}
