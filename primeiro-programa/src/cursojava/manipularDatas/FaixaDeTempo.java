package cursojava.manipularDatas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;



public class FaixaDeTempo {

	
	public static void main(String[] args)  throws ParseException{
		
		
		
	Long  dias = ChronoUnit.MONTHS.between(LocalDate.parse("2021-02-01"), LocalDate.now());
	
	System.out.println("Possui "+dias+" meses entre a faixa de data");
		
	}
	
}
