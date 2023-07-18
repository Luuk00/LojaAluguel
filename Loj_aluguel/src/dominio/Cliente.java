package dominio;

public class Cliente {

	private String nome;
	private String cpf;
	private int cep;
	private int numero_casa;
	private String telefone;
	private String email;
	
	public Cliente() {
	}
	
	public Cliente(String nome, String cpf, int cep, int numero_casa, String telefone, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.cep = cep;
		this.numero_casa = numero_casa;
		this.telefone = telefone;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String name) {
		this.nome = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	
	public int getNumero_casa() {
		return numero_casa;
	}
	public void setNumero_casa(int numero_casa) {
		this.numero_casa = numero_casa;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}