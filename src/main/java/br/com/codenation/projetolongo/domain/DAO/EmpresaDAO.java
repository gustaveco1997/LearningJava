package br.com.codenation.projetolongo.domain.DAO;

import br.com.codenation.projetolongo.domain.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

@Repository
public interface EmpresaDAO extends JpaRepository<Empresa, Long> {//Long é a chave primária

    //@Query("SELECT e FROM Company WHERE c.name like :name ORDER BY name")
    //List<Empresa> findByName(@PathParam("name") String name);
    //findAllByNameByOrderBy

/*

@Query("SELECT e FROM Empresa where c.name)
    @Modifying
    @Query(value = "INSERT INTO company (name, document, vacancies, site) VALUES (:name, :document, :vacancies, :site)", nativeQuery = true)
    Empresa salvar(@PathParam("name") String name,
                   @PathParam("document") String document,
                   @PathParam("vacancies") int vacancies,
                   @PathParam("site") String site);

    @Modifying
    @Query("DELETE FROM company WHERE id = :id")
    void deletar(@PathParam("id") Long id);*/

}
