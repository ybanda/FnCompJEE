/**
 * 
 */
package com.mastertutorial.jse.concepts;

/**
 * @author Yashwanth
 *
 */
public class SingletonClass {

	private static SingletonClass singletonClass;
	
	static {
		singletonClass = new SingletonClass();
	}
	public static SingletonClass getInstance() {
		return singletonClass;
	}
	
	private SingletonClass() {
		System.out.println("Singleton Class Object Created");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingletonClass obj = SingletonClass.getInstance();
		System.out.println(obj.toString());
		
		SingletonClass obj2 = SingletonClass.getInstance();
		System.out.println(obj2.toString());

	}

}
