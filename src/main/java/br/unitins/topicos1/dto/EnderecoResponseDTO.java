package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Cidade;
import br.unitins.topicos1.model.Endereco;

public record EnderecoResponseDTO(
        Long id,
        Cidade cidade,
        String bairro,
        String quadra,
        String rua,
        String lote) {
    public static EnderecoResponseDTO valueOf(Endereco endereco) {
        return new EnderecoResponseDTO(
                endereco.getId(),
                endereco.getCidade(),
                endereco.getBairro(),
                endereco.getQuadra(),
                endereco.getRua(),
                endereco.getLote());
    }
}