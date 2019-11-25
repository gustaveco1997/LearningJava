package br.com.codenation.projetolongo.jobs;

import br.com.codenation.projetolongo.service.EmpresaServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
//@EnableScheduling
@Slf4j
public class LeitorEmpresasJob {

    @Autowired
    private EmpresaServiceImpl empresaService;

    @Scheduled(fixedRate = 2000)
    public void lerDadosBancoEmpresa() {
        log.info("### START VERIFY COUNT COMPANIES");
        long totalEmpresas = empresaService.countEmpresas();
        log.info("## FOUND {} COMPANY IN BASE", totalEmpresas);
        log.info("### START VERIFY COUNT COMPANIES\n");
    }
}
