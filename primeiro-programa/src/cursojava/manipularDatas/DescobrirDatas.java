package cursojava.manipularDatas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DescobrirDatas {

	public static void main(String[] args) {
		
		LocalDate localDate = LocalDate.now();
		
		System.out.println(localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		System.out.println("Dia da semana: " + localDate.getDayOfWeek());
		System.out.println("Dia do mês: " + localDate.getDayOfMonth());
		System.out.println("Dia do ano: " + localDate.getDayOfYear());
		System.out.println("Mes do ano: " + localDate.getMonth());
		System.out.println("Número do mês: " + localDate.getMonthValue());
		System.out.println("Ano:" + localDate.getYear());
	}
}
