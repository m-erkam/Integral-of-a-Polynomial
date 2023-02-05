
package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Polynomial {

	private double deltaX = 0.0001;

	//Example solution:
	//Index 0: Coef. of x^0
	//Index 1: Coef. of x^1
	//Index 2: Coef. of x^2
	//Index 3: Coef. of x^3
	//Index 4: Coef. of x^4
	//If there is no x^n, that coefficient should be 0.

	private ArrayList<Integer> coefficients = new ArrayList<Integer>();

	//Fill in coefficients inside the constructor
	public Polynomial(String polynomial) {
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		
		
		int x4_coef = 0;	// Initializing x^4 coefficient 
		for (int i = 0; i < polynomial.length()-2; i++) {		// First I search "x" in the string	
			if (polynomial.charAt(i) == 'x') {
				if (polynomial.charAt(i+1) == '^' && polynomial.charAt(i+2) == '4') {	// When it finds x then it checks ^4  
					if (i == 0)		// When x^4 is in the beginning of the string, it sets coefficient to 1
						x4_coef = 1;	
					for (int j = i-1, power = 0 ; j >= 0; j--, power++) {	// When it is not in the beginning, it search for all digits of the coefficient
						if (Character.isDigit(polynomial.charAt(j))) {		
							x4_coef += (polynomial.charAt(j)-48) * Math.pow(10, power);		// According to the digit number, it adds the number to the coefficient 
							continue;
						} else if (polynomial.charAt(j) == '-') {	// If coefficient is negative, it convert the positive coef. to negative
							if (x4_coef == 0) {
								x4_coef = -1;
							} else {
								x4_coef *= -1;
							}
							break;
						} else if (polynomial.charAt(j) == '+') {	
							if (x4_coef == 0) {
								x4_coef = 1;
							}
							break;
						}
					}

				}
			}
		}
		coefficients.add(0, x4_coef);	// Lastly, It adds the coefficient to the first element of the list 
		
		
		
		int x3_coef = 0;	// Initializing x^3 coefficient
		for (int i = 0; i < polynomial.length()-2; i++) {	// First I search "x" in the string	
			if (polynomial.charAt(i) == 'x') {
				
				if (polynomial.charAt(i+1) == '^' && polynomial.charAt(i+2) == '3') {  // When it finds x then it checks ^3
					if (i == 0)		// When x^3 is in the beginning of the string, it sets coefficient to 1
						x3_coef = 1;
					for (int j = i-1, power = 0 ; j >= 0; j--, power++) {	// When it is not in the beginning, it search for all digits of the coefficient
						if (Character.isDigit(polynomial.charAt(j))) {
							x3_coef += (polynomial.charAt(j)-48) * Math.pow(10, power);		// According to the digit number, it adds the number to the coefficient
							continue;
						} else if (polynomial.charAt(j) == '-') {	// If coefficient is negative, it convert the positive coef. to negative
							if (x3_coef == 0) {
								x3_coef = -1;
							} else {
								x3_coef *= -1;
							}
							break;
						} else if (polynomial.charAt(j) == '+') {
							if (x3_coef == 0) {
								x3_coef = 1;
							}
							break;
						}
					}

				}
			}
		}
		coefficients.add(0, x3_coef);		// It adds the coefficient to the first element of the list 
		
		
		int x2_coef = 0;	// Initializing x^2 coefficient
		for (int i = 0; i < polynomial.length()-2; i++) {	// First I search "x" in the string	
			if (polynomial.charAt(i) == 'x') {

				if (polynomial.charAt(i+1) == '^' && polynomial.charAt(i+2) == '2') {	// When it finds x then it checks ^2
					if (i == 0)		// When x^2 is in the beginning of the string, it sets coefficient to 1
						x2_coef = 1;
					for (int j = i-1, power = 0 ; j >= 0; j--, power++) {	// When it is not in the beginning, it search for all digits of the coefficient
						if (Character.isDigit(polynomial.charAt(j))) {
							x2_coef += (polynomial.charAt(j)-48) * Math.pow(10, power);	// According to the digit number, it adds the number to the coefficient
							continue;
						} else if (polynomial.charAt(j) == '-') {	// If coefficient is negative, it convert the positive coef. to negative
							if (x2_coef == 0) {
								x2_coef = -1;
							} else {
								x2_coef *= -1;
							}
							break;
						} else if (polynomial.charAt(j) == '+') {
							if (x2_coef == 0) {
								x2_coef = 1;
							}
							break;
						}
					}

				}
			}
		}
		coefficients.add(0, x2_coef);	// It adds the coefficient to the first element of the list 
		
		int x_coef = 0;		// Initializing x coefficient
		for (int i = 0; i < polynomial.length(); i++) {		// First I search "x" in the string	
			if (polynomial.charAt(i) == 'x') {

				if (i == polynomial.length()-1 || polynomial.charAt(i+1) != '^') {		// When it finds x then it checks ^1
					if (i == 0)		// When x^1 is in the beginning of the string, it sets coefficient to 1
						x_coef = 1;
					for (int j = i-1, power = 0 ; j >= 0; j--, power++) {	// When it is not in the beginning, it search for all digits of the coefficient
						if (Character.isDigit(polynomial.charAt(j))) {
							x_coef += (polynomial.charAt(j)-48) * Math.pow(10, power);	// According to the digit number, it adds the number to the coefficient
							continue;
						} else if (polynomial.charAt(j) == '-') {	// If coefficient is negative, it convert the positive coef. to negative
							if (x_coef == 0) {
								x_coef = -1;
							} else {
								x_coef *= -1;
							}
							break;
						} else if (polynomial.charAt(j) == '+') {
							if (x_coef == 0) {
								x_coef = 1;
							}
							break;
						}
					}

				}
			}
		}
		coefficients.add(0, x_coef);	// It adds the coefficient to the first element of the list 
		
		int constant = 0;	// Initializing constant
		
		String[] plus_array = polynomial.split("\\+");	// Program splits the string from + sign 
		for (String el:plus_array) {	// And for each splitted string, it search for a constant number
			if (!el.contains("x")) {	
				if (!el.isEmpty()) {
					constant = Integer.valueOf(el);	// If it finds the number, it sets the number as the constant
					break;
				}
			}
			String[] splitted = el.split("\\-");	// If it doesn't find the number, it again splits the splitted string form - sign
			for (String elements:splitted) {		// And for each splitted string, it search for a constant number
				if (!elements.contains("x")) {
					if (!elements.isEmpty()) {
						if (elements != splitted[0]) {	// If it finds the number in the first index, it means that it splitted form the plus sign and
							constant = -Integer.valueOf(elements);	// it set the constant positive. If it is not in the first index, it should be negative
							break;
						} else {
							constant = Integer.valueOf(elements);
						}
						
					}
					
				}
			}
		}
		
		
		
		coefficients.add(0, constant);	// It adds the constant to the first element of the list 
		

		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	}

	public double valueAt(double point) {
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		
		double fx = Math.pow(point, 4) * coefficients.get(4) + 	// This method takes the point and returns the value of the function at this point
				Math.pow(point, 3) * coefficients.get(3) +
				Math.pow(point, 2) * coefficients.get(2) +
				Math.pow(point, 1) * coefficients.get(1) +
				Math.pow(point, 0) * coefficients.get(0);
		
		
		return fx;

		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	}

	public void setDeltaX(double deltaX) {
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		this.deltaX = deltaX;	// This method sets the deltaX


		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	}


	public int computeIntegral(int min, int max) {
		
		double integration = 0;
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		
		
		
		for (int k = 0; min + (k * deltaX) < max; k++) {			// Compute integral method takes the limits of the integral and it divides the area under the fx
			integration += valueAt(min + (k * deltaX)) * deltaX;	// into small rectangles with width deltaX and adds them and computes the integral
		}
		

		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
		
		return (int)integration;
	}

}

