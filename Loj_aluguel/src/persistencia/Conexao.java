package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
      //atributos
	private String usuario;
	private String senha;
	private String caminho;
	private Connection conex;
	
		//contrutor parametros do contrutor
	public Conexao(String caminho, String usuario, String senha) {
		this.caminho = caminho;
		this.usuario = usuario;
		this.senha = senha;
	}
	
		//metodo
	public void conectar() {
		try {
			Class.forName("org.postgresql.Driver"); 
			conex = DriverManager.getConnection(caminho, usuario, senha); 
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void desconectar() {
		try {
			conex.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Connection getConexao() {
		return this.conex;
	}
}

