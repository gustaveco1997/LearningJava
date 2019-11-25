package br.com.codenation.projetolongo;

import br.com.codenation.projetolongo.domain.entity.Empresa;
import br.com.codenation.projetolongo.domain.entity.Usuario;
import br.com.codenation.projetolongo.service.AplicacaoService;
import br.com.codenation.projetolongo.service.EmpresaServiceImpl;
import br.com.codenation.projetolongo.service.UsuarioServiceImpl;
import br.com.codenation.projetolongo.service.interfaces.EmpresaService;
import br.com.codenation.projetolongo.service.interfaces.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProjetoLongoApplicationTests {

    @Autowired
    EmpresaServiceImpl empresaService;
    @Autowired
    UsuarioServiceImpl usuarioService;


    //Criar Builder para Usuario e Empresas

    @Test
    void updateName() {
        Usuario u = new Usuario();
        u.setId(2L);
        u.setName("Novo Nome");
        usuarioService.updateUser(u);
    }

    @Test
    void testando_selects() {
        List<Empresa> empresas = empresaService.findByName("EmpresaTeste");

        assert (empresas != null && !empresas.isEmpty());
        empresas.forEach(empresa -> System.out.println(empresa.getName()));


        //Empresa empresa = empresaService.findById(1L);
        //assert (empresa != null && empresa.getId() != null);

    }

    @Test
    void insertEmpresa() {
        /*Empresa e = new Empresa();
        e.setName("Empresa Lumina");
        e.setDocumento("02.068.969/0001-20");
        e.setVagas(2);
        e.setSite("www.lumina.com.br");

        Empresa empresa = empresaService.salvar(e);
        assert (empresa != null && empresa.getId() != null);*/
    }

    @Test
    void findEmpresaByName() {
        empresaService.findByName("Empresa");
    }

    @Test
    Empresa findEmpresaById() {
        return empresaService.findById(1L);
    }

    @Test
    void inserirUsuario() {
        //service.findByName("Empresa 1")

        Usuario u = new Usuario();
        u.setName("Gustavo");
        u.setDocumento("2318029");

        //u.setEmpresa();
        u.setIdade(22);
        u.setLogin("euteste");
        u.setSalario(new BigDecimal(123.2));
        u.setSenha("1234");


    }

    @Test
    void teste_inclusao_de_dados() {
        //Usuario u = new Usuario();
        //u.setName("Gustavo");

        //controller.inserirUsuario();
        //service.findEmpresasByNameOrderByName();

        /*controller.setDadosFromArquivos();

        List<Empresa> maioresSalariosEmpresa = controller.showMaiorSalarioCadaEmpresa();
        assert (maioresSalariosEmpresa != null);

        maioresSalariosEmpresa.forEach(empresa -> {
            assert (empresa.getSalario() != null);
            assert (!empresa.getSalario().equals(BigDecimal.ZERO));
        });

        List<Empresa> mediaSalarialCadaEmpresa = controller.showMediaSalarialCadaEmpresa();
        mediaSalarialCadaEmpresa.forEach(empresa -> {
            assert (empresa.getSalario() != null);
            assert (!empresa.getSalario().equals(BigDecimal.ZERO));
        });


        List<Empresa> folhasPagamento = controller.showMediaSalarialCadaEmpresa();
        folhasPagamento.forEach(empresa -> {
            assert (empresa.getSalario() != null);
            assert (!empresa.getSalario().equals(BigDecimal.ZERO));

        });*/


        //controller.showFolhaPagamentoCadaEmpresa();
        //controller.showMediaIdade();
        //controller.showUsuariosOdenadosIdadeCadaEmpresa();
        //controller.findEmpresa(1L);
        //controller.findUsuariosEmpresa(2L);

    }

    @Test
    void contextLoads() {

        Class<?> classe = AplicacaoService.class;
        for (Method field : classe.getDeclaredMethods()) {
            System.out.println(field.getName());
        }
        /*for (Method declaredMethod : FileStreamService.class.getDeclaredMethods()) {
            assert (declaredMethod.getAnnotation(MyAnnotation.class).texto()).equals("");

            if (declaredMethod.getAnnotation(MyAnnotation.class) != null) {
                System.out.println(declaredMethod.getAnnotation(MyAnnotation.class).texto());
            } else {
                System.out.println("Nulo");
            }
        }*/
    }
}


