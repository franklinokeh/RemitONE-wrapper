package com.codedsolutions47.remitonewrapper.exceptions;

/**
 *
 * @author Kolawole
 */
public class ApiException extends RuntimeException {

    ApiException(String message){
        super(message);
    }

    ApiException(String message, Throwable cause){
        super(message, cause);
        if(this.getCause() == null && cause != null){
            this.initCause(cause);
        }
    }
}
