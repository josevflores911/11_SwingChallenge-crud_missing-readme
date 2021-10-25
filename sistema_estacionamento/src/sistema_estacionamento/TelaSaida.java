package sistema_estacionamento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import bean.Ativos;
import bean.Vehiculo;
import middle.GestaoPagamento;
import middle.Movimentacao;
import middle.VehiculosAtivos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TelaSaida extends JFrame {

	private JFrame frame;
	
	private JComboBox comboBox_1;
	
	private JLabel lblNewLabel;
	
	private List<Ativos> ativos;
	private JButton btnNewButton_3;
	
	
	private int index; 
	private Date dayOut;
	private DateFormat dateFormat;
	private int tempoA; 
	private int total;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSaida window = new TelaSaida();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaSaida() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("O valor a pagar e");
		lblNewLabel.setBounds(10, 11, 187, 44);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
				
			}
		});
		btnNewButton.setBounds(335, 22, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Inicio");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voltar();
			}
		});
		btnNewButton_1.setBounds(335, 66, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(20, 66, 135, 22);
		getContentPane().add(comboBox_1);
		
		JButton btnNewButton_2 = new JButton("Calcular");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnNewButton_2.setBounds(335, 114, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Pagar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pagar();
				}catch(NullPointerException ev) {
					JOptionPane.showMessageDialog(null, "Primero deve calcular","Aviso",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnNewButton_3.setBounds(335, 157, 89, 23);
		getContentPane().add(btnNewButton_3);
		
		cargarAtivos();
	}
	
	

	protected void pagar() {
		
		
		 	
			String saida = dateFormat.format(dayOut);
			String tempo = String.valueOf(tempoA);
			String valor = String.valueOf(total);;
			
			Vehiculo vehiculo = new Vehiculo();
			
			
			vehiculo.setSaida(saida);
			vehiculo.setTempo(tempo);
			vehiculo.setValor(valor);
			
			Movimentacao movimentacao = new Movimentacao();
			
			
			int validacao = movimentacao.adicionarPagamento(vehiculo,index+1);
			
			if(validacao > 0) {
				JOptionPane.showMessageDialog(null, "Tenha um Bom dia");
			}else {
				
				JOptionPane.showMessageDialog(null, "No cadastrado","Aviso",JOptionPane.WARNING_MESSAGE);
				
			}
			
			//---------------------------------------------------------------------------------------------------------
		
			this.dispose();
			
			JFrame telaPrincipal = new TelaPrincipal();
			telaPrincipal.setVisible(true);
			
			telaPrincipal.setBounds(100, 100, 450, 300);
		
		
		
	}

	public void cargarAtivos() {
		VehiculosAtivos vehiculosAtivos = new VehiculosAtivos();
		ativos = vehiculosAtivos.getVehiculosAtivos() ;
		
		int i =1;
			
		for(Ativos ativo: ativos) {
			GestaoPagamento gestaoPagamento_1 = new GestaoPagamento();
			Vehiculo pagamentoVehiculo_1 = gestaoPagamento_1.ObterVehiculo(i);
			if(pagamentoVehiculo_1.getSaida()!=null) {
				
				i++;
				
			}else {
				comboBox_1.addItem(ativo.getDescricao());
				i++;
				
			}
							
		}	
		
	}

	protected void voltar() {
		dispose();
		
		JFrame telaPrincipal = new TelaPrincipal();
		telaPrincipal.setVisible(true);
		
		telaPrincipal.setBounds(100, 100, 450, 300);
		
	}

	protected void sair() {
		System.exit(0);
		
	}
	
	
	
	protected void calcular() {
		index = comboBox_1.getSelectedIndex();
		
		GestaoPagamento gestaoPagamento = new GestaoPagamento();
		
		Vehiculo pagamentoVehiculo = gestaoPagamento.ObterVehiculo(index+1);
		
		if(pagamentoVehiculo!=null) {
			
			dateFormat = new SimpleDateFormat("HH:mm:ss yyyy/MM/dd ");
			dayOut = new Date();
			
			
			System.out.println("pagara tal calculo..."+dateFormat.format(dayOut)+" "+pagamentoVehiculo.getEntrada()+"telaSaida");
			
			
			
			//corregir si fica mas de um dia
			
			String valorA=dateFormat.format(dayOut).substring(0, 3).replace(":", "");//salida
			String valorB=pagamentoVehiculo.getEntrada().substring(0, 3).replace(":", "");
			
			String valorC=dateFormat.format(dayOut).substring(2, 5).replace(":", "");//salida
			String valorD=pagamentoVehiculo.getEntrada().substring(2, 5).replace(":", "");
			
			tempoA = Integer.parseInt(valorA)-Integer.parseInt(valorB);
			int tempoB = Integer.parseInt(valorA)-Integer.parseInt(valorB);
			
			
			
			
			if(tempoA==0) {
				total = 6;
				lblNewLabel.setText("tempo: "+tempoA +"hrs pagamento: "+total+"R$");	
			}else if(tempoA >= 1 && tempoB >= 1) {
				
				int total =6+((tempoA-1)*4);
				lblNewLabel.setText("tempo: "+tempoA +"hrs pagamento: "+total+"R$");
			}
							
			
		}else {
			JOptionPane.showMessageDialog(null, "Dados Invalidos","Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
