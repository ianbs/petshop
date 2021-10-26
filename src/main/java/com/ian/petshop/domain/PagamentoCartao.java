package com.ian.petshop.domain;

import javax.persistence.Entity;

import com.ian.petshop.domain.enuns.SituacaoPagamento;

@Entity
public class PagamentoCartao extends Pagamento {

  public static final long serialVersionUID = 1L;

  private Integer parcelas;

  public PagamentoCartao() {
  }

  public PagamentoCartao(Integer id, Double valor, SituacaoPagamento situacao, Servico servico, Integer parcelas) {
    super(id, valor, situacao, servico);
    this.parcelas = parcelas;
  }

  public Integer getParcelas() {
    return parcelas;
  }

  public void setParcelas(Integer parcelas) {
    this.parcelas = parcelas;
  }

}
