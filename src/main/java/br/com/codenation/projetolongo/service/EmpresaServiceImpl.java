package br.com.codenation.projetolongo.service;

import br.com.codenation.projetolongo.domain.DAO.EmpresaDAO;
import br.com.codenation.projetolongo.domain.entity.Empresa;
import br.com.codenation.projetolongo.domain.entity.Usuario;
import br.com.codenation.projetolongo.domain.vo.EmpresaVo;
import br.com.codenation.projetolongo.service.interfaces.EmpresaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//List<CompanyVo> findAll(), List.class
@Service
public class EmpresaServiceImpl implements EmpresaService {
    Logger LOG = LoggerFactory.getLogger(EmpresaServiceImpl.class);
    private List<Empresa> empresas = new ArrayList<>();

    //instancia a interface
    @Autowired
    private EmpresaDAO empresaDAO;

    public Long countEmpresas() {
        return empresaDAO.count();
    }

    @Override
    public Empresa salvar(Empresa empresa) {
        return empresaDAO.save(empresa);
    }

    @Override
    public void deletar(Empresa empresa) {
        empresaDAO.delete(empresa);
    }

    @Override
    public List<Empresa> findByName(String nome) {
        return empresaDAO.findByName(nome);
    }

    @Override
    public Empresa findById(Long id) {
        return empresaDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        empresaDAO.deleteById(id);
    }

    @Override
    public List<Empresa> findAll() {
        return empresaDAO.findAll();
    }

    @Override
    public List<EmpresaVo> mediaSalarialEmpresa() {
        List<Empresa> empresas = findAll();
        List<EmpresaVo> empresaVos = new ArrayList<>();
        empresas.forEach(empresa -> {

            EmpresaVo empresaVo = Empresa.toEmpresaVo(empresa);
            List<Usuario> usuariosFromEmpresa = empresaDAO.getUsuarios(empresa);

            BigDecimal soma = usuariosFromEmpresa.stream().map(Usuario::getSalario)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal media;
            if (usuariosFromEmpresa.isEmpty()) {
                media = BigDecimal.ZERO;
            } else {
                media = soma.divide(new BigDecimal(usuariosFromEmpresa.size()));
            }

            empresaVo.setMediaSalarialEmpresa(media);
            empresaVos.add(empresaVo);

        });
        return empresaVos;
    }

    /*public BigDecimal average(List<BigDecimal> bigDecimals, RoundingMode roundingMode) {
        BigDecimal sum = bigDecimals.stream()
                .map(Objects::requireNonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum.divide(new BigDecimal(bigDecimals.size()), roundingMode);
    }*/



    /*    public Empresa insertEmpresa(Empresa empresa) throws MyExceptions {

        validarEmpresaInsert(empresa);
        empresas.add(empresa);
        LOG.info("#### EMPRESA CADASTRADA: " + empresa.getName());
        return empresa;
    }


    public Empresa findEmpresaById(Long id) {
        Empresa empresaEncontrada = empresas.stream().filter(empresa -> empresa.getId().equals(id)).findFirst().orElse(null);
        if (empresaEncontrada != null) {
            System.out.println("Empresa ENCONTRADA: " + empresaEncontrada.getName());
        } else {
            System.out.println("Empresa NAO ENCONTRADA: ");
        }

        return empresaEncontrada;
    }


    private void validarEmpresaInsert(Empresa empresa) {
        boolean erroDocumento;
        boolean erroNome;
        String tipoErro = "";

        erroNome = empresas.stream().anyMatch(e1 -> e1.getName().equals(empresa.getName()));
        erroDocumento = empresas.stream().anyMatch(e1 -> e1.getDocumento().equals(empresa.getDocumento()));

        if (erroNome) {
            tipoErro = "EMPRESA JÁ CADASTRADA";

        } else if (erroDocumento) {
            tipoErro = "DOCUMENTO JÁ CADASTRADO";
        }
        if (erroNome || erroDocumento) {
            throw new MyExceptions("#### ERROR - " + tipoErro);
        }
    }

    //se existe vaga na empresa
    private void validarEmpresa(Empresa empresa) {
        if (empresa == null) {
            throw new MyExceptions("#### EMPRESA NÃO ENCONTRADA");
        }
    }*/


}
