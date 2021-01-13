package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converter.NumberConverter;
import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.math.SimpleMath;

@RestController
public class MathController {
	
	private NumberConverter converter = new NumberConverter();
	
	SimpleMath math = new SimpleMath();
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
	if(!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)) {
		throw new UnsuportedMathOperationException("Please set a numeric value");
	}
		return math.sum(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
	}

		
	@RequestMapping(value="/subtrai/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtrai(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
	if(!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)) {
		throw new UnsuportedMathOperationException("Please set a numeric value");
	}
		return math.subtraction(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/multiplic/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplic(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
	if(!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)) {
		throw new UnsuportedMathOperationException("Please set a numeric value");
	}
		return math.multiplication(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/divide/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double divide(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
	if(!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)) {
		throw new UnsuportedMathOperationException("Please set a numeric value");
	}
		return math.division(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
	if(!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)) {
		throw new UnsuportedMathOperationException("Please set a numeric value");
	}
		return math.media(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/raizq/{number}", method = RequestMethod.GET)
	public Double raizq(@PathVariable("number") String number) throws Exception {
		if (!converter.isNumeric(number)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		return math.squareRoot(converter.convertToDouble(number));
	}
}
