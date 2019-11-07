package br.com.codenation.projetolongo;

import br.com.codenation.projetolongo.controller.AplicacaoController;
import br.com.codenation.projetolongo.service.AplicacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;

@SpringBootTest
class ProjetoLongoApplicationTests {

    @Test
    void teste_inclusao_de_dados(){
        AplicacaoController controller = new AplicacaoController();
        controller.setDadosFromArquivos();
        //controller.showMaiorSalarioCadaEmpresa();
        //controller.showMediaSalarialCadaEmpresa();
        //controller.showFolhaPagamentoCadaEmpresa();
        //controller.showMediaIdade();
        //controller.showUsuariosOdenadosIdadeCadaEmpresa();
        //controller.findEmpresa(1L);
        controller.findUsuariosEmpresa(2L);


    }

    @Test
    void contextLoads() {

        Class<?> classe = AplicacaoService.class;
        for(Method field : classe.getDeclaredMethods()){
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


