package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Aluguel;
import dominio.Cliente;
import dominio.Funcionario;
import dominio.Itens;

public class AluguelDAO {
	
	private Conexao c;
	private String Relatorio = "select * from \"aluguel\"";
	private String Buscar = "select * from \"aluguel\" where \"codigo\" = ?";
	private String Incluir = "insert into \"aluguel\" (\"codigo\" ,\"fk_cliente\", \"fk_funcionario\", \"data_saida\", \"forma_pag\", \"qtd_itens\", \"data_entrega\", \"ajuste\", \"observacao\", \"valor_total\") values (?,?,?,?,?,?,?,?,?,?)";
	private String Deletar = "delete from \"aluguel\" where \"codigo\" = ?";
	private String Alterar = "update \"aluguel\" set \"fk_cliente\"= ? , \"fk_funcionario\" = ? , \"fk_item\" = ? , \"data_saida\" = ? , \"forma_pagamento\"  = ? , \"quantidade_itens\" = ? , \"data_devolucao\" = ? , \"ajuste\" = ? , \"observacao\" = ? , \"valor_total\" = ?";	

	public AluguelDAO() {
		c = new Conexao("jdbc:postgresql://localhost:5432/Aluguel","postgres","123");
	}
	
	public ArrayList<Aluguel> Relatorio() {
		Aluguel aluguel;
		ArrayList<Aluguel> lista = new ArrayList<Aluguel>();
		Cliente cliente = null;
		Funcionario funcionario = null;
		ClienteDAO clienteDAO = new ClienteDAO();
		FuncionarioDAO fDAO = new FuncionarioDAO();
		try {
			c.conectar(); 
			Statement instrucao = c.getConexao().createStatement();
			ResultSet rs = instrucao.executeQuery(Relatorio);
			while(rs.next()) { 
				aluguel = new Aluguel(rs.getLong("codigo"), rs.getString("data_saida"), rs.getString("forma_pag"), rs.getInt("qtd_itens"), rs.getString("data_entrega"), rs.getString("ajuste"), rs.getString("observacao"), rs.getFloat("valor_total"));
				cliente = clienteDAO.buscar(rs.getString("fk_cliente"));
				funcionario = fDAO.buscar(rs.getString("fk_funcionario"));
				aluguel.setFk_cliente(cliente);
				aluguel.setFk_funcionario(funcionario);
				lista.add(aluguel);
			}
			c.desconectar(); 
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	public Aluguel buscar(Long codigo) {
		Cliente cliente = null;
		Aluguel aluguel = null;
		Funcionario funcionario = null;
		Itens item = null;
		ClienteDAO clienteDAO = new ClienteDAO();
		FuncionarioDAO fDAO = new FuncionarioDAO();
		ItensDAO iDAO = new ItensDAO();
		
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(Buscar);
			
			instrucao.setLong(1, codigo);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				aluguel = new Aluguel(rs.getLong("codigo"), rs.getString("data_saida"), rs.getString("forma_pag"), rs.getInt("qtd_itens"), rs.getString("data_entrega"), rs.getString("ajuste"), rs.getString("observacao"), rs.getFloat("valor_total"));
				cliente = clienteDAO.buscar(rs.getString("fk_cliente"));
				funcionario = fDAO.buscar(rs.getString("fk_funcionario"));
			//	item = iDAO.buscar(rs.getString("fk_item"));
				aluguel.setFk_cliente(cliente);
				aluguel.setFk_funcionario(funcionario);
				aluguel.setFk_item(item);
			};
			c.desconectar();
		}catch(Exception e) {
			System.out.println(e);
		}
		return aluguel;
	}
	
	public void incluir(Aluguel aluguel, Cliente Clientes, Funcionario Funcionarios) {		
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(Incluir);
			instrucao.setLong(1, aluguel.getCodigo());
			instrucao.setString(2, Clientes.getCpf());
			instrucao.setString(3, Funcionarios.getCpf());
			instrucao.setString(4, aluguel.getData_saida());
			instrucao.setString(5, aluguel.getForma_pagamento());
			instrucao.setInt(6, aluguel.getQuantidade_itens());
			instrucao.setString(7, aluguel.getData_devolucao());
			instrucao.setString(8, aluguel.getAjuste());
			instrucao.setString(9, aluguel.getObservacao());
			instrucao.setFloat(10, aluguel.getValor_total());
			instrucao.execute();
			c.desconectar();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void Deletar (Long codigo) {
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(Deletar);
			instrucao.setLong(1, codigo);
			instrucao.execute();
			c.desconectar();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
	public void Alterar (Aluguel aluguel, Cliente cliente, Funcionario funcionario, Itens item){
        try{
        	c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Alterar);
            instrucao.setLong(1, aluguel.getCodigo());
			instrucao.setString(2, cliente.getCpf());
			instrucao.setString(3, funcionario.getCpf());
			instrucao.setString(4, item.getTipo());
			instrucao.setString(5, aluguel.getData_saida());
			instrucao.setString(6, aluguel.getForma_pagamento());
			instrucao.setInt(7, aluguel.getQuantidade_itens());
			instrucao.setString(8, aluguel.getData_devolucao());
			instrucao.setString(9, aluguel.getAjuste());
			instrucao.setString(10, aluguel.getObservacao());
			instrucao.setFloat(11, aluguel.getValor_total());
            c.desconectar();
        }catch(Exception e){
            System.out.println(e.getMessage());
        } 
	}

}