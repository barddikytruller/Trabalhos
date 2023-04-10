programa
{
	inclua biblioteca Util
	
	inteiro quartos[20], opcao = 100, totalc = 0, totali = 0, totalp = 0 // OBS: números inteiros pesam menos
	cadeia dadosi[20][2]
	cadeia dadosc[500][3]
	
	funcao inicio()
	{
		zerar()
		enquanto (opcao!=7){
			limpa()
			menu()
			se (opcao==1){
				consulta()
			}
			se (opcao==2){
				internacao()
			}
			se (opcao==3){
				listar_quartos()
			}
			se (opcao==4){
				fatura()
			}
			se (opcao==5){
				listar_internados()
			}
			se (opcao==6){
				listar_consultas()
			}
			se (opcao==7){
				escreva("Programa encerrado.")
			}
		}
	}
	funcao menu() // Função do menu interativo
	{
		escreva("\n      HOSPITAL - XPTO\n\n")
		escreva("-----------------------------\n")
		escreva("1 --> Consulta Ambulatorial")
		escreva("\n2 --> Internação")
		escreva("\n3 --> Listar Quartos")
		escreva("\n4 --> Faturamento")
		escreva("\n5 --> Listar internados")
		escreva("\n6 --> Listar Consultas")
		escreva("\n7 --> Sair\n")
		escreva("-----------------------------\n\n")
		escreva("Digite a opção: ")
		leia(opcao)
		limpa()
		enquanto (opcao > 7 ou opcao <= 0){
			escreva("\nOpção inválida!\n")
			escreva("Digite novamente:\n")
			leia(opcao)
			limpa()
		}
	}
	
	funcao zerar() // Função que atribui valor 0 a todos os espaços do vetor "quartos"
	{
		para(inteiro i=0; i < 20; i++){
			quartos[i] = 0
		}
	}
	
	funcao internacao() // Função interativa que reserva um quarto para internação
	{
		inteiro o = 0

		escreva("-----------------------------\n")
		escreva("         INTERNAÇÃO\n")
		escreva("-----------------------------\n\n")
		escreva("Qual quarto deseja reservar: ")
		leia(o)
		enquanto (o > 20 ou o - 1 < 0){ // O "o - 1" foi posto pra fazer a indexagem 1, 20
			limpa()
			escreva("-----------------------------\n")
			escreva("         INTERNAÇÃO\n")
			escreva("-----------------------------\n\n")
			escreva("Número de quarto inválido!\n\n")
			escreva("Por favor, digite novamente: ")
			leia(o)
		}
		se (quartos[o - 1] == 1){
			limpa()
			escreva("-----------------------------\n")
			escreva("         INTERNAÇÃO\n")
			escreva("-----------------------------\n\n")
			escreva("Quarto já ocupado!\n\n")
			escreva("Voltando ao menu!\n")
			Util.aguarde(3000)
		}senao{
			cadeia numero, nome
			limpa()
			escreva("-----------------------------\n")
			escreva("         INTERNAÇÃO\n")
			escreva("-----------------------------\n\n")
			escreva("Digite o nome do paciente: ")
			leia(nome)
			limpa()
			escreva("-----------------------------\n")
			escreva("         INTERNAÇÃO\n")
			escreva("-----------------------------\n\n")
			escreva("Digite o número do paciente: ")
			leia(numero)
			dadosi[o - 1][0] = nome
			dadosi[o - 1][1] = numero
			quartos[o - 1] = 1
			totali++
			limpa()
			escreva("-----------------------------\n")
			escreva("         INTERNAÇÃO\n")
			escreva("-----------------------------\n\n")
			escreva("Quarto reservado com sucesso!")
			Util.aguarde(3000)
		}
	}
	
	funcao listar_quartos() // Função que lista os quartos
	{
		cadeia continuar
		
		limpa()
		escreva("-----------------------------\n")
		escreva("           QUARTOS\n")
		escreva("-----------------------------\n\n")
		para (inteiro i=0; i < 20; i++){
			escreva(quartos[i], " ")
			se ((i + 1)%5 == 0){
				escreva("\n")
			}
	  	}
	  	escreva("\n0 para vazio e 1 para ocupado.")
	  	escreva("\n\nPressione qualquer tecla para continuar.")
		leia(continuar)
	}
	
   	funcao fatura() // Função que faz um relatório das consultas, internações e arrecadações
   	{ 
   		cadeia continuar
   		limpa()
		escreva("-----------------------------------------\n")
		escreva("              FATURAMENTO\n\n")
		escreva("Total arrecadado por consulta: R$", (totalc * 120) + (totalp * 150), ",00", "\n")
   		escreva("Total arrecadado por internação: R$", totali * 500, ",00", "\n")
   		escreva("Total geral arrecadado: R$", (totalc * 120) + (totalp * 150) + (totali * 500), ",00", "\n")
		escreva("-----------------------------------------\n")
		escreva("-----------------------------------------\n")
		escreva("     NÚMERO DE CONSULTAS E INTERNADOS\n\n")
		escreva("Número de consultas tipo pediátricas: ", totalp, "\n")
   		escreva("Número de outros tipos de consulta: ", totalc, "\n")
   		escreva("Número total de consultas: ", totalc + totalp, "\n")
   		escreva("Número total de internados: ", totali, "\n")
		escreva("-----------------------------------------\n")
		escreva("Pressione qualquer tecla para continuar.")
		leia(continuar)
   	}

   	funcao consulta() // Função interativa que registra uma consulta
   	{ 
   		cadeia nome, numero
   		inteiro tipo
   		
   		escreva("-----------------------------\n")
   		escreva("    CONSULTA AMBULATORIAL\n")
   		escreva("-----------------------------\n\n")
   		escreva("Digite o nome do paciente: ")
   		leia(nome)
   		limpa()
   		escreva("-----------------------------\n")
   		escreva("    CONSULTA AMBULATORIAL\n")
   		escreva("-----------------------------\n\n")
   		escreva("Digite o número do paciente: ")
   		leia(numero)
   		limpa()
   		escreva("-----------------------------\n")
   		escreva("    CONSULTA AMBULATORIAL\n")
   		escreva("-----------------------------\n\n")
   		escreva("[1] Pediatria\n")
   		escreva("[2] Outro\n")
   		escreva("\nEscolha o tipo de consulta: ")
   		leia(tipo)
   		
   		enquanto(tipo < 1 ou tipo > 2){
   			limpa()
   			escreva("-----------------------------\n")
   			escreva("    CONSULTA AMBULATORIAL\n")
   			escreva("-----------------------------\n\n")
   			escreva("Opção inválida!\n")
   			escreva("Digite novamente:\n")
   			leia(tipo)
   		}
   		se (tipo == 1){
   			dadosc[totalc + totalp][0] = nome
   			dadosc[totalc + totalp][1] = numero
   			dadosc[totalc + totalp][2] = "Pediatria"
   			totalp++
   			limpa()
   			escreva("-----------------------------\n")
   			escreva("    CONSULTA AMBULATORIAL\n")
   			escreva("-----------------------------\n\n")
   			escreva("Consulta Registrada!\n")
   			Util.aguarde(3000)
   		}
   		se (tipo == 2){
   			dadosc[totalc + totalp][0] = nome
   			dadosc[totalc + totalp][1] = numero
   			dadosc[totalc + totalp][2] = "Outro"
   			totalc++
   			limpa()
   			escreva("-----------------------------\n")
   			escreva("    CONSULTA AMBULATORIAL\n")
   			escreva("-----------------------------\n\n")
   			escreva("Consulta Registrada!\n")
   			Util.aguarde(3000)
   		}
   	}
   	
   	funcao listar_internados() // Função que lista os internados registrados no "dadosi"
   	{
   		inteiro c = 0
   		cadeia continuar
   		escreva("-----------------------------\n")
   		escreva("         INTERNADOS\n")
   		escreva("-----------------------------\n\n")
   		para(inteiro i=0; i < 20; i++){ 
   			se (quartos[i] == 1){
   				escreva("Quarto: ", i + 1, "\n")
   				escreva("Paciente: ", dadosi[i][0], "\n")
   				escreva("Número: ", dadosi[i][1], "\n")
   				escreva("-----------------------------\n")
   				c++
   			}
   		}
   		escreva("\nExistem ", 20 - c, " vagas disponíveis.\n\n")
   		escreva("Pressione qualquer tecla para continuar.")
		leia(continuar)
   	}
   	funcao listar_consultas() // Função que lista as consultas registradas no "dadosc"
   	{
   		cadeia continuar
   		
   		escreva("-----------------------------\n")
   		escreva("         CONSULTAS\n")
   		escreva("-----------------------------\n\n")
   		para(inteiro i=0; i < totalc + totalp; i++){
   			escreva("Paciente: ", dadosc[i][0], "\n")
   			escreva("Número: ", dadosc[i][1], "\n")
   			escreva("Tipo: ", dadosc[i][2], "\n")
   			escreva("-----------------------------\n\n")
   		}
   		escreva("Pressione qualquer tecla para continuar.")
		leia(continuar)
   	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 3223; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {dadosi, 6, 8, 6}-{dadosc, 7, 8, 6};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */