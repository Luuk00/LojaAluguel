package persistencia;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Funcionario;



public class FuncionarioDAO {

		private Conexao c;
		private String Relatorio = "select * from \"funcionario\"";
		private String Buscar = "select * from \"funcionario\" where \"cpf\"=?";
		private String Incluir = "insert into \"funcionario\" (\"nome\",\"cpf\",\"carteira_trabalho\",\"contrato\",\"cep\",\"numero_casa\",\"telefone\",\"email\") values (?,?,?,?,?,?,?,?)";
		private String Deletar = "delete from \"funcionario\" where \"cpf\" = ?";
		private String Alterar = "update \"funcionario\" set \"nome\" = ?,\"carteira_trabalho\" = ?, \"contrato\" = ?,\"cep\" = ?, \"numero_casa\" = ?, \"telefone\" = ? , \"email\" = ?,\"cpf\" = ? where \"cpf\" = ? ";	
		public FuncionarioDAO() {
			c = new Conexao("jdbc:postgresql://localhost:5432/Aluguel","postgres","123");
		}
		
		public ArrayList<Funcionario> Relatorio() {
			Funcionario Funcionarios;
			ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
			try {
				c.conectar(); 
				Statement instrucao = c.getConexao().createStatement();
				ResultSet rs = instrucao.executeQuery(Relatorio);
				while(rs.next()) { 
					Funcionarios = new Funcionario(rs.getString("nome"), rs.getString("cpf"), rs.getString("carteira_trabalho"), rs.getString("contrato"), rs.getInt("cep"), rs.getInt("numero_casa"), rs.getString("telefone"), rs.getString("email"));
					lista.add(Funcionarios);
				}
				c.desconectar(); 
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return lista;
		}
		
		public Funcionario buscar(String cpfaux) {
			Funcionario Funcionarios = null;
			try {
				c.conectar();
				PreparedStatement instrucao = c.getConexao().prepareStatement(Buscar);
				instrucao.setString(1, cpfaux);
				ResultSet rs = instrucao.executeQuery();
				if(rs.next()) {
					Funcionarios = new Funcionario(rs.getString("nome"), rs.getString("cpf"), rs.getString("carteira_trabalho"), rs.getString("contrato"), rs.getInt("cep"), rs.getInt("numero_casa"), rs.getString("telefone"), rs.getString("email"));
				}
				c.desconectar();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return Funcionarios;
		}
		
		public void incluir(Funcionario Funcionarios) {
			try {
				c.conectar();
				PreparedStatement instrucao = c.getConexao().prepareStatement(Incluir);
				instrucao.setString(1, Funcionarios.getNome());
				instrucao.setString(2, Funcionarios.getCpf());
				instrucao.setString(3, Funcionarios.getCarteira_trab());
				instrucao.setString(4, Funcionarios.getContrato());
				instrucao.setInt(5, Funcionarios.getCep());
				instrucao.setInt(6, Funcionarios.getNumero_casa());
				instrucao.setString(7, Funcionarios.getTelefone());	
				instrucao.setString(8, Funcionarios.getEmail());
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
		public void Alterar (Funcionario Funcionarios,String cpfaux){
	        try{
	            c.conectar();
	            PreparedStatement instrucao = c.getConexao().prepareStatement(Alterar);
	        	instrucao.setString(1, Funcionarios.getNome());
				instrucao.setString(2, Funcionarios.getCarteira_trab());
				instrucao.setString(3, Funcionarios.getContrato());
				instrucao.setInt(4, Funcionarios.getCep());
				instrucao.setInt(5, Funcionarios.getNumero_casa());
				instrucao.setString(6, Funcionarios.getTelefone());	
				instrucao.setString(7, Funcionarios.getEmail());
				instrucao.setString(8, Funcionarios.getCpf());
				instrucao.setString(9, cpfaux);
				instrucao.execute();
	            c.desconectar();
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	        } 
		}

}