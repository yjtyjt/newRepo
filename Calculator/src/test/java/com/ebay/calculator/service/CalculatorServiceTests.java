package com.ebay.calculator.service;

import com.ebay.calculator.entity.ChainRequest;
import com.ebay.calculator.entity.OperationAction;
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
public class CalculatorServiceTests {
    @InjectMocks
    private CalculatorService service;
    @Mock
    private CalculationValidationService validationService;

    @Mock
    private Calculator calculator;

    @Test
    public void testMethodCal() throws Exception {
        service.cal("ADD", 2, 3);
        // make sure validationService and calculator according method is called.
        verify(validationService,times(1)).validate(Mockito.any(OperationAction.class));
        verify(calculator,times(1)).calculate("ADD", 2, 3);
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
        service.chain(request);
        // make sure validationService and calculator according method is called.
        verify(validationService,times(1)).validate(Mockito.anyList());
        verify(calculator,times(1)).chainCalculate(request);
    }

}
