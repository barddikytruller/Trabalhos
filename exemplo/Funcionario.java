package exemplo;

import javax.swing.JOptionPane;

public class Funcionario {
	String nome;
	String telefone;
	String email;
	String salario;

	public static void main(String[] args) {
		Funcionario a = new Funcionario();
		a.nome = JOptionPane.showInputDialog("Digite o nome:\n");
		a.telefone = JOptionPane.showInputDialog("Digite o telefone:\n");
		a.email = JOptionPane.showInputDialog("Digite o email:\n");
		a.salario = JOptionPane.showInputDialog("Digite o salario:\n");
		Float n = Float.parseFloat(a.salario);
		JOptionPane.showMessageDialog(null, a.nome + "\n" + a.telefone + "\n" + a.email + "\n" + a.salario);
		var salario = (n * 0.10) + n;
		JOptionPane.showMessageDialog(null, "Novo salário:\n" + salario);
	}

}
