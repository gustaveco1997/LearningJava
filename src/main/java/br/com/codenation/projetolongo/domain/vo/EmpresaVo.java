package br.com.codenation.projetolongo.domain.vo;

import br.com.codenation.projetolongo.domain.entity.Endereco;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class EmpresaVo {

    private Long id;
    private String name;
    private String documento;
    private Integer vagas;
    private String site;
    private Endereco endereco;

}
