package com.gerenciador.contas.excption;

public class ResourceNotFOundException extends RuntimeException{
private static final long serialVersionUID = 1L;
public ResourceNotFOundException(String msg) {
        super(msg);
        }
}
