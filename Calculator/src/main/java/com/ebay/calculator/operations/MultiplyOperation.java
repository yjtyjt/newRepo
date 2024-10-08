package com.ebay.calculator.operations;

public class MultiplyOperation implements OperationStrategy{
    @Override
    public double cal(double num1, double num2) {
        return num1 * num2;
    }
}
