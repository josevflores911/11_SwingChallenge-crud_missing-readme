package sistema_estacionamento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import bean.Ativos;
import bean.Vehiculo;
import middle.GestaoPagamento;
import middle.VehiculosAtivos;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class TelaPrincipal extends JFrame{

	private JFrame frame;
	
	private JComboBox comboBox;
	
	private List<Ativos> ativos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
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
	public TelaPrincipal() {
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
		
		comboBox = new JComboBox();
		comboBox.setBounds(41, 32, 126, 22);
		getContentPane().add(comboBox);
		
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		btnNewButton.setBounds(265, 29, 100, 28);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
				
			}
		});
		btnNewButton_1.setBounds(319, 208, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Pagamento/Saida");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
		btnNewButton_2.setBounds(265, 78, 100, 28);
		getContentPane().add(btnNewButton_2);
		
		cargarAtivos();
	}

	protected void editar() {
		/*dispose();
		
		JFrame cadastroEdicao = new CadastroEdicao();
		cadastroEdicao.setVisible(true);
		
		cadastroEdicao.setBounds(100, 100, 450, 300);
		*/
	}

	protected void cadastrar() {
		dispose();
		
		JFrame cadastroEdicao = new CadastroEdicao();
		cadastroEdicao.setVisible(true);
		
		cadastroEdicao.setBounds(100, 100, 450, 300);
		
	}

	protected void sair() {
		//pagamento
		dispose();
		
		JFrame telaSaida = new TelaSaida ();
		telaSaida.setVisible(true);
		
		telaSaida.setBounds(100, 100, 450, 300);
		//System.exit(0);
		
	}
	
	public void cargarAtivos() {
		/*VehiculosAtivos vehiculosAtivos = new VehiculosAtivos();
		List<Ativos> ativos = vehiculosAtivos.getVehiculosAtivos() ;
		for(Ativos ativo: ativos) {
			comboBox.addItem(ativo.getDescricao());
		}*/
		VehiculosAtivos vehiculosAtivos = new VehiculosAtivos();
		ativos = vehiculosAtivos.getVehiculosAtivos() ;
		
		int i =1;
			
		for(Ativos ativo: ativos) {
			GestaoPagamento gestaoPagamento_1 = new GestaoPagamento();
			Vehiculo pagamentoVehiculo_1 = gestaoPagamento_1.ObterVehiculo(i);
			if(pagamentoVehiculo_1.getSaida()!=null) {
				
				i++;
				
			}else {
				comboBox.addItem(ativo.getDescricao());
				i++;
				
			}
							
		}
		
	}

}
