package br.unitins.topicos1.dto;


import br.unitins.topicos1.model.BandeiraCartao;
import jakarta.validation.constraints.NotBlank;


public class CartaoDTO {

    @NotBlank(message = "O campo nome não pode ser nulo")
    private String nome;

    
    private String numero;
    private String dataValidade ;
    private BandeiraCartao bandeiraCartao;
    private Integer cvc;

    // CONSTRUTOR PADRÃO
    public CartaoDTO(@NotBlank(message = "O campo nome não pode ser nulo") String nome, String numero, String dataValidade,
           BandeiraCartao bandeiraCartao, Integer cvc) {
        this.nome = nome;
        this.dataValidade = dataValidade;
        this.numero = numero;
        this.cvc = cvc;
        this.bandeiraCartao = bandeiraCartao;

    }

    // GETTERS E SETTERS
public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public BandeiraCartao getBandeiraCartao() {
        return bandeiraCartao;
    }

    public void setBandeiraCartao(BandeiraCartao bandeiraCartao) {
        this.bandeiraCartao = bandeiraCartao;
    }

    public Integer getCvc() {
        return cvc;
    }

    public void setCvc(Integer cvc) {
        this.cvc = cvc;
    }

    // HASH CODE
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        result = prime * result + ((cvc == null) ? 0 : cvc.hashCode());
        result = prime * result + ((bandeiraCartao == null) ? 0 : bandeiraCartao.hashCode());
        result = prime * result + ((dataValidade == null) ? 0 : dataValidade.hashCode());
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
        CartaoDTO other = (CartaoDTO) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        if (cvc == null) {
            if (other.cvc != null)
                return false;
        } else if (!cvc.equals(other.cvc))
            return false;
        if (bandeiraCartao == null) {
            if (other.bandeiraCartao != null)
                return false;
        } else if (!bandeiraCartao.equals(other.bandeiraCartao))
            return false;
            if (dataValidade == null) {
            if (other.dataValidade != null)
                return false;
        } else if (!dataValidade.equals(other.dataValidade))
            return false;

        return true;
    }

}