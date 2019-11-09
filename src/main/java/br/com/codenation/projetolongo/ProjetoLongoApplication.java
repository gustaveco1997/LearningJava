package br.com.codenation.projetolongo;

import br.com.codenation.projetolongo.controller.AplicacaoController;
import br.com.codenation.projetolongo.domain.DAO.EmpresaDAO;
import br.com.codenation.projetolongo.domain.entity.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class ProjetoLongoApplication {



    public static void main(String[] args) {
        //Logger LOG = LoggerFactory.getLogger(AplicacaoService.class);
        SpringApplication.run(ProjetoLongoApplication.class, args);



        AplicacaoController controller = new AplicacaoController();
        Empresa e = new Empresa();
        e.setName("Empresa teste");
        e.setDocumento("9999");
        e.setVagas(123);
        e.setSite("www.www.www");


//        controller.inserirEmpresa(e);

        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("application");
        //factory.close();
    }
}

//DAO (Comandos de Banco)
//controller (entrada e exibição de dados)
//service (regra de negócio)
