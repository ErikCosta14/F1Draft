package game;

import java.util.Scanner;
import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		Random aleatorio = new Random();
		//vetores para atribuir os códigos deacesso dos vetores de banco de dados
		String circuitos[] = {"BRASIL", "BAHREIN", "INGLATERRA", "AUSTRIA", "ESPANHA", "MONACO", "BELGICA", "ITALIA", "EMILIA-ROMAGNHA", "JAPAO"};
		String carros[] = {"ASTON", "ALPINE", "FERRARI", "HAAS", "MCLAREN", "MERCEDES", "REDBULL", "SAUBER", "VCARB", "WILLIANS"};
		String chefes[] = {"HORNER", "WOLFF", "VASSEUR", "BROWN", "KRACK", "FAMIN", "VOWLES", "MEKIES", "BRAVI", "KOMATSU"};
		String pilotos[] = {"ALONSO", "STROLL", "GASLY", "DOOHAN", "LECLERC", "LEWIS", "BEARMAN", "OCON", "NORRIS", "PIASTRI",
				"RUSSEL", "KIMI", "MAX", "PEREZ", "NICO", "GABRIEL", "YUKI", "LAWSOM", "ALBON", "SAINZ"};
		String circJogo[];
		String equipSel[] = new String[4];
		String confgCirc;
		String confgJog;
		String vetAtr[];
		String varAtr;
		boolean menu;
		boolean circVal;
		int atrbEquip[][] = new int[4][6];
		int opcPrinc;
		int cont = 1;
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
						
						System.out.println("|==============Opcões de chefe de equipe================|");
						System.out.println("|  NOME | LID | ESTR | GST PSS | PATR | DES CORR | OVR  |");
						select(2);
						
						System.out.println("|==================Opcões de carros=====================|");
						System.out.println("|  NOME  | AER | MOTR | VELO | EFI DRS | EFI ERS | OVR  |");
						select(3);
						System.out.println("|=======================================================|");
						System.out.println("|=====Selecione uma opção de cada como no exemplo:======|");
						System.out.println("|=============exp: Max;Gabriel;Wolff;Aston==============|");
						System.out.printf(" Digite aqui suas opções: ");
						confgJog = teclado.next();
						
						equipSel = confgJog.split(";"); //equipe digitada vai para um vetor
						
						//Adicionando os atributos da equipe em uma matriz para facilitar
						for(int i = 0; i < atrbEquip.length; i++) {
							cont = 1;
							for(int j = 0; j < atrbEquip[i].length; j++) {
								if (i == 0 || i == 1) {
									vetAtr = pilotos(equipSel[i].toUpperCase()).split(";");
									varAtr = vetAtr[cont];
									atrbEquip[i][j] = Integer.parseInt(varAtr);
									cont++;
								}
								else if (i == 2) {
									vetAtr = chefe(equipSel[i].toUpperCase()).split(";");
									varAtr = vetAtr[cont];
									atrbEquip[i][j] = Integer.parseInt(varAtr);
									cont++;
								}
								else {
									vetAtr = carro(equipSel[i].toUpperCase()).split(";");
									varAtr = vetAtr[cont];
									atrbEquip[i][j] = Integer.parseInt(varAtr);
									cont++;
								}
							}
							cont++;
						} //Definições: 1 linha: piloto 1, 2 linha: piloto 2, 3 linha: chefe, 4 linha: carro
						
						//configurações terminadas
						
						jogoIni(numCirc, circJogo, equipSel, atrbEquip); //chamando a função para iniciar o jogo
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
	
	//função para centralizar alguma palavra de acordo com o menu
	static void centerMenu(int tmPal, String Pal) {
		
		int tmnCirc;
		int tmnAntCic;
		int sobraTmn;
		int cont;
		
		tmnCirc = 55 - tmPal;
		sobraTmn = tmnCirc % 2;
		tmnAntCic = tmnCirc / 2;
		tmnCirc /= 2;
		
		if(sobraTmn != 0) {
			tmnCirc += sobraTmn;
		}
		
		System.out.print("|");
		cont = 0;
		while ( cont < tmnAntCic) {
			System.out.print(" ");
			cont++;
		}
		System.out.printf("%s", Pal); //centralizando o nome do circuito na tela
		cont = 0;
		while ( cont < tmnCirc) {
			System.out.print(" ");
			cont++;
		}
		System.out.print("|\n");
		
	}
	
	//Função para escolher o carro
	static String carro(String carro) {
		
		String nome;
		int atributos[] = new int[5];
		int mediaAtrib;
		
		//A variável carro é analizada para determinar qual foi escolhida e atribuir os atributos no vetor
		switch (carro) {
			case "ASTON":
				nome = "Aston";
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
				nome = "VCARB";
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
	
	//Função para mostrar pneus disponíveis e suas estatísticas
	static void pneus() {
		
		String nomePneus[] = {"Macio(S)", "Médio(M)", "Duro(H)", "Intermediário(I)", "Chuva(W)"};
		int pneus[][] = {
				{100, 20, 20, 15}, //S
				{85,  35, 20, 15}, //M
				{75,  40, 20, 15}, //H
				{70, 45, 100, 60}, //I
				{65, 50, 60, 100}  //W
		};
		
		System.out.println("|      NOME      | ADER | DURAB | CHUV LEVE | CHUV PESA |");
		for (int j = 0; j < pneus.length; j++) {
			if(j == 0) {
				System.out.printf("|    %s    |  %d |  %d   |    %d     |    %d     |\n", nomePneus[j], pneus[j][0], 
						pneus[j][1], pneus[j][2], pneus[j][3]);
			}
			else if (j == 1) {
				System.out.printf("|    %s    |  %d  |  %d   |    %d     |    %d     |\n", nomePneus[j], pneus[j][0], 
						pneus[j][1], pneus[j][2], pneus[j][3]);
			}
			else if (j == 2) {
				System.out.printf("|    %s     |  %d  |  %d   |    %d     |    %d     |\n", nomePneus[j], pneus[j][0], 
						pneus[j][1], pneus[j][2], pneus[j][3]);
			}
			else if (j == 3){
				System.out.printf("|%s|  %d  |  %d   |    %d    |    %d     |\n", nomePneus[j], pneus[j][0], 
						pneus[j][1], pneus[j][2], pneus[j][3]);
			}
			else {
				System.out.printf("|     %s   |  %d  |  %d   |    %d     |    %d    |\n", nomePneus[j], pneus[j][0], 
						pneus[j][1], pneus[j][2], pneus[j][3]);
			}
		}
		System.out.println("|=======================================================|");
		
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
			case "LEWIS":
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
			case "KIMI":
				nome = "Kimi";
				atributos[0] = 6; //Suavidade
				atributos[1] = 5; //Tempo de resposta
				atributos[2] = 5; //Controle emocional
				atributos[3] = 6; //Agressividade
				atributos[4] = 6; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "MAX":
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
			case "NICO":
				nome = "Nico";
				atributos[0] = 7; //Suavidade
				atributos[1] = 7; //Tempo de resposta
				atributos[2] = 6; //Controle emocional
				atributos[3] = 8; //Agressividade
				atributos[4] = 8; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "GABRIEL":
				nome = "Gabriel";
				atributos[0] = 7; //Suavidade
				atributos[1] = 7; //Tempo de resposta
				atributos[2] = 9; //Controle emocional
				atributos[3] = 7; //Agressividade
				atributos[4] = 8; //Trabalho em equipe
				
				mediaAtrib = media(atributos);
				
				break;
			case "YUKI":
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
			return  nome + ";" + infoCirc[0] + ";" + infoCirc[1] + ";" + infoCirc[2] + ";" + infoCirc[3] + ";" + infoCirc[4];
		}
		else {
			return "";
		}
		
	}
	
	static String chefe(String chefe) {
		
		String nome;
		int atrbChefe[] = new int [5];
		int mediaAtrb;
		
		switch (chefe) {
			case "HORNER":
				nome = "Horner";
				
				atrbChefe[0] = 7; //Liderança
				atrbChefe[1] = 8; //Estratégia
				atrbChefe[2] = 6; //Gestão de pessoas
				atrbChefe[3] = 8; //Apelo patrocinio
				atrbChefe[4] = 7; //Desempenho em corrida
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "WOLFF":
				nome = "Wolff";
				
				atrbChefe[0] = 9; //Liderança
				atrbChefe[1] = 7; //Estratégia
				atrbChefe[2] = 8; //Gestão de pessoas
				atrbChefe[3] = 9; //Apelo patrocinio
				atrbChefe[4] = 8; //Desempenho em corrida
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "VASSEUR":
				nome = "Vasseur";
				
				atrbChefe[0] = 7; //Liderança
				atrbChefe[1] = 6; //Estratégia
				atrbChefe[2] = 8; //Gestão de pessoas
				atrbChefe[3] = 7; //Apelo patrocinio
				atrbChefe[4] = 8; //Desempenho em corrida
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "BROWN":
				nome = "Brown";
				
				atrbChefe[0] = 9; //Liderança
				atrbChefe[1] = 7; //Estratégia
				atrbChefe[2] = 9; //Gestão de pessoas
				atrbChefe[3] = 9; //Apelo patrocinio
				atrbChefe[4] = 9; //Desempenho em corrida
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "KRACK":
				nome = "Krack";
				
				atrbChefe[0] = 6; //Liderança
				atrbChefe[1] = 7; //Estratégia
				atrbChefe[2] = 6; //Gestão de pessoas
				atrbChefe[3] = 5; //Apelo patrocinio
				atrbChefe[4] = 6; //Desempenho em corrida
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "FAMIN":
				nome = "Famin";
				
				atrbChefe[0] = 5; //Liderança
				atrbChefe[1] = 4; //Estratégia
				atrbChefe[2] = 2; //Gestão de pessoas
				atrbChefe[3] = 4; //Apelo patrocinio
				atrbChefe[4] = 3; //Desempenho em corrida
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "VOWLES":
				nome = "Vowles";
				
				atrbChefe[0] = 6; //Liderança
				atrbChefe[1] = 5; //Estratégia
				atrbChefe[2] = 6; //Gestão de pessoas
				atrbChefe[3] = 5; //Apelo patrocinio
				atrbChefe[4] = 6; //Desempenho em corrida
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "MEKIES":
				nome = "Mekies";
				
				atrbChefe[0] = 6; //Liderança
				atrbChefe[1] = 4; //Estratégia
				atrbChefe[2] = 5; //Gestão de pessoas
				atrbChefe[3] = 4; //Apelo patrocinio
				atrbChefe[4] = 3; //Desempenho em corrida
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "BRAVI":
				nome = "Bravi";
				
				atrbChefe[0] = 5; //Liderança
				atrbChefe[1] = 3; //Estratégia
				atrbChefe[2] = 4; //Gestão de pessoas
				atrbChefe[3] = 2; //Apelo patrocinio
				atrbChefe[4] = 2; //Desempenho em corrida
				
				mediaAtrb = media(atrbChefe);
				
				break;
			case "KOMATSU":
				nome = "Komatsu";
				
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
			return nome + ";" + atrbChefe[0] + ";" + atrbChefe[1] + ";" + atrbChefe[2] + ";" + atrbChefe[3] + ";" 
				+ atrbChefe[4] + ";" + mediaAtrb;
		}
		else {
			return "";
		}
		
	}
	
	static void select (int indice) {
		
		Random aleatorio = new Random();
		String pilotos[] = {"ALONSO", "STROLL", "GASLY", "DOOHAN", "LECLERC", "LEWIS", "BEARMAN", "OCON", "NORRIS", "PIASTRI",
				"RUSSEL", "KIMI", "MAX", "PEREZ", "NICO", "GABRIEL", "YUKI", "LAWSOM", "ALBON", "SAINZ"};
		String chefes[] = {"HORNER", "WOLFF", "VASSEUR", "BROWN", "KRACK", "FAMIN", "VOWLES", "MEKIES", "BRAVI", "KOMATSU"};
		String carros[] = {"ASTON", "ALPINE", "FERRARI", "HAAS", "MCLAREN", "MERCEDES", "REDBULL", "SAUBER", "VCARB", "WILLIANS"};
		String atrb[];
		String confg;
		int num;
		int tmnAtrb;
		int numFoi[];
		
		if (indice == 1) { //Selecionou a mostragem de pilotos
			numFoi = new int[3];
			
			//Mostrar na tela os pilotos disponiveis
			for (int i = 1; i <= 3; i++) {
				num = aleatorio.nextInt(1, 20);
				
				//Impede repetição de pilotos
				for (int j = 0; j < numFoi.length; j++) {
					if ((num != numFoi[j]) && (numFoi[j] == 0)) {
						numFoi[j] = num;
						break;
					}
					else if (num == numFoi[j]) {
						num = aleatorio.nextInt(1, 20);
						j = -1;
					}
				}
				
				//chamando o piloto selecionado
				confg = pilotos(pilotos[num - 1]);
				atrb = confg.split(";");
				
				//mostrando os atributos do piloto selecionado
				for (int j = 0; j < atrb.length; j++) {
					System.out.print("|");
					tmnAtrb = 0;
					
					if (j == 0) {
						tmnAtrb += atrb[j].length();
						System.out.printf("%s", atrb[j]);
						while (tmnAtrb < 7) {
							System.out.print(" ");
							tmnAtrb++;
						}
					}
					else if (j == 1) {
						System.out.print("  ");
						System.out.printf("%s", atrb[j]);
						System.out.print("  ");
					}
					else if (j == 2) {
						System.out.print("     ");
						System.out.printf("%s", atrb[j]);
						System.out.print("     ");
					}
					else if (j == 3) {
						System.out.print("  ");
						System.out.printf("%s", atrb[j]);
						System.out.print("  ");
					}
					else if (j == 4) {
						System.out.print("  ");
						System.out.printf("%s", atrb[j]);
						System.out.print("   ");
					}
					else if (j == 5) {
						System.out.print("    ");
						System.out.printf("%s", atrb[j]);
						System.out.print("    ");
					}
					else {
						System.out.print("  ");
						System.out.printf("%s", atrb[j]);
						System.out.print("   ");
					}
				}
				System.out.println("|");
			}
		}
		else if (indice == 2) { //chamando os chefes
			numFoi = new int[3];
			
			//Mostrar na tela os chefes disponiveis
			for (int i = 1; i <= 3; i++) {
				num = aleatorio.nextInt(1, 10);
				
				//Impede repetição de chefes
				for (int j = 0; j < numFoi.length; j++) {
					if ((num != numFoi[j]) && (numFoi[j] == 0)) {
						numFoi[j] = num;
						break;
					}
					else if (num == numFoi[j]) {
						num = aleatorio.nextInt(1, 10);
						j = -1;
					}
				}
				
				//chamando o chefe selecionado
				confg = chefe(chefes[num - 1]);
				atrb = confg.split(";");
				
				//mostrando os atributos do chefe selecionado
				for (int j = 0; j < atrb.length; j++) {
					System.out.print("|");
					tmnAtrb = 0;
					
					if (j == 0) {
						tmnAtrb += atrb[j].length();
						System.out.printf("%s", atrb[j]);
						while (tmnAtrb < 7) {
							System.out.print(" ");
							tmnAtrb++;
						}
					}
					else if (j == 1) {
						System.out.print("  ");
						System.out.printf("%s", atrb[j]);
						System.out.print("  ");
					}
					else if (j == 2) {
						System.out.print("  ");
						System.out.printf("%s", atrb[j]);
						System.out.print("   ");
					}
					else if (j == 3) {
						System.out.print("    ");
						System.out.printf("%s", atrb[j]);
						System.out.print("    ");
					}
					else if (j == 4) {
						System.out.print("  ");
						System.out.printf("%s", atrb[j]);
						System.out.print("   ");
					}
					else if (j == 5) {
						System.out.print("    ");
						System.out.printf("%s", atrb[j]);
						System.out.print("     ");
					}
					else {
						System.out.print("  ");
						System.out.printf("%s", atrb[j]);
						System.out.print("   ");
					}
				}
				System.out.println("|");
			}
		}
		else if (indice == 3) {
			numFoi = new int[3];
			
			//Mostrar na tela os carros disponiveis
			for (int i = 1; i <= 3; i++) {
				num = aleatorio.nextInt(1, 10);
				
				//Impede repetição de carros
				for (int j = 0; j < numFoi.length; j++) {
					if ((num != numFoi[j]) && (numFoi[j] == 0)) {
						numFoi[j] = num;
					}
					else if (num == numFoi[j]) {
						num = aleatorio.nextInt(1, 10);
						j = -1;
					}
				}
				
				//chamando o carro selecionado
				confg = carro(carros[num - 1]);
				atrb = confg.split(";");
				
				//mostrando os atributos do carro selecionado
				for (int j = 0; j < atrb.length; j++) {
					System.out.print("|");
					tmnAtrb = 0;
					
					if (j == 0) {
						tmnAtrb += atrb[j].length();
						System.out.printf("%s", atrb[j]);
						while (tmnAtrb < 8) {
							System.out.print(" ");
							tmnAtrb++;
						}
					}
					else if (j == 1) {
						System.out.print("  ");
						System.out.printf("%s", atrb[j]);
						System.out.print("  ");
					}
					else if (j == 2) {
						System.out.print("  ");
						System.out.printf("%s", atrb[j]);
						System.out.print("   ");
					}
					else if (j == 3) {
						System.out.print("  ");
						System.out.printf("%s", atrb[j]);
						System.out.print("   ");
					}
					else if (j == 4) {
						System.out.print("    ");
						System.out.printf("%s", atrb[j]);
						System.out.print("    ");
					}
					else if (j == 5) {
						System.out.print("    ");
						System.out.printf("%s", atrb[j]);
						System.out.print("    ");
					}
					else {
						System.out.print("  ");
						System.out.printf("%s", atrb[j]);
						System.out.print("   ");
					}
				}
				System.out.println("|");
			}
		}
		
	}
	
	//Função para iniciar o jogo oficialmente
	static void jogoIni(int numCir, String circs[], String eqpSel[], int atbEqu[][]) {
		
		Scanner teclado = new Scanner(System.in);
		String cicAtual[];
		String pneuAtu[] = new String[5];
		String pneu;
		String chmPneu;
		boolean pnSelect;
		int voltParad[];
		int paradas;
		int pitBom = 0;
		int smVol;
		
		//iniciando um loop para o game de acordo com os circuitos escolhidos
		for (int i = 0; i < numCir; i++) {
			cicAtual = circuito(circs[i].toUpperCase()).split(";"); //definindo o primeiro circuito que o jogadpr escolheu
			
			//Pedindo para digitar o número de paradas que deseja
			limpaTela(1);
			System.out.println("|=======================================================|");
			System.out.println("|===Quantas paradas você deseja fazer neste circuito?===|");
			centerMenu(cicAtual[0].length(), cicAtual[0]);
			centerMenu(20, "Número de voltas: " + cicAtual[1]);
			System.out.println("|=======================================================|");
			System.out.print(" Digite aqui: ");
			paradas = teclado.nextInt();
			
			//Definindo as chances de vitórias de acordo com as paradas selecionadas
			if (paradas == Integer.parseInt(cicAtual[5])) {
				pitBom = 90;
			}
			else if (paradas > Integer.parseInt(cicAtual[5])) {
				smVol = paradas - Integer.parseInt(cicAtual[5]);
				
				if (smVol >= 2) {
					pitBom = 60;
				}
				else if (smVol == 1) {
					pitBom = 75;
				}
			}
			else {
				smVol = Integer.parseInt(cicAtual[5]) - paradas;
				
				if (paradas <= 0) {
					pitBom = 0;
				}
				else if (smVol >= 2) {
					pitBom = 50;
				}
				else if (smVol == 1) {
					pitBom = 70;
				}
			}
			
			voltParad = new int[paradas];
			
			//pedindo para especificar as voltas de cada parada
			limpaTela(2);
			System.out.println("|=======================================================|");
			System.out.println("|=====Digite as voltas que deseja fazer cada parada=====|");
			centerMenu(20, "Número de voltas: " + cicAtual[1]);
			System.out.println("|=======================================================|");
			for (int j = 0; j < voltParad.length; j++) {
				System.out.printf(" Digite aqui a parada %d: \n", j + 1);
				voltParad[j] = teclado.nextInt();
				
				if ((voltParad[j] > Integer.parseInt(cicAtual[1])) || voltParad[j] <= 0) {
					System.out.println("|=======================================================|");
					System.out.println("|===========Volta não existente nesse circuito==========|");
					System.out.println("|=======================================================|");
					j--;
				}
			}
			
			pnSelect = true;
			
			//definindo qual pneu será usado no início da corrida
			while (pnSelect) {
				limpaTela(2);
				System.out.println("|=======================================================|");
				System.out.println("|=====Qual pneu deseja utilizar no iníio da corrida=====|");
				pneus();
				System.out.print(" Digite aqui(Apenas a letra ex: 'M'): ");
				pneu = teclado.next();
				
				chmPneu = pneuAtual(pneu);
				
				if (chmPneu.equals("")) {
					System.out.println("|=======================================================|");
					System.out.println("|=============Pneu inválido digite novamente============|");
					System.out.println("|=======================================================|");
				}
				else {
					pneuAtu = chmPneu.split(";");
					pnSelect = false;
				}
			}
			
			corrida(pneuAtu, circs, eqpSel, atbEqu, pitBom);
		}
		
		teclado.close();
		
	}
	
	static String pneuAtual(String letPneu) {
		
		String nomePneus[] = {"Macio(S)", "Médio(M)", "Duro(H)", "Intermediário(I)", "Chuva(W)"};
		//atrbindo peneus, cada linha é: Macio(S), Médio(M), Duro(H), Chuva Leve(I), Chuva Pesada(W) 
		//Cada coluna atributo é: Aderência, Durabilidade(Em voltas), Pista úmida, Pista Molhada
		int pneus[][] = {
				{100, 20, 20, 15}, //S
				{85,  35, 20, 15}, //M
				{75,  40, 20, 15}, //H
				{70, 45, 100, 60}, //I
				{65, 50, 60, 100}  //W
		};
		
		switch (letPneu.toUpperCase()) {
			case "S":
				return nomePneus[0] + ";" + pneus[0][0] + ";" + pneus[0][1] + ";" + pneus[0][2] + ";" + pneus[0][3];
			case "M":
				return nomePneus[1] + ";" + pneus[1][0] + ";" + pneus[1][1] + ";" + pneus[1][2] + ";" + pneus[1][3];
			case "H":
				return nomePneus[2] + ";" + pneus[2][0] + ";" + pneus[2][1] + ";" + pneus[2][2] + ";" + pneus[2][3];
			case "I":
				return nomePneus[3] + ";" + pneus[3][0] + ";" + pneus[3][1] + ";" + pneus[3][2] + ";" + pneus[3][3];
			case "W":
				return nomePneus[4] + ";" + pneus[4][0] + ";" + pneus[4][1] + ";" + pneus[4][2] + ";" + pneus[4][3];
			default:
				return "";
		}
		
	}
	
	static void corrida(String pnAtu[], String circu[], String eqSele[], int atEqp[][], int pitBm) {
		
		Random aleatorio = new Random();
		Scanner teclado = new Scanner(System.in);
		String carros[] = {"ASTON", "ALPINE", "FERRARI", "HAAS", "MCLAREN", "MERCEDES", "REDBULL", "SAUBER", "VCARB", "WILLIANS"};
		String chefes[] = {"HORNER", "WOLFF", "VASSEUR", "BROWN", "KRACK", "FAMIN", "VOWLES", "MEKIES", "BRAVI", "KOMATSU"};
		String pilotos[] = {"ALONSO", "STROLL", "GASLY", "DOOHAN", "LECLERC", "LEWIS", "BEARMAN", "OCON", "NORRIS", "PIASTRI",
				"RUSSEL", "KIMI", "MAX", "PEREZ", "NICO", "GABRIEL", "YUKI", "LAWSOM", "ALBON", "SAINZ"};
		String pilVol[];
		String pilStan;
		int pils[] = new int[10];
		int ovrParc;
		int ovrlEqp = 0;
		int sftCar;
		int chvLev;
		int chvPes;
		int cont = 0;
		
		for (int i = 0; i < atEqp.length; i++) {
			ovrlEqp += atEqp[i][6];
		}
		
		ovrlEqp /= 4;
		
		for (int i = 0; i < pilotos.length; i += 2) {
			ovrParc = 0;
			
			for (int j = i; j < i + 2; j++) {
				pilStan = pilotos(pilotos[j]);
				pilVol = pilStan.split(";");
				
				ovrParc += Integer.parseInt(pilVol[6]); 
			}
			
			pils[cont] = ovrParc /= 2;
			cont++;
		}
		
		for (int i = 1; i <= Integer.parseInt(circu[1]); i ++) {
			
		}
		
		teclado.close();
		
	}
	
}
