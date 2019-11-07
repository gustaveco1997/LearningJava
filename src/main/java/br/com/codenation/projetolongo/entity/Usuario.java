package br.com.codenation.projetolongo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "user")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @Column(name = "login", nullable = false, length = 255)
    private String login;

    @Column(name = "password", nullable = false, length = 255)
    private String senha;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Empresa empresa;

    @Column(name = "salary")
    private BigDecimal salario;

    @Column(name = "name")
    private String name;

    @Column(name = "document")
    private String documento;

    @Column(name = "age")
    private int idade;

    @OneToOne
    @JoinColumn(name="endereco_id")
    private Endereco enderco;

    public Usuario() {

    }

    public Usuario(Long id, String nome, String documento, int idade, String login, String senha, Empresa empresa, BigDecimal salario) {
        this.id = id;
        this.name = nome;
        this.documento = documento;
        this.idade = idade;
        this.login = login;
        this.senha = senha;
        this.empresa = empresa;
        this.salario = salario;
    }


    public Endereco getEnderco() {
        return enderco;
    }

    public void setEnderco(Endereco enderco) {
        this.enderco = enderco;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
