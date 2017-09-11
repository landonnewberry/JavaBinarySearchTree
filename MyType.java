package dataStructures;

public class MyType implements Comparable<MyType>, Displayable{
	public int key;
	public String name;
	
	public MyType(int key, String name) {
		this.key = key;
		this.name = name;
	}

	public void display() {
		System.out.print("[" + this.key + "-" + this.name + "]");
	}

	public int compareTo(MyType a) {
		return this.key - a.key;
	}
}