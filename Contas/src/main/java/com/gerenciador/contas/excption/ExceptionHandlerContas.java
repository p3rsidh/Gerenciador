package com.gerenciador.contas.excption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerContas {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> exceptionHandlerValorInvalido(HttpMessageNotReadableException exception, HttpServletRequest request){
        return new ResponseEntity<>("O preenchimento é invalido, revise os itens obrigatorios e a formatação", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> exceptionHandlerObjetoNaoEncontrado(HttpClientErrorException.NotFound notFound, HttpServletRequest request){
        return new ResponseEntity<>("Sua busca não encontrou resultados", HttpStatus.NOT_FOUND);
    }
}
