package br.com.codenation.projetolongo.domain.entity;

import br.com.codenation.projetolongo.domain.vo.EmpresaVo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
@Data
@Getter
@Setter
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "document")
    private String documento;

    @Column(name = "vacancies")
    private int vagas;

    @Column(name = "site")
    private String site;

    @Column(name = "salary")
    private BigDecimal salario;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Endereco endereco;

    //FetchType.LAZY //traz apenas quando eu quero+
    //FetchType.EAGER //traz instanciado
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Usuario> usuarios = new ArrayList<>();

    public Empresa() {

    }

    public Empresa(Long id, String nome, String documento, int vagas, String site) {
        this.id = id;
        this.name = nome;
        this.documento = documento;
        this.vagas = vagas;
        this.site = site;
        usuarios = new ArrayList<>();
    }

    public static EmpresaVo toEmpresaVo(Empresa retorno) {
        EmpresaVo empresaVo = EmpresaVo.builder()
                .id(retorno.getId())
                .documento(retorno.getDocumento())
                .endereco(retorno.getEndereco())
                .site(retorno.getSite())
                .vagas(retorno.getVagas())
                .name(retorno.getName())
                .build();

        return empresaVo;

    }
}
