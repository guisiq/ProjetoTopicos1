package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Estado;
import jakarta.validation.constraints.NotBlank;

public class CidadeDTO {

    @NotBlank(message = "O campo nome não pode ser nulo.")
    private final String nome;
    private final Estado estado;

    // CONSTRUTOR PADRÃO
    public CidadeDTO(@NotBlank(message = "O campo nome não pode ser nulo.") String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;

    }

    // GETTERS
    public String getNome() {
        return nome;
    }

    public Estado getEstado() {
        return estado;
    }

    // HASHCODE
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
        return result;
    }

    // EQUALS
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CidadeDTO other = (CidadeDTO) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (estado == null) {
            if (other.estado != null)
                return false;
        } else if (!estado.equals(other.estado))
            return false;
        return true;
    }

}
