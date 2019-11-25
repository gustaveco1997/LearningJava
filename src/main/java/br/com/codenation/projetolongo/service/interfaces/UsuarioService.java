package br.com.codenation.projetolongo.service.interfaces;

import br.com.codenation.projetolongo.domain.entity.Usuario;

import java.math.BigDecimal;

public interface UsuarioService {

    Usuario salvar(Usuario usuario);

    void updateUser(Usuario usuario);

    void deletar(Usuario usuario);

    Usuario findById(Long id);

    void deleteById(Long id);

    void updateSalario(Long id, BigDecimal salario);

    Usuario findByUserName(String username);
}
