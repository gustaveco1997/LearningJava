package br.com.codenation.projetolongo.controller;

import br.com.codenation.projetolongo.domain.entity.Empresa;
import br.com.codenation.projetolongo.domain.entity.Usuario;
import br.com.codenation.projetolongo.service.AplicacaoService;
import br.com.codenation.projetolongo.service.EmpresaServiceImpl;
import br.com.codenation.projetolongo.service.FileStreamService;
import br.com.codenation.projetolongo.service.UsuarioServiceImpl;
import br.com.codenation.projetolongo.service.interfaces.ApplicationService;

import java.util.List;

public class AplicacaoController implements ApplicationService {

    private AplicacaoService service = new AplicacaoService();
    private EmpresaServiceImpl empresaService = new EmpresaServiceImpl();
    private UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();
    private FileStreamService fileService = new FileStreamService();

    @Override
    public Usuario inserirUsuario(Usuario usuario) {
        return usuarioService.salvar(usuario);

    }

    @Override
    public Empresa findEmpresa(Long idEmpresa) {
        return null;
    }

    @Override
    public List<Usuario> findUsuariosEmpresa(Long idEmpresa) {
        return null;
    }

    @Override
    public void inserirUsuarioEmpresa(Usuario usuario) {

    }

    @Override
    public Empresa inserirEmpresa(Empresa empresa) {
        return empresaService.salvar(empresa);
    }

    @Override
    public void setDadosFromArquivos() {

    }

    @Override
    public void popularBanco() {

    }

    @Override
    public List<Empresa> showMaiorSalarioCadaEmpresa() {
        return null;
    }

    @Override
    public List<Empresa> showMediaSalarialCadaEmpresa() {
        return null;
    }

    @Override
    public List<Empresa> showFolhaPagamentoCadaEmpresa() {
        return null;
    }

    @Override
    public double showMediaIdade() {
        return 0;
    }

    @Override
    public List<Empresa> showUsuariosOdenadosIdadeCadaEmpresa() {
        return null;
    }


    /*@Override
    public void setDadosFromArquivos() {
        List<Empresa> empresas = fileService.lerArquivoEmpresa();
        List<Usuario> usuarios = fileService.lerArquivoUsuario();
        service.setDadosUsuariosEmpresas(usuarios, empresas);
    }

    @Override
    public void popularBanco() {

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
*/

}
