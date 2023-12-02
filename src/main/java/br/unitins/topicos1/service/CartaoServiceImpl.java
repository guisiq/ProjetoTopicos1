package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.CartaoDTO;
import br.unitins.topicos1.dto.CartaoResponseDTO;
import br.unitins.topicos1.model.Cartao;

import br.unitins.topicos1.repository.CartaoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CartaoServiceImpl implements CartaoService {


    @Inject
    CartaoRepository repository;

    @Override
    @Transactional
    public CartaoResponseDTO insert(CartaoDTO dto){
        Cartao novoCartao = new Cartao();
        novoCartao.setNome(dto.getNome());
        novoCartao.setNumero(dto.getNumero());
        novoCartao.setDataValidade(dto.getDataValidade());
        novoCartao.setBandeiraCartao(dto.getBandeiraCartao());
        novoCartao.setCvc(dto.getCvc());

        repository.persist(novoCartao);

        return CartaoResponseDTO.valueOf(novoCartao);
    }

    @Override
    @Transactional
    public CartaoResponseDTO update(CartaoDTO dto, Long id){

        Cartao Cartao = repository.findById(id);
        if(Cartao != null ){
            Cartao.setNome(dto.getNome());
            Cartao.setNumero(dto.getNumero());
            Cartao.setDataValidade(dto.getDataValidade());
            Cartao.setBandeiraCartao(dto.getBandeiraCartao());
            Cartao.setCvc(dto.getCvc());
        } else
            throw new NotFoundException();

        return CartaoResponseDTO.valueOf(Cartao);
    }
    
    @Override
    @Transactional
    public void delete(Long id){
        if(!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public CartaoResponseDTO findById(Long id){
        return CartaoResponseDTO.valueOf(repository.findById(id));
    }

    @Override 
    public List<CartaoResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
        .map(e -> CartaoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<CartaoResponseDTO> findByAll(){
        return repository.listAll().stream()
            .map(e -> CartaoResponseDTO.valueOf(e)).toList();
    }

    
}
