package com.ian.petshop.repository;

import com.ian.petshop.domain.Raca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Integer> {

}
