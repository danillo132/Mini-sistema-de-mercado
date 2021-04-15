package cursojava.executavel;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Disciplina;
import cursojava.classesauxiliares.FuncaoAutenticacao;
import cursojava.constantes.StatusAluno;
import cursojava.excecao.ExcecaoProcessarNota;
import cursojava.interfaces.PermitirAcesso;

public class EntradadeDados {

	public static void main(String[] args) throws ExcecaoProcessarNota {

		/*
		 * String carros =
		 * JOptionPane.showInputDialog("Informe a quantidade de carros: "); String
		 * pessoas = JOptionPane.showInputDialog("Informe a quantidade de pessoas: ");
		 * 
		 * double carrosNumero = Double.parseDouble(carros); double pessoasNumero =
		 * Double.parseDouble(pessoas);
		 * 
		 * int divisao = (int) (carrosNumero / pessoasNumero);
		 * 
		 * double resto = carrosNumero % pessoasNumero;
		 * 
		 * int resposta = JOptionPane.showConfirmDialog(null,
		 * "Deseja ver o resultado da divisão?: ");
		 * 
		 * if(resposta == 0) { JOptionPane.showMessageDialog(null,
		 * "divisao para pessoas deu: " + divisao); }
		 * 
		 * resposta = JOptionPane.showConfirmDialog(null,
		 * "Deseja ver o resto da divisão?: ");
		 * 
		 * if(resposta == 0) {
		 * 
		 * JOptionPane.showMessageDialog(null, " O resto da divisão é: " + resto +
		 * " carros" ); }else { JOptionPane.showMessageDialog(null,
		 * "Saindo do programa.."); }
		 * 
		 * 
		 * int resposta = JOptionPane.showConfirmDialog(null,
		 * "Deseja calcular a média?: "); do { String nota1 =
		 * JOptionPane.showInputDialog("informe a primeira nota: "); String nota2 =
		 * JOptionPane.showInputDialog("informe a segunda nota: "); String nota3 =
		 * JOptionPane.showInputDialog("informe a terceira nota: "); String nota4 =
		 * JOptionPane.showInputDialog("informe a quarta nota: ");
		 * 
		 * double primeiraNota = Double.parseDouble(nota1); double segundaNota =
		 * Double.parseDouble(nota2); double terceiraNota = Double.parseDouble(nota3);
		 * double quartaNota = Double.parseDouble(nota4);
		 * 
		 * double media = (primeiraNota + segundaNota + terceiraNota + quartaNota) /4;
		 * 
		 * 
		 * 
		 * if(media >= 70) { JOptionPane.showMessageDialog(null,
		 * "A média do aluno(a) foi: " + media + " e foi aprovado!!"); resposta =
		 * JOptionPane.showConfirmDialog(null, "Deseja calcular outra média?: "); }else
		 * if(media >= 40) { JOptionPane.showMessageDialog(null,
		 * "A média do aluno(a) foi: " + media + " e está em recuperação!!"); resposta =
		 * JOptionPane.showConfirmDialog(null, "Deseja calcular outra média?: "); }else
		 * { JOptionPane.showMessageDialog(null, "A média do aluno(a) foi: " + media +
		 * " e foi reprovado!!"); resposta = JOptionPane.showConfirmDialog(null,
		 * "Deseja calcular outra média?: "); }
		 * 
		 * 
		 * }while(resposta == 0);
		 */

		// JOptionPane.showMessageDialog(null, "o nome do aluno é: " + aluno1.getNome()
		// + "\n sua média é: " + aluno1.getMediaNota());

		/*
		 * System.out.println("o nome do aluno é: " + aluno1.getNome());
		 * System.out.println("a idade do aluno é: " + aluno1.getIdade());
		 * System.out.println("a data da matricula do aluno é: " +
		 * aluno1.getDataMatricula());
		 * System.out.println("a data de nascimento do aluno é: " +
		 * aluno1.getDataNascimento());
		 * System.out.println("o numero de cpf do aluno é: " + aluno1.getNumeroCpf());
		 * System.out.println("o RG do aluno é: " + aluno1.getRegistroGeral());
		 * System.out.println("a media da nota é:" + aluno1.getMediaNota());
		 * System.out.println("resultado = " + (aluno1.getAlunoAprovado() ? "aprovado" :
		 * "reprovado"));
		 */

		// ===================aluno 1==============================

		try {
			String login = JOptionPane.showInputDialog("informe o login: ");
			String senha = JOptionPane.showInputDialog("informe a senha: ");

			LerArquivo();

			PermitirAcesso permitirAcesso = new Diretor(login, senha);

			if (new FuncaoAutenticacao(permitirAcesso).autenticar()) // travar o contrato para autorizar somente quem
																		// realmente tem o contrato 100% legitimo
			{

				List<Aluno> alunos = new ArrayList<Aluno>();

				HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

				for (int qtd = 1; qtd <= 2; qtd++) {

					String nome = JOptionPane.showInputDialog("qual o nome do aluno " + qtd + " ?: ");


					String idade = JOptionPane.showInputDialog("qual a idade do aluno?: ");
					/*
					 * String dataMatricula =
					 * JOptionPane.showInputDialog("qual a data da matrícula do aluno?: "); String
					 * numeroCpf = JOptionPane.showInputDialog("qual o número de cpf do aluno?: ");
					 * String registroGeral = JOptionPane.showInputDialog("qual o RG do aluno?: ");
					 * String dataNascimento =
					 * JOptionPane.showInputDialog("qual a data de nascimento do aluno?: ");
					 */

					Aluno aluno1 = new Aluno();
					aluno1.setNome(nome);
					aluno1.setIdade(Integer.valueOf(idade));
					/*
					 * aluno1.setDataMatricula(dataMatricula); aluno1.setNumeroCpf(numeroCpf);
					 * aluno1.setRegistroGeral(registroGeral);
					 * aluno1.setDataNascimento(dataNascimento);
					 */

					for (int pos = 1; pos <= 4; pos++) {
						String nomeDisciplina = JOptionPane.showInputDialog("nome da disciplina " + pos + ": ");
						String notaDisciplina = JOptionPane.showInputDialog("nota da disciplina " + pos + ": ");

						Disciplina disciplina = new Disciplina();
						disciplina.setDisciplina(nomeDisciplina);
						//disciplina.setNota(Double.valueOf(notaDisciplina));

						aluno1.getDisciplinas().add(disciplina);

					}

					int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");

					if (escolha == 0) {

						int continuarRemover = 0;
						int posicao = 1;
						while (continuarRemover == 0 && posicao <= 4) {
							String disciplinaRemover = JOptionPane.showInputDialog("qual a disciplina1,2,3 ou 4?: ");
							aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
							posicao++;
							continuarRemover = JOptionPane.showConfirmDialog(null, "continuar a remover?");

						}

					}

					alunos.add(aluno1);

				}
				
				

				maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
				maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
				maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());

				for (Aluno aluno : alunos) {

					if (aluno.getAlunoaprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {

						maps.get(StatusAluno.APROVADO).add(aluno);

					} else if (aluno.getAlunoaprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {

						maps.get(StatusAluno.RECUPERACAO).add(aluno);

					} else {
						maps.get(StatusAluno.REPROVADO).add(aluno);
					}
				}

				System.out.println("========lista dos aprovados===========");
				for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
					System.out.println(
							"Resultado: " + aluno.getAlunoaprovado2() + " com média de " + aluno.getMediaNota());

				}

				System.out.println("========lista dos alunos em recuperação===========");
				for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
					System.out.println(
							"Resultado: " + aluno.getAlunoaprovado2() + " com média de " + aluno.getMediaNota());

				}
				System.out.println("========lista dos reprovados===========");
				for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
					System.out.println(
							"Resultado: " + aluno.getAlunoaprovado2() + " com média de " + aluno.getMediaNota());

				}

			} else {
				JOptionPane.showMessageDialog(null, "Login ou senha incorretos!!");
			}
		} catch (Exception e) {

			StringBuilder saida = new StringBuilder();
			e.printStackTrace(); // imprime o erro no console java

			// Mensagem de erro ou causa
			System.out.println("Mensagem: " + e.getMessage());

			for (int i = 0; i < e.getStackTrace().length; i++) {
				saida.append("\n classe de erro: " + e.getStackTrace()[i].getClassName());
				saida.append("\n método de erro: " + e.getStackTrace()[i].getMethodName());
				saida.append("\n linha de erro: " + e.getStackTrace()[i].getLineNumber());
				saida.append("\n classe de exceção: " + e.getClass().getName());
			}

			JOptionPane.showMessageDialog(null, "Erro inesperado: " + saida.toString());

		} finally /*
					 * SEMPRE É EXECUTADO OCORRENDO ERRO OU NÃO! Porque o finally sempre é usado
					 * quando precisa executar um processo acontecendo erro ou nao
					 */
		{
			JOptionPane.showMessageDialog(null, "obrigado por aprender java");
		}
	}

	public static void LerArquivo() throws FileNotFoundException {

		/*File fil = new File("c://arquivo.txt");
		Scanner scanner = new Scanner(fil);*/
	}
}
