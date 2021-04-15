package cursojava.manipularDatas;

import java.time.LocalDate;
import java.time.Period;

public class ObjetoPeriod {

	public static void main(String[] args) {
		
		
		LocalDate dataAntiga = LocalDate.of(2012, 12, 23);
		
		LocalDate dataNova = LocalDate.of(2021, 04, 12);
		
		System.out.println("A data antiga � maior do que a nova?: " + dataAntiga.isAfter(dataNova));
		
		System.out.println("A data antiga � menor do que a nova?" + dataAntiga.isBefore(dataNova));
		System.out.println("As datas s�o iguais?: " + dataAntiga.isEqual(dataNova));
		
		Period periodo = Period.between(dataAntiga, dataNova);
		
		System.out.println("Dias entre as datas:" + periodo.getDays());
		System.out.println("meses entre as datas:" + periodo.getMonths());
		System.out.println("anos entre as datas: " + periodo.getYears());
		
		System.out.println("O per�odo �: " + periodo.getYears()+ " anos " + periodo.getMonths() + " meses e " + periodo.getDays() + " dias");
	}
}
