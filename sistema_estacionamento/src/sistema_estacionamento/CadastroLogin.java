package sistema_estacionamento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import bean.Usuario;
import middle.GestaoUsuarios;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CadastroLogin extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroLogin window = new CadastroLogin();
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
	public CadastroLogin() {
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
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		btnNewButton.setBounds(58, 102, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.setBounds(335, 214, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("usuario");
		lblNewLabel.setBounds(58, 28, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("senha");
		lblNewLabel_1.setBounds(58, 66, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(135, 25, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("nombre");
		lblNewLabel_2.setBounds(261, 186, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(338, 183, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Sair");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
				
			}
		});
		btnNewButton_2.setBounds(335, 11, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(135, 64, 86, 17);
		frame.getContentPane().add(passwordField);
	}


        
	protected void ingresar() {
		String usuarioForm = textField.getText();
		String claveForm = String.valueOf(passwordField.getPassword());
		
		GestaoUsuarios gestaoUsuario = new GestaoUsuarios();
		
		Usuario usuarioDado = new Usuario();
		usuarioDado.setUsuario(usuarioForm);
		usuarioDado.setSenha(claveForm);
		
		Usuario user = gestaoUsuario.ObterUsuario(usuarioDado);
		
		if(user!=null) {
			JOptionPane.showMessageDialog(null, "Bemvindo");
			
			
			dispose();
			
			JFrame telaPrincipal = new TelaPrincipal();
			telaPrincipal.setVisible(true);
			
			telaPrincipal.setBounds(100, 100, 450, 300);
			
			
		}else {
			JOptionPane.showMessageDialog(null, "Dados Invalidos","Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}

	protected void sair() {
		System.exit(0);
		
	}
}
