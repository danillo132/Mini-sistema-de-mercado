package cursojava.executavel;

public class PrimeiraClasseJava {

	public static void main(String[] args) {
		/*
		 * 
		 * //double e int double nota1 = 90; double nota2 = 70; double nota3 = 50;
		 * double nota4 = 88; double media = (nota1 + nota2 + nota3 + nota4) /4;
		 * 
		 * 
		 * System.out.println("médias das notas: " + media);
		 * 
		 * 
		 * //char char pessoaFisica = 'F'; char pessoaJuridica = 'J';
		 * 
		 * //String:
		 * 
		 * String nome = "Danillo"; String sobrenome = "Santiago";
		 * 
		 * 
		 * System.out.println("meu nome completo é: " + nome + " " + sobrenome);
		 * 
		 * int mediaAluno = 75;
		 * 
		 * String nome = "Fabio";
		 * 
		 * if (mediaAluno >= 70 && nome.equals("Danillo")) {
		 * System.out.println("você foi aprovado!"); } else if (mediaAluno < 70) {
		 * System.out.println(" voce foi reprovado"); } else {
		 * System.out.println("aluno nao encontrado"); } // operadores ternários para
		 * micro-validações int mediaAluno1 = 75;
		 * 
		 * String SaidaResultado = mediaAluno1 >= 70 ? "aluno aprovado" :
		 * "aluno reprovado"; System.out.println(SaidaResultado);
		 * 
		 * 
		 * // operações lógicas aninhadas : são operações dentro de operações int media
		 * = 95;
		 * 
		 * if (media >= 50) { if (media >= 70) { if (media > 90) {
		 * System.out.println("parabéns você foi aprovado"); } else {
		 * System.out.println("voce foi aprovado"); } } else {
		 * System.out.println("aluno em recuperação"); } } else {
		 * System.out.println("aluno reprovado!"); }
		 * 
		 * 
		 * // estrutura de repetição while ( verifica e depois executa) int numero = 1;
		 * int n = 1;
		 * 
		 * 
		 * while(numero <20) { while(n <= 10) { System.out.println("tabuada do " +
		 * numero + " = " + numero + " x " + n + " = " + numero * n); n++;
		 * 
		 * } numero++; n = 1; }
		 * 
		 * 
		 * //estrutura de repetição do/while (executa e depois verifica) int n = 1; do {
		 * System.out.println("o numero atual é: " + n); n++; }while(n <=10);
		 * 
		 * 
		 * // estrutura de repetição for:
		 * 
		 * for(int number = 1;number<=10;number++) {
		 * System.out.println("o numero atual é: " + number); }
		 * 
		 * // estrutura de repetição for com break:
		 * 
		 * for(int number = 1;number<=10;number++) { if(number == 7) {
		 * System.out.println("encontrei o numero 7"); break; } } //estrutura for com
		 * continue
		 * 
		 * 
		 * for(int number = 1;number<=10;number++) { if(number == 7 || number == 8) {
		 * System.out.println("encontrei o numero: " + number); continue; }
		 * 
		 * }
		 * 
		 */
		
		// módulo: resto da divisao %
		
		
		 double carro = 9;
		 double pessoa = 2;
		 
		 double resto = carro % pessoa;
		 
		 System.out.println("sobraram exatamente: "+ resto + "carros");

		
	}
}