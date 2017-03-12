/**
 * 
 */
package com.drusev.ejbexamples;

import javax.ejb.Remote;

/**
 * @author Drusev
 *
 */
@Remote
public interface Calculator {

	int add(int a, int b);

	int subtract(int a, int b);
}
