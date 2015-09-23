package edu.starterkit.aop.logger;

import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.interceptor.AroundInvoke;

@Logged
@Interceptor
public class LoggerInterceptor {
	
	@AroundInvoke
	public Object aroundInvokeMethod(InvocationContext context) throws Exception {
		
		System.out.println("Intercepting method call");
		
		/*
		 * Print the called method.
		 */
		System.out.println("Called method:\n" + context.getMethod().getName().toString());
		
		/*
		 * Print called method parameters.
		 */
		System.out.println("Parameters:");
		for(Object param : context.getParameters()) {
			System.out.println("Parameter: " + param.getClass().toString() + ", value: " + param.toString());
		}
		
		/*
		 * Call the method.
		 */
		Object result = context.proceed();
		
		/*
		 * Print the result.
		 */
		System.out.println("Result:\n" + result.toString());
		
		return result;
	}
}
