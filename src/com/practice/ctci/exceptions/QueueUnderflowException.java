package com.practice.ctci.exceptions;

/**
 * Created by SKapadia on 11/16/2015.
 */
public class QueueUnderflowException extends Exception{
    public QueueUnderflowException() {
        super();
    }

    public QueueUnderflowException(String message) {
        super(message);
    }
}
