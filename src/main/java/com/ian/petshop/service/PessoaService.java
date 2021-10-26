package com.ian.petshop.service;

import java.util.Optional;

import com.ian.petshop.domain.Pessoa;
import com.ian.petshop.repository.PessoaRepository;
import com.ian.petshop.service.exceptions.ObjetoNaoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

  @Autowired
  private PessoaRepository repository;

  public Pessoa findPessoa(Integer id) {
    Optional<Pessoa> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(
        "Objeto não encontrado. ID: " + id + ", Tipo: " + Pessoa.class.getName()));
  }

}
