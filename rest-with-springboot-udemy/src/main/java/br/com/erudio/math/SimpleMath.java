package br.com.erudio.math;

public class SimpleMath {

	public Double sum(Double fistNumber, Double secondNumber) {
		return fistNumber + secondNumber;
	}
	
	public Double subtraction(Double fistNumber, Double secondNumber) {
		return fistNumber - secondNumber;
	}
	
	public Double multiplication(Double fistNumber, Double secondNumber) {
		return fistNumber * secondNumber;
	}
	
	public Double division(Double fistNumber, Double secondNumber) {
		return fistNumber / secondNumber;
	}
	
	public Double media(Double fistNumber, Double secondNumber) {
		return (fistNumber + secondNumber)/2;
	}
	
	public Double squareRoot(Double number) {
		return (Double) Math.sqrt(number);
	}
}
