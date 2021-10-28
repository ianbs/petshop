package com.ian.petshop.service;

import java.util.List;
import java.util.Optional;

import com.ian.petshop.domain.Servico;
import com.ian.petshop.repository.ServicoRepository;
import com.ian.petshop.service.exceptions.DataIntegrityException;
import com.ian.petshop.service.exceptions.ObjetoNaoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

  public Servico insertServico(Servico servico) {
    servico.setId(null);
    return servicoRepository.save(servico);
  }

  public Servico updateServico(Servico servico) {
    findServico(servico.getId());
    return servicoRepository.save(servico);
  }

  public void deleteServico(Integer id) {
    findServico(id);
    try {
      servicoRepository.deleteById(id);
    } catch (DataIntegrityViolationException e) {
      throw new DataIntegrityException("Servico possui produtos. Não é possivel excluir.");
    }
  }

  public List<Servico> findAllServicos() {
    List<Servico> obj = servicoRepository.findAll();
    return obj;
  }
}
