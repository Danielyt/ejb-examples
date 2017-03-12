/**
 * 
 */
package com.drusev.ejbexamples;

import javax.ejb.Remote;

/**
 * @author Drusev
 *
 */
@Remote // if there is no remote annotation the ejb cannot be located by a
		// remote client
public interface Calculator {

	int add(int a, int b);

	int subtract(int a, int b);
}
