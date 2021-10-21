package com.ian.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import com.ian.petshop.domain.Categoria;
import com.ian.petshop.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PopulaDados {
  @Autowired
  CategoriaRepository categoriaRepository;

  @PostConstruct
  public void cadrastro() {
    Categoria cat1 = new Categoria(null, "Alimento");
    Categoria cat2 = new Categoria(null, "Remédio");
    Categoria cat3 = new Categoria(null, "Cosmético");

    categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
  }
}
