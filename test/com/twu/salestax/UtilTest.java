package com.twu.salestax;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UtilTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldBeAbleToCalculate10PercentageTax() {
        double actualResult = Util.calculateTax(14.99, 10);

        assertThat(actualResult, is(1.5));
    }

    @Test
    public void shouldBeAbleToParseStrings() {
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("1");
        expectedList.add("music CD");
        expectedList.add("14.99");

        ArrayList<String> actualList = Util.parseString("1 music CD at 14.99");

        assertThat(actualList, is(expectedList));
    }

    @Test
    public void shouldBeAbleToIdentifyImportedItems() {
        Boolean actualResult = Util.isImported("1 packet of imported headache pills at 9.75");

        assertThat(actualResult, is(true));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}