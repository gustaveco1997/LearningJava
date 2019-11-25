package br.com.codenation.projetolongo.domain.vo;

import lombok.Data;

@Data
public class EnderecoVo {
    private Long id;
    private String zipCode;
    private String street;
    private int numero;
    private String bairro;
    private String cidade;
    private String pais;
}
