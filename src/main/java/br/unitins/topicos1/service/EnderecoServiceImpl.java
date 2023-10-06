package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.EnderecoDTO;
import br.unitins.topicos1.dto.EnderecoResponseDTO;
import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.repository.EnderecoRespository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class EnderecoServiceImpl implements EnderecoService {

    @Inject
    EnderecoRespository repository;

    @Override
    @Transactional
    public EnderecoResponseDTO insert(EnderecoDTO dto) {
        Endereco novoEndereco = new Endereco();
        novoEndereco.setBairro(dto.getBairro());
        novoEndereco.setQuadra(dto.getQuadra());
        novoEndereco.setLote(dto.getLote());
        novoEndereco.setRua(dto.getRua());

        repository.persist(novoEndereco);

        return EnderecoResponseDTO.valueOf(novoEndereco);
    }

    @Override
    @Transactional
    public EnderecoResponseDTO update(EnderecoDTO dto, Long id) {

        Endereco endereco = repository.findById(id);
        if (endereco != null) {
            endereco.setBairro(dto.getBairro());
            endereco.setQuadra(dto.getQuadra());
            endereco.setLote(dto.getLote());
            endereco.setRua(dto.getRua());
        } else
            throw new NotFoundException();

        return EnderecoResponseDTO.valueOf(endereco);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public EnderecoResponseDTO findById(Long id) {
        return EnderecoResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<EnderecoResponseDTO> findByNome(String bairro) {
        return repository.findByNome(bairro).stream()
                .map(e -> EnderecoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<EnderecoResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> EnderecoResponseDTO.valueOf(e)).toList();
    }

}