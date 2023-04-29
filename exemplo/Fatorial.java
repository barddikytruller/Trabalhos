package exemplo;

import java.util.Scanner;

public class Fatorial {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite um número:");
		var n = ler.nextInt();
		var fatorial = n;
		
		for (int i = 0; i < n; i++) {
			if (i==0) {
				continue;
			}
			
			fatorial = i * fatorial;
		} 
			
		System.out.printf("O fatorial de %d é %d", n, fatorial);
	}

}
