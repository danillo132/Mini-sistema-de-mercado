package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;

public class ArrayVetor {

	public static void main(String[] args) {

		// Array pode ser de todo tipo de dado e objeto

		// Array sempre deve ter a quantidade de posições definidas

		/*
		 * String posicoes = JOptionPane.showInputDialog(null,
		 * "quantas posições o array deve ter?: "); double[] notas = new
		 * double[Integer.parseInt(posicoes)];
		 * 
		 * 
		 * for(int j = 0; j < notas.length;j++) { String valor =
		 * JOptionPane.showInputDialog(null, "qual o valor da posição " + j + " ?: ");
		 * notas[j] = Double.valueOf(valor); }
		 * 
		 * 
		 * 
		 * for(int i = 0; i < notas.length;i++) { System.out.println("a nota " + (i + 1)
		 * + " é " +notas[i]); }
		 * 
		 * 
		 * System.out.println("Nome do aluno: " + aluno.getNome() + " Matriculado em: " + aluno.getDataMatricula());
		System.out.println("===========Disciplinas do aluno======== ");
		for (Disciplina d : aluno.getDisciplinas()) {
			
			
			System.out.println("disciplina: " + d.getDisciplina());
			System.out.println("notas da disciplina: " );
			
			double notaMaxima = 0.0;
			double notaMenor = 0.0;
			
			for(int pos = 0; pos < d.getNota().length; pos++) {
				System.out.println("nota " + (pos + 1) + " é igual a " + d.getNota()[pos]);
				
				if(pos == 0) {
					notaMaxima = d.getNota()[pos];
					}else if(d.getNota()[pos] > notaMaxima) {
						notaMaxima = d.getNota()[pos];
					}
				if(pos == 0) {
					notaMenor = d.getNota()[pos];
					}else if(d.getNota()[pos] < notaMenor) {
						notaMenor = d.getNota()[pos];
					}
				
			}
			
			System.out.println("a maior nota da disciplina " +d.getDisciplina()+ " é de valor: " +notaMaxima );
			System.out.println("a menor nota da disciplina " +d.getDisciplina()+ " é de valor: " +notaMenor);
			
		}

		 */
		
		
		
		
		//Criação do aluno
		Aluno aluno = new Aluno();
		aluno.setNome("Danillo");
		aluno.setDataMatricula("20/03/2021");
		
		//criação da disciplina
		Disciplina disciplina = new Disciplina();
		disciplina.setDisciplina("java");
		
		double[] notas = {8.8, 7.6, 6.8, 9.1};
		double[] notasLogica = {8.4, 9.6, 7.8, 8.6};
		
		disciplina.setNota(notas);
		
		aluno.getDisciplinas().add(disciplina);
		
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDisciplina("Lógica de programação");
		disciplina2.setNota(notasLogica);
		
		aluno.getDisciplinas().add(disciplina2);
		
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("José");
		aluno2.setDataMatricula("23/06/2021");
		
		//criação da disciplina
		Disciplina disciplina3 = new Disciplina();
		disciplina3.setDisciplina("java");
		
		double[] notas2 = {8.1, 9.2, 10.0, 7.1};
		double[] notasLogica2 = {8.2, 7.6, 6.9, 9.3};
		
		disciplina3.setNota(notas2);
		
		aluno2.getDisciplinas().add(disciplina3);
		
		Disciplina disciplina4 = new Disciplina();
		disciplina4.setDisciplina("Lógica de programação");
		disciplina4.setNota(notasLogica2);
		
		aluno2.getDisciplinas().add(disciplina4);
		//----------------------------------------------------------
		
		Aluno[] arrayAlunos = new Aluno[2];
		
		arrayAlunos[0] = aluno;
		arrayAlunos[1] = aluno2;
		
		for(int pos =0; pos < arrayAlunos.length;pos++) {
			System.out.println("O nome do aluno é: " + arrayAlunos[pos].getNome());
			
			for (Disciplina d : arrayAlunos[pos].getDisciplinas()) {
				System.out.println("Nome da disciplina é: " + d.getDisciplina());
				
				for(int posNota = 0; posNota < d.getNota().length;posNota++) {
					System.out.println("A nota número "+ (posNota+1) +  ": " + "é igual a " + d.getNota()[posNota]);
					
				}
				
			}
			System.out.println("==============================================");
		}
		
		
		
	}
}
