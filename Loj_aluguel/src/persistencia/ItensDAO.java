package persistencia;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import dominio.Itens;

public class ItensDAO {

	private Conexao c;
	private String Relatorio = "select * from \"item\"";
	private String Buscar = "select * from item where tipo=?";
	private String Incluir = "insert into \"item\" (\"tipo\",\"tamanho\",\"manutencao\",\"valor\") values (?,?,?,?)";
	private String Deletar = "delete from \"item\" where \"tipo\" = ?";
	private String Alterar = "update \"item\" set \"tipo\" = ?, \"tamanho\" = ?, \"manutencao\" = ?, \"valor\" = ? where \"tipo\" = ?";	
	
	public ItensDAO() {
		c = new Conexao("jdbc:postgresql://localhost:5432/Aluguel","postgres","123");
	}
	
	public ArrayList<Itens> Relatorio() {
		Itens Item;
		ArrayList<Itens> lista = new ArrayList<Itens>();
		try {
			c.conectar(); 
			Statement instrucao = c.getConexao().createStatement();
			ResultSet rs = instrucao.executeQuery(Relatorio);
			while(rs.next()) { 
				Item = new Itens(rs.getString("tipo"), rs.getString("tamanho"), rs.getString("manutencao"),rs.getFloat("valor"));
				lista.add(Item);
			}
			c.desconectar(); 
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	public Itens buscar(String tipoaux) {
		Itens Item = null;
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(Buscar);
			instrucao.setString(1, tipoaux);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				Item = new Itens(rs.getString("tipo"), rs.getString("tamanho"), rs.getString("manutencao"),rs.getFloat("valor"));
			}
			c.desconectar();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return Item;
	}
	
	public void incluir(Itens item) {
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(Incluir);
			instrucao.setString(1, item.getTipo());
			instrucao.setString(2, item.getTamanho());
			instrucao.setString(3, item.getManutencao());
			instrucao.setFloat(4, item.getValor());
			instrucao.execute();
			c.desconectar();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void Deletar (String tipoaux) {
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(Deletar);
			instrucao.setString(1, tipoaux);
			instrucao.execute();
			c.desconectar();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
	public void Alterar (Itens item, Itens ItemAux){
        try{
        	c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Alterar);
            instrucao.setString(1, item.getTipo());
            instrucao.setString(2, item.getTamanho());
            instrucao.setString(3, item.getManutencao());
			instrucao.setFloat(4, item.getValor());
			instrucao.setString(5, ItemAux.getTipo());
            instrucao.execute();
            c.desconectar();
        }catch(Exception e){
            System.out.println(e.getMessage());
        } 
	}
}
