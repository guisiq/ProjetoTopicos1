package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ProdutoDTO;
import br.unitins.topicos1.dto.ProdutoResponseDTO;
import br.unitins.topicos1.model.Produto;
import br.unitins.topicos1.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ProdutoServiceImpl implements ProdutoService {

    @Inject
    ProdutoRepository repository;

    @Override
    @Transactional
    public ProdutoResponseDTO insert(ProdutoDTO dto){
        Produto novoProduto = new Produto();
        novoProduto.setNome(dto.getNome());
        novoProduto.setTipo(dto.getTipo());
        novoProduto.setEstoque(dto.getEstoque());
        novoProduto.setPreco(dto.getPreco());

        repository.persist(novoProduto);
        return ProdutoResponseDTO.valueOf(novoProduto);
    }

    @Override
    @Transactional
    public ProdutoResponseDTO update(ProdutoDTO dto, Long id){

        Produto produto = repository.findById(id);
        if(produto != null ){
            produto.setNome(dto.getNome());
            produto.setTipo(dto.getTipo());
            produto.setEstoque(dto.getEstoque());
            produto.setPreco(dto.getPreco());
        } else
            throw new NotFoundException();

        return ProdutoResponseDTO.valueOf(produto);

        
    }

     @Override
    @Transactional
    public ProdutoResponseDTO updateNomeImagem(Long id, String nomeImagem) {
        Produto produto = repository.findById(id);
        produto.setNomeImagem(nomeImagem);
        return ProdutoResponseDTO.valueOf(produto);
    }
    
    @Override
    @Transactional
    public void delete(Long id){
        if(!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public ProdutoResponseDTO findById(Long id){
        return ProdutoResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<ProdutoResponseDTO> findByEstoque(Integer estoque){
        return repository.findByEstoque(estoque).stream()
        .map(e -> ProdutoResponseDTO.valueOf(e)).toList();
    }

    

    @Override 
    public List<ProdutoResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
        .map(e -> ProdutoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ProdutoResponseDTO> findByAll(){
        return repository.listAll().stream()
            .map(e -> ProdutoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public ProdutoResponseDTO findById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

}

