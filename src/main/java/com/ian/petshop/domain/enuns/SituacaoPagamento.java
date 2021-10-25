package com.ian.petshop.domain.enuns;

public enum SituacaoPagamento {
  QUITADO(1, "Quitado"), CANCELADO(2, "Cancelado"), PENDENTE(3, "Pendente");

  private int codigo;
  private String descricao;

  private SituacaoPagamento(int codigo, String descricao) {
    this.setCodigo(codigo);
    this.setDescricao(descricao);
  }

  public static SituacaoPagamento toEnum(Integer codigo) {
    if (codigo == null) {
      return null;
    }
    for (SituacaoPagamento sPagamento : SituacaoPagamento.values()) {
      if (codigo.equals(sPagamento.getCodigo())) {
        return sPagamento;
      }
    }
    throw new IllegalArgumentException();
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

}
