package br.com.codenation.projetolongo.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "user")
@Data
@Getter @Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
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
    @JoinColumn(name="address_id")
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
}
