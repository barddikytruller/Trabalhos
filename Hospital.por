programa
{
	inteiro quartos[20], opcao = 100, totalc, totali, totalp
	cadeia dadosi[20][2]
	cadeia dadosc[1000][3]
	funcao inicio()
	{
		zerar()
		enquanto (opcao != 5) {
			
			se (opcao == 1) {
				
				}
			se (opcao == 2) {
				
				}
			se (opcao == 3) {
				
				}
			se (opcao == 4) {
				
				}
			}
	}
	funcao menu() {
		escreva("      HOSPITAL - XPTO\n\n")
		escreva("-----------------------------\n")
		escreva("1 --> Consulta Ambulatorial.")
		escreva("\n2 --> Internação.")
		escreva("\n3 --> Listar Quartos.")
		escreva("\n4 --> Faturamento")
		escreva("\n5 --> Sair\n")
		escreva("-----------------------------\n\n")
		escreva("Digite a opção: ")
		leia(opcao)
		limpa()
		enquanto (opcao > 5 ou opcao <= 0) {
			escreva("\nOpção inválida!\n")
			escreva("Digite novamente:\n")
			leia(opcao)
			limpa()
				}
		}
	funcao zerar() {
		para(inteiro i=0; i < 20; i++) {
			quartos[i] = 0
			}
		}
	funcao internacao(inteiro v[]){
		inteiro o
		escreva("Qual quarto deseja reservar:")
		leia(o)
		enquanto (o > 20 ou o < 0) {
			
			}
		}
	
	funcao consulta() {
		
		}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1040; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */