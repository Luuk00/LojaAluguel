package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Aluguel;
import dominio.Itens;
import dominio.Itens_alugados;

public class Itens_alugadosDAO {
	
	private Conexao c;
	private String Relatorio = "select * from \"itens_alugados\"";
	private String RelatorioDeItens = "select * from \"itens_alugados\" WHERE \"fk_aluguel\"=?";
	private String Buscar = "select * from \"itens_alugados\" where \"codigo\"=?";
	private String Buscaraluguel = "select * from \"itens_alugados\" where \"fk_aluguel\"=?";
	private String Incluir = "insert into \"itens_alugados\" (\"codigo\",\"fk_item\",\"fk_aluguel\") values (?,?,?)";
	private String Deletar = "delete from \"itens_alugados\" where \"codigo\" = ?";
	private String Alterar = "update \"itens_alugados\" set \"fk_itens\" = ?, \"fk_aluguel\" = ? where \"codigo\" = ? ";	

	public Itens_alugadosDAO() {
		c = new Conexao("jdbc:postgresql://localhost:5432/Aluguel","postgres","123");
	}
	
	public ArrayList<Itens_alugados> Relatorio() {
		Itens_alugados itens_alugados;
		ArrayList<Itens_alugados> lista = new ArrayList<Itens_alugados>();
		ItensDAO iDAO = new ItensDAO();
		AluguelDAO aDAO = new AluguelDAO();
		try {
			c.conectar(); 
			Statement instrucao = c.getConexao().createStatement();
			ResultSet rs = instrucao.executeQuery(Relatorio);
			while(rs.next()) { 
				itens_alugados = new Itens_alugados();
				itens_alugados.setCodigo(rs.getLong("codigo"));
				itens_alugados.setFk_aluguel(aDAO.buscar(rs.getLong("fk_aluguel")));
				itens_alugados.setFk_itens(iDAO.buscar(rs.getString("fk_item")));
				lista.add(itens_alugados);
			}
			c.desconectar(); 
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	public Itens_alugados buscar(Long codigo) {
		Itens_alugados itens_alugados = null;
		ItensDAO iDAO = new ItensDAO();
		AluguelDAO aDAO = new AluguelDAO();
		
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(Buscar);
			instrucao.setLong(1, codigo);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				itens_alugados = new Itens_alugados();
				itens_alugados.setCodigo(rs.getLong("codigo"));
				itens_alugados.setFk_aluguel(aDAO.buscar(rs.getLong("fk_aluguel")));
				itens_alugados.setFk_itens(iDAO.buscar(rs.getString("fk_item")));
			}
			c.desconectar();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return itens_alugados;
	}
	
	public void incluir(Itens_alugados itens_alugados, Itens item, Aluguel aluguel) {
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(Incluir);
			instrucao.setLong(1, itens_alugados.getCodigo());
			instrucao.setLong(3, aluguel.getCodigo());
			instrucao.setString(2, item.getTipo());
			instrucao.execute();
			c.desconectar();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void Deletar (int idAux) {
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(Deletar);
			instrucao.setInt(1, idAux);
			instrucao.execute();
			c.desconectar();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
	public void Alterar (Itens_alugados itens_alugados){
        try{
        	c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Alterar);
            instrucao.setString(1, itens_alugados.getFk_itens().getTipo());
            instrucao.setLong(2, itens_alugados.getFk_aluguel().getCodigo());
            instrucao.setLong(3, itens_alugados.getCodigo());
            instrucao.execute();
            c.desconectar();
        }catch(Exception e){
            System.out.println(e.getMessage());
        } 
	}
	
	public ArrayList<Itens_alugados> buscaraluguel(Long codigo) {
		Itens_alugados itens_alugados;
		ArrayList<Itens_alugados> lista = new ArrayList<Itens_alugados>();
		ItensDAO iDAO = new ItensDAO();
		AluguelDAO aDAO = new AluguelDAO();
		try {
			c.conectar(); 
            PreparedStatement instrucao = c.getConexao().prepareStatement(Buscaraluguel);
			instrucao.setLong(1,codigo);
			ResultSet rs = instrucao.executeQuery(Buscaraluguel);
			while(rs.next()) { 
				itens_alugados = new Itens_alugados();
				itens_alugados.setCodigo(rs.getLong("codigo"));
				itens_alugados.setFk_aluguel(aDAO.buscar(rs.getLong("fk_aluguel")));
				itens_alugados.setFk_itens(iDAO.buscar(rs.getString("fk_item")));
				lista.add(itens_alugados);
			}
			c.desconectar(); 
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	public ArrayList<Itens_alugados> RelatorioDeItens(Long codaux) {
		Itens_alugados itens_alugados;
		ArrayList<Itens_alugados> lista = new ArrayList<Itens_alugados>();
		ItensDAO iDAO = new ItensDAO();
		AluguelDAO aDAO = new AluguelDAO();
		try {
			c.conectar(); 
			PreparedStatement instrucao = c.getConexao().prepareStatement(RelatorioDeItens);
			instrucao.setLong(1,codaux);
			ResultSet rs = instrucao.executeQuery();
			while(rs.next()) { 
				itens_alugados = new Itens_alugados();
				itens_alugados.setCodigo(rs.getLong("codigo"));
				itens_alugados.setFk_aluguel(aDAO.buscar(rs.getLong("fk_aluguel")));
				itens_alugados.setFk_itens(iDAO.buscar(rs.getString("fk_item")));
				lista.add(itens_alugados);
			}
			c.desconectar(); 
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
}
