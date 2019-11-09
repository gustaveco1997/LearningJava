package br.com.codenation.projetolongo.service;

import br.com.codenation.projetolongo.domain.entity.Empresa;
import br.com.codenation.projetolongo.domain.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class AplicacaoService {
    Logger LOG = LoggerFactory.getLogger(AplicacaoService.class);

    private List<Usuario> usuarios = new ArrayList<>();
    private List<Empresa> empresas = new ArrayList<>();

    /*
    public List<Empresa> showMaiorSalarioCadaEmpresa() {
        LOG.info("\n#### -- MAIOR SALARIO POR EMPRESA");

        List<Empresa> empresasMaiorSalario = new ArrayList<>();
        empresas.forEach(empresa -> {
            //getMaiorSalarioPorEmpresa(empresa.getId())

            BigDecimal mediaSalarial = getMaiorSalarioPorEmpresa(empresa);
            empresa.setSalario(mediaSalarial);
            empresasMaiorSalario.add(empresa);

            LOG.info("#### EMPRESA: {} - R$ {}", empresa.getName(), mediaSalarial);
        });

        return empresasMaiorSalario;
    }

    public List<Empresa> showMediaSalarialCadaEmpresa() {
        LOG.info("\n#### -- MÉDIA SALARIAL");
        List<Empresa> empresasMediaSalarial = new ArrayList<>();

        empresas.forEach(empresa -> {
            empresa.setSalario(getMediaSalarialEmpresa(empresa));
            empresasMediaSalarial.add(empresa);

            LOG.info("#### EMPRESA: {} - R$ {}", empresa.getName(), getMediaSalarialEmpresa(empresa));
        });

        return empresasMediaSalarial;
    }

    public List<Empresa> showFolhaPagamentoCadaEmpresa() {
        LOG.info("\n#### -- FOLHA PAGAMENTO");

        List<Empresa> folhasPagamento = new ArrayList<>();

        empresas.forEach(empresa -> {
            BigDecimal folhaValor = empresa.getUsuarios().stream()
                    .map(Usuario::getSalario).reduce(BigDecimal.ZERO, BigDecimal::add);

            empresa.setSalario(folhaValor);
            folhasPagamento.add(empresa);

            System.out.println(empresa.getName() + " -- R$ " + folhaValor);

        });

        return folhasPagamento;

    }

    public double showMediaIdade() {
        double mediaIdade = getMediaIdade();
        LOG.info("#### MEDIA IDADE: {} ", mediaIdade);

        return mediaIdade;
    }

    public List<Empresa> showUsuariosOdenadosIdadeCadaEmpresa() {
        //crescente
        List<Empresa> empresaUsuariosOrdenadosIdade = new ArrayList<>();

        empresas.forEach(empresa -> {

            LOG.info("#### ORDENADO IDADE: {} ", empresa.getName());
            List<Usuario> usuariosOrdenados = ordenaUsuariosIdadePorEmpresa(empresa);
            usuariosOrdenados.forEach(usuario ->
                    LOG.info("#### USUARIO IDADE: {} ", usuario.getIdade())
            );
            empresa.setUsuarios(usuariosOrdenados);
            empresaUsuariosOrdenadosIdade.add(empresa);
        });

        return empresaUsuariosOrdenadosIdade;
    }

    private BigDecimal getMaiorSalarioPorEmpresa(Empresa empresa) {

        return usuarios.stream()
                .filter(usuario -> usuario.getEmpresa().equals(empresa))
                .max(Comparator.comparing(Usuario::getSalario))
                .map(Usuario::getSalario).orElse(BigDecimal.ZERO);
    }

    private BigDecimal getMediaSalarialEmpresa(Empresa empresa) {
        BigDecimal somatorio = getTotalFolhaPorEmpresa(empresa);
        BigDecimal qntUsuarios = new BigDecimal(usuarios.size());
        return somatorio.divide(qntUsuarios, 2, RoundingMode.CEILING); //2 significa qnt de digitos após a virgula
    }

    private BigDecimal getTotalFolhaPorEmpresa(Empresa empresa) {
        //valido
        return usuarios.stream()
                .filter(usuario -> usuario.getEmpresa().equals(empresa))
                .map(Usuario::getSalario).reduce(BigDecimal.ZERO, (somario, atual) -> atual);
    }

    //average
    private double getMediaIdade() {
        double somatorio = getTotalIdade();
        return somatorio / usuarios.size();
    }

    private List<Usuario> ordenaUsuariosIdadePorEmpresa(Empresa empresa) {
        return usuarios.stream().filter(usuario -> usuario.getEmpresa().equals(empresa)).sorted(Comparator.comparing(Usuario::getIdade)).collect(Collectors.toList());
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



    //usuario nao podem repetir lista empresa
    public void setDadosUsuariosEmpresas(List<Usuario> users, List<Empresa> empres) {
        empres.forEach(this::insertEmpresa);
        users.forEach(this::insertUsuario);
        //System.out.println("Dados Adicionados");
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
*/

}
