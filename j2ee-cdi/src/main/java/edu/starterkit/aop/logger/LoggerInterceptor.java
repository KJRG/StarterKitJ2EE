package edu.starterkit.aop.logger;

import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;

@Logged
@Interceptor
public class LoggerInterceptor {
	
	private Logger logger = Logger.getGlobal();
	
	@AroundInvoke
	public Object aroundInvokeMethod(InvocationContext context) throws Exception {
		
		StringBuilder builder = new StringBuilder();
		builder.append("Intercepting method call");
		
		/*
		 * Print the called method's name and parameters.
		 */
		builder.append("\nCalled method: " + context.getMethod().getName() + "(");
		List<Parameter> params = Arrays.asList(context.getMethod().getParameters());
		ListIterator<Parameter> iter = params.listIterator();
		while(iter.hasNext()) {
			Parameter p = iter.next();
			builder.append(p.getParameterizedType().toString() + " " + p.getName());
			if(iter.hasNext()) {
				builder.append(", ");
			}
		}
		builder.append(")");
		
		/*
		 * Print called method parameters.
		 */
		Object[] passedParams = context.getParameters();
		if(passedParams != null && passedParams.length > 0) {
			builder.append("\nParameters:");
			for(Object param : passedParams) {
				builder.append("\n\ttype: " + param.getClass().toString() + ", value: " + param.toString());
			}
		}
		
		/*
		 * Call the method.
		 */
		builder.append("\nCalling method...");
		logger.log(Level.INFO, builder.toString());
		Object result = context.proceed();
		
		/*
		 * Print the result.
		 */
		logger.log(Level.INFO, "Result:\n" + result.toString());
		
		return result;
	}
}
