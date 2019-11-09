package br.com.codenation.projetolongo.domain.DAO;

import br.com.codenation.projetolongo.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
    /*@Modifying
    @Query("INSERT INTO user (name, document, age, login, password, company_id, salary ) VALUES (:name, :document, :age, :login, :password, :company, :salary)")
    Empresa salvar(@PathParam("name") String name,
                   @PathParam("document") String document,
                   @PathParam("age") String age,
                   @PathParam("login") String login,
                   @PathParam("password") String password,
                   @PathParam("company") String company,
                   @PathParam("salary") String salary);

    @Modifying
    @Query("DELETE FROM user WHERE id=:id")
    Empresa deletar(@PathParam("id") Long id);*/
}
