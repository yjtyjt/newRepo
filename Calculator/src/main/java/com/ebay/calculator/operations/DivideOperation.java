package com.ebay.calculator.operations;

import com.ebay.calculator.exceptions.DividendZeroException;

public class DivideOperation implements OperationStrategy{
    @Override
    public double cal(double num1, double num2) {
        if (num2 == 0) {
            throw new DividendZeroException();
        }
        return num1 / num2;
    }
}
