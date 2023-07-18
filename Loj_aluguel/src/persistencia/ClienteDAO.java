package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Cliente;

public class ClienteDAO {
	private Conexao c;
	private String Relatorio = "select * from \"cliente\"";
	private String Buscar = "select * from \"cliente\" where \"cpf\"=?";
	private String Incluir = "insert into \"cliente\" (\"nome\", \"cpf\",\"cep\",\"numero_casa\", \"telefone\", \"email\") values (?,?,?,?,?,?)";
	private String Deletar = "delete from \"cliente\" where \"cpf\" = ?";
	private String Alterar = "update \"cliente\" set \"nome\" = ?, \"cpf\" = ?, \"cep\" = ?, \"numero_casa\" = ?, \"telefone\" = ?, \"email\" = ? where \"cpf\" = ? ";	
	public ClienteDAO() {
		c = new Conexao("jdbc:postgresql://localhost:5432/Aluguel","postgres","123");
	}
	
	public ArrayList<Cliente> Relatorio() {
		Cliente cliente;
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		try {
			c.conectar(); 
			Statement instrucao = c.getConexao().createStatement();
			ResultSet rs = instrucao.executeQuery(Relatorio);
			while(rs.next()) { 
				cliente = new Cliente(rs.getString("nome"), rs.getString("cpf"), rs.getInt("cep"), rs.getInt("numero_casa"), rs.getString("telefone"), rs.getString("email"));
				lista.add(cliente);
			}
			c.desconectar(); 
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	public Cliente buscar(String cpfaux) {
		Cliente cliente = null;
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(Buscar);
			instrucao.setString(1, cpfaux);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				cliente = new Cliente(rs.getString("nome"), rs.getString("cpf"), rs.getInt("cep"), rs.getInt("numero_casa"), rs.getString("telefone"), rs.getString("email"));			
			}
			c.desconectar();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return cliente;
	}
	
	public void incluir(Cliente cliente) {
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(Incluir);
			instrucao.setString(1, cliente.getNome());
			instrucao.setString(2, cliente.getCpf());
			instrucao.setInt(3, cliente.getCep());
			instrucao.setInt(4, cliente.getNumero_casa());
			instrucao.setString(5, cliente.getTelefone());
			instrucao.setString(6, cliente.getEmail());

			instrucao.execute();
			c.desconectar();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void Deletar (String cpfAux) {
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(Deletar);
			instrucao.setString(1, cpfAux);
			instrucao.execute();
			c.desconectar();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
	public void Alterar (Cliente cliente,String cpfaux){
        try{
        	c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Alterar);
            instrucao.setString(1, cliente.getNome());
			instrucao.setString(2, cliente.getCpf());
			instrucao.setInt(3, cliente.getCep());
			instrucao.setInt(4, cliente.getNumero_casa());
			instrucao.setString(5, cliente.getTelefone());
			instrucao.setString(6, cliente.getEmail());
			instrucao.setString(7, cpfaux);
            c.desconectar();
        }catch(Exception e){
            System.out.println(e.getMessage());
        } 
	}
}
