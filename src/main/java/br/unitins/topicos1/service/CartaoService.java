package br.unitins.topicos1.service;
import java.util.List;

import br.unitins.topicos1.dto.CartaoDTO;
import br.unitins.topicos1.dto.CartaoResponseDTO;

public interface CartaoService {
    
    public CartaoResponseDTO insert(CartaoDTO dto);

    public CartaoResponseDTO update(CartaoDTO dto, Long id);

    public void delete(Long id);

    public CartaoResponseDTO findById(Long id);

    public List<CartaoResponseDTO> findByNome(String nome);

    public List<CartaoResponseDTO> findByAll(); 
}
