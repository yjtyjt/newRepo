package com.ebay.calculator.exceptions;


public class DividendZeroException extends RuntimeException{
    public DividendZeroException(){
        super("Dividend can not be zero!");
    }
}
