package br.unitins.topicos1.dto;


import br.unitins.topicos1.model.Produto;


public record ProdutoResponseDTO(
    Long id,
    String nome,
    String tipo,
    Double preco,
    String nomeImagem,
    Integer estoque


) { 
    public static ProdutoResponseDTO valueOf(Produto produto){
        return new ProdutoResponseDTO(
            produto.getId(), 
            produto.getNome(),
            produto.getTipo(),
            produto.getPreco(),
            produto.getNomeImagem(),
            produto.getEstoque()


        );
    }
}