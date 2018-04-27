/**
 * 
 */
package com.mastertutorial.mvc.aop;

import org.springframework.aop.ThrowsAdvice;

/**
 * @author Yashwanth
 *
 */
public class ExecuteAfterThrowingAdvice implements ThrowsAdvice{

	public void afterThrowing(IllegalArgumentException e) throws Throwable{
		System.err.println("ExecuteAfterThrowingAdvice :: After Throwing Exception");
	}
	
}
