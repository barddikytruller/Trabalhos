package livros;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class testarLivro {
	public static void main(String[] args) {
	    List<Livro> lista = new ArrayList<Livro>();
	    Biblioteca b = new Biblioteca("Arthur");
	    Scanner ler = new Scanner(System.in);
	    while (Biblioteca.opcao != 5) {
	        b.menu();
	        if (Biblioteca.opcao == 1) {
	            System.out.println("Digite o titulo: ");
	            var t = ler.next();
	            System.out.println("Digite o autor: ");
	            var a = ler.next();
	            System.out.println("Digite o preço: ");
	            var p = ler.nextDouble();

	            Livro livro = new Livro(t, a, p);
	            b.adicionar(livro);
	            System.out.println("Livro adicionado!");
	        } else if (Biblioteca.opcao == 2) {
	            List<Livro> livros = b.getListaLivros();
	            for (Livro livro : livros) {
	                System.out.println(livro);
	            }
	        } else if (Biblioteca.opcao == 3) {
	            System.out.println("Digite o valor minimo: ");
	            var n = ler.nextDouble();
	            System.out.println("Digite o valor maximo: ");
	            var n1 = ler.nextDouble();
	            b.pesquisarFaixaDePreco(n, n1);
	        } else if (Biblioteca.opcao == 4) {
	            System.out.println(b.calcularTotalLivros());
	        }
	    }
	}
	
}