/**
 * 
 */
package com.mastertutorial.mvc.aop;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Yashwanth
 *
 */
public class ExecuteAroundMethod implements MethodInterceptor{


	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("ExecuteAroundMethod :: Before Executed");
		
		System.out.println("Name ="+invocation.getMethod().getName());
		System.out.println("Arguments = "+Arrays.toString(invocation.getArguments()));
		
		Object result = invocation.proceed();
		System.out.println("ExecuteAroundMethod :: After Executed");
		
		return result;
	}

}
