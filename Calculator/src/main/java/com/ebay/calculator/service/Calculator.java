package com.ebay.calculator.service;

import com.ebay.calculator.entity.ChainRequest;
import com.ebay.calculator.operations.OperationCreation;
import com.ebay.calculator.operations.OperationStrategy;
import org.springframework.stereotype.Service;

/**
 * Calculator only focus on operations.
 */
@Service
public class Calculator {

    /**
     * calculate a chain of operations
     * @param request
     * @return
     * @throws Exception
     */
    public double chainCalculate(ChainRequest request) throws Exception {
        double res = request.initialValue;
        // It is a valid case, there is no operations in the chain
        // for example, when user presses a number then presses equals"=" in a real calculator,
        // it shows the same number without issues.
        if (request.ops == null) {
            return res;
        }
        int size = request.ops.size();
        for (int i = 0; i < size; i++) {
            res = calculate(request.ops.get(i).operation, res, request.ops.get(i).value);
        }
        return res;
    }

    /**
     * calculate one operation
     * @param op
     * @param num1
     * @param num2
     * @return
     * @throws Exception
     */
    public double calculate(String op, double num1, double num2) throws Exception {
        OperationStrategy os = OperationCreation.create(op);
        return os.cal(num1, num2);
    }
}
