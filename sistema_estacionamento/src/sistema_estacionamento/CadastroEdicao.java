package sistema_estacionamento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import bean.Vehiculo;
import middle.Movimentacao;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CadastroEdicao extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroEdicao window = new CadastroEdicao();
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
	public CadastroEdicao() {
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
		frame.getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("placa");
		lblNewLabel.setBounds(61, 43, 46, 14);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("modelo");
		lblNewLabel_1.setBounds(61, 96, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(160, 40, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 93, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("Gravar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gravar();
			}
		});
		btnNewButton.setBounds(308, 30, 89, 27);
		getContentPane().add(btnNewButton);
		
		btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voltar();
			}
		});
		btnNewButton_2.setBounds(308, 90, 89, 27);
		getContentPane().add(btnNewButton_2);
		
		
		
	}

	protected void voltar() {
		dispose();
		
		JFrame telaPrincipal = new TelaPrincipal();
		telaPrincipal.setVisible(true);
		
		telaPrincipal.setBounds(100, 100, 450, 300);
	}

	protected void gravar() {
				
		
	    String placa = textField.getText().toString();
		String modelo= textField_1.getText().toString();

		
		String entrada = "cualquiercosa";
		String saida = "anything";
		String tempo = "anything";
		String valor = "anything";
		
		Vehiculo vehiculo = new Vehiculo();
		
		vehiculo.setPlaca(placa);
		vehiculo.setModelo(modelo);
		vehiculo.setEntrada(entrada);
		vehiculo.setSaida(saida);
		vehiculo.setTempo(tempo);
		vehiculo.setValor(valor);
		
		Movimentacao movimentacao = new Movimentacao();
		
		int validacao = movimentacao.adicionarVehiculo(vehiculo);
		
		if(validacao > 0) {
			JOptionPane.showMessageDialog(null, "Cadastrado");
		}else {
			
			JOptionPane.showMessageDialog(null, "No cadastrado","Aviso",JOptionPane.WARNING_MESSAGE);
			System.out.println("segundo");
			System.out.println(validacao);
		}
		
		
		//------------------------------------------------------------------------------------------------------
		
		 /*Connection con=null;
		 Statement stmt=null;
		
		try {
	           
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/estacionamento"; 
			String usuario ="root";
			String senha = "2812";
			
			con = DriverManager.getConnection(url, usuario, senha); 
            
			if ( con != null ) 
                   System.out.println("Se ha establecido una conexión a la base de datos " +  
                                      "\n " + url ); 
 
                 stmt =  con.createStatement(); 
                 
               
                 
                 stmt.executeUpdate("INSERT INTO tbl_movimentacao (placa, modelo, data_entrada) VALUES ('"+69 + "','"+69+"','"+69+"')");
                 
                 
                 System.out.println("Los valores han sido agregados a la base de datos ");
                 
                
                  
       } catch (SQLException | ClassNotFoundException e) {
			System.out.println("error de envio");
			e.printStackTrace();
		} finally {
           if (con != null) {
               try {
                   con.close();
                   stmt.close();
               } catch ( Exception e ) { 
                        System.out.println( e.getMessage());
               }
           }
       }
		
		*/
		
		//--------------------------------------------------------------------------------	
		this.dispose();
		
		JFrame telaPrincipal = new TelaPrincipal();
		telaPrincipal.setVisible(true);
		
		telaPrincipal.setBounds(100, 100, 450, 300);
		
	}
		

	
}
