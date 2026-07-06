package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AaaPatternTest {
    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testAddUsingAaaPattern() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(5, result);
    }
}
