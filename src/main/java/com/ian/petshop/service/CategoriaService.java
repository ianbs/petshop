package com.ian.petshop.service;

import java.util.List;
import java.util.Optional;

import com.ian.petshop.domain.Categoria;
import com.ian.petshop.repository.CategoriaRepository;
import com.ian.petshop.service.exceptions.DataIntegrityException;
import com.ian.petshop.service.exceptions.ObjetoNaoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository repository;

  public Categoria findCategoria(Integer id) {
    Optional<Categoria> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(
        "Objeto não encontrado. ID: " + id + ", Tipo: " + Categoria.class.getName()));
  }

  public Categoria insertCategoria(Categoria categoria) {
    categoria.setId(null);
    return repository.save(categoria);
  }

  public Categoria updateCategoria(Categoria categoria) {
    findCategoria(categoria.getId());
    return repository.save(categoria);
  }

  public void deleteCategoria(Integer id) {
    findCategoria(id);
    try {
      repository.deleteById(id);
    } catch (DataIntegrityViolationException e) {
      throw new DataIntegrityException("Categoria possui produtos. Não é possivel excluir.");
    }
  }

  public List<Categoria> findAllCategorias() {
    List<Categoria> obj = repository.findAll();
    return obj;
  }

}
