package cursojava.EscritaeLeituradeArquivos;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiLendo {

	public static void main(String[] args) throws IOException {
		
		FileInputStream inputStream = new FileInputStream(new File("C:\\eclipse-workspace\\primeiro-programa\\src\\cursojava\\EscritaeLeituradeArquivos\\arquivo_excel.xls"));
		
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream); //Prepara a entrada do arquivo para ler
		HSSFSheet sheet = workbook.getSheetAt(0); //Pega a primeira planilha do arquivo excel
		
		Iterator<Row> linhaIterator = sheet.iterator();
		
		List<Pessoa>pessoas = new ArrayList<Pessoa>();
		
		while(linhaIterator.hasNext()) { // Enquanto tiver linha no arquivo do excel
			
			Row linha = linhaIterator.next(); //Dados da pessoa na linha
			
			Iterator<Cell> celula = linha.iterator();
			
			Pessoa pessoa = new Pessoa();
			
			while(celula.hasNext()) { // Percorrer as celulas
				
				Cell cell = celula.next();
				
				switch (cell.getColumnIndex()) {
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;

				case 1:
					pessoa.setEmail(cell.getStringCellValue());
					break;
					
				case 2:
					pessoa.setIdade(Double.valueOf( cell.getNumericCellValue()).intValue());
					break;
				
				}
			} // Fim da linha de pessoas
			
			pessoas.add(pessoa);
			
		}
		
		inputStream.close();//terminou de ler o arquivo excel
		
		for (Pessoa pessoa : pessoas) { // Poderia gravar no banco de dados
			System.out.println(pessoa);
		}
	}
}
