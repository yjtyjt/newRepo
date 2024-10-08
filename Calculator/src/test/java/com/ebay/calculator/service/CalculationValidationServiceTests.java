package com.ebay.calculator.service;

import com.ebay.calculator.entity.OperationAction;
import com.ebay.calculator.exceptions.DividendZeroException;
import com.ebay.calculator.exceptions.IllegalOperationException;
import com.ebay.calculator.exceptions.MissingOperationException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculationValidationServiceTests {

    @Test
    public void testValidSingleOperationAction() {
        CalculationValidationService c = new CalculationValidationService();
        assertDoesNotThrow(() -> c.validate(new OperationAction("ADD", -2)));
        assertDoesNotThrow(() -> c.validate(new OperationAction("SUBTRACT", 7)));
        assertDoesNotThrow(() -> c.validate(new OperationAction("MULTIPLY", 2)));
        assertDoesNotThrow(() -> c.validate(new OperationAction("DIVIDE", 20)));
    }

    @Test
    public void testIllegalOperationAction() {
        CalculationValidationService c = new CalculationValidationService();
        assertThrows(IllegalOperationException.class, () -> {
            c.validate(new OperationAction("XOR", 2.5));
        });
    }

    @Test
    public void testDividendZeroError() {
        CalculationValidationService c = new CalculationValidationService();
        assertThrows(DividendZeroException.class, () -> {
            c.validate(new OperationAction("DIVIDE", 0));
        });
    }

    @Test
    public void testValidOperationActionList() {
        CalculationValidationService c = new CalculationValidationService();
        List<OperationAction> ops = new ArrayList<>();
        ops.add(new OperationAction("ADD", -2));
        ops.add(new OperationAction("SUBTRACT", 4857));
        ops.add(new OperationAction("MULTIPLY", -2));
        ops.add(new OperationAction("DIVIDE", -2));
        assertDoesNotThrow(() -> c.validate(ops));
    }

    @Test
    public void testNullOperationActionList() {
        CalculationValidationService c = new CalculationValidationService();
        List<OperationAction> ops = new ArrayList<>();
        assertDoesNotThrow(() -> c.validate(ops));
    }

    @Test
    public void testIllegalOperationList() {
        CalculationValidationService c = new CalculationValidationService();
        List<OperationAction> ops = new ArrayList<>();
        ops.add(new OperationAction("ADD", -2));
        ops.add(new OperationAction("SUBTRACT", 4857));
        ops.add(new OperationAction("MULTIPLY", -2));
        ops.add(new OperationAction("XOR", 9));
        assertThrows(IllegalOperationException.class, () -> {
            c.validate(ops);
        });
    }

    @Test
    public void testDividendZeroOperationList() {
        CalculationValidationService c = new CalculationValidationService();
        List<OperationAction> ops = new ArrayList<>();
        ops.add(new OperationAction("ADD", -2));
        ops.add(new OperationAction("SUBTRACT", 4857));
        ops.add(new OperationAction("MULTIPLY", -2));
        ops.add(new OperationAction("DIVIDE", 0));
        assertThrows(DividendZeroException.class, () -> {
            c.validate(ops);
        });
    }

    @Test
    public void testMissingOperationList() {
        CalculationValidationService c = new CalculationValidationService();
        List<OperationAction> ops = new ArrayList<>();
        ops.add(new OperationAction(null, -2));
        ops.add(new OperationAction("SUBTRACT", 4857));
        ops.add(new OperationAction("MULTIPLY", -2));
        ops.add(new OperationAction("DIVIDE", 0));
        assertThrows(MissingOperationException.class, () -> {
            c.validate(ops);
        });
    }


}
