package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Cidade;

public class EnderecoDTO {

    private Cidade cidade;
    private String bairro;
    private String quadra;
    private String rua;
    private String lote;

    public EnderecoDTO(Cidade cidade, String bairro, String quadra, String rua, String lote) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.quadra = quadra;
        this.rua = rua;
        this.lote = lote;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getQuadra() {
        return quadra;
    }

    public String getRua() {
        return rua;
    }

    public String getLote() {
        return lote;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
        result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
        result = prime * result + ((quadra == null) ? 0 : quadra.hashCode());
        result = prime * result + ((rua == null) ? 0 : rua.hashCode());
        result = prime * result + ((lote == null) ? 0 : lote.hashCode());
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
        EnderecoDTO other = (EnderecoDTO) obj;
        if (cidade == null) {
            if (other.cidade != null)
                return false;
        } else if (!cidade.equals(other.cidade))
            return false;
        if (bairro == null) {
            if (other.bairro != null)
                return false;
        } else if (!bairro.equals(other.bairro))
            return false;
        if (quadra == null) {
            if (other.quadra != null)
                return false;
        } else if (!quadra.equals(other.quadra))
            return false;
        if (rua == null) {
            if (other.rua != null)
                return false;
        } else if (!rua.equals(other.rua))
            return false;
        if (lote == null) {
            if (other.lote != null)
                return false;
        } else if (!lote.equals(other.lote))
            return false;
        return true;
    }

}