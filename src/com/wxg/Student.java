package com.wxg;

public class Student implements Cloneable {
 public int age;

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public Student(int age) {
	super();
	this.age = age;
}
public Student() {

}
@Override  
public Object clone() throws CloneNotSupportedException  
{  
    return super.clone();  
}  
}

