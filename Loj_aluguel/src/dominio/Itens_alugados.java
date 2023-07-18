package dominio;

public class Itens_alugados {
	
	
	private Long codigo;
	private Aluguel fk_aluguel;
	private Itens fk_itens;

	public Itens_alugados(Long codigo, Aluguel fk_aluguel, Itens fk_itens){
		this.codigo = codigo;
		this.fk_aluguel = fk_aluguel;
		this.fk_itens = fk_itens;
	}
	
	public Itens_alugados(Itens fk_itens){
		this.fk_itens = fk_itens;
	}
	
	public Itens_alugados(){
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Aluguel getFk_aluguel() {
		return fk_aluguel;
	}
	public void setFk_aluguel(Aluguel fk_aluguel) {
		this.fk_aluguel = fk_aluguel;
	}
	public Itens getFk_itens() {
		return fk_itens;
	}
	public void setFk_itens(Itens fk_itens) {
		this.fk_itens = fk_itens;
	}
	
}
