package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Pessoa;
import cursojava.classes.Secretario;

public class TestandoClassesFilhas {

	public static void main(String[] args) {

		Aluno aluno = new Aluno();
		aluno.setNome("danillo Santiago");
		aluno.setIdade(18);

		Diretor diretor = new Diretor();
		diretor.setRegistroGeral("67584932");
		diretor.setNome("jo�o");
		diretor.setIdade(50);

		Secretario secretario = new Secretario();
		secretario.setExperiencia("Administra��o");
		secretario.setNumeroCpf("854373842");
		secretario.setIdade(32);
		secretario.setNome("Roberto");

		System.out.println(aluno);
		System.out.println(diretor);
		System.out.println(secretario);

		System.out.println(aluno.pessoaMaiorIdade() + " - " + aluno.msgMaiorIdade());
		System.out.println(diretor.pessoaMaiorIdade());
		System.out.println(secretario.pessoaMaiorIdade());

		System.out.println("sal�rio do aluno �: " + aluno.salario());
		System.out.println("sal�rio do diretor �: " + diretor.salario());
		System.out.println("sal�rio do secret�rio �: " + secretario.salario());

		teste(aluno);
		teste(diretor);
		teste(secretario);

	}
		
	public static void teste(Pessoa pessoa) {
		System.out.println("essa pessoa � demais: " + pessoa.getNome() + " e o sal�rio � de: " + pessoa.salario());
	}

}
