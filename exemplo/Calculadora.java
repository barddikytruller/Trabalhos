package exemplo;

import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite um número: ");
		var n = ler.nextInt();
		for (int i = 0; i < 11; i++) {
			System.out.printf("%d x %d = %d \n", i, n, i * n);
		}
	}

}
