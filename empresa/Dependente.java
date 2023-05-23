package empresa;

import java.time.LocalDate;

public class Dependente extends Pessoa {
	Parentesco parentesco;

	public Dependente(String nome, String cpf, LocalDate dataNascimento, Parentesco parentesco) {
		super(nome, cpf, dataNascimento);
		this.parentesco = parentesco;
	}

	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public LocalDate getNascimento() {
		return dataNascimento;
	}

	public Parentesco getParentesco() {
		return parentesco;
	}
	
	public String toString() {
		return nome + ";" + cpf + ";" + dataNascimento + ";" + parentesco;
	}

}