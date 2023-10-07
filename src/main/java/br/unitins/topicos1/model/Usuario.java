package br.unitins.topicos1.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Usuario extends DefaultEntity {

    private String login;
    
    @NotBlank(message = "O campo não pode ser nulo")
    private String senha;

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