package calculator;

import org.junit.jupiter.api.Test;

import NegativeNumbersNotAllowedException.NegativeNumbersNotAllowedException;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

    @Test
    void empty_string_should_return_0() throws NumberFormatException, NegativeNumbersNotAllowedException{
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int() throws NumberFormatException, NegativeNumbersNotAllowedException {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }
    
    @Test
    void string_with_two_number_should_return_number_as_sum() throws NumberFormatException, NegativeNumbersNotAllowedException  {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("1,2"));
    }
    
    @Test
    void string_with_multiple_number_should_return_number_as_sum() throws NumberFormatException, NegativeNumbersNotAllowedException  {
    	StringCalculator stringCalculator = new StringCalculator();
        assertEquals(10, stringCalculator.add("1,2,3,4"));
    }
    
    @Test
    void string_with_multiple_delimiter_should_return_number_as_sum2() throws NumberFormatException, NegativeNumbersNotAllowedException  {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }
    
    @Test
    void string_starts_with_multiple_delimiter_should_return_number_as_sum() throws NumberFormatException, NegativeNumbersNotAllowedException  {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("//;\n1;2"));
        
    }
    @Test
    void string_with_negative_number_should_throw_error() throws NumberFormatException, NegativeNumbersNotAllowedException  {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("//;\n-1;-2"));
    }

    @Test
    void string_with_number_greater_than_1000_should_return_number_as_int() throws NumberFormatException, NegativeNumbersNotAllowedException {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(2, stringCalculator.add("2+1001"));
    }
    
    }

