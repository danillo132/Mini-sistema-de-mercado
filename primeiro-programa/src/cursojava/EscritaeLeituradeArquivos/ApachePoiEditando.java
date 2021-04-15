package cursojava.EscritaeLeituradeArquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEditando {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\eclipse-workspace\\primeiro-programa\\src\\cursojava\\EscritaeLeituradeArquivos\\arquivo_excel.xls");
		
		FileInputStream stream = new FileInputStream(file);
		
		HSSFWorkbook workbook = new HSSFWorkbook(stream); // Prepar a entrada do arquivo 
		HSSFSheet planilha = workbook.getSheetAt(0); // Pegando a planilha
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while(linhaIterator.hasNext()) {
			
			Row linha = linhaIterator.next(); // dados da pessoa na linha
			
			int numeroCelulas = linha.getPhysicalNumberOfCells(); // quantidade de celulas
			
			String valorCelula = linha.getCell(0).getStringCellValue();
			linha.getCell(0).setCellValue(valorCelula + " * valor gravado na aula");
			
		}
		
		stream.close();
		
		FileOutputStream saida = new FileOutputStream(file);
		workbook.write(saida);
		saida.close();
		
		System.out.println("planilha atualizada!!");
	}
}
