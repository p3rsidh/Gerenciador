package com.gerenciador.contas.execption;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import javax.naming.NotContextException;
import javax.servlet.http.HttpServletRequest;
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

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<String>

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> apagarMsg(HttpClientErrorException exception, HttpServletRequest servletRequest){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> valorIncompativel(DataIntegrityViolationException exception, HttpServletRequest request){
        return new ResponseEntity<>("Os campos não podem ser nulos", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NotContextException.class)
    public ResponseEntity<String > valorNaoAceito(NotContextException exception, HttpServletRequest servletRequest){
        return new ResponseEntity<>("O valor inserido não é aceito", HttpStatus.EXPECTATION_FAILED);
    }
}
