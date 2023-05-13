package livros;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Biblioteca {
	private String responsavel;
	private List<Livro> livro = new ArrayList<Livro>();
	static protected int opcao;
	private Scanner sc = new Scanner(System.in);
	
	public Biblioteca(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getResponsavel() {
		return responsavel;
	}
	
	public List<Livro> getListaLivros() {
		return this.livro;
	}
	
	public void adicionar(Livro livro) {
		this.livro.add(livro);
	}
	
	public void pesquisarFaixaDePreco(double valorInicial, double valorFinal) {
		for (Livro l : this.livro) {
			if (l.getPreco() >= valorInicial && l.getPreco() <= valorFinal) {
				System.out.println(l.getTitulo());
			}
		}
	
	}
	
	public double calcularTotalLivros() {
		double total = 0;
		for (Livro l : this.livro) {
			total = total + l.getPreco();
		}
		
		return total;
	}
	
	public void menu() {
		System.out.println("**BIBLIOTECA DA FACULDADE**");
        System.out.println("1- Adicionar");
        System.out.println("2- Listar");
        System.out.println("3- Pesquisar Por Preço");
        System.out.println("4- Calcular Total");
        System.out.println("5- Sair");
        System.out.println("Digite a opção: ");
        opcao = sc.nextInt();
        
	}
	
}








