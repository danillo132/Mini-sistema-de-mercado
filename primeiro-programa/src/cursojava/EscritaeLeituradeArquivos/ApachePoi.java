package cursojava.EscritaeLeituradeArquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\eclipse-workspace\\primeiro-programa\\src\\cursojava\\EscritaeLeituradeArquivos\\arquivo_excel.xls");
		
		if(!file.exists()) {
			file.createNewFile();
			
		}
		
		Pessoa pessoa1 = new Pessoa();
		Pessoa pessoa2 = new Pessoa();
		Pessoa pessoa3 = new Pessoa();
		Pessoa pessoa4 = new Pessoa();

		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setNome("Paulo");
		pessoa1.setIdade(23);

		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setNome("Ana");
		pessoa2.setIdade(34);

		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setNome("Marcos");
		pessoa3.setIdade(29);
		
		pessoa4.setEmail("pessoa4@gmail.com");
		pessoa4.setNome("Isis");
		pessoa4.setIdade(35);
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); // VAI SER USADO PARA ESCREVER A PLANILHA
		
		HSSFSheet linhaPessoa = hssfWorkbook.createSheet("planilha de pessoas excel"); // CRIAR A PLANILHA
		
		int numeroLinha = 0;
		
		for (Pessoa p : pessoas) {
			Row linha = linhaPessoa.createRow(numeroLinha++); //Criando linha na planilha
			
			int celula = 0;
			
			Cell celNome = linha.createCell(celula++); // celula 1
			celNome.setCellValue(p.getNome());
			
			Cell celEmail = linha.createCell(celula++); // celula 2
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula++); // celula 3
			celIdade.setCellValue(p.getIdade());
		}
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida); // Escreve a planilha em arquivos
		
		saida.flush();
		saida.close();
		System.out.println("planilha foi criada!");
	}
}
