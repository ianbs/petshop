package com.ian.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import com.ian.petshop.domain.Categoria;
import com.ian.petshop.domain.Cidade;
import com.ian.petshop.domain.Especie;
import com.ian.petshop.domain.Estado;
import com.ian.petshop.domain.Pet;
import com.ian.petshop.domain.Produto;
import com.ian.petshop.domain.Raca;
import com.ian.petshop.repository.CategoriaRepository;
import com.ian.petshop.repository.CidadeRepository;
import com.ian.petshop.repository.EspecieRepository;
import com.ian.petshop.repository.EstadoRepository;
import com.ian.petshop.repository.PetRepository;
import com.ian.petshop.repository.ProdutoRepository;
import com.ian.petshop.repository.RacaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PopulaDados {
  @Autowired
  CategoriaRepository categoriaRepository;
  @Autowired
  ProdutoRepository produtoRepository;
  @Autowired
  PetRepository petRepository;
  @Autowired
  EspecieRepository especieRepository;
  @Autowired
  RacaRepository racaRepository;
  @Autowired
  EstadoRepository estadoRepository;
  @Autowired
  CidadeRepository cidadeRepository;

  @PostConstruct
  public void cadrastro() {
    Categoria cat1 = new Categoria(null, "Alimento");
    Categoria cat2 = new Categoria(null, "Remédio");
    Categoria cat3 = new Categoria(null, "Cosmético");

    Produto p1 = new Produto(null, "Ração", 100.00);
    Produto p2 = new Produto(null, "Sache", 80.00);
    Produto p3 = new Produto(null, "Vermifugo", 20.00);
    Produto p4 = new Produto(null, "Shampoo", 50.00);

    Especie esp1 = new Especie(null, "Cachorro");
    Especie esp2 = new Especie(null, "Gato");

    Raca rac1 = new Raca(null, "Shitzu");
    Raca rac2 = new Raca(null, "Akita");
    Raca rac3 = new Raca(null, "Persa");

    Pet pet1 = new Pet(null, "Jonh", 6, esp1, rac1);
    Pet pet2 = new Pet(null, "Hana", 5, esp1, rac2);
    Pet pet3 = new Pet(null, "Mewth", 8, esp2, rac3);

    cat1.getProdutos().addAll(Arrays.asList(p1, p2));
    cat2.getProdutos().addAll(Arrays.asList(p3, p4));
    cat3.getProdutos().addAll(Arrays.asList(p4));

    p1.getCategorias().add(cat1);
    p2.getCategorias().add(cat1);
    p3.getCategorias().add(cat2);
    p4.getCategorias().addAll(Arrays.asList(cat2, cat3));

    Estado est1 = new Estado(null, "Minas Gerais");
    Estado est2 = new Estado(null, "São Paulo");

    Cidade cid1 = new Cidade(null, "Belo Horizonte", est1);
    Cidade cid2 = new Cidade(null, "Capelinha", est1);
    Cidade cid3 = new Cidade(null, "São Paulo", est2);

    est1.getCidades().addAll(Arrays.asList(cid1, cid2));
    est2.getCidades().addAll(Arrays.asList(cid3));

    categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
    especieRepository.saveAll(Arrays.asList(esp1, esp2));
    racaRepository.saveAll(Arrays.asList(rac1, rac2, rac3));
    petRepository.saveAll(Arrays.asList(pet1, pet2, pet3));
    estadoRepository.saveAll(Arrays.asList(est1, est2));
    cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
  }
}
