package cursojava.manipularDatas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class CalcularDatas {

	
	public static void main(String[] args)  throws ParseException{
		
		Calendar calendar = Calendar.getInstance(); /*pega a data atual*/
		
		calendar.setTime(new SimpleDateFormat("dd/MM/yyyy").parse("10/03/2021"));
		
		//Somando mes
		calendar.add(Calendar.MONTH, 1);
		
		//Somando dia
		calendar.add(Calendar.DAY_OF_MONTH, 4);
		
		//Somando um ano
		
		calendar.add(Calendar.YEAR, 2);
		
		System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
		
	}
}
