package cursojava.thread;

import javax.swing.JOptionPane;

public class AulaThread {

	public static void main(String[] args) throws InterruptedException {

		// Thread processando em paralelo do envio de email
		Thread threadEmail = new Thread(thread1);
		threadEmail.start();

		// ====================================================

		Thread threadNotaFiscal = new Thread(thread2); // Thread processando em paralelo do envio de nota fiscal
		threadNotaFiscal.start();

		// c�digo do sistema do usu�rio continua o fluxo de trabalho
		System.out.println("CHEGOU AO FIM DO C�DIGO TESTE DE THREAD");
		// Fluxo do sistema, cadastro de vendas, emiss�o de nota fiscal etc..
		JOptionPane.showMessageDialog(null, "sistema continua executando para o usu�rio");
	}

	private static Runnable thread2 = new Runnable() {

		@Override
		public void run() {

			// codigo da rotina

			// Quero executar esse envio com um tempo de parada ou com um tempo determinado

			// codigo da rotina que quero executar em paralelo
			for (int i = 0; i < 10; i++) {

				System.out.println("executando alguma rotina, envio de nota fiscal");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // tempo de pausa na execu��o
			}
			// fim do codigo em paralelo

		}
	};

	private static Runnable thread1 = new Runnable() {

		@Override
		public void run() {

			// codigo da rotina

			// Quero executar esse envio com um tempo de parada ou com um tempo determinado

			// codigo da rotina que quero executar em paralelo
			for (int i = 0; i < 10; i++) {

				System.out.println("executando alguma rotina, exemplo enviar e-mail");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // tempo de pausa na execu��o
			}
			// fim do codigo em paralelo

		}
	};

}
