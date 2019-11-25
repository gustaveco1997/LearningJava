package br.com.codenation.projetolongo.domain.DAO;

import br.com.codenation.projetolongo.domain.entity.Empresa;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaDAO extends JpaRepository<Empresa, Long> {//Long é a chave primária

    @Override
    Optional<Empresa> findById(Long aLong);

    @Query(value = "SELECT e FROM Empresa e WHERE e.name = :name ")
    List<Empresa> findByName(@PathParam("name") String name);


    @Transactional
    @Modifying
    @Query(value = "UPDATE company e SET e.vagas = :vagas " +
            " WHERE e.id = :id", nativeQuery = true)
    void updateVagasFromId(@Param("id") Long id, @Param("vagas") int vagas);


    //List<Empresa> findAllByNameByOrderByName(@PathParam("name") String name);



    @Override
    <S extends Empresa> S save(S s);

    @Override
    void deleteById(Long aLong);
}
