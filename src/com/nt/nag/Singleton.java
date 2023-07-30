package com.nt.nag;

import java.io.Serializable;

final public class Singleton implements Serializable,Cloneable{
	static Singleton s= null;
private Singleton() throws Exception {
}
//to fix the reflection api problem
{
	if(s!=null) {
		throw new Exception("Object is already present");
	}
}
//to fix the Deserialization problem
 Object readResolve(){
	 return s;
 }

 //to make the lazy loading
static Singleton getInstance() throws Exception{
	if(s==null) {
		s=new Singleton();
	}
	return s;
}
@Override
protected Object clone() throws CloneNotSupportedException {
	//for breaking the Singleton
//	return super.clone();
	//to fix the problem 
	return s;
	
}
}
