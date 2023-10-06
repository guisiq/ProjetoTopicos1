package br.unitins.topicos1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario extends DefaultEntity {

    @OneToOne
    private Pessoa pessoa;
    private String nome;
    private String login;
    private String senha;




    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }     
}