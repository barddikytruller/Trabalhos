package br.com.senai.trabalho.classes;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.senai.trabalho.enums.Valores;
import br.com.senai.trabalho.exceptions.FuncionarioException;
import br.com.senai.trabalho.interfaces.Empresa;

public class Funcionario extends Pessoa implements Empresa {

	private Double salarioBruto, INSS, IR = Valores.irALIQUOTA1.getValor(), deducaoINSS,
			deducaoIR = Valores.irDEDUCAO1.getValor();

	private List<Dependente> dependentes = new ArrayList<>();

	private static List<Funcionario> funcionariosCadastrados = new ArrayList<>();

	private static Set<String> cpfsCadastrados = new HashSet<>();

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, Double salarioBruto)
			throws FuncionarioException {

		super(nome, cpf, dataNascimento);

		validarFuncionario();

		this.salarioBruto = salarioBruto;

		cpfsCadastrados.add(cpf);

		funcionariosCadastrados.add(this);
	}

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, Double salarioBruto, Dependente dependente)
			throws FuncionarioException {

		super(nome, cpf, dataNascimento);

		validarFuncionario();

		this.salarioBruto = salarioBruto;

		dependentes.add(dependente);

		cpfsCadastrados.add(cpf);

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

		return salarioBruto - calculoINSS() - calculoIR();
	}

	public void INSS() {

		if (salarioBruto <= Valores.inssTETO1.getValor()) {

			INSS = Valores.inssALIQUOTA1.getValor();
			deducaoINSS = Valores.inssDEDUCAO1.getValor();
		} else if (salarioBruto >= Valores.inssTETO1.getValor() + 0.01
				&& salarioBruto <= Valores.inssTETO2.getValor()) {

			INSS = Valores.inssALIQUOTA2.getValor();
			deducaoINSS = Valores.inssDEDUCAO2.getValor();
		} else if (salarioBruto >= Valores.inssTETO2.getValor() + 0.01
				&& salarioBruto <= Valores.inssTETO3.getValor()) {

			INSS = Valores.inssALIQUOTA3.getValor();
			deducaoINSS = Valores.inssDEDUCAO3.getValor();
		} else if (salarioBruto >= Valores.inssTETO3.getValor() + 0.01
				&& salarioBruto <= Valores.inssTETO4.getValor()) {

			INSS = Valores.inssALIQUOTA4.getValor();
			deducaoINSS = Valores.inssDEDUCAO4.getValor();
		} else {

			INSS = Valores.inssALIQUOTA5.getValor();
			deducaoINSS = Valores.inssDEDUCAO5.getValor();
		}
	}

	public void IR() {

		Double c = (salarioBruto - calculoINSS()) - descontoDependentes();

		if (c <= Valores.irTETO1.getValor()) {

			IR = Valores.irALIQUOTA1.getValor();
			deducaoIR = Valores.irDEDUCAO1.getValor();
		} else if (c >= Valores.irTETO1.getValor() + 0.01 && c <= Valores.irTETO2.getValor()) {

			IR = Valores.irALIQUOTA2.getValor();
			deducaoIR = Valores.irDEDUCAO2.getValor();
		} else if (c >= Valores.irTETO2.getValor() + 0.01 && c <= Valores.irTETO3.getValor()) {

			IR = Valores.irALIQUOTA3.getValor();
			deducaoIR = Valores.irDEDUCAO3.getValor();
		} else if (c >= Valores.irTETO3.getValor() + 0.01 && c <= Valores.irTETO4.getValor()) {

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

		if (salarioBruto > Valores.inssTETO4.getValor()) {

			return (Valores.inssTETO4.getValor() * Valores.inssALIQUOTA5.getValor()) - deducaoINSS;
		} else {

			return (salarioBruto * INSS) - deducaoINSS;
		}
	}

	@Override
	public Double calculoIR() {

		Double teste = salarioBruto - calculoINSS() - descontoDependentes();

		return (teste * IR) - deducaoIR;
	}

	private void validarFuncionario() throws FuncionarioException {

		LocalDate dataAtual = LocalDate.now();

		Period periodo = Period.between(dataNascimento, dataAtual);

		int idade = periodo.getYears();

		if (idade < 18) {

			throw new FuncionarioException("O funcionário não pode ter menos de 18 anos.");
		}

		if (cpf.length() != 11) {

			throw new FuncionarioException("CPF deve ter 11 dígitos.");
		}

		if (cpf.matches(".*[a-zA-Z].*")) {

			throw new FuncionarioException("O CPF não pode conter letras.");
		}
	}
}