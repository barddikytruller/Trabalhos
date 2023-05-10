package trabalhos;

public class testarAtleta {

	public static void main(String[] args) {
		Pais eua = new Pais("Eua");
		Pais brasil = new Pais("Brasil");
		
		Atleta a1 = new Atleta("Anderson Silva", 98, brasil);
		Atleta a2 = new Atleta("Jon Jone", 59, eua);
		Atleta a3 = new Atleta("Vitor Belfort", 110, brasil);
		
		Atleta[] lista = {a1, a2, a3};
		
		for (int i = 0; i < 3; i++) {
			System.out.printf("O participante %s %s \n", lista[i].getNome(), lista[i].verificaSituacao());
		}
		
		System.out.println("O total de participantes é: " + Atleta.getTotalParticipantes());

	}

}
