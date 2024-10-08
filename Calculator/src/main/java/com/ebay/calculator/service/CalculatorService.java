package com.ebay.calculator.service;

import com.ebay.calculator.entity.ChainRequest;
import com.ebay.calculator.entity.OperationAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service contains all the business logic for calcultion.
 */
@Service
public class CalculatorService {

    @Autowired
    private Calculator calculator;

    @Autowired
    private CalculationValidationService calValidationService;

    /**
     * calculate one operation.
     * @param op
     * @param num1
     * @param num2
     * @return double result
     * @throws Exception
     */
    public double cal(String op, double num1, double num2) throws Exception {
        calValidationService.validate(new OperationAction(op, num2));
        return calculator.calculate(op, num1, num2);
    }

    /**
     * calculate a chain of operations.
     * @param request
     * @return a double result
     * @throws Exception
     */
    public double chain(ChainRequest request) throws Exception{
        List<OperationAction> actionList = request.ops;
        calValidationService.validate(actionList);
        return calculator.chainCalculate(request);
    }

}
