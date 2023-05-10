package trabalhos;

public class Livro {
	final String autor;
	final String titulo;
	private double valor;
	
	Livro(String autor, String titulo, double  valor) {
		this.autor = autor;
		this.titulo = titulo;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Livro [autor=" + autor + ", titulo=" + titulo + ", valor=" + valor + "]";
	}

	public String getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public double getValor() {
		return valor;
	}

	public void reajuste(double valorReajuste) {
		valor = valor * (valorReajuste/100) + valor;
	}
}
