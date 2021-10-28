package com.ian.petshop.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import com.ian.petshop.service.exceptions.DataIntegrityException;
import com.ian.petshop.service.exceptions.ObjetoNaoEncontradoException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ObjetoNaoEncontradoException.class)
  public ResponseEntity<StandardError> objNotFounEntity(ObjetoNaoEncontradoException e, HttpServletRequest request) {
    StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

  }

  @ExceptionHandler(DataIntegrityException.class)
  public ResponseEntity<StandardError> dataIntegrityEntity(DataIntegrityException e, HttpServletRequest request) {
    StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

  }
}
