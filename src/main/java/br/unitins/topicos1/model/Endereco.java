package br.unitins.topicos1.model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Endereco extends DefaultEntity {

    @ManyToOne
    private Cidade cidade;
    private String bairro;
    private String quadra;
    private String rua;
    private String lote;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getQuadra() {
        return quadra;
    }

    public void setQuadra(String quadra) {
        this.quadra = quadra;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

}