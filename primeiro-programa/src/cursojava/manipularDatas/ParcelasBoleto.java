package cursojava.manipularDatas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ParcelasBoleto {

	public static void main(String[] args) throws ParseException {
		
		
		Date dataInicial = new SimpleDateFormat("dd/MM/yyyy").parse("12/04/2021"); // Data inicial
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataInicial);
		
		for(int parcela = 1; parcela <= 12; parcela++) {
			calendar.add(Calendar.MONTH, 1);
			
			System.out.println("Parcela número: " + parcela + " vencimento na data: " + new SimpleDateFormat("dd/MM/yyy").format(calendar.getTime()));
		}
	}
}
