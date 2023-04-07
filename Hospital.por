programa
{
	inteiro quartos[20], opcao = 100, totalc, totali, totalp
	cadeia dadosc[1000][3]
	funcao inicio()
	{
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
		escreva("\n 1 --> Consulta Ambulatorial.")
		escreva("\n 2 --> Internação.")
		escreva("\n 3 --> Listar Quartos.")
		escreva("\n 4 --> Faturamento")
		escreva("\n 5 --> Sair\n")
		leia(opcao)
		limpa()
		enquanto (opcao > 5 ou opcao <= 0) {
			escreva("\nOpção inválida!\n")
			escreva("Digite novamente:\n")
			leia(opcao)
			limpa()
				}
		}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 378; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */