package br.com.codenation.projetolongo.service.interfaces;

import br.com.codenation.projetolongo.domain.entity.Usuario;

public interface UsuarioService {

    Usuario salvar(Usuario usuario);

    void deletar(Usuario usuario);
}
