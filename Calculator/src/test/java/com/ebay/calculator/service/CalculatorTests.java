package com.ebay.calculator.service;

import com.ebay.calculator.entity.ChainRequest;
import com.ebay.calculator.entity.OperationAction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
// because the validation service will block invalid input, so only valid case is tested.
public class CalculatorTests {

    @Test
    public void testCalculate() throws Exception {
        Calculator c = new Calculator();
        assertEquals(1, c.calculate("ADD", -2, 3));
        assertEquals(-1, c.calculate("SUBTRACT", 2, 3));
        assertEquals(6, c.calculate("MULTIPLY", 2, 3));
        assertEquals(0.5, c.calculate("DIVIDE", 2, 4));
    }

    @Test
    public void testChainCalculate() throws Exception {
        Calculator c = new Calculator();
        List<OperationAction> ops = new ArrayList<>();
        ops.add(new OperationAction("ADD", -2));
        ops.add(new OperationAction("SUBTRACT", 4857));
        ops.add(new OperationAction("MULTIPLY", -2));
        ops.add(new OperationAction("DIVIDE", -2));
        ChainRequest request = new ChainRequest();
        request.initialValue = 1;
        request.ops = ops;
        assertEquals(-4858.0, c.chainCalculate(request));
    }

    public static class CalculationServiceTests {
    }
}
