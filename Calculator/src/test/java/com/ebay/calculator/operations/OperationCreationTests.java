package com.ebay.calculator.operations;

import com.ebay.calculator.exceptions.IllegalOperationException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class OperationCreationTests {

    @Test
    public void test() throws Exception {
        assertThat(OperationCreation.create("ADD"), instanceOf(AddOperation.class));
        assertThat(OperationCreation.create("SUBTRACT"), instanceOf(SubstractOperation.class));
        assertThat(OperationCreation.create("MULTIPLY"), instanceOf(MultiplyOperation.class));
        assertThat(OperationCreation.create("DIVIDE"), instanceOf(DivideOperation.class));
    }

    @Test
    public void testIllegalOperationException() {
        assertThrows(IllegalOperationException.class, () -> {
            OperationCreation.create("ABC");
        });
    }
}
