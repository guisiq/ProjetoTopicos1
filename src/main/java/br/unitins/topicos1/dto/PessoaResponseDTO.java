package br.unitins.topicos1.dto;

import java.time.LocalDate;
import java.util.List;

import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.model.Pessoa;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.model.Usuario;

public record PessoaResponseDTO(
                String nome,
                String cpf,
                LocalDate dataNascimento,
                List<Telefone> listaTelefone,
                Endereco endereco,
                Usuario usuario) {
        public static PessoaResponseDTO valueOf(Pessoa pessoa) {
                return new PessoaResponseDTO(
                                pessoa.getNome(),
                                pessoa.getCpf(),
                                pessoa.getDataNascimento(),
                                pessoa.getListaTelefone(),
                                pessoa.getEndereco(),
                                pessoa.getUsuario());
        }
}