package br.com.codenation.projetolongo.controller;

import br.com.codenation.projetolongo.domain.entity.Empresa;
import br.com.codenation.projetolongo.domain.vo.EmpresaVo;
import br.com.codenation.projetolongo.service.EmpresaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//31725162
//una@2019
@RestController
@RequestMapping("/v1/Empresa")
public class EmpresaController {

    @Autowired
    EmpresaServiceImpl empresaService;

    @PostMapping("/save")
    public ResponseEntity salvar(@RequestBody EmpresaVo empresaVo) {
        Empresa empresa = new Empresa(null, empresaVo.getName(), empresaVo.getDocumento(), empresaVo.getVagas(), empresaVo.getSite());
        Empresa retorno = empresaService.salvar(empresa);
        return ResponseEntity.ok(retorno);
    }

    @GetMapping("/byname/{nome}")
    public ResponseEntity findByName(@PathVariable String nome) {
        List<Empresa> empresas = empresaService.findByName(nome);
        List<EmpresaVo> empresaVos = empresas.stream().map(Empresa::toEmpresaVo).collect(Collectors.toList());
        return ResponseEntity.ok(empresaVos);
    }

    @GetMapping("/mediasalarial")
    public ResponseEntity mediaSalarialEmpresa() {
        List<EmpresaVo> empresas = empresaService.mediaSalarialEmpresa();
        //List<EmpresaVo> empresaVos = empresas.stream().map(Empresa::toEmpresaVo).collect(Collectors.toList());
        return ResponseEntity.ok(empresas);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteEmpresaById(@Param("id") Long id) {
        empresaService.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
