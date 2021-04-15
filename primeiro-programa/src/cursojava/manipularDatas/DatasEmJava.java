package cursojava.manipularDatas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.DataFormatException;


public class DatasEmJava   {

	
	public static void main(String[] args) throws DataFormatException, ParseException {
		
		SimpleDateFormat  dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dataVencimentoBoleto = dateFormat.parse("11/04/2021");
		
		Date DataDeHoje = dateFormat.parse("12/04/2021");
		
		
		
		// SE A DATA 1 É MAIOR QUE A DATA 2
		
		
		if(dataVencimentoBoleto.after(DataDeHoje)) {
			
			System.out.println("boleto ainda não vencido");
		}else {
			System.out.println("Boleto Vencido!!!");
		}
		
		if(dataVencimentoBoleto.before(DataDeHoje)) {
			System.out.println("Boleto vencido!!");
		}else {
			System.out.println("BOleto ainda nao venceu");
		}
		
	}
}
