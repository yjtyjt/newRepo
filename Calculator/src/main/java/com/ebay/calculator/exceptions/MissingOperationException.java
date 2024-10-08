package com.ebay.calculator.exceptions;

public class MissingOperationException extends RuntimeException {
    public MissingOperationException(){
        super("Some operation is missing.");
    }
}
