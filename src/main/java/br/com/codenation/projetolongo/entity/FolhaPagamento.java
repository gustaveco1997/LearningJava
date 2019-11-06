package br.com.codenation.projetolongo.entity;

import java.math.BigDecimal;

public class FolhaPagamento {
    private Empresa empresa;
    private BigDecimal folhaPagamento;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public BigDecimal getFolhaPagamento() {
        return folhaPagamento;
    }

    public void setFolhaPagamento(BigDecimal folhaPagamento) {
        this.folhaPagamento = folhaPagamento;
    }
}
