package br.com.codenation.projetolongo.domain.DAO;

import br.com.codenation.projetolongo.domain.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoDAO extends JpaRepository<Endereco, Long> {

}
