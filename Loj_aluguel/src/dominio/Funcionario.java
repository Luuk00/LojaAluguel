package dominio;

public class Funcionario {



    private String nome;
    private String cpf;
    private String carteira_trab;
    private String contrato;
    private int cep;
    private int numero_casa;
    private String telefone;
    private String email;

    public Funcionario() {

    }

    public Funcionario(String nome, String cpf, String carteira_trab, String contrato, int cep, int numero_casa, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.carteira_trab = carteira_trab;
        this.contrato = contrato;
        this.cep = cep;
        this.numero_casa = numero_casa;
        this.telefone = telefone;
        this.email = email;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getCarteira_trab() {
        return carteira_trab;
    }
    public void setCarteira_trab(String carteira_trab) {
        this.carteira_trab = carteira_trab;
    }
    public String getContrato() {
        return contrato;
    }
    public void setContrato(String contrato) {
        this.contrato = contrato;
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