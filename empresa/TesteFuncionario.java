package empresa;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class TesteFuncionario {

	public static void main(String[] args) {
		Dependente dependente01 = new Dependente("Artur", "00345693475", LocalDate.of(2004, 7, 13), Parentesco.FILHO);
		Dependente dependente02 = new Dependente("Caio", "49687012346", LocalDate.of(2010, 2, 19), Parentesco.FILHO);
		
		List<Dependente> dependentes = new ArrayList<>();
		
		dependentes.add(dependente01);
		dependentes.add(dependente02);
		
		try {
			Funcionario funcionario = new Funcionario("Victor Santana", "78965734568", LocalDate.of(1985, 8, 2), 6000.00, dependentes);
			funcionario.listaDependentes();
			System.out.println(funcionario.calculoINSS());
			System.out.println(funcionario.calculoIR());
			System.out.println(funcionario.descontoDependentes());
			System.out.println(funcionario.salarioLiq());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
