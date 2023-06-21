package br.com.senai.trabalho.main;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.senai.trabalho.classes.Dependente;
import br.com.senai.trabalho.classes.Funcionario;
import br.com.senai.trabalho.enums.Parentesco;
import br.com.senai.trabalho.exceptions.DependenteException;
import br.com.senai.trabalho.exceptions.FuncionarioException;

public class GerarPagamentos {

	public static void main(String[] args) throws Exception, DependenteException, FuncionarioException {

		String arquivoEntrada = JOptionPane.showInputDialog(null, "Digite o caminho do arquivo de entrada e seu nome:",
				"Arquivo de entrada", 1);

		String arquivoSaida = JOptionPane.showInputDialog(null,
				"Digite o caminho que você quer salvar o arquivo de saída e seu nome:", "Arquivo de saída", 1);

		List<Funcionario> funcionarios = lerArquivo(arquivoEntrada);

		for (Funcionario f : funcionarios) {

			f.INSS();
			f.IR();
		}

		exportarArquivo(funcionarios, arquivoSaida);
	}

	private static List<Funcionario> lerArquivo(String arquivo) throws Exception {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

		List<Funcionario> funcionarios = new ArrayList<>();

		Funcionario funcionario = null;

		Scanner sc = new Scanner(new InputStreamReader(new FileInputStream(arquivo), "UTF-8"));

		while (sc.hasNextLine()) {

			String linha = sc.nextLine();

			if (!linha.isEmpty()) {

				String[] dados = linha.split(";");

				if (funcionario != null) {

					String nomeDependente = dados[0];
					String cpfDependente = dados[1];
					LocalDate dataNascimentoDependente = LocalDate.parse(dados[2], formatter);
					String parentesco = dados[3];

					try {

						Dependente dependente = new Dependente(nomeDependente, cpfDependente, dataNascimentoDependente,
								Enum.valueOf(Parentesco.class, parentesco));

						funcionario.getDependentes().add(dependente);
					} catch (Exception e) {

						System.err.println(e.getMessage());
					}

					continue;
				}

				String nomeFuncionario = dados[0];
				String cpfFuncionario = dados[1];
				LocalDate dataNascimentoFuncionario = LocalDate.parse(dados[2], formatter);
				double salarioBrutoFuncionario = Double.parseDouble(dados[3]);

				funcionario = new Funcionario(nomeFuncionario, cpfFuncionario, dataNascimentoFuncionario,
						salarioBrutoFuncionario);
			} else {

				funcionarios.add(funcionario);
				funcionario = null;
			}
		}

		funcionarios.add(funcionario);
		sc.close();

		return funcionarios;
	}

	private static void exportarArquivo(List<Funcionario> funcionarios, String arquivo) {

		DecimalFormat df = new DecimalFormat("0.00");

		df.setRoundingMode(RoundingMode.HALF_UP);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {

			for (Funcionario funcionario : funcionarios) {

				bw.write(funcionario.getNome() + ";" + funcionario.getCpf() + ";" + df.format(funcionario.calculoINSS())
						+ ";" + df.format(funcionario.calculoIR()) + ";" + df.format(funcionario.salarioLiq()));
				bw.newLine();
			}
		} catch (Exception e) {

			System.err.println("Erro ao exportar o arquivo: " + e.getMessage());
		} finally {

			JOptionPane.showMessageDialog(null, "Arquivo exportado e salvo com sucesso em: " + "'" + arquivo + "'",
					"Arquivo de saída", 1);
		}
	}
}