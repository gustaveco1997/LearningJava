package br.com.codenation.projetolongo.domain.entity;

import br.com.codenation.projetolongo.domain.vo.UsuarioVo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "user")
@Data
@Getter
@Setter
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
    @JoinColumn(name = "company_id")
    @JsonIgnore
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
    @JoinColumn(name = "address_id")
    private Endereco enderco;

    /*@OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;*/

    public Usuario() {

    }

    public Usuario(Usuario usuario) {
        super();
        this.id = usuario.getId();
        this.name = usuario.getName();
        this.documento = usuario.getDocumento();
        this.idade = usuario.getIdade();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.empresa = usuario.getEmpresa();
        this.salario = usuario.getSalario();
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

    public static UsuarioVo toUsuarioVo(Usuario usuario) {
        UsuarioVo u = UsuarioVo.builder()
                .id(usuario.getId())
                .empresa(usuario.getEmpresa())
                .endereco(usuario.getEnderco())
                .idade(usuario.getIdade())
                .login(usuario.getLogin())
                .salario(usuario.getSalario())
                .name(usuario.getName())
                .documento(usuario.getDocumento()).build();
        return u;
    }

    public static Usuario toUsuario(UsuarioVo usuarioVo) {
        Usuario u = new Usuario();
        u.setName(usuarioVo.getName());
        u.setDocumento(usuarioVo.getName());
        u.setSalario(usuarioVo.getSalario());
        u.setLogin(usuarioVo.getLogin());
        u.setSenha("123_PADRAO");

        return u;

    }
}
