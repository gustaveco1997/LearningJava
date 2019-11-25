package br.com.codenation.projetolongo.service.interfaces;

import br.com.codenation.projetolongo.domain.entity.Empresa;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmpresaService {

    Empresa salvar(Empresa empresa);

    void deletar(Empresa empresa);

    List<Empresa> findByName(String nome);

    Empresa findById(Long id);

    void deleteById(Long id);

    List<Empresa> findAll();

}
