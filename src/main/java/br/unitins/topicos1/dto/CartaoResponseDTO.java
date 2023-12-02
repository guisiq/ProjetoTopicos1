package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.BandeiraCartao;
import br.unitins.topicos1.model.Cartao;
import jakarta.persistence.Enumerated;



public record CartaoResponseDTO(
    Long id,
    String nome,
    @Enumerated BandeiraCartao bandeiraCartao,
    Integer Cvc,
    String numero
    
)  { 
    public static CartaoResponseDTO valueOf(Cartao Cartao){
        return new CartaoResponseDTO(
            Cartao.getId(), 
            Cartao.getNome(),
            Cartao.getBandeiraCartao(),
            Cartao.getCvc(),
            Cartao.getNumero()
        );
    }
}

