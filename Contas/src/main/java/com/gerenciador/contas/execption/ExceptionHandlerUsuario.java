package com.gerenciador.contas.execption;

import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionHandlerUsuario {

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<String> valorDuplicado(DuplicateKeyException duplicateKeyException, HttpServletRequest servletRequest){
        return new ResponseEntity<>("Este usuario ja existe em nosso sistema", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> valorInaceitavel(MethodArgumentNotValidException exception, HttpServletRequest request){
        return new ResponseEntity<>("A formatação ou o numero de caracteres é invalida", HttpStatus.METHOD_NOT_ALLOWED);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> exceptionHandlerValorInvalido(HttpMessageNotReadableException exception, HttpServletRequest request){
        return new ResponseEntity<>("O preenchimento é invalido, revise os itens obrigatorios e a formatação", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> valorIncompativel(ConstraintViolationException exception, HttpServletRequest request){
        return new ResponseEntity<>("O numero de caracteres é invalido", HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
