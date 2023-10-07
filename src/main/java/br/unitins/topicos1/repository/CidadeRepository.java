package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Cidade;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CidadeRepository implements PanacheRepository<Cidade> {
    public List<Cidade> findByNome(String cidade) {
        return find("UPPER(cidade) LIKE UPPER(?1)", "%" + cidade + "%").list();
    }
}
