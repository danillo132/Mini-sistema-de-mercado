package cursojava.executavel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitArray {

	public static void main(String[] args) {
		
		String texto = "danillo, curso java, 80,  70, 90, 89";
		
		String[] valores = texto.split(",");
		
		System.out.println("nome do aluno: " + valores[0]);
		System.out.println("curso do aluno: " + valores[1]);
		System.out.println("nota 1 do aluno: " + valores[2]);
		System.out.println("nota 2 do aluno: " + valores[3]);
		System.out.println("nota 3 do aluno: " + valores[4]);
		System.out.println("nota 4 do aluno: " + valores[5]);
		
		
		/* Convertendo array em lista*/
		
		List<String> list = Arrays.asList(valores);
		
		for (String valorString : list) {
			System.out.println(valorString);
			
			
			
			//Convertendo uma lista em array
			
			String[] conversaoArray = list.toArray(new String[6]);
			
			for(int i = 0; i  < conversaoArray.length;i++) {
				System.out.println(conversaoArray[i]);
			}
			
		}
	}
}
