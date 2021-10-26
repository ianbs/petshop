package com.ian.petshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ian.petshop.domain.Pessoa;
import com.ian.petshop.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

  @Autowired
  PessoaService service;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Pessoa> findCategorias(@PathVariable Integer id) {
    Pessoa objPessoa = service.findPessoa(id);
    return ResponseEntity.ok().body(objPessoa);
  }
}
