package cursojava.manipularDatas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BoletoComLocalDate {

	
	public static void main(String[] args) {
		
		LocalDate dataBase = LocalDate.parse("2019-10-05");
		
		
		System.out.println("Mais 5 dias: " + (dataBase = dataBase.plusDays(5)));
		System.out.println("Mais 5 semanas: " + (dataBase = dataBase.plusWeeks(5)));
		System.out.println("Mais 4 meses: " + (dataBase = dataBase.plusMonths(4)));
		System.out.println("Mais 5 anos: " + (dataBase = dataBase.plusYears(5)));
		System.out.println("Menos 2 anos: " + (dataBase = dataBase.minusYears(2)));
		
		System.out.println("-------------------------------------------");
		
		for(int data = 1; data <= 12; data++) {
			dataBase = dataBase.plusMonths(1);
			System.out.println("Boleto Número " +data + " com vencimento: " + dataBase.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			
		}
	}
}
