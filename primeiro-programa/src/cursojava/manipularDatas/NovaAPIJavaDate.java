package cursojava.manipularDatas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class NovaAPIJavaDate {

	
	public static void main(String[] args) throws ParseException{
		
		// NOVA API DE DATA A PARTIR DO JAVA 8
		
		LocalDate dataAtual = LocalDate.now();
		
		
		
		System.out.println("data atual: " +  dataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		LocalTime horaAtual = LocalTime.now();
		
		
		
		System.out.println(horaAtual.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
		
		LocalDateTime horaEdataAtual = LocalDateTime.now();
		
		System.out.println(horaEdataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
	}
}
