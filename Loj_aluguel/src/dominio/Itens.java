package dominio;

public class Itens {
	
	
	private String tipo;
	private String tamanho;
	private String manutencao;
	private float valor;

	public Itens() {
	}
	
	public Itens (String tipo, String tamanho, String manutencao, float valor) {
		this.tipo = tipo;
		this.tamanho = tamanho;
		this.manutencao = manutencao;
		this.valor = valor;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	public String getManutencao() {
		return manutencao;
	}
	
	public void setManutencao(String manutencao) {
		this.manutencao = manutencao;
	}
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
}