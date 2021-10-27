package com.ian.petshop.resources;

import com.ian.petshop.domain.Servico;
import com.ian.petshop.service.ServicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoResource {

  @Autowired
  ServicoService service;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Servico> findServico(@PathVariable Integer id) {
    Servico objServico = service.findServico(id);
    return ResponseEntity.ok().body(objServico);
  }

}
