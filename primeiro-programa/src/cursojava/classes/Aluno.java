package cursojava.classes;

import java.util.ArrayList;
import java.util.List;

import cursojava.constantes.StatusAluno;

/* Esta é a classe/objeto que representa o aluno*/

public class Aluno extends Pessoa{

	
	private String dataMatricula;
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public Aluno() {
		// Metodo construtor: cria os dados na memoria -sendo padrão do java
		
		
	}
	
	
	/*Métodos SETTERS E GETTERS:
	//SETTERS é para adicionar ou receber dados para os atributos
	 *Getters é para resgatar ou obter o valor do atributo
	*/
	
	//recebe dados
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getRegistroGeral() {
		return registroGeral;
	}


	public void setRegistroGeral(String registroGeral) {
		this.registroGeral = registroGeral;
	}


	public String getNumeroCpf() {
		return numeroCpf;
	}


	public void setNumeroCpf(String numeroCpf) {
		this.numeroCpf = numeroCpf;
	}


	public String getDataMatricula() {
		return dataMatricula;
	}


	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}


	
	
	/*metodo que retorna a media do aluno */
	
     public double getMediaNota(){
    	 
    	 double somaNotas = 0.0;
    	 
    	 for (Disciplina disciplina : disciplinas) {
			somaNotas += disciplina.getMediaNotas();
		}
    	 return somaNotas / disciplinas.size();
    	
    	 
     }
     
     public boolean getAlunoAprovado() {
    	 double media = this.getMediaNota();
    	 if(media >=70) {
    		 return true;
    	 } else {
    		 return false;
    	 }
     }
     
     public String getAlunoaprovado2() {
    	 double media = this.getMediaNota();
    	 if(media >=50) {
    		 if(media >= 70) {
    			 return StatusAluno.APROVADO;
    		 }else {
    		   return StatusAluno.RECUPERACAO;
    		 }
    		 } else {
    		 return StatusAluno.REPROVADO;
    	 }
     }
    	 

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", registroGeral="
				+ registroGeral + ", numeroCpf=" + numeroCpf + ", dataMatricula=" + dataMatricula +"]";
	}
     
     


	


	





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroCpf == null) ? 0 : numeroCpf.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroCpf == null) {
			if (other.numeroCpf != null)
				return false;
		} else if (!numeroCpf.equals(other.numeroCpf))
			return false;
		return true;
	}
	


	@Override //identifica metodo sobreescrito
	public boolean pessoaMaiorIdade() {
		// TODO Auto-generated method stub
		return idade >=21;
	}
	
	public String msgMaiorIdade() {
		return this.pessoaMaiorIdade() ? "oba, o aluno é maior de idade" : "ixi, o aluno é menor de idade";
	}

	@Override
	public double salario() {
		// TODO Auto-generated method stub
		return 800.91;
	}

	
     
	
	
}

