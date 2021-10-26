package com.ian.petshop.domain;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa {
  public static final long serialVersionUID = 1L;

  private String funcao;

  public Funcionario() {
  }

  public Funcionario(Integer id, String nome, String email, String codNacional, String funcao) {
    super(id, nome, email, codNacional);
    this.setFuncao(funcao);
  }

  public String getFuncao() {
    return funcao;
  }

  public void setFuncao(String funcao) {
    this.funcao = funcao;
  }
}
