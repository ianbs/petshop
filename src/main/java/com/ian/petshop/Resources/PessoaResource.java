package com.ian.petshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.ian.petshop.domain.Pessoa;
import com.ian.petshop.dtos.PessoaDTO;
import com.ian.petshop.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

  @Autowired
  PessoaService service;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Pessoa> findPessoas(@PathVariable Integer id) {
    Pessoa objPessoa = service.findPessoa(id);
    return ResponseEntity.ok().body(objPessoa);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Pessoa> insertPessoas(@RequestBody Pessoa pessoa) {
    Pessoa objPessoa = service.insertPessoa(pessoa);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objPessoa.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Void> updatePessoas(@RequestBody Pessoa pessoa, @PathVariable Integer id) {
    pessoa.setId(id);
    pessoa = service.updatePessoa(pessoa);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> deletePessoas(@PathVariable Integer id) {
    service.deletePessoa(id);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<PessoaDTO>> findAllPessoas() {
    List<Pessoa> objPessoa = service.findAllPessoa();
    List<PessoaDTO> pessoaDTOs = objPessoa.stream().map((obj) -> new PessoaDTO(obj)).collect(Collectors.toList());
    return ResponseEntity.ok().body(pessoaDTOs);
  }

}
