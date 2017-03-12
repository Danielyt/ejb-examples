/**
 * 
 */
package com.drusev.ejbexamples;

import javax.ejb.Stateless;

/**
 * @author Drusev
 *
 */
@Stateless // if the annotation is missing NoSuchEjbException is thrown when
			// lociting the ejb
public class CalculatorImpl implements Calculator {

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int subtract(int a, int b) {
		return a - b;
	}

}
