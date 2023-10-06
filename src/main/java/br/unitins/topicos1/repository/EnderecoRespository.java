package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Endereco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EnderecoRespository implements PanacheRepository<Endereco> {
    public List<Endereco> findByNome(String bairro) {
        return find("UPPER(bairro) LIKE UPPER(?1)", "%" + bairro + "%").list();
    }
}
