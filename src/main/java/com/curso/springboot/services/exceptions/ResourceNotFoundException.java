
package com.curso.springboot.services.exceptions;

/**
 *
 * @author Evandro
 */
public class ResourceNotFoundException  extends RuntimeException{

    public ResourceNotFoundException( Object id) {
        super("Resource not found, id: " + id);
    }
    
}
