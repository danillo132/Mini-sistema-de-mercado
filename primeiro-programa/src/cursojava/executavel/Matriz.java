package cursojava.executavel;

public class Matriz {

	public static void main(String[] args) {
		
		int notas[][] = new int[2][3];
		
		notas[0][0] = 80;
		notas[0][1] = 160;
		notas[0][2] = 320;
		notas[1][0] = 640;
		notas[1][1] = 1280;
		notas[1][2] = 3560;
		
		for(int i = 0; i < notas.length;i++) {
			System.out.println("=======================");
			for(int j = 0; j < notas[i].length;j++) {
			System.out.println("os valores do indice " + (i +1) + " da matriz são: "+ notas[i][j] );
		}

	}

	}
}
