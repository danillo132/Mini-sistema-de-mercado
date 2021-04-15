package cursojava.EscritaeLeituradeArquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EscrevendoTxt {

	public static void main(String[] args) throws IOException {

		Pessoa pessoa1 = new Pessoa();
		Pessoa pessoa2 = new Pessoa();
		Pessoa pessoa3 = new Pessoa();

		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setNome("Paulo");
		pessoa1.setIdade(23);

		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setNome("Ana");
		pessoa2.setIdade(34);

		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setNome("Marcos");
		pessoa3.setIdade(29);

		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);

		File arquivo = new File(
				"C:\\eclipse-workspace\\primeiro-programa\\src\\cursojava\\EscritaeLeituradeArquivos\\arquivo.csv");

		if (!arquivo.exists()) {
			arquivo.createNewFile();

		}

		FileWriter escrever_no_arquivo = new FileWriter(arquivo);



		for (Pessoa pessoa : pessoas) {

			escrever_no_arquivo.write("\n" + pessoa.getNome() + ";" + pessoa.getIdade() + ";" + pessoa.getEmail());
		}

		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();

	}

	public boolean validarLogin(String nome) {

		return true;

	}
}
