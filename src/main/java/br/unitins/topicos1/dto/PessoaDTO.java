package br.unitins.topicos1.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class PessoaDTO {

    @NotBlank(message = "O campo nome não pode ser nulo")
    private String nome;

    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$",
        message = "O campo CPF deve estar formulado: 000.000.000-00")
    private String cpf;

    private LocalDate dataNascimento;  // Formatado para string
    private Endereco endereco;
    private List<Telefone> listaTelefone;
    private Usuario usuario;
 

    public String getDataNascimentoFormatted() {
        if (dataNascimento != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return dataNascimento.format(formatter);
        } else {
            return null;
        }
    }

    //CONSTRUTOR PADRÃO
    public PessoaDTO(@NotBlank(message = "O campo nome não pode ser nulo") String nome,
            @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$", message = "O campo CPF deve estar formulado: 000.000.000-00") String cpf,
            LocalDate dataNascimento, List<Telefone> listaTelefone, Endereco endereco, Usuario usuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.listaTelefone = listaTelefone;
        this.endereco = endereco;
        this.usuario = usuario;
    }


    //GETTERS E SETTERS
  public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public List<Telefone> getListaTelefone() {
        return listaTelefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    //HASH CODE
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
        result = prime * result + ((listaTelefone == null) ? 0 : listaTelefone.hashCode());
        result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
        return result;
    }

  
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PessoaDTO other = (PessoaDTO) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (dataNascimento == null) {
            if (other.dataNascimento != null)
                return false;
        } else if (!dataNascimento.equals(other.dataNascimento))
            return false;
        if (listaTelefone == null) {
            if (other.listaTelefone != null)
                return false;
        } else if (!listaTelefone.equals(other.listaTelefone))
            return false;
        if (endereco == null) {
            if (other.endereco != null)
                return false;
        } else if (!endereco.equals(other.endereco))
            return false;
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        return true;
    }



}