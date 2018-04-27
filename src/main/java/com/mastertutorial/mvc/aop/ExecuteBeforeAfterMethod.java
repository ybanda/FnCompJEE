/**
 * 
 */
package com.mastertutorial.mvc.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author Yashwanth
 *
 */
public class ExecuteBeforeAfterMethod implements MethodBeforeAdvice,AfterReturningAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("ExecuteBeforeMethod :: Executed Before Method :: before()");
		
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("ExecuteBeforeMethod :: Executed after Returning Method :: afterReturning()");
		
	}

}
