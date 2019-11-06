package br.com.codenation.projetolongo.service;

import br.com.codenation.projetolongo.entity.Empresa;
import br.com.codenation.projetolongo.entity.FolhaPagamento;
import br.com.codenation.projetolongo.entity.Usuario;
import br.com.codenation.projetolongo.exception.MyExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AplicacaoService {
    Logger LOG = LoggerFactory.getLogger(AplicacaoService.class);

    private List<Usuario> usuarios = new ArrayList<>();
    private List<Empresa> empresas = new ArrayList<>();

    /*PRINTS*/
    public void showMaiorSalarioCadaEmpresa() {
        LOG.info("\n#### -- MAIOR SALARIO POR EMPRESA");
        empresas.forEach(empresa -> {
            LOG.info("#### EMPRESA: {} - R$ {}", empresa.getName(), getMaiorSalarioPorEmpresa(empresa.getId()));
        });
    }

    public void showMediaSalarialCadaEmpresa() {
        LOG.info("\n#### -- MÉDIA SALARIAL");



        empresas.forEach(empresa -> {
            LOG.info("#### EMPRESA: {} - R$ {}", empresa.getName(), getMediaSalarialEmpresa(empresa.getId()));
        });
    }

    public List<FolhaPagamento> showFolhaPagamentoCadaEmpresa() {
        LOG.info("\n#### -- FOLHA PAGAMENTO");

        List<FolhaPagamento> folhas = new ArrayList<>();
        FolhaPagamento folhaPagamento = new FolhaPagamento();
        empresas.forEach(empresa -> {
            BigDecimal folhaValor = empresa.getUsuarios().stream()
                    .map(Usuario::getSalario).reduce(BigDecimal.ZERO, BigDecimal::add);

            folhaPagamento.setEmpresa(empresa);
            folhaPagamento.setFolhaPagamento(folhaValor);
            folhas.add(folhaPagamento);

            System.out.println("aaaaaaaa");
            System.out.println(empresa.getName());
            System.out.println(folhaValor);

        });


        return folhas;
        //return folhaPagamento;

        /*BigDecimal d = empresas.stream()
                .flatMap(empresa -> empresa.getUsuarios().stream())
                .map(Usuario::getSalario).reduce(BigDecimal.ZERO, BigDecimal::add);*/





        /*empresas.forEach(empresa -> {
            LOG.info("#### EMPRESA: {} - R${}", empresa.getName(), getTotalFolhaPorEmpresa(empresa.getId()));
        });*/
    }

    public void showMediaIdade() {
        LOG.info("#### MEDIA IDADE: {} ", getMediaIdade());
    }

    public void showUsuariosOdenadosIdadeCadaEmpresa() {
        empresas.forEach(empresa -> {
            LOG.info("#### ORDENADO IDADE: {} ", empresa.getName());
            ordenaUsuariosIdadePorEmpresa(empresa.getId()).forEach(usuario ->
                    LOG.info("#### USUARIO ORDENADO: {} ", usuario.getName())
            );
        });
    }

    public BigDecimal getMaiorSalarioPorEmpresa(Long idEmpresa) {
        return usuarios.stream()
                .filter(usuario -> usuario.getIdEmpresa() == idEmpresa)
                .max(Comparator.comparing(Usuario::getSalario))
                .map(Usuario::getSalario).orElse(BigDecimal.ZERO);
//        return usuarios.stream().filter(usuario -> usuario.getIdEmpresa() == idEmpresa).max(Comparator.comparing(Usuario::getSalario)).map(Usuario::getSalario).orElse(0.0);
    }

    public BigDecimal getMediaSalarialEmpresa(Long idEmpresa) {
        BigDecimal somatorio = getTotalFolhaPorEmpresa(idEmpresa);
        return somatorio.divide(new BigDecimal(usuarios.size()));
    }

    public BigDecimal getTotalFolhaPorEmpresa(Long idEmpresa) {
        return usuarios.stream()
                .filter(usuario -> usuario.getIdEmpresa() == idEmpresa)
                .map(Usuario::getSalario).reduce(BigDecimal.ZERO, (somario, atual) -> atual);
    }

    //average
    public double getMediaIdade() {
        double somatorio = getTotalIdade();
        return somatorio / usuarios.size();
    }

    public List<Usuario> ordenaUsuariosIdadePorEmpresa(Long idEmpresa) {
        return usuarios.stream().filter(usuario -> usuario.getIdEmpresa() == idEmpresa).sorted(Comparator.comparing(Usuario::getIdade)).collect(Collectors.toList());
    }

    private int getTotalIdade() {
        //return usuarios.stream().map(Usuario::getIdade).reduce(0, (somatoro, atual) -> atual);
        return usuarios.stream().mapToInt(Usuario::getIdade).sum();
    }

    public BigDecimal getMaiorSalarioGeral() {
        return usuarios.stream().max(Comparator.comparing(Usuario::getSalario))
                .map(Usuario::getSalario)
                .orElse(BigDecimal.ZERO);
    }

    public Empresa getEmpresaMenorCusto() {

        //aquiii

        //Empresa empresa = showFolhaPagamentoCadaEmpresa().stream().min(Comparator.comparing(FolhaPagamento::getFolhaPagamento))



        return null;

        //empresas.stream().min(empresa -> Comparator.comparing(Comparator.comparing(getTotalFolhaPorEmpresa(empresa.getId()))));
    }

    /*PRINTS*/

    //usuario nao podem repetir lista empresa
    public void setDadosUsuariosEmpresas(List<Usuario> users, List<Empresa> empres) {
        empres.forEach(this::insertEmpresa);
        users.forEach(this::insertUsuario);
        //System.out.println("Dados Adicionados");
    }

    //colocar repetir usuario
    public Usuario insertUsuario(Usuario usuario) throws MyExceptions {
        validarUsuario(usuario); //gera //exception

        usuarios.add(usuario);
        LOG.info("#### USUÁRIO {} CADASTRADO COM SUCESSO", usuario.getName());
        inserirUsuarioEmpresa(usuario);

        return usuario;
    }

    public Empresa findEmpresaById(Long id) {
        return empresas.stream().filter(empresa -> empresa.getId() == id).findFirst().orElse(null);
    }

    public List<Usuario> findUsuariosEmpresas(Usuario usuario) {
        List<Usuario> users = usuarios.stream().filter(user -> user.getIdEmpresa() == usuario.getIdEmpresa()
                && user.getName().equals(usuario.getName())
                && user.getDocumento().equals(usuario.getDocumento())
                && user.getIdade() == usuario.getIdade()).collect(Collectors.toList());

        return users;
    }


    public void inserirUsuarioEmpresa(Usuario usuario) throws MyExceptions {
        Long idEmpresa = usuario.getIdEmpresa();
        Empresa empresa = findEmpresaById(idEmpresa);

        validarEmpresa(empresa); //gera Exception
        validarVagas(empresa);//gera Exception

        empresa.getUsuarios().add(usuario);
        int index = empresas.indexOf(empresa);
        empresas.set(index, empresa);


        LOG.info("#### USUÁRIO {} ENTROU NA EMPRESA {}", usuario.getName(), empresa.getName());
    }

    public Empresa insertEmpresa(Empresa empresa) throws MyExceptions {

        validarEmpresaInsert(empresa);
        empresas.add(empresa);
        LOG.info("#### EMPRESA CADASTRADA: " + empresa.getName());
        return empresa;
    }


    /*UTIL E VALIDAÇÕES*/
    private boolean existeNomeUsuario(String nome) {
        return usuarios.stream().anyMatch(user -> user.getName().equals(nome));
    }

    private boolean existeLoginUsuario(String login) {
        return usuarios.stream().anyMatch(user -> user.getLogin().equals(login));
    }

    private boolean existeDocumentoUsuario(String documento) {
        return usuarios.stream().anyMatch(user -> user.getDocumento().equals(documento));
    }

    private void validarUsuario(Usuario usuario) {
        if (isNullOrEmpty(usuario.getName())) {
            throw new MyExceptions("### NOME DEVE SER PREENCHIDO");
        } else if (isNullOrEmpty(usuario.getDocumento())) {
            throw new MyExceptions("### DOCUMENTO DEVE SER PREENCHIDO");
        } else if (isNullOrEmpty(usuario.getLogin())) {
            throw new MyExceptions("### LOGIN DEVE SER PREENCHIDO");
        } else if (isNullOrEmpty(usuario.getSenha())) {
            throw new MyExceptions("### SENHA DEVE SER PREENCHIDA");
        } else if (usuario.getIdade() <= 0) {
            throw new MyExceptions("### IDADE DEVE SER PREENCHIDA");
        }

        boolean existeUsuarioNome = existeNomeUsuario(usuario.getName());
        boolean existeUsuarioLogin = existeLoginUsuario(usuario.getLogin());
        boolean existeUsuarioDocumento = existeDocumentoUsuario(usuario.getDocumento());

        if (existeUsuarioNome) {
            throw new MyExceptions("#### NOME DO USUARIO JÁ CADASTRADO : " + usuario.getName());
        } else if (existeUsuarioLogin) {
            //LOG.error("#### LOGIN DO USUARIO JÁ CADASTRADO : " + usuario.getName());
            throw new MyExceptions("#### LOGIN DO USUARIO JÁ CADASTRADO : " + usuario.getName());

        } else if (existeUsuarioDocumento) {
            //LOG.error("#### DOCUMENTO DO USUARIO JÁ CADASTRADO : " + usuario.getName());
            throw new MyExceptions("#### DOCUMENTO DO USUARIO JÁ CADASTRADO : " + usuario.getName());
        }
    }


    private void validarEmpresaInsert(Empresa empresa) {
        boolean erroDocumento;
        boolean erroNome;
        String tipoErro = "";

        erroNome = empresas.stream().anyMatch(e1 -> e1.getName().equals(empresa.getName()));
        erroDocumento = empresas.stream().anyMatch(e1 -> e1.getDocumento().equals(empresa.getDocumento()));

        if (erroNome) {
            tipoErro = "EMPRESA JÁ CADASTRADA";

        } else if (erroDocumento) {
            tipoErro = "DOCUMENTO JÁ CADASTRADO";
        }
        if (erroNome || erroDocumento) {
            throw new MyExceptions("#### ERROR - " + tipoErro);
        }
    }

    //se existe vaga na empresa
    private void validarEmpresa(Empresa empresa) {
        if (empresa == null) {
            throw new MyExceptions("#### EMPRESA NÃO ENCONTRADA");
        }
    }

    private void validarVagas(Empresa empresa) {
        if (empresa.getUsuarios().size() >= empresa.getVagas()) {
            throw new MyExceptions("#### NÃO HÁ MAIS VAGAS NA EMPRESA " + empresa.getName());
        }
    }

    private int getIndexListaEmpresa(Empresa empresa) {
        int index = empresas.indexOf(empresa);
        if (index != -1) {
            throw new MyExceptions("#### EMPRESA NÃO ENCONTRADA");
        }

        return index;
    }

    private void alterarUsuarioLista(Empresa empresa) {
        int index = getIndexListaEmpresa(empresa);
        empresas.set(index, empresa);
    }

    private boolean isNullOrEmpty(String texto) {
        return texto == null || texto.isEmpty();
    }


}
