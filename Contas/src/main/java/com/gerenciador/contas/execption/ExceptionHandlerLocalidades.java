package com.gerenciador.contas.execption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.NoSuchElementException;

public class ExceptionHandlerLocalidades {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> valorInaceitavel(MethodArgumentNotValidException exception, HttpServletRequest request){
        return new ResponseEntity<>("A formatação é invalida", HttpStatus.METHOD_NOT_ALLOWED);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> exceptionHandlerValorInvalido(HttpMessageNotReadableException exception, HttpServletRequest request){
        return new ResponseEntity<>("O preenchimento é invalido, revise os itens obrigatorios e a formatação", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> exceptionHandlerObjetoNaoEncontrado( NoSuchElementException notFound, HttpServletRequest request) {
        return new ResponseEntity<>("Resultado(s) não encontrado(s)", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<String> listaVazia(HttpServerErrorException exception, HttpServletRequest servletRequest){
        return new ResponseEntity<>("Sua lista esta vazia",HttpStatus.NOT_FOUND);
    }
}
