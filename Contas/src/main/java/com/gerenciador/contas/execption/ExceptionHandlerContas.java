package com.gerenciador.contas.execption;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionHandlerContas {



    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> exceptionHandlerValorInvalido(HttpMessageNotReadableException exception, HttpServletRequest request){
        return new ResponseEntity<>("O preenchimento é invalido, revise os itens obrigatorios e a formatação", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> exceptionHandlerObjetoNaoEncontrado( NoSuchElementException notFound, HttpServletRequest request) {
        return new ResponseEntity<>("Resultado(s) não encontrado(s)", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> resourceNotFound(HttpClientErrorException notFound, HttpServletRequest servletRequest){
        return new ResponseEntity<>("Sua lista esta vazia", HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> valorIncompativel(DataIntegrityViolationException exception, HttpServletRequest request){
        return new ResponseEntity<>("Os campos não podem ser nulos", HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
