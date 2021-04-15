package cursojava.manipularDatas;
import java.time.Duration;
import java.time.Instant;

public class ClasseInstante {

	public static void main(String[] args) throws InterruptedException {
		
		Instant inicio = Instant.now();
		
		Thread.sleep(60000); // Pode ser um processo qualquer que nao conhecemos 
		
		Instant ifinal = Instant.now();
		
		Duration duracao = Duration.between(inicio, ifinal);
		
		
		System.out.println("Duração em nanos segundos: " + duracao.toNanos());
		System.out.println("Duração em milisegundos segundos: " + duracao.toMillis());
		System.out.println("Duração em segundos: " + duracao.getSeconds());
		System.out.println("Duração em minutos: " + duracao.toMinutes());
	}
}
