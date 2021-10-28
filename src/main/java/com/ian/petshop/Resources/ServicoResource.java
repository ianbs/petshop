package com.ian.petshop.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.ian.petshop.domain.Servico;
import com.ian.petshop.dtos.ServicoDTO;
import com.ian.petshop.service.ServicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Servico> insertServicos(@RequestBody Servico servico) {
    Servico objServico = service.insertServico(servico);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objServico.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Void> updateServicos(@RequestBody Servico servico, @PathVariable Integer id) {
    servico.setId(id);
    servico = service.updateServico(servico);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> deleteServicos(@PathVariable Integer id) {
    service.deleteServico(id);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<ServicoDTO>> findAllPessoas() {
    List<Servico> objServicos = service.findAllServicos();
    List<ServicoDTO> servicoDTOs = objServicos.stream().map((obj) -> new ServicoDTO(obj)).collect(Collectors.toList());
    return ResponseEntity.ok().body(servicoDTOs);
  }
}
