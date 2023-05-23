package empresa;

import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Funcionario extends Pessoa implements Empresa {
	private Double salarioBruto, INSS, IR, deducaoINSS, deducaoIR;
	private List<Dependente> dependentes = new ArrayList<>();
	private static List<Funcionario> funcionariosCadastrados = new ArrayList<>();
	private static Set<String> cpfsCadastrados = new HashSet<>();

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, Double salarioBruto, List<Dependente> dependentes) throws Exception {
		super(nome, cpf, dataNascimento);
		
		if (cpfsCadastrados.contains(cpf)) {
			throw new Exception("Esse cpf já existe"); //Faz um funcionarioException aí
		}
		
		this.salarioBruto = salarioBruto;
		this.dependentes = dependentes;
		cpfsCadastrados.add(cpf);
		INSS();
		IR();
		funcionariosCadastrados.add(this);
}
		
	@Override
	public String toString() {
		return "Funcionario - Salario Bruto: " + salarioBruto + " | " + "CPF: " + cpf + " | "
				+ "Nome:" + nome;
	}

	public Double getSalarioBruto() {
		return salarioBruto;
	}

	
	public Double salarioLiq() {
		
		return salarioBruto - calculoINSS() - calculoIR() - descontoDependentes();
	}
	

	@Override
	public String listaFuncionarios() {
		
		return "...";
	}

	@Override
	public void listaDependentes() {
		
		for (Dependente d : dependentes) {
			System.out.println(d.toString());
		}
		
	}
	
	private void INSS() {
	    if (salarioBruto <= 1320.00) {
	        INSS = 0.075;
	        deducaoINSS = 0.0;
	    } else if (salarioBruto > 1320.00 && salarioBruto < 2571.29) {
	        INSS = 0.09;
	        deducaoINSS = 19.80;
	    } else if (salarioBruto >= 2571.29 && salarioBruto < 3856.90) {
	        INSS = 0.12;
	        deducaoINSS = 96.94;
	    } else {
	        INSS = 0.14;
	        deducaoINSS = 174.08;
	    }
	}
	
	private void IR() {
		var c = (salarioBruto - (salarioBruto * INSS)) - descontoDependentes();
	    if ( c <= 2112.00) {
	        IR = 0.0; 
	        deducaoIR = 0.0; 
	    } else if (c > 2112.00 && c <= 2826.65) {
	        IR = 0.075;
	        deducaoIR = 158.40;
	    } else if (c > 2826.65 && c <= 3751.05) {
	        IR = 0.15;
	        deducaoIR = 370.40;
	    } else if (c > 3751.05 && c <= 4664.68) {
	        IR = 0.225;
	        deducaoIR = 651.73;
	    } else {
	        IR = 0.275;
	        deducaoIR = 884.96;
	    }    
	
	}
	
	public Double descontoDependentes() {
		return dependentes.size() * 189.59;
	}

	@Override
	public Double calculoINSS() {
		return salarioBruto * INSS + deducaoINSS;
	}

	@Override
	public Double calculoIR() {
		return ((salarioBruto - (calculoINSS() + descontoDependentes())) * IR) + deducaoIR;
	}

}


