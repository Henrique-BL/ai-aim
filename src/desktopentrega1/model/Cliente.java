package desktopentrega1.model;

import java.io.Serializable;

public class Cliente implements Serializable{
    private static long serialVersionUID = 1L;
    private String cpf;
    private String cep;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;
    
    public Cliente(){
        
    }
    public Cliente(String nome, String cpf, String email, String telefone, String endereco, String cep) {
        this.cpf = cpf;
        this.cep = cep;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }
    

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    //Retorna a string que será escrita no arquivo de texto
    @Override
    public String toString() {
        return   nome + "-" + cpf+ "-" + email + "-" + telefone +
                "-" + endereco + "-" + cep+"\n";
    }

}
