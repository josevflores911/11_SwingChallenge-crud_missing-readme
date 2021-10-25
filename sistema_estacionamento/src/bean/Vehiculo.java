package bean;

public class Vehiculo {

	private String placa;
	private String modelo;
	private String entrada;
	private String saida;
	private String tempo;
	private String valor;
	public Vehiculo() {
		super();
	}
	public Vehiculo(String placa, String modelo, String entrada, String saida, String tempo, String valor) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.entrada = entrada;
		this.saida = saida;
		this.tempo = tempo;
		this.valor = valor;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getEntrada() {
		return entrada;
	}
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
	public String getSaida() {
		return saida;
	}
	public void setSaida(String saida) {
		this.saida = saida;
	}
	public String getTempo() {
		return tempo;
	}
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	
	
}
