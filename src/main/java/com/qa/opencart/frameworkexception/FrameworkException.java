package com.qa.opencart.frameworkexception;

public class FrameworkException extends RuntimeException 
//as its a customized class so it will extend RuntimeException class
{
   public  FrameworkException(String message)
   {
	   super(message);
   }
}
