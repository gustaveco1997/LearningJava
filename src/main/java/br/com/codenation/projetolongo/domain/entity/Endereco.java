package br.com.codenation.projetolongo.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "address")
@Data
@Getter
@Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="zip_code")
    private String zipCode;

    @Column(name="street")
    private String street;

    @Column(name="number")
    private int numero;

    @Column(name="district")
    private String bairro;

    @Column(name="city")
    private String cidade;

    @Column(name="country")
    private String pais;

}
