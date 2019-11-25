package br.com.codenation.projetolongo.domain.DAO;

import br.com.codenation.projetolongo.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE user u SET u.name = :nomeAlterado WHERE u.id = :usuario_id ", nativeQuery = true)
    void updateNameFromId(@Param("usuario_id") Long usuarioId, @Param("nomeAlterado") String nomeAlterado);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user u SET u.salario = :salario " +
            " WHERE u.id = :id", nativeQuery = true)
    void updateSalarioFromId(@Param("id") Long id, @Param("salario") BigDecimal salario);

    @Query(value = "SELECT * FROM user u WHERE u.login = :login LIMIT 1", nativeQuery = true)
    Usuario findByUsername(@Param("login") String login);

    @Override
    Optional<Usuario> findById(Long aLong);

    @Override
    <S extends Usuario> S save(S s);

    @Override
    void deleteById(Long aLong);

    /*
    @Modifying
    @Query("DELETE FROM user WHERE id=:id")
    Empresa deletar(@PathParam("id") Long id);*/
}
