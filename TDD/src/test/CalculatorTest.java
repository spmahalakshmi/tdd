package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.Calculator;

class CalculatorTest {

	static Calculator calculator;

	@BeforeAll
	static void setUpClass() {
		calculator = new Calculator();
	}

	@Test
	@DisplayName("1 + 1 = 2")
	void test_addTwoNumbers() {
		assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
	}

	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({ "0,    1,   1", "1,    2,   3", "49,  51, 100", "1,  100, 101" })
	void test_additionWithParameters(int first, int second, int expectedResult) {
		assertEquals(expectedResult, calculator.add(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}

	@Test
	void test_multiply2Numbers() {
		assertEquals(4, calculator.multiply(2, 2), "2*2 should equal to 4");
	}

	@ParameterizedTest(name = "{0} * {1} = {2}")
	@CsvSource({ "3,4,12", "5,5,25", "6,7,42", "8,3,24" })
	void test_multiplicationWithParameters(int a, int b, int result) {
		assertEquals(result, calculator.multiply(a, b), 
				() -> a + " * " + b + "should equal to " + result);
	}
	
	@Test
	void testSubtract2Numbers() {
		assertEquals(5,calculator.subtract(8,3),"8-3 should equal to 5");
	}
	
	@ParameterizedTest(name = "{0} - {1} = {2}")
	@CsvSource({ "16,4,12", "30,5,25", "6,2,4", "8,3,5" })
	void test_subtractionWithParameters(int a, int b, int result) {
		assertEquals(result, calculator.subtract(a, b), 
				() -> a + " - " + b + "should equal to " + result);
	}
	
	@Test
	void testDivisionOf2Numbers() {
		assertEquals(5,calculator.divide(25,5),"25/5 should equal to 5");
	}
	
	@ParameterizedTest(name = "{0} / {1} = {2}")
	@CsvSource({ "16,4,4", "30,5,6", "6,2,3", "9,3,3" })
	void test_DivisionWithParameters(int a, int b, int result) {
		assertEquals(result, calculator.divide(a, b), 
				() -> a + " - " + b + "should equal to " + result);
	}
	
	@Test
	void testDivisionForDivideByZeroError() {
		assertThrows(ArithmeticException.class, 
				() -> calculator.divide(56, 0));
	}

}
