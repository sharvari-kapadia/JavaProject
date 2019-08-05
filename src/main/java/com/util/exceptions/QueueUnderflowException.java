package com.util.exceptions;

/**
 * Created by SKapadia on 11/28/2015.
 */
public class QueueUnderflowException extends Exception{
    public QueueUnderflowException() {
        super();
    }

    public QueueUnderflowException(String message) {
        super(message);
    }
}
