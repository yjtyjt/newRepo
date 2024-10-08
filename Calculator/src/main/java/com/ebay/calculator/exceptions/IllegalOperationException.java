package com.ebay.calculator.exceptions;

public class IllegalOperationException extends RuntimeException{
    public IllegalOperationException(String operation){
        super(String.format("The operation %s is not supported.", operation));
    }
}

