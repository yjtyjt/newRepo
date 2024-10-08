package com.ebay.calculator.entity;

public class OperationAction {
    public String operation;
    public double value;
    public OperationAction(String operation, double value) {
        this.operation = operation;
        this.value = value;
    }
}
