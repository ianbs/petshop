package com.ian.petshop.service;

import java.util.Optional;

import com.ian.petshop.domain.Servico;
import com.ian.petshop.repository.ServicoRepository;
import com.ian.petshop.service.exceptions.ObjetoNaoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {
  @Autowired
  private ServicoRepository servicoRepository;

  public Servico findServico(Integer id) {
    Optional<Servico> obj = servicoRepository.findById(id);
    return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(
        "Objeto não encontrado. ID: " + id + ", Tipo: " + Servico.class.getName()));
  }

}
