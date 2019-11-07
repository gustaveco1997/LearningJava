package br.com.codenation.projetolongo.controller;

import br.com.codenation.projetolongo.entity.Empresa;
import br.com.codenation.projetolongo.entity.FolhaPagamento;
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
    public List<Empresa> showMaiorSalarioCadaEmpresa() {
        return service.showMaiorSalarioCadaEmpresa();
    }

    @Override
    public List<Empresa> showMediaSalarialCadaEmpresa() {
        return service.showMediaSalarialCadaEmpresa();
    }

    @Override
    public List<Empresa> showFolhaPagamentoCadaEmpresa() {
        return service.showFolhaPagamentoCadaEmpresa();
    }

    @Override
    public double showMediaIdade() {
        return service.showMediaIdade();
    }

    @Override
    public List<Empresa> showUsuariosOdenadosIdadeCadaEmpresa() {
        return service.showUsuariosOdenadosIdadeCadaEmpresa();
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
        return service.findUsuariosFromEmpresa(idEmpresa);
    }

    @Override
    public void inserirUsuarioEmpresa(Usuario usuario) {
        service.inserirUsuarioEmpresa(usuario);
    }

    @Override
    public Empresa inserirEmpresa(Empresa empresa) {
        return service.insertEmpresa(empresa);
    }


}
