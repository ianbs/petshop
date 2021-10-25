package com.ian.petshop.domain;

import com.ian.petshop.domain.enuns.SituacaoPagamento;

public class PagamentoCartao extends Pagamento {

  public static final long serialVersionUID = 1L;

  private Integer parcelas;

  public PagamentoCartao() {
  }

  public PagamentoCartao(Integer id, Double valor, SituacaoPagamento situacao, Integer parcelas) {
    super(id, valor, situacao);
    this.parcelas = parcelas;
  }

}
