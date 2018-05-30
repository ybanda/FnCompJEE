/**
 * 
 */
package com.mastertutorial.jse.concepts;

/**
 * @author Yashwanth
 *
 */
public class Concepts {
  
	public void getStatus() {
		System.out.println("Concepts :: Status");
	}
	public void getStatus(int index) {
		System.out.println("Concepts :: Status (1)");
	}
	public int getStatus(int index, String name) {
		System.out.println("Concepts :: Status(1,2)");
		return 0;
	}
	public static void overrideStatic() {
		System.out.println("Concepts :: Override Static");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test ;
		try {
			test ="Yashwanth";
			System.out.println("test = "+test);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			test=null;
		}

	}

}
