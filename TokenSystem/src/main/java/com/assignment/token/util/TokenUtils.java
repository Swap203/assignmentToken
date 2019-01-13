package com.assignment.token.util;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import com.assignment.token.businessObject.Token;



public class TokenUtils {


    public static Integer counter=0;
    public static Integer numberOfCounters = 5;

    public static Comparator<Token> comparator = new Comparator<Token>(){
		
		@Override
		public int compare(Token t1, Token t2) {
		return t2.getForPrivilegedCustomer() - t1.getForPrivilegedCustomer();
		
        }
	};

	public static HashMap<String, Token> counters = new LinkedHashMap<String, Token>(5);
    public static Queue<Token> serviceCounterQueue = new PriorityBlockingQueue<Token>(5, comparator);

   static {
	   for(int i=1; i<=5;i++)
	   {
		   counters.put("Counter "+i, null);
	   }
	   
   }







}
