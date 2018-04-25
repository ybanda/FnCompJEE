/**
 * 
 */
package com.mastertutorial.jse.concepts;

/**
 * @author Yashwanth
 *
 */
public class OverloadOverride extends Concepts{

	public OverloadOverride() {
		// TODO Auto-generated constructor stub
		super();
	}

	public void getStatus() {
		System.out.println("OverloadOverride :: Status");
	}
	public static void overrideStatic() {
		System.out.println("OverloadOverride :: Override Static");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OverloadOverride obj = new OverloadOverride();
		obj.getStatus();
		obj.getStatus(1);
		overrideStatic();
	}
	public void main(String[] args,int u) {
		try {
			
		}
		
		catch(ArithmeticException | NullPointerException  nullpe) {
				
			}
			
		}
	}
