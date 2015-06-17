/*
 * 4.29.2015: 
 */
package com.mindsmapped.hw3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class hw3 {
	public static void main(String args[]) {
		ArrayList arraylist = new ArrayList();
		
		LinkedList linkedList = new LinkedList();
		
		HashSet hashSet = new HashSet();
		
		TreeSet treeSet = new TreeSet();
		

		  LinkedHashSet linkSet = new LinkedHashSet();
		  linkSet.add("TV");
		  linkSet.add("Radio");
		  linkSet.add("Games");
		  linkSet.add("Couch");
		  linkSet.add("TV");
		  Iterator i=linkSet.iterator();
		  while(i.hasNext())
		  
		  System.out.println(i.next());
		  
		  String msg = "Hello";
		  System.out.println(msg.hashCode());
		  
		  msg += " World";
		  System.out.println(msg.hashCode());
		  
		  String anotherMsg = "Hello";
		  System.out.println(anotherMsg.hashCode());

	}
}