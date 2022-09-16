package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.math.BasicMath;

@RestController
public class MathController {
	
	BasicMath calc = new BasicMath();

	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");			
		}
		Double sum  = calc.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		return sum;
	}
	
	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double sub = calc.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		return sub;
	}
	
	@RequestMapping(value="/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mult(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double mult = calc.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		return mult;
	}
	
	@RequestMapping(value="div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double div = calc.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		return div;
	}
	
	@RequestMapping(value="med/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double med(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double med = calc.med(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		return med;
	}
	
	@RequestMapping(value="root/{number}", method = RequestMethod.GET)
	public Double root(@PathVariable("number") String number) throws Exception {
		if(!NumberConverter.isNumeric(number)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double root = calc.root(NumberConverter.convertToDouble(number));
		return root;
	}

}