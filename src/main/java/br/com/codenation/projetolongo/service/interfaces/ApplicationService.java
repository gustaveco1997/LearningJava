package br.com.codenation.projetolongo.service.interfaces;

import br.com.codenation.projetolongo.domain.entity.Empresa;
import br.com.codenation.projetolongo.domain.entity.Usuario;

import java.util.List;

public interface ApplicationService {

    Usuario inserirUsuario(Usuario usuario);
    Empresa findEmpresa(Long idEmpresa);
    List<Usuario> findUsuariosEmpresa(Long idEmpresa);
    void inserirUsuarioEmpresa(Usuario usuario);
    Empresa inserirEmpresa(Empresa empresa);
    void  setDadosFromArquivos();
    void  popularBanco();

    List<Empresa> showMaiorSalarioCadaEmpresa();
    List<Empresa> showMediaSalarialCadaEmpresa();
    List<Empresa> showFolhaPagamentoCadaEmpresa();

    double showMediaIdade();
    List<Empresa> showUsuariosOdenadosIdadeCadaEmpresa();
}
