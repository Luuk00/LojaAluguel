package dominio;

import java.util.ArrayList;

public class Aluguel {
	
	private Long codigo;
	private Cliente fk_cliente;
	private Funcionario fk_funcionario;
	private ArrayList<Itens> fk_itens;
	private String data_saida;
	private String forma_pagamento;
	private int quantidade_itens;
	private String data_devolucao;
	private String ajuste;
	private String observacao;
	private float valor_total;
	
	public Aluguel() {
		
	}
	
	public Aluguel(Long codigo, String data_saida, String forma_pagamento, int quantidade_itens, String data_devolucao, String ajuste, String observacao, float valor_total) {
		this.codigo = codigo;
		this.data_saida = data_saida;
		this.forma_pagamento = forma_pagamento;
		this.quantidade_itens = quantidade_itens;
		this.data_devolucao = data_devolucao;
		this.ajuste = ajuste;
		this.observacao = observacao;
		this.valor_total = valor_total;
		this.fk_itens = new ArrayList<Itens>();
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Cliente getFk_cliente() {
		return fk_cliente;
	}
	public void setFk_cliente(Cliente fk_cliente) {
		this.fk_cliente = fk_cliente;
	}
	public Funcionario getFk_funcionario() {
		return fk_funcionario;
	}
	public void setFk_funcionario(Funcionario fk_funcionario) {
		this.fk_funcionario = fk_funcionario;
	}
	public ArrayList<Itens> getFk_item() {
		return fk_itens;
	}
	public void setFk_item(Itens fk_item) {
		fk_itens.add(fk_item);
	}
	public String getData_saida() {
		return data_saida;
	}
	public void setData_saida(String data_saida) {
		this.data_saida = data_saida;
	}
	public String getForma_pagamento() {
		return forma_pagamento;
	}
	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}
	public int getQuantidade_itens() {
		return quantidade_itens;
	}
	public void setQuantidade_itens(int quantidade_itens) {
		this.quantidade_itens = quantidade_itens;
	}
	public String getData_devolucao() {
		return data_devolucao;
	}
	public void setData_devolucao(String data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	public String getAjuste() {
		return ajuste;
	}
	public void setAjuste(String ajuste) {
		this.ajuste = ajuste;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public float getValor_total() {
		return valor_total;
	}
	public void setValor_total(float valor_total) {
		this.valor_total = valor_total;
	}

}