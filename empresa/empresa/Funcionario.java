package empresa;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;


public class Funcionario extends Pessoa implements Empresa {
	private Double salarioBruto, INSS, IR, deducaoINSS, deducaoIR;
	private List<Dependente> dependentes = new ArrayList<>();
	private static List<Funcionario> funcionariosCadastrados = new ArrayList<>();
	private static Set<String> cpfsCadastrados = new HashSet<>();

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, Double salarioBruto, Dependente dependente) throws FuncionarioException {
		 super(nome, cpf, dataNascimento);
	        validarFuncionario();
	        this.salarioBruto = salarioBruto;
	        dependentes.add(dependente);
	        cpfsCadastrados.add(cpf);
	        INSS();
	        IR();
	        funcionariosCadastrados.add(this);
	    }
		
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		return nome + ";" + cpf + ";" + dataNascimento.format(formatter) + ";" + salarioBruto;
	}

	public Double getSalarioBruto() {
		return salarioBruto;
	}
	
	public List<Dependente> getDependentes() {
		return this.dependentes;
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
	
	private Boolean INSS() {
        if (salarioBruto <= Valores.inssTETO1.getValor()) {
            INSS = Valores.inssALIQUOTA1.getValor();
            deducaoINSS = Valores.inssDEDUCAO1.getValor();
            return false;
        } else if (salarioBruto  >= Valores.inssTETO1.getValor() + 0.01 && salarioBruto <= Valores.inssTETO2.getValor()) {
            INSS = Valores.inssALIQUOTA2.getValor();
            deducaoINSS = Valores.inssDEDUCAO2.getValor();
            return false;
        } else if (salarioBruto >= Valores.inssTETO2.getValor() + 0.01 && salarioBruto <= Valores.inssTETO3.getValor()) {
            INSS = Valores.inssALIQUOTA3.getValor();
            deducaoINSS = Valores.inssDEDUCAO3.getValor();
            return false;
        } else if (salarioBruto >= Valores.inssTETO3.getValor() + 0.01 && salarioBruto <= Valores.inssTETO4.getValor()){
            INSS = Valores.inssALIQUOTA4.getValor();
            deducaoINSS = Valores.inssDEDUCAO4.getValor();
            return false;
        } else {
            return true;       //Obs.: Salário acima de R$ 7507,49 deve ser aplicado o valor de 14% sobre R$ 7507,49
       }
    }
	
	private void IR() {
		var c = (salarioBruto - (salarioBruto * INSS)) - descontoDependentes();
	    if ( c <= Valores.irTETO1.getValor()) {
	        IR = Valores.irALIQUOTA1.getValor(); 
	        deducaoIR = Valores.irDEDUCAO1.getValor(); 
	    } else if (c > Valores.irTETO1.getValor() && c <= Valores.irTETO2.getValor()) {
	        IR = Valores.irALIQUOTA2.getValor();
	        deducaoIR = Valores.irDEDUCAO2.getValor();
	    } else if (c > Valores.irTETO2.getValor() && c <= Valores.irTETO3.getValor()) {
	        IR = Valores.irALIQUOTA3.getValor();
	        deducaoIR = Valores.irDEDUCAO3.getValor();
	    } else if (c > Valores.irTETO3.getValor() && c <= Valores.irTETO4.getValor()) {
	        IR = Valores.irALIQUOTA4.getValor();
	        deducaoIR = Valores.irDEDUCAO4.getValor();
	    } else {
	        IR = Valores.irALIQUOTA5.getValor();
	        deducaoIR = Valores.irDEDUCAO5.getValor();
	    }    
	
	}
	
	public Double descontoDependentes() {
		return dependentes.size() * 189.59;
	}

	@Override
	public Double calculoINSS() {
		
		if (INSS()) {
			return Valores.inssTETO4.getValor() * INSS - deducaoINSS;
		}
		return salarioBruto * INSS - deducaoINSS;
	}

	@Override
	public Double calculoIR() {
		return ((salarioBruto - (calculoINSS() + descontoDependentes())) * IR) - deducaoIR;
	}
	
	private void validarFuncionario() throws FuncionarioException {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        int idade = periodo.getYears();
        if (idade < 18) {
            throw new FuncionarioException("O funcionário não pode ter menos de 18 anos.");
        }
        if (cpfsCadastrados.contains(cpf)) {
        	throw new FuncionarioException("O cpf já foi utilizado.");
        }
    }
	

}


