package trabalhos;

public class Atleta implements Olimpiadas {
	private String nome;
	private double peso;
	private String modalidade;
	private Pais pais;
	static private int totalParticipantes;
	
	public Atleta(String nome, double peso, Pais pais) {
		this.nome = nome;
		this.peso = peso;
		this.pais = pais;
		totalParticipantes++;
	}

	@Override
	public String toString() {
		return "Atleta [nome=" + nome + ", peso=" + peso + ", modalidade=" + modalidade + ", pais=" + pais.getNome() + "]";
	}

	@Override
	public String verificaSituacao() {
		if (peso > 90) {
			modalidade = "Peso Pesado";
			return "participará";
		}
		
		if (peso >= 60 && peso <= 90) {
			modalidade = "Peso médio";
			return "participará";
		}
		
		else {
			return "Não participará";
		}
	}

	public String getNome() {
		return nome;
	}

	public double getPeso() {
		return peso;
	}

	public String getModalidade() {
		return modalidade;
	}
	
	public void setModalidade(String modalidade) { // This method should not exist
		this.modalidade = modalidade;
	}

	public Pais getPais() {
		return pais;
	}

	public static int getTotalParticipantes() {
		return totalParticipantes;
	}
	
	
}
