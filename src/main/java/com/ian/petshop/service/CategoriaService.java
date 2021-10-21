package com.ian.petshop.service;

import java.util.Optional;

import com.ian.petshop.domain.Categoria;
import com.ian.petshop.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository repo;

  public Categoria findCategoria(Integer id) {
    Optional<Categoria> obj = repo.findById(id);
    return obj.orElse(null);
  }

}
