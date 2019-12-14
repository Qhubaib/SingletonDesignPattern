package com.javainterviewquestion;


/**
 * 
 * @author roshan
 * 
 * For Normal class we use constructor to create the object,
 * where as for singleton class we use getInstance() method for instantiation
 *
 */
public class Singleton {
	
	
	public String str;
	
	//private constructor restricted to this class itself
	private Singleton()
	{
		str = "This is a string of singleton";
	}
	
	//static variable instance of type singleton
	private static Singleton singleInstance = null;
	
	//static getInstance method to create instance of Singleton Class
	public static Singleton getInstance()
	{
		if(singleInstance == null)
		{
			singleInstance = new Singleton();
		}
		return singleInstance;		
	}
	

	public static void main(String[] args)
	{
		Singleton s = Singleton.getInstance();
		
		Singleton t = Singleton.getInstance();
		
		Singleton u = Singleton.getInstance();
		
		t.str = t.str.toUpperCase(); //Here we converted object 't' string in upper case
		
		System.out.println("For Instance of 's': "+s.str);
		System.out.println("For Instance of 't': "+t.str);
		System.out.println("For Instance of 'u': "+u.str);
		
		/*** OUTPUT::
		 * For Instance of 's': THIS IS A STRING OF SINGLETON
			For Instance of 't': THIS IS A STRING OF SINGLETON
			For Instance of 'u': THIS IS A STRING OF SINGLETON
		 */
		
		//Which means even though we have created so many objects s, t, u but it is pointing only one reference
		//that is the reason - the output of all objects has come to Upper Case
	}
}


