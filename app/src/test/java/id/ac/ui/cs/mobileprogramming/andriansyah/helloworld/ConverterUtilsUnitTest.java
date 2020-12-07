package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterUtilsUnitTest {
    @Test
    public void celciusToFahrenheitWasConvertedCorrectly() {
        assertEquals("86.0", ConverterUtils.convertCelsiusToFahrenheit(30));
    }

    @Test
    public void celciusToReamurWasConvertedCorrectly() {
        assertEquals("24.0", ConverterUtils.convertCelsiusToReamur(30));
    }

    @Test
    public void FahrenheitToCelciusWasConvertedCorrectly() {
        assertEquals("30.0", ConverterUtils.convertFahrenheitToCelsius(86));
    }

    @Test
    public void FahrenheitToReamurWasConvertedCorrectly() {
        assertEquals("24.0", ConverterUtils.convertFahrenheitToReamur(86));
    }

    @Test
    public void reamurToCelciusWasConvertedCorrectly() {
        assertEquals("30.0", ConverterUtils.convertReamurToCelcius(24));
    }

    @Test
    public void reamurToFahrenheitWasConvertedCorrectly() {
        assertEquals("86.0", ConverterUtils.convertReamurToFahrenheit(24));
    }
}