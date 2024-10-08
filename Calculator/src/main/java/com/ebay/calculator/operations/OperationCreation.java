package com.ebay.calculator.operations;

import com.ebay.calculator.exceptions.IllegalOperationException;

/**
 * create the operation strategry
 */
public class OperationCreation {
    public OperationStrategy operationStrategy;

    /**
     * create a operationStrategy based on the operation.
     * @param operation
     * @return
     * @throws Exception
     */
    public static OperationStrategy create(String operation) throws Exception {
        if (Operation.ADD.name().equalsIgnoreCase(operation)) {
            return new AddOperation();
        } else if (Operation.SUBTRACT.name().equalsIgnoreCase(operation)) {
            return new SubstractOperation();
        } else if (Operation.MULTIPLY.name().equalsIgnoreCase(operation)) {
            return new MultiplyOperation();
        } else if (Operation.DIVIDE.name().equalsIgnoreCase(operation)) {
            return new DivideOperation();
        } else {
            throw new IllegalOperationException(operation);
        }
    }
}
