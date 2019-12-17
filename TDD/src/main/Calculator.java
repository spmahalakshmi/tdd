package main;

public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}

	public int multiply(int i, int j) {
		return i * j;
	}

	public int subtract(int i, int j) {
		return i - j;
	}

	public int divide(int i, int j) throws ArithmeticException{
		return i/j;
	}	
}
