package cursojava.EscritaeLeituradeArquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class LendoArquivoTxt {

	public static void main(String[] args) throws FileNotFoundException {
		
		FileInputStream entradaDeDados = new FileInputStream( new File("C:\\eclipse-workspace\\primeiro-programa\\src\\cursojava\\EscritaeLeituradeArquivos\\arquivo.csv"));
	
	
		Scanner lerArquivos = new Scanner(entradaDeDados, "UTF-8");
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while(lerArquivos.hasNext()) {
			String linha = lerArquivos.nextLine();
			
			if( linha != null && !linha.isEmpty()) {
			
				String[] dados = linha.split("\\;");
				Pessoa  pessoa = new Pessoa();
				
				
				pessoa.setNome(dados[0]);
				pessoa.setIdade(Integer.valueOf(dados[1]));
				pessoa.setEmail(dados[2]);
				
				
				pessoas.add(pessoa);
			}
			
		}
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
		
	
	}
}
