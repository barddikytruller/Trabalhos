package exemplo;

import java.util.Scanner;

public class Pessoa {
	String nome;
	double peso;
	double altura;
	
	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		
		Pessoa a = new Pessoa();
		Pessoa b = new Pessoa();
		Pessoa c = new Pessoa();
		Pessoa d = new Pessoa();
		Pessoa[] dados = {a, b, c, d};
		
		String maior_peso = "z�";
		String maior_altura = "z�";
		double mp = 0;
		double ma = 0;
		
		for (int i = 0; i < 4; i++) {
			
			System.out.println("Nome:");
			dados[i].nome = ler.next();
			System.out.println("Peso:");
			dados[i].peso = ler.nextDouble();
			System.out.println("Altura");
			dados[i].altura = ler.nextDouble();
	
			if (dados[i].peso > mp) {
				maior_peso = dados[i].nome;
				mp = dados[i].peso;
			}
			
			if (dados[i].altura > ma) {
				maior_altura = dados[i].nome;
				ma = dados[i].altura;
			}
		}
		System.out.printf("%s tem o maior peso.\n", maior_peso);
		System.out.printf("%s tem a maior altura.\n", maior_altura);
		System.out.printf("A m�dia dos pesos � %.2f \n", a.peso+b.peso+c.peso+d.peso/4);
		System.out.printf("A m�dia das alturas � %.2f", a.altura+b.altura+c.altura+d.altura/4);
	}
}


