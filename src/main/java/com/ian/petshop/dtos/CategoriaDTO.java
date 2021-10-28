package com.ian.petshop.dtos;

import java.io.Serializable;

import com.ian.petshop.domain.Categoria;

public class CategoriaDTO implements Serializable {

  public static final long serialVersionUID = 1L;

  private String nome;

  public CategoriaDTO() {
  }

  public CategoriaDTO(Categoria categoria) {
    this.nome = categoria.getNome();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
