package com.ian.petshop.service;

import java.util.List;
import java.util.Optional;

import com.ian.petshop.domain.Endereco;
import com.ian.petshop.domain.Pessoa;
import com.ian.petshop.repository.EnderecoRepository;
import com.ian.petshop.repository.PessoaRepository;
import com.ian.petshop.service.exceptions.DataIntegrityException;
import com.ian.petshop.service.exceptions.ObjetoNaoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

  @Autowired
  private PessoaRepository pessoaRepository;
  @Autowired
  private EnderecoRepository enderecoRepository;

  public Pessoa findPessoa(Integer id) {
    Optional<Pessoa> obj = pessoaRepository.findById(id);
    return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(
        "Objeto não encontrado. ID: " + id + ", Tipo: " + Pessoa.class.getName()));
  }

  public Pessoa insertPessoa(Pessoa pessoa) {
    pessoa.setId(null);
    pessoaRepository.save(pessoa);
    for (Endereco endereco : pessoa.getEnderecos()) {
      endereco.setPessoa(pessoa);
    }

    enderecoRepository.saveAll(pessoa.getEnderecos());
    return pessoaRepository.save(pessoa);
  }

  public Pessoa updatePessoa(Pessoa pessoa) {
    findPessoa(pessoa.getId());
    return pessoaRepository.save(pessoa);
  }

  public void deletePessoa(Integer id) {
    findPessoa(id);
    try {
      pessoaRepository.deleteById(id);
    } catch (DataIntegrityViolationException e) {
      throw new DataIntegrityException("Não é possivel excluir.");
    }
  }

  public List<Pessoa> findAllPessoa() {
    List<Pessoa> obj = pessoaRepository.findAll();
    return obj;
  }

}
