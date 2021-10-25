package com.ian.petshop.domain;

import java.io.Serializable;

import com.ian.petshop.domain.enuns.SituacaoPagamento;

public class Pagamento implements Serializable {

  public static final long serialVersionUID = 1L;

  private Integer id;
  private Double valor;
  private SituacaoPagamento situacao;

  public Pagamento() {
  }

  public Pagamento(Integer id, Double valor, SituacaoPagamento situacao) {
    super();
    this.id = id;
    this.setValor(valor);
    this.setSituacao(situacao);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Pagamento other = (Pagamento) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public SituacaoPagamento getSituacao() {
    return situacao;
  }

  public void setSituacao(SituacaoPagamento situacao) {
    this.situacao = situacao;
  }

}
