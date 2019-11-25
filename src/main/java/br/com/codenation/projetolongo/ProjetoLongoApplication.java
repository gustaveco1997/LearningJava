package br.com.codenation.projetolongo;

import br.com.codenation.projetolongo.controller.AplicacaoController;
import br.com.codenation.projetolongo.domain.entity.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ProjetoLongoApplication {



    public static void main(String[] args) {
        //Logger LOG = LoggerFactory.getLogger(AplicacaoService.class);
        SpringApplication.run(ProjetoLongoApplication.class, args);
        /*SpringApplication app = new SpringApplication(ProjetoLongoApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        app.run(args);*/



        /*AplicacaoController controller = new AplicacaoController();
        Empresa e = new Empresa();
        e.setName("Empresa teste");
        e.setDocumento("9999");
        e.setVagas(123);
        e.setSite("www.www.www");*/


//        controller.inserirEmpresa(e);

        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("application");
        //factory.close();
    }
}

//DAO (Comandos de Banco)
//controller (entrada e exibição de dados)
//service (regra de negócio)
