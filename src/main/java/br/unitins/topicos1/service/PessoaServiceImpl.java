package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.PessoaDTO;
import br.unitins.topicos1.dto.PessoaResponseDTO;
import br.unitins.topicos1.model.Pessoa;
import br.unitins.topicos1.repository.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PessoaServiceImpl implements PessoaService {

    @Inject
    PessoaRepository repository;

    @Override
    @Transactional
    public PessoaResponseDTO insert(PessoaDTO dto) {
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome(dto.getNome());
        novaPessoa.setCpf(dto.getCpf());
        novaPessoa.setDataNascimento(dto.getDataNascimento());
        novaPessoa.setEndereco(dto.getEndereco());
        novaPessoa.setListaTelefone(dto.getListaTelefone());
        novaPessoa.setUsuario(dto.getUsuario());

        repository.persist(novaPessoa);

        return PessoaResponseDTO.valueOf(novaPessoa);
    }

    @Override
    @Transactional
    public PessoaResponseDTO update(PessoaDTO dto, Long id) {

        Pessoa pessoa = repository.findById(id);
        if (pessoa != null) {
            pessoa.setNome(dto.getNome());
            pessoa.setCpf(dto.getCpf());
            pessoa.setDataNascimento(dto.getDataNascimento());
            pessoa.setEndereco(dto.getEndereco());
            pessoa.setListaTelefone(dto.getListaTelefone());
            pessoa.setUsuario(dto.getUsuario());
        } else
            throw new NotFoundException();

        return PessoaResponseDTO.valueOf(pessoa);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public PessoaResponseDTO findById(Long id) {
        return PessoaResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<PessoaResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> PessoaResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PessoaResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> PessoaResponseDTO.valueOf(e)).toList();
    }

}