package com.curso.springboot.services.exceptions;

/**
 *
 * @author Evandro
 */
public class DataBaseException extends RuntimeException{

    public DataBaseException(String msg) {
        super(msg);
    }
    
}
