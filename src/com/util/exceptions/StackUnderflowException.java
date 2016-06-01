package com.util.exceptions;

/**
 * Created by SKapadia on 11/16/2015.
 */
public class StackUnderflowException extends Exception{
    public StackUnderflowException() {
        super();
    }

    public StackUnderflowException(String message) {
        super(message);
    }
}
