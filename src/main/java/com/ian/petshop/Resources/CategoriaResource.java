package com.ian.petshop.resources;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
  public ResponseEntity<Categoria> findCategorias(@PathVariable Integer id) {
    Categoria objCategoria = service.findCategoria(id);
    return ResponseEntity.ok().body(objCategoria);
  }
}
