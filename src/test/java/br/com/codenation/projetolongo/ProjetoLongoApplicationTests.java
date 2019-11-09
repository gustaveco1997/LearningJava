package br.com.codenation.projetolongo;

import br.com.codenation.projetolongo.controller.AplicacaoController;
import br.com.codenation.projetolongo.domain.DAO.EmpresaDAO;
import br.com.codenation.projetolongo.domain.entity.Empresa;
import br.com.codenation.projetolongo.domain.entity.Usuario;
import br.com.codenation.projetolongo.service.AplicacaoService;
import br.com.codenation.projetolongo.service.EmpresaServiceImpl;
import br.com.codenation.projetolongo.service.interfaces.EmpresaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProjetoLongoApplicationTests {


    @Autowired
    EmpresaService service;


    //Criar Builder para Usuario e Empresa
    @Test
    void insertEmpresa() {
        Empresa e = new Empresa();
        e.setName("Empresa teste");
        e.setDocumento("1111");
        e.setVagas(111);
        e.setSite("www.www.www");

        Empresa empresa = service.salvar(e);
        assert (empresa != null && empresa.getId() != null);
    }

    @Test
    void findEmpresa() {


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


