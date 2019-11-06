package br.com.codenation.projetolongo.controller;

import br.com.codenation.projetolongo.entity.Empresa;
import br.com.codenation.projetolongo.entity.Usuario;
import br.com.codenation.projetolongo.service.AplicacaoService;
import br.com.codenation.projetolongo.service.FileStreamService;
import br.com.codenation.projetolongo.service.interfaces.ApplicationServiceImpl;

import java.util.List;

public class AplicacaoController implements ApplicationServiceImpl {

    private AplicacaoService service = new AplicacaoService();
    private FileStreamService fileService = new FileStreamService();


    @Override
    public void setDadosFromArquivos() {
        List<Empresa> empresas = fileService.lerArquivoEmpresa();
        List<Usuario> usuarios = fileService.lerArquivoUsuario();
        service.setDadosUsuariosEmpresas(usuarios, empresas);

    }

    @Override
    public void showMaiorSalarioCadaEmpresa() {
        service.showMaiorSalarioCadaEmpresa();
    }

    @Override
    public void showMediaSalarialCadaEmpresa() {
        service.showMediaSalarialCadaEmpresa();
    }

    @Override
    public void showFolhaPagamentoCadaEmpresa() {
        service.showFolhaPagamentoCadaEmpresa();
    }

    @Override
    public void showMediaIdade() {
        service.showMediaIdade();
    }

    @Override
    public void showUsuariosOdenadosIdadeCadaEmpresa() {
        service.showUsuariosOdenadosIdadeCadaEmpresa();
    }

    @Override
    public Usuario inserirUsuario(Usuario usuario) {
        return service.insertUsuario(usuario);
    }

    @Override
    public Empresa findEmpresa(Long idEmpresa) {
        return service.findEmpresaById(idEmpresa);
    }

    @Override
    public List<Usuario> findUsuariosEmpresa(Long idEmpresa) {
        return findUsuariosEmpresa(idEmpresa);
    }

    @Override
    public void inserirUsuarioEmpresa(Usuario usuario) {
        inserirUsuarioEmpresa(usuario);
    }

    @Override
    public Empresa inserirEmpresa(Empresa empresa) {
        return service.insertEmpresa(empresa);
    }


}
