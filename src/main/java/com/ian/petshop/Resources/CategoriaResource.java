package com.ian.petshop.resources;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ian.petshop.domain.Categoria;
import com.ian.petshop.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

  @Autowired
  CategoriaService service;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public List<Categoria> findCategorias() {
    Categoria cat1 = new Categoria(1, "Alimento");
    Categoria cat2 = new Categoria(2, "Cosmético");
    Categoria cat3 = new Categoria(3, "Remédio");

    List<Categoria> lista = new ArrayList<>();

    lista.add(cat1);
    lista.add(cat2);
    lista.add(cat3);

    return lista;
  }
}
