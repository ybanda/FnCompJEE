/**
 * 
 */
package com.mastertutorial.jse.concepts;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.slf4j.LoggerFactory;

import com.mastertutorial.mvc.model.Person;

public class ReflectionTest {
private static org.slf4j.Logger Logger = LoggerFactory.getLogger(ReflectionTest.class);
	   public static void main(String args[]) throws ClassNotFoundException {

@SuppressWarnings("unchecked")
Class<Person> person = (Class<Person>) Class.forName("com.mastertutorial.mvc.model.Person");

   //getFields() does not return private field
   System.out.println("Fields : " + Arrays.toString(person.getFields()));

   //getDeclaredFields() return both private and non private fields using reflection
   System.out.println("Declared Fields : " + Arrays.toString(person.getDeclaredFields()));      
      
   //getDeclaredMethods() return both private and non private methods using reflection
   System.out.println("Declared methods : " + Arrays.toString(person.getDeclaredMethods()));

   try {
    
       //accessing value of private field using reflection in Java
       Person privateRyan = new Person("John" , "8989736353");
       java.lang.reflect.Field privateField = person.getDeclaredField("phone");
    
       //this call allows private fields to be accessed via reflection
       privateField.setAccessible(true);
    
       //getting value of private field using reflection
       String value = (String) privateField.get(privateRyan);          
    
       //print value of private field using reflection
       System.out.println("private field: " + privateField + " value: " + value);
    
    
       //accessing private method using reflection
       Method privateMethod = person.getDeclaredMethod("call");
    
       //making private method accessible using reflection
       privateMethod.setAccessible(true);
    
       //calling private method using reflection in java
       privateMethod.invoke(privateRyan);
    
    
   } catch (InvocationTargetException ex) {
       Logger.error(ex.toString());
   } catch (NoSuchMethodException ex) {
       Logger.error( ex.toString());
   } catch (IllegalArgumentException ex) {
       Logger.error(ex.toString());
   } catch (IllegalAccessException ex) {
       Logger.error( ex.toString());
   } catch (NoSuchFieldException ex) {
       Logger.error(ex.toString());
   } catch (SecurityException ex) {
       Logger.error(ex.toString());
   }


}
}
