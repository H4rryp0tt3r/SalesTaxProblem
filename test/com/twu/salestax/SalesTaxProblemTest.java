package com.twu.salestax;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SalesTaxProblemTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("1 imported box of chocolates at 10.00\n1 imported bottle of perfume at 47.50".getBytes());

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(inContent);
    }

    @Test
    public void shouldBeAbleToPrintFinalReceiptWithTaxDetails() {
        SalesTaxProblem salesTaxProblem = new SalesTaxProblem(new Items());

        salesTaxProblem.printReceipt();

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is("1 imported box of chocolates : 10.50\n" +
                "1 imported bottle of perfume : 54.65\n" +
                "Sales Taxes : 7.65\n" +
                "Total : 65.15\n"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
        System.setIn(null);
    }
}