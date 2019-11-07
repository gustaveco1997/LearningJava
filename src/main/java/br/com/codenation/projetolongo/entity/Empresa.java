package br.com.codenation.projetolongo.entity;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import org.apache.tomcat.jni.Address;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "company")
//@Data
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "document")
    private String documento;

    @Column(name = "vacancies")
    private int vagas;

    @Column(name = "site")
    private String site;

    //@Column(name = "salary")
    @Ignore
    private BigDecimal salario;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco enderco;

    //FetchType.LAZY //traz apenas quando eu quero
    //FetchType.EAGER //traz instanciado
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Usuario> usuarios = new ArrayList<>();

    //private int idade;

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


    public Endereco getEnderco() {
        return enderco;
    }

    public void setEnderco(Endereco enderco) {
        this.enderco = enderco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }
}
