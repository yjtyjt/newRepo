package com.ebay.calculator.controller;

import com.ebay.calculator.entity.ChainRequest;
import com.ebay.calculator.entity.OperationAction;
import com.ebay.calculator.service.CalculationValidationService;
import com.ebay.calculator.service.Calculator;
import com.ebay.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTests {
    @InjectMocks
    private CalculatorController controller;
    @Mock
    private CalculatorService service;

    @Test
    public void testMethodCal() throws Exception {
        controller.cal("ADD", 2, 3);
        // make sure calculatorService according method is called.
        verify(service,times(1)).cal("ADD", 2, 3);
    }

    @Test
    public void testMethodChain() throws Exception {
        Calculator c = new Calculator();
        List<OperationAction> ops = new ArrayList<>();
        ops.add(new OperationAction("ADD", -2));
        ops.add(new OperationAction("SUBTRACT", 4857));
        ops.add(new OperationAction("MULTIPLY", -2));
        ops.add(new OperationAction("DIVIDE", -2));
        ChainRequest request = new ChainRequest();
        request.initialValue = 1;
        request.ops = ops;
        controller.chain(request);
        // make sure calculatorService according method is called.
        verify(service,times(1)).chain(Mockito.any());
    }
}
