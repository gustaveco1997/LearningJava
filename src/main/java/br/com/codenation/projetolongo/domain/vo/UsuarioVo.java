package br.com.codenation.projetolongo.domain.vo;

import br.com.codenation.projetolongo.domain.entity.Empresa;
import br.com.codenation.projetolongo.domain.entity.Endereco;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Builder
@Getter
@Setter
public class UsuarioVo {
    private Long id;
    private String login;
    private Empresa empresa;
    private BigDecimal salario;
    private String name;
    private String documento;
    private int idade;
    private Endereco endereco;
}
