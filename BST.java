package dataStructures;
import java.util.*;

// for testing, T also extends my Displayable interface. This is for printing
public class BST<T extends Comparable<T> & Displayable> {
	
	private class BSTNode {
		
		private BSTNode leftChild;
		private BSTNode rightChild;
		private BSTNode parent;
		private T value;
		
		private BSTNode(T val) {
			this.leftChild = null;
			this.rightChild = null;
			this.parent = this;
			this.value = val;
		}
		
	}
	
	private BSTNode root;
	private int size;
	
	public BST() {
		this.root = null;
		this.size = 0;
	}
	
	
	private void insertBSTNode(T val, BSTNode n) {
		// val > n.value
		if (val.compareTo(n.value) > 0) {
			if (n.rightChild == null) {
				n.rightChild = new BSTNode(val);
				n.rightChild.parent = n;
			} else {
				insertBSTNode(val, n.rightChild);
			}
		}
		// val < n.value
		else if (val.compareTo(n.value) < 0) {
			if (n.leftChild == null) {
				n.leftChild = new BSTNode(val);
				n.leftChild.parent = n;
			} else {
				insertBSTNode(val, n.leftChild);
			}
		}
		else {
			n.value = val;
		}
	}
	
	public void insert(T val) {
		// tree is empty
		if (this.root == null) {
			this.root = new BSTNode(val);
		} else {
			insertBSTNode(val, this.root);
		}
		
		this.size++;
	}
	
	private void displayBSTNode(BSTNode n) {
		if (n.parent == n)
			System.out.print("ROOT-");
		else if (n == n.parent.leftChild)
			System.out.print("L-");
		else
			System.out.print("R-");
		
		n.value.display();
				
		if (n.parent != n) {
			System.out.print("(");
			n.parent.value.display();
			System.out.print(") "); 
		}
	}
	
	private void displayBSTQueue(LinkedList<BSTNode> q) {
		if (q.isEmpty()) return;
		
		LinkedList<BSTNode> next = new LinkedList<BSTNode>();
		
		while (!q.isEmpty()) {
			BSTNode n = q.remove();
			displayBSTNode(n);
			if (n.leftChild != null)
				next.add(n.leftChild);
			if (n.rightChild != null)
				next.add(n.rightChild);
		}
		System.out.println("");
		displayBSTQueue(next);
	}
	
	public void display() {
		if (this.root != null) {
			displayBSTNode(this.root);
			System.out.println("");
		}
		
		// treating linked list as a simple queue with no priority
		LinkedList<BSTNode> q = new LinkedList<BSTNode>();
		if (this.root.leftChild != null)
			q.add(this.root.leftChild);
		if (this.root.rightChild != null)
			q.add(this.root.rightChild);
		
		displayBSTQueue(q);
	}
	
	
	private BSTNode findBSTNode(T val, BSTNode n) {
		if (n == null) return null;
		else if (val.compareTo(n.value) > 0) return findBSTNode(val, n.rightChild);
		else if (val.compareTo(n.value) < 0) return findBSTNode(val, n.leftChild);
		else return n;
	}
	
	public T find(T val) {
		return findBSTNode(val, this.root).value;
	}
	
	
    public void delete(T val)
    {
        this.root = deleteBSTNode(this.root, val);
    }
 
    private BSTNode deleteBSTNode(BSTNode n, T val)
    {
        if (n == null)  return n;
 
        if (val.compareTo(n.value) < 0)
            n.leftChild = deleteBSTNode(n.leftChild, val);
        else if (val.compareTo(n.value) > 0)
            n.rightChild = deleteBSTNode(n.rightChild, val);
 
        else
        {
            if (n.leftChild == null)
                return n.rightChild;
            else if (n.rightChild == null)
                return n.leftChild;
 
            n.value = minValue(n.rightChild);
 
            n.rightChild = deleteBSTNode(n.rightChild, n.value);
        }
 
        return n;
    }
    
    private T minValue(BSTNode n) {
    	while (n.leftChild != null) {
    		n = n.leftChild;
    	}
    	return n.value;
    }
	
}
