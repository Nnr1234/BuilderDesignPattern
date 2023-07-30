package com.nt.nag;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class Test {

public static void main(String[] args) throws Exception {
Singleton s= Singleton.getInstance();
System.out.println(s.hashCode());
Singleton s1= Singleton.getInstance();
System.out.println(s1.hashCode());
Singleton s2= Singleton.getInstance();
System.out.println(s2.hashCode());

//reflection api
/*
 * Constructor<Singleton> s3 = Singleton.class.getDeclaredConstructor();
 * s3.setAccessible(true); Singleton instance = s3.newInstance();
 * System.out.println(s3.hashCode());
 */	
//Serialzation
FileOutputStream f= new FileOutputStream("C:\\Users\\NAGENDRA\\OneDrive\\Desktop.Serializable.txt");
ObjectOutputStream out= new ObjectOutputStream(f);
out.writeObject(s);

//DeSerialization
FileInputStream f1= new FileInputStream("C:\\Users\\NAGENDRA\\OneDrive\\Desktop.Serializable.txt");
ObjectInputStream in= new ObjectInputStream(f1);
Singleton s5=(Singleton)in.readObject();
System.out.println(s5.hashCode());

Singleton s6=(Singleton)s5.clone();
System.out.println(s6.hashCode());
}

}
