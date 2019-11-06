package br.com.codenation.projetolongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class ProjetoLongoApplication {

    public static void main(String[] args) {
        //Logger LOG = LoggerFactory.getLogger(AplicacaoService.class);
        SpringApplication.run(ProjetoLongoApplication.class, args);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("application");
        factory.close();

        /*AplicacaoController controller = new AplicacaoController();
        controller.setDadosFromArquivos();

        controller.showFolhaPagamentoCadaEmpresa();/
        //controller.showMaiorSalarioCadaEmpresa();
        //controller.showMediaSalarialCadaEmpresa();

        //controller.showMediaIdade();
        //controller.showUsuariosOdenadosIdadeCadaEmpresa();

        /*try {
            AplicacaoController controller = new AplicacaoController();

            Empresa empresa = new Empresa(1L, "Codenation", "12310290", 0);
            controller.insertEmpresa(empresa);

            empresa = new Empresa(2L, "Dti Digital", "92810", 10);
            controller.insertEmpresa(empresa);

            empresa = new Empresa(3L, "Sympla", "12380", 15);
            controller.insertEmpresa(empresa);

            Usuario usuario = new Usuario(1L, "Thiago",
                    "123456789", 31,
                    "oathiago", "codenation", 1L);
            controller.insertUsuario(usuario);

            usuario = new Usuario(2L, "Guilherme",
                    "13212", 30,
                    "guilherme", "codenation", 2L);
            controller.insertUsuario(usuario);

            usuario = new Usuario(3L, "Gustavo",
                    "21370192", 22,
                    "gustavo_henrique", "codenation", 3L);
            controller.insertUsuario(usuario);

            usuario = new Usuario(4L, "Leonardo",
                    "8981299", 34,
                    "leonardo", "codenarion", 1L);
            controller.insertUsuario(usuario);

            controller.findUsuariosEmpresas(usuario);


        } catch (MyExceptions e) {
            LOG.error(e.getMessage());
        }*/
    }
}

//DAO (Comandos de Banco)
//controller (entrada e exibição de dados)
//service (regra de negócio)
