package trabalhos;

public class testarLivro {

	public static void main(String[] args) {
		Livro l0 = new Livro("Marco Antônio", "Cisco CCNA", 85.00);
		Livro l1 = new Livro("Kathy Sierra", "Use a Cabeça Java", 98.00);
		LivrariaOperacao op0 = new LivrariaOperacao("venda", l0);
		LivrariaOperacao op1 = new LivrariaOperacao("venda", l1);
		
		l0.reajuste(6);
		System.out.printf("%.2f\n", l0.getValor());
		op0.venderLivro();
		System.out.println(op0.toString() + "\n");
		op1.emprestarLivro();
		System.out.println(op1.toString());
	}

}
