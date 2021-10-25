package com.ian.petshop.domain;

import java.util.Date;

import com.ian.petshop.domain.enuns.SituacaoPagamento;

public class PagamentoDinheiro extends Pagamento {

  public static final long serialVersionUID = 1L;

  private Date dataPagamento;
  private Double desconto;

  public PagamentoDinheiro() {
  }

  public PagamentoDinheiro(Integer id, Double valor, SituacaoPagamento situacao, Date dataPagamento, Double desconto) {
    super(id, valor, situacao);
    this.dataPagamento = dataPagamento;
    this.desconto = desconto;
  }

  public Date getDataPagamento() {
    return dataPagamento;
  }

  public void setDataPagamento(Date dataPagamento) {
    this.dataPagamento = dataPagamento;
  }

  public Double getDesconto() {
    return desconto;
  }

  public void setDesconto(Double desconto) {
    this.desconto = desconto;
  }

}
