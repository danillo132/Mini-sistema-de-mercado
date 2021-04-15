package cursojava.thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {

	
	private static ConcurrentLinkedQueue<ObjetoFilathread> pilhaFilha 
	= new ConcurrentLinkedQueue<ObjetoFilathread>();
	
	public static void add(ObjetoFilathread objetoFilathread) {
		pilhaFilha.add(objetoFilathread);
		
	}
	
	@Override
	public void run() {
		
		
		
		while(true) {
			Iterator iteracao  = pilhaFilha.iterator();
		synchronized (iteracao) { //Bloquear o acesso a esta lista por outros processos
			
			while(iteracao.hasNext()) { //Enquanto houver dados na lista irá processar
				
				ObjetoFilathread processar = (ObjetoFilathread) iteracao.next();
				
				/*  Processar 10 mil notas fiscais*/
				// Gerar uma lista de PDF
				
				System.out.println("======================================");
				System.out.println(processar.getEmail());
				System.out.println(processar.getNome());
				
				iteracao.remove();
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
			}
			
		}
		
		
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		super.run();
	}
	
	
	}
}
