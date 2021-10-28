package com.ian.petshop.dtos;

import java.io.Serializable;
import java.util.Date;

import com.ian.petshop.domain.Cliente;
import com.ian.petshop.domain.Pagamento;
import com.ian.petshop.domain.Pet;
import com.ian.petshop.domain.Servico;

public class ServicoDTO implements Serializable {

  public static final long serialVersionUID = 1L;

  private Date dataEntrada;
  private Date dataSaida;
  private String descricao;
  private Pagamento pagamento;
  private Cliente cliente;
  private Pet pet;

  public ServicoDTO() {
  }

  public ServicoDTO(Servico servico) {
    this.dataEntrada = servico.getDataEntrada();
    this.dataSaida = servico.getDataSaida();
    this.descricao = servico.getDescricao();
    this.pagamento = servico.getPagamento();
    this.cliente = servico.getCliente();
    this.pet = servico.getPet();
  }

  public Date getDataEntrada() {
    return dataEntrada;
  }

  public void setDataEntrada(Date dataEntrada) {
    this.dataEntrada = dataEntrada;
  }

  public Date getDataSaida() {
    return dataSaida;
  }

  public void setDataSaida(Date dataSaida) {
    this.dataSaida = dataSaida;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Pagamento getPagamento() {
    return pagamento;
  }

  public void setPagamento(Pagamento pagamento) {
    this.pagamento = pagamento;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Pet getPet() {
    return pet;
  }

  public void setPet(Pet pet) {
    this.pet = pet;
  }

}
