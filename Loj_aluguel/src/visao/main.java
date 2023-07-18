package visao;

import persistencia.AluguelDAO;
import persistencia.ClienteDAO;
import persistencia.FuncionarioDAO;
import persistencia.ItensDAO;
import persistencia.Itens_alugadosDAO;
import dominio.Aluguel;
import dominio.Cliente;
import dominio.Funcionario;
import dominio.Itens;
import dominio.Itens_alugados;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ItensDAO iDAO = new ItensDAO();
        ClienteDAO clDAO = new ClienteDAO();
        FuncionarioDAO fDAO= new FuncionarioDAO();
        AluguelDAO aDAO = new AluguelDAO();
        Itens_alugadosDAO iaDAO = new Itens_alugadosDAO();
        
        ArrayList<Itens> aitens;
        ArrayList<Cliente> aclientes;
        ArrayList<Funcionario> afuncionarios;
        ArrayList<Aluguel> alugueis;
        ArrayList<Itens_alugados> ialista;
        
        Itens Item, ItemAux;
        Cliente cliente;
        Funcionario funcionario;
        Aluguel aluguel;
        Itens_alugados itens_alugados;
        Random codigoRandomAux= new Random();
		Random codigo = new Random();
        
        int op,op2,i,contaux,o,iaux;
        float valortotal;
        String tipoaux,cpfaux;
        Scanner teclado = new Scanner(System.in);
		Long codigoRandom,codaux;
		boolean continuar = false;

        do {
			System.out.println("\nMenu Principal");
			System.out.println("1 - Buscar");
			System.out.println("2 - Incluir");
			System.out.println("3 - Alterar");
			System.out.println("4 - Excluir");
			System.out.println("5 - Relatório");
			System.out.println("6 - Alugar");
			System.out.println("7 - Sair");
			op = teclado.nextInt();
			teclado.nextLine();
			
			switch(op) {
				case 1:
					System.out.println("\nOque Voce deseja Buscar?");
					System.out.println("1 - Item");
					System.out.println("2 - Cliente");
					System.out.println("3 - Funcionario");
					System.out.println("4 - Aluguel");
					System.out.println("5 - Voltar");
					op2 = teclado.nextInt();
					teclado.nextLine();
					switch(op2) {
					case 1:
						System.out.println("Buscando Itens...");
						System.out.println("Digite o id de item: ");
						tipoaux = teclado.nextLine();
						Item = iDAO.buscar(tipoaux);
						if(Item == null) {
							System.out.println("Itens não encontrados no estoque");
						}else {
							System.out.println("Item encontrado");
							System.out.println("Tipo: "+Item.getTipo());
							System.out.println("Tamanho: "+Item.getTamanho());
							System.out.println("Manutencao: "+Item.getManutencao());
							System.out.println("Valor: R$"+Item.getValor());
							}
					break;
					case 2:
						System.out.println("Buscando Cliente...");
						System.out.println("Digite o cpf do cliente: ");
						cpfaux = teclado.nextLine();
						cliente = clDAO.buscar(cpfaux);
						if(cliente == null) {
							System.out.println("Cliente não encontrado");
						}else {
							System.out.println("Cliente encontrado");
							System.out.println("Nome: "+cliente.getNome());
							System.out.println("Cpf: "+cliente.getCpf());
							System.out.println("Cep: "+cliente.getCep());
							System.out.println("Numero da casa: "+cliente.getNumero_casa());
							System.out.println("Telefone: "+cliente.getTelefone());
							System.out.println("Email: "+cliente.getEmail());
						}
					break;
					case 3:
						System.out.println("Buscando Funcionário...");
						System.out.println("Digite o cpf do Funcionário: ");
						cpfaux = teclado.nextLine();
						funcionario = fDAO.buscar(cpfaux);
						if(funcionario == null) {
							System.out.println("Funcionário não encontrado");
						}else {
							System.out.println("Funcionário encontrado");
							System.out.println("Nome: "+funcionario.getNome());
							System.out.println("Cpf: "+funcionario.getCpf());
							System.out.println("Carteira de trab: "+funcionario.getCarteira_trab());
							System.out.println("Contrato: "+funcionario.getContrato());
							System.out.println("Cep: "+funcionario.getCep());
							System.out.println("Numero da casa: "+funcionario.getNumero_casa());
							System.out.println("Telefone: "+funcionario.getTelefone());
							System.out.println("Email: "+funcionario.getEmail());
						}
					break;
					case 4:
						System.out.println("Buscando o aluguel...");
						System.out.println("Digite o id do aluguel: ");
						codaux = teclado.nextLong();
						aluguel = aDAO.buscar(codaux);
						ialista = iaDAO.buscaraluguel(codaux);
						if(aluguel == null) {
							System.out.println("Aluguel não encontrado");
						}else {
							System.out.println("Aluguel encontrado: ");
							System.out.println("Id: "+aluguel.getCodigo());
							cliente = aluguel.getFk_cliente();
							System.out.println("Cpf cliente: "+cliente.getCpf());
							funcionario = aluguel.getFk_funcionario();
							System.out.println("Cpf funcionario: "+funcionario.getCpf());
							aitens = aluguel.getFk_item();
							for(i = 0; i < ialista.size(); i++) {
								System.out.println("O tipo do item: " + aitens.get(i).getTipo());
							}
							System.out.println("Data de saida: "+aluguel.getData_saida());
							System.out.println("Data de entrega: "+aluguel.getData_devolucao());
							System.out.println("Quantidade: "+aluguel.getQuantidade_itens());
							System.out.println("Valor total: "+aluguel.getValor_total());
							System.out.println("Ajuste: "+aluguel.getAjuste());
							System.out.println("Observação: "+aluguel.getObservacao());
						}
					break;
					default:
					}
					
				break;
				case 2: 
					System.out.println("\nOque Voce deseja Incluir?");
					System.out.println("1 - Item");
					System.out.println("2 - Cliente");
					System.out.println("3 - Funcionario");
					System.out.println("4 - Voltar");
					op2 = teclado.nextInt();
					teclado.nextLine();
					switch(op2) {
					case 1:
						System.out.println("Digite o tipo de item: ");
						tipoaux = teclado.nextLine();
						Item = iDAO.buscar(tipoaux);
						if(Item == null) {
							Item = new Itens();
							Item.setTipo(tipoaux);
							
							System.out.println("Digite o tamanho");
							Item.setTamanho(teclado.nextLine());
							
							System.out.println("O item precisa de manuteção?");
							Item.setManutencao(teclado.nextLine());
							
							System.out.println("Qual o valor do item?");
							Item.setValor(teclado.nextFloat());
							
							iDAO.incluir(Item);
						}else {
							System.out.println("Itens já cadastrado no estoque");
						}
					break;
					case 2:
						System.out.println("Digite o cpf do cliente: ");
						cpfaux = teclado.nextLine();
						cliente = clDAO.buscar(cpfaux);
						if(cliente == null) {
							cliente = new Cliente();
							cliente.setCpf(cpfaux);
							System.out.println("Digite o nome do novo cliente: ");
							cliente.setNome(teclado.nextLine());
							
							System.out.println("Digite o cep do novo cliente: ");
							cliente.setCep(teclado.nextInt());
							teclado.nextLine();
							
							System.out.println("Digite o numero da casa do novo cliente: ");
							cliente.setNumero_casa(teclado.nextInt());
							teclado.nextLine();
							
							System.out.println("Digite o telefone do novo cliente: ");
							cliente.setTelefone(teclado.nextLine());
							
							System.out.println("Digite o Email do novo cliente: ");
							cliente.setEmail(teclado.nextLine());
							
							clDAO.incluir(cliente);
						}else {
							System.out.println("Cliente já cadastrado");
						}
					break;
					case 3:
						System.out.println("Digite o cpf do Funcionário: ");
						cpfaux = teclado.nextLine();
						funcionario = fDAO.buscar(cpfaux);
						if(funcionario == null) {
							funcionario = new Funcionario();
							funcionario.setCpf(cpfaux);
							System.out.println("Digite o nome do novo funcionario: ");
							funcionario.setNome(teclado.nextLine());
							
							System.out.println("Digite o cep do novo funcionario: ");
							funcionario.setCep(teclado.nextInt());
							teclado.nextLine();
							
							System.out.println("Digite o numero da casa do novo funcionario: ");
							funcionario.setNumero_casa(teclado.nextInt());
							teclado.nextLine();
							
							System.out.println("Digite o telefone do novo funcionario: ");
							funcionario.setTelefone(teclado.nextLine());
							
							System.out.println("Digite o Email do novo funcionario: ");
							funcionario.setEmail(teclado.nextLine());
							
							System.out.println("Digite o contrato do novo funcionario: ");
							funcionario.setContrato(teclado.nextLine());
							
							System.out.println("Digite o numero da carteira de trabalho do novo funcionario: ");
							funcionario.setCarteira_trab(teclado.nextLine());
							
							fDAO.incluir(funcionario);
						}else {
							System.out.println("Funcionario já cadastrado");
						}
					break;
					default:
					}
				break;
				
				case 3:
					System.out.println("\nOque Voce Deseja Alterar?");
					System.out.println("1 - Item");
					System.out.println("2 - Cliente");
					System.out.println("3 - Funcionario");
					System.out.println("4 - Aluguel");
					System.out.println("5 - Voltar");
					op2 = teclado.nextInt();
					teclado.nextLine();
					switch(op2) {
					case 1:
						System.out.println("Buscando Itens...");
						System.out.println("Digite o id do item: ");
						tipoaux = teclado.nextLine();					
						ItemAux = iDAO.buscar(tipoaux);
						if(ItemAux == null) {
							System.out.println("Itens não encontrados no estoque");
						}else {
							Itens Item1 = new Itens();
							System.out.println("Item encontrado");
							System.out.println("Tipo: "+ItemAux.getTipo());
							System.out.println("Tamanho: "+ItemAux.getTamanho());
							System.out.println("Manutencao: "+ItemAux.getManutencao());
							System.out.println("Valor: "+ItemAux.getValor());
							System.out.println("Digite novo tipo: ");
							Item1.setTipo(teclado.nextLine());
							System.out.println("Digite novo tamanho: ");
							Item1.setTamanho(teclado.nextLine());
							System.out.println("Digite novo Manutenção: ");
							Item1.setManutencao(teclado.nextLine());
							System.out.println("digite o novo valor: ");
							Item1.setValor(teclado.nextFloat());
							iDAO.Alterar(Item1, ItemAux);
							}
					break;
					case 2:
						System.out.println("Buscando Cliente...");
						System.out.println("Digite o cpf do cliente: ");
						cpfaux = teclado.nextLine();
						cliente = clDAO.buscar(cpfaux);
						if(cliente == null) {
							System.out.println("Cliente não encontrado");
						}else {
							cpfaux = cliente.getCpf();
							System.out.println("Cliente encontrado");
							System.out.println("Nome: "+cliente.getNome());
							System.out.println("Cpf: "+cliente.getCpf());
							System.out.println("Cep: "+cliente.getCep());
							System.out.println("Numero da casa: "+cliente.getNumero_casa());
							System.out.println("Telefone: "+cliente.getTelefone());
							System.out.println("Email: "+cliente.getEmail());
							System.out.println("Digite novo nome: ");
							cliente.setNome(teclado.nextLine());
							System.out.println("Digite novo CPF: ");
							cliente.setCpf(teclado.nextLine());
							System.out.println("Digite novo CEP: ");
							cliente.setCep(teclado.nextInt());
							teclado.nextLine();
							System.out.println("Digite novo Numero da casa: ");
							cliente.setNumero_casa(teclado.nextInt());
							teclado.nextLine();
							System.out.println("Digite novo Telefone: ");
							cliente.setTelefone(teclado.nextLine());
							System.out.println("Digite novo Email: ");
							cliente.setEmail(teclado.nextLine());
							clDAO.Alterar(cliente,cpfaux);
						}
					break;
					case 3:
						System.out.println("Buscando Funcionário...");
						System.out.println("Digite o cpf do Funcionário: ");
						cpfaux = teclado.nextLine();
						funcionario = fDAO.buscar(cpfaux);
						if(funcionario == null) {
							System.out.println("Funcionário não encontrado");
						}else {
							cpfaux = funcionario.getCpf();
							System.out.println("Funcionário encontrado");
							System.out.println("Nome: "+funcionario.getNome());
							System.out.println("Cpf: "+funcionario.getCpf());
							System.out.println("Cpf: "+funcionario.getCarteira_trab());
							System.out.println("Cpf: "+funcionario.getContrato());
							System.out.println("Cep: "+funcionario.getCep());
							System.out.println("Numero da casa: "+funcionario.getNumero_casa());
							System.out.println("Telefone: "+funcionario.getTelefone());
							System.out.println("Email: "+funcionario.getEmail());
							System.out.println("Digite novo nome: ");
							funcionario.setNome(teclado.nextLine());
							System.out.println("Digite novo CPF: ");
							funcionario.setCpf(teclado.nextLine());
							System.out.println("Digite novo Carteira de Trabalho: ");
							funcionario.setCarteira_trab(teclado.nextLine());
							System.out.println("Digite novo Contrato: ");
							funcionario.setContrato(teclado.nextLine());
							System.out.println("Digite novo CEP: ");
							funcionario.setCep(teclado.nextInt());
							teclado.nextLine();
							System.out.println("Digite novo Numero da casa: ");
							funcionario.setNumero_casa(teclado.nextInt());
							teclado.nextLine();
							System.out.println("Digite novo Telefone: ");
							funcionario.setTelefone(teclado.nextLine());
							System.out.println("Digite novo Email: ");
							funcionario.setEmail(teclado.nextLine());
							fDAO.Alterar(funcionario, cpfaux);														
						}
					break;
					case 4:
						System.out.println("Para alterar um aluguel...");
						System.out.println("Exclua o aluguel anterior e digite novamente: ");
						System.out.println("No menu 6, exlusivo para Alugueis: ");
					
					}	
					
				break;			
				default:
				case 4:
					System.out.println("\nOque Voce deseja excluir?");
					System.out.println("1 - Item");
					System.out.println("2 - Cliente");
					System.out.println("3 - Funcionario");
					System.out.println("4 - Aluguel");
					System.out.println("5 - Voltar");

					op2 = teclado.nextInt();
					teclado.nextLine();
					switch(op2) {
					case 1:
						System.out.println("Digite o tipo de item: ");
						tipoaux = teclado.nextLine();
						Item = iDAO.buscar(tipoaux);
						if(Item == null) {
							System.out.println("Itens não encontrado");
						}else {
							System.out.println("Todos alugueis relacionados com este item serão apagados: ");
							System.out.println("Você tem certeza disso? 1- sim 2- não ");
							iaux = teclado.nextInt();
							teclado.nextLine();
							if(iaux == 1) {
							System.out.println("Item deletado com sucesso");
							iDAO.Deletar(tipoaux);
							}else if(iaux == 2) {
								System.out.println("Exclusão do item cancelada");
								break;								
							}
						}
					break;
					case 2:
						System.out.println("Digite o cpf do cliente: ");
						cpfaux = teclado.nextLine();
						cliente = clDAO.buscar(cpfaux);
						if(cliente == null) {
							System.out.println("Cliente não encontrado");
						}else {
							System.out.println("Todos alugueis relacionados com este cliente serão apagados: ");
							System.out.println("Você tem certeza disso? 1- sim 2- não ");
							iaux = teclado.nextInt();
							teclado.nextLine();
							if(iaux == 1) {
							System.out.println("Cliente deletado com sucesso");
							clDAO.Deletar(cpfaux);
							}else if(iaux == 2) {
								System.out.println("Exclusão do Cliente cancelada");
								break;
							}
						}
					break;
					case 3:
						System.out.println("Digite o cpf do Funcionário: ");
						cpfaux = teclado.nextLine();
						funcionario = fDAO.buscar(cpfaux);
						if(funcionario == null) {
							System.out.println("Funcionario não encontrado");
						}else {
							System.out.println("Todos alugueis relacionados com este funcionario serão apagados: ");
							System.out.println("Você tem certeza disso? 1- sim 2- não ");
							iaux = teclado.nextInt();
							teclado.nextLine();
							if(iaux == 1) {
							System.out.println("Funcionario deletado com sucesso");
							fDAO.Deletar(cpfaux);
							}else if(iaux == 2) {
								System.out.println("Exclusão do Funcionario cancelada");
								break;
							}							
						}
					break;
					case 4:
						System.out.println("Digite o Codigo do Aluguel que deseja excluir: ");
						codaux = teclado.nextLong();
						aluguel = aDAO.buscar(codaux);
						if(aluguel == null) {
							System.out.println("Aluguel não encontrado");
						}else {
							System.out.println("Todos alugueis serão apagados: ");
							System.out.println("Você tem certeza disso? 1- sim 2- não ");
							iaux = teclado.nextInt();
							teclado.nextLine();
							if(iaux == 1) {
							System.out.println("Aluguel deletado com sucesso");
							aDAO.Deletar(codaux);
							}else if(iaux == 2) {
								System.out.println("Exclusão do Aluguel cancelada");
								break;
							}							
						}
					default:
					}
				break;
				
				case 5:
					System.out.println("\nQual relatório você deseja?");
					System.out.println("1 - Item");
					System.out.println("2 - Cliente");
					System.out.println("3 - Funcionario");
					System.out.println("4 - Aluguel");
					System.out.println("5 - Voltar");
					op2 = teclado.nextInt();
					teclado.nextLine();
					switch(op2) {
					
					case 1:
						System.out.println("Relat�rio de Itens...");
	                    aitens = iDAO.Relatorio();
	                    for(i=0; i<aitens.size(); i++){
	                        System.out.println("-------------------------------");
	                        System.out.println("Informaçòes do Item: ");
							System.out.println("Tipo: "+aitens.get(i).getTipo());
							System.out.println("Tamanho: "+aitens.get(i).getTamanho());
							System.out.println("Manutencao: "+aitens.get(i).getManutencao());
							System.out.println("Valor: R$"+aitens.get(i).getValor());
	                    }
	                    System.out.println("Fim de relat�rio...\n");
	                    break;
	                 
					case 2:
						System.out.println("Relat�rio de Cliente...");
	                    aclientes = clDAO.Relatorio();
	                    for(i=0; i<aclientes.size(); i++){
	                    	System.out.println("-------------------------------");
	                        System.out.println("Informaçòes do Cliente: ");
	                    	System.out.println("Nome: "+aclientes.get(i).getNome());
							System.out.println("Cpf: "+aclientes.get(i).getCpf());
							System.out.println("Cep: "+aclientes.get(i).getCep());
							System.out.println("Numero da casa: "+aclientes.get(i).getNumero_casa());
							System.out.println("Telefone: "+aclientes.get(i).getTelefone());
							System.out.println("Email: "+aclientes.get(i).getEmail());
	                    }
	                    System.out.println("Fim de relat�rio...\n");
	                    break;
					case 3:
						System.out.println("Relat�rio de Funcionário...");
						afuncionarios = fDAO.Relatorio();
	                    for(i=0; i<afuncionarios.size(); i++){
	                        System.out.println("-------------------------------");
	                        System.out.println("Funcionário encontrado");
							System.out.println("Nome: "+afuncionarios.get(i).getNome());
							System.out.println("Cpf: "+afuncionarios.get(i).getCpf());
							System.out.println("Carteira de trab: "+afuncionarios.get(i).getCarteira_trab());
							System.out.println("Contrato: "+afuncionarios.get(i).getContrato());
							System.out.println("Cep: "+afuncionarios.get(i).getCep());
							System.out.println("Numero da casa: "+afuncionarios.get(i).getNumero_casa());
							System.out.println("Telefone: "+afuncionarios.get(i).getTelefone());
							System.out.println("Email: "+afuncionarios.get(i).getEmail());
	                    }
	                    System.out.println("Fim de relat�rio...\n");
	                    break;
					case 4:
						System.out.println("Relatório de Aluguel...");
						alugueis = aDAO.Relatorio();
						aluguel = null;
	                    for(i=0; i<alugueis.size(); i++){
	                        System.out.println("-------------------------------");
	                        System.out.println("Aluguel encontrado: ");
							System.out.println("Codigo: "+alugueis.get(i).getCodigo());
							System.out.println("Cpf cliente: "+alugueis.get(i).getFk_cliente().getCpf());
							System.out.println("Cpf funcionario: "+alugueis.get(i).getFk_funcionario().getCpf());
							ialista = iaDAO.RelatorioDeItens(alugueis.get(i).getCodigo());
		                    
							for(o=0; o<ialista.size(); o++){
		                    	Item = iDAO.buscar(ialista.get(o).getFk_itens().getTipo());
		                    	System.out.println("Tipo: "+Item.getTipo());
								System.out.println("Tamanho: "+Item.getTamanho());
								System.out.println("Manutencao: "+Item.getManutencao());
								System.out.println("Valor: R$"+Item.getValor());
		                    }
							System.out.println("Data de saida: "+alugueis.get(i).getData_saida());
							System.out.println("Data de entrega: "+alugueis.get(i).getData_devolucao());
							System.out.println("Quantidade: "+alugueis.get(i).getQuantidade_itens());
							System.out.println("Valor total: "+alugueis.get(i).getValor_total());
							System.out.println("Ajuste: "+alugueis.get(i).getAjuste());
							System.out.println("Observação: "+alugueis.get(i).getObservacao());
	                    }
	                    System.out.println("Fim de relat�rio...\n");
	                    break;
						default:
					}
					break;
				
				case 6:
					System.out.println("\nCadastrar um novo aluguel");
	                System.out.println("\nDigite o CPF do Cliente");
	                cpfaux = teclado.nextLine();
	                cliente = clDAO.buscar(cpfaux);
	                if(cliente == null) {
	                        System.out.println("Cliente não encontrado, por favor cadastrar cliente");
	                }else {
	                	System.out.println("\nDigite o CPF do Funcionario");
	                	funcionario = fDAO.buscar(teclado.nextLine());
	                	if(funcionario == null) {
	                		System.out.println("Funcionario não encontrado, por favor cadastrar Funcionario");
	                	}else {
	                		aluguel = new Aluguel();
	                		System.out.println("\nDigite a data de saída");
	                		aluguel.setData_saida(teclado.nextLine());
	                		System.out.println("\nDigite a forma de pagamento");
	                		aluguel.setForma_pagamento(teclado.nextLine());
	                		System.out.println("\nDigite a Quantidade de itens");
	                		aluguel.setQuantidade_itens(teclado.nextInt());
	                		teclado.nextLine();
	                		System.out.println("\nDigite a data de devolução");
	                		aluguel.setData_devolucao(teclado.nextLine());
	                		System.out.println("\nDigite o tipo de ajuste");
	                		aluguel.setAjuste(teclado.nextLine());
	                		System.out.println("\nObservações");
	                		aluguel.setObservacao(teclado.nextLine());                           
	                		codigoRandom = codigoRandomAux.nextLong()*100;
	                		if (codigoRandom < 0) {
	                			codigoRandom = codigoRandom * -1;
	                		}
	                		System.out.println("---------------------------------");
	                		System.out.println("Codigo do aluguel: "+codigoRandom);
	                		aluguel.setCodigo(codigoRandom);
	                		aDAO.incluir(aluguel, cliente, funcionario);
	                		do {
	                			System.out.println("\nDigite o codigo Item a ser alugado");
	                			Item = iDAO.buscar(teclado.nextLine());
	                			if(Item == null) {
	                				System.out.println("Item não encontrado!");
	                				break;
	                			}else {
	                				itens_alugados = new Itens_alugados();
	                                	
	                				codigoRandom = codigoRandomAux.nextLong()*100;
	                				if (codigoRandom < 0) {
	                					codigoRandom = codigoRandom * -1;
	                				}
	                				itens_alugados.setCodigo(codigoRandom);
	    	    						
	                				iaDAO.incluir(itens_alugados,Item, aluguel);
	                				aluguel.setValor_total(Item.getValor());
	                				System.out.println("Deseja adicionar outro item? Sim-1 ou Nao-0?");
	                				contaux = teclado.nextInt();
	                				teclado.nextLine();
	                				if(contaux == 1) {
	                					continuar = true;
	                				}else {
	                					break;
	                				}
	                			}                                       
	                		}while(continuar = true);
	                	}
	                }
	                break;
			}	
		}while(op!=7);
     }
}