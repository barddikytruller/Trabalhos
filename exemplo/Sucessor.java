package exemplo;

import java.util.Scanner;

public class Sucessor {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite um número inteiro:");
		var n = ler.nextInt();
		System.out.printf("%d <-- %d --> %d", n-1, n, n+1);

	}

}
