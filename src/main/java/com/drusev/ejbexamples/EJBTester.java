/**
 * 
 */
package com.drusev.ejbexamples;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Drusev
 *
 */
public class EJBTester {

	private InitialContext context;

	public EJBTester() throws NamingException {
		context = getContext();
	}

	private InitialContext getContext() throws NamingException {
		Hashtable<String, String> jndiProperties = new Hashtable<>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		return new InitialContext(jndiProperties);
	}

	private <T> String buildBeanName(final Class<? extends T> implementationClass, final Class<T> remoteViewClass) {
		// The app name is the application name of the deployed EJBs. This is
		// typically the ear name
		// without the .ear suffix. However, the application name could be
		// overridden in the application.xml of the
		// EJB deployment on the server.
		// Since we haven't deployed the application as a .ear, the app name for
		// us will be an empty string
		final String appName = "";
		// This is the module name of the deployed EJBs on the server. This is
		// typically the jar name of the
		// EJB deployment, without the .jar suffix, but can be overridden via
		// the ejb-jar.xml
		// In this example, we have deployed the EJBs in a
		// jboss-as-ejb-remote-app.jar, so the module name is
		// jboss-as-ejb-remote-app
		final String moduleName = "ejb-examples-0.0.1-SNAPSHOT";
		// AS7 allows each deployment to have an (optional) distinct name. We
		// haven't specified a distinct name for
		// our EJB deployment, so this is an empty string
		final String distinctName = "";
		// The EJB name which by default is the simple class name of the bean
		// implementation class
		final String beanName = implementationClass.getSimpleName();
		// the remote view fully qualified class name
		final String viewClassName = remoteViewClass.getName();
		return "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;
	}

	private void testStatelessEjb2() throws NamingException {
		Calculator calculator = (Calculator) context.lookup(buildBeanName(CalculatorImpl.class, Calculator.class));
		int a = 3;
		int b = 5;
		int sum = calculator.add(a, b);
		System.out.println(a + " + " + b + " = " + sum);
	}

	public static void main(String[] args) throws NamingException {
		EJBTester ejbTester = new EJBTester();
		ejbTester.testStatelessEjb2();
	}
}
