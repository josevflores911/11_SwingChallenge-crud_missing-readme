package bean;

public class Usuario {
	
	private String usuario;
	private String senha;
	private String nome;
	
	public Usuario() {
		super();
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario( String nome,String usuario, String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
		this.nome = nome;
	}



	
	
	

}
