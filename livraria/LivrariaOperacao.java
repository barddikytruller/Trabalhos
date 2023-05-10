package trabalhos;

public class LivrariaOperacao implements Livraria {
	final String tipo;
	private double valorOperacao;
	private Livro livro;
	
	public LivrariaOperacao(String tipo, Livro livro) {
		this.tipo = tipo;
		this.livro = livro;
	}

	@Override
	public String toString() {
		return "LivrariaOperacao [tipo=" + tipo + ", valorOperacao=" + valorOperacao + ", livro=" + livro + "]";
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public double getValorOperacao() {
		return valorOperacao;
	}

	@Override
	public void emprestarLivro() {
		valorOperacao = livro.getValor() * 0.02 + Livraria.taxaEmprestimo;
	}

	@Override
	public void venderLivro() {	
		valorOperacao = livro.getValor() + livro.getValor() * 0.09;
		
	}
	
	
}
