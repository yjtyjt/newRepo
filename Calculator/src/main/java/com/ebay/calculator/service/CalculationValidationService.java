package com.ebay.calculator.service;

import com.ebay.calculator.entity.OperationAction;
import com.ebay.calculator.exceptions.DividendZeroException;
import com.ebay.calculator.exceptions.IllegalOperationException;
import com.ebay.calculator.exceptions.MissingOperationException;
import com.ebay.calculator.operations.Operation;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * All the validation of calculation is accomplished here.
 */
@Service
public class CalculationValidationService {
    /**
     * validate one operationAction
     * @param operationAction
     * @throws Exception
     */
    public void validate(OperationAction operationAction) throws Exception {
        if (operationAction.operation == null) {
            throw new MissingOperationException();
        }
        boolean exist = false;
        for (Operation o : Operation.values()) {
            if (o.name().equalsIgnoreCase(operationAction.operation)) {
                exist = true;
            }
        }
        if (!exist) {
            throw new IllegalOperationException(operationAction.operation);
        }
        if (Operation.valueOf(operationAction.operation) == Operation.DIVIDE && operationAction.value == 0) {
            throw new DividendZeroException();
        }
    }

    /**
     * validate a list of operationAction
     * @param operationActions
     * @throws Exception
     */
    public void validate(List<OperationAction> operationActions) throws Exception {
        // It is a valid case, there is no operations in the chain
        // for example, when user presses a number then presses equals"=" in a real calculator,
        // it shows the same number without issues.
        if (operationActions == null) {
            return;
        }
        for (OperationAction oa : operationActions) {
            validate(oa);
        }
    }
}
