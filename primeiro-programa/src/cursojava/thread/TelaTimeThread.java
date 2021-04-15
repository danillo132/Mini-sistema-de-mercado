package cursojava.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class TelaTimeThread extends JDialog{

	
	private JPanel jPanel = new JPanel(new GridBagLayout()); // painel de componentes
	
	private JLabel descricaoHora = new JLabel("Nome: "); 
	
	private JTextField mostraTempo = new JTextField();	
	
	private JLabel descricaoHora2 = new JLabel("E-mail: "); 
	
	private JTextField mostraTempo2 = new JTextField();	
	
	private JButton start = new JButton("Add lista");
	
	private JButton stop = new JButton("Stop");
	
	private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();	
	
	

	
	
	
	public TelaTimeThread() // Executa o que tiver dentro no momento da abertura ou execução do objeto
	{
		setTitle("Minha tela de Time com thread");
		setSize(new Dimension(240, 240));
		setLocationRelativeTo(null);
		setResizable(false);
		//Primeira parte concluída
		
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints(); // contralador de posicionamento de componentes
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		gridBagConstraints.anchor = gridBagConstraints.WEST;
		
		
		descricaoHora.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricaoHora, gridBagConstraints);
		
		mostraTempo.setPreferredSize(new Dimension(200,25));
		
		gridBagConstraints.gridy++;
		jPanel.add(mostraTempo, gridBagConstraints);
		
		descricaoHora2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(descricaoHora2, gridBagConstraints);
		
		mostraTempo2.setPreferredSize(new Dimension(200,25));
		
		gridBagConstraints.gridy++;
		jPanel.add(mostraTempo2, gridBagConstraints);
		
		gridBagConstraints.gridwidth = 1;
		
		start.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy++;
		jPanel.add(start, gridBagConstraints);
		
		stop.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx++;
		jPanel.add(stop, gridBagConstraints);
		
		
		start.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) { // executa o clique no botão
				
				if(fila == null) {
					fila = new ImplementacaoFilaThread();
					fila.start();	
				}
				
				for(int qtd = 0; qtd < 100; qtd++) { // simulando 100 envios em massa
					
				
				ObjetoFilathread filaThread = new ObjetoFilathread();
				filaThread.setNome(mostraTempo.getText());
				filaThread.setEmail(mostraTempo2.getText() + " - " + qtd);
				
				fila.add(filaThread);
				
				}
			}
		});
		
		
		
		stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				fila.stop();
				fila = null;
				
			}
		});
		
		
		fila.start();
		add(jPanel, BorderLayout.WEST);
		//Sempre será o último comando
		setVisible(true); // TOrna a tela visível para o usuário
	}
}
