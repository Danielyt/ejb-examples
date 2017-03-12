/**
 * 
 */
package com.drusev.ejbexamples;

import javax.ejb.Stateless;

/**
 * @author Drusev
 *
 */
@Stateless
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
