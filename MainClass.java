package dataStructures;

public class MainClass {
	public static void main(String[] args) {
		BST<MyType> bst = new BST<MyType>();
		bst.insert(new MyType(45, "Landon"));
		bst.insert(new MyType(12, "Newbs"));
		bst.insert(new MyType(20, "Something"));
		bst.insert(new MyType(50, "Fifty"));
		bst.insert(new MyType(20, "SOME"));
		bst.display();

		System.out.println("");
		
		bst.delete(new MyType(45, "Landon"));
		bst.display();
	}
}
