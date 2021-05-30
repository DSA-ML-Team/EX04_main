package de.unistuttgart.vis.dsass2021.ex04.p3;

import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> implements
		IBinarySearchTreeIterable<T> { 

	private volatile IBinaryTreeNode<T> root;

	public BinarySearchTree() {
		this.root = null;
		

		    	
	}

	
		
	public void PreorderIterator(IBinaryTreeNode<T> n) {
        if (n == null) {
            return;
        }
        Stack<IBinaryTreeNode<T>> st = new Stack<IBinaryTreeNode<T>>();
        IBinaryTreeNode<T> current = n;
        while (current != null || !st.isEmpty()) {

            while (current != null) {
                System.out.println(current.getValue());
                st.push(current);
                current = current.getLeftChild();
            }

            if (!st.empty()) {
                current = st.pop();
                current = current.getRightChild();
            }
        }
    }
	
	public void InorderIterator(IBinaryTreeNode<T> n) {

        if (n == null) {
            return;
        }
        Stack<IBinaryTreeNode<T>> st = new Stack<IBinaryTreeNode<T>>();
        IBinaryTreeNode<T> current = n;
        while (current != null || !st.isEmpty()) {

            while (current != null) {

                st.push(current);
                current = current.getLeftChild();
            }

            if (!st.empty()) {
                current = st.pop();
                System.out.println(current.getValue());
                current = current.getRightChild();
            }

        }
    }
	
	public void PostorderIterator(IBinaryTreeNode<T> n) {

        if (n == null) {
            return;
        }
        Stack<IBinaryTreeNode<T>> st = new Stack<IBinaryTreeNode<T>>();
        IBinaryTreeNode<T> current = n;
        while (current != null || !st.isEmpty()) {

            while (current != null) {
                current.isFirst = true;
                st.push(current);
                current = current.getLeftChild();
            }

            if (!st.empty()) {
                current = st.pop();

                if (current.isFirst) {
                    current.isFirst = false;
                    st.push(current);
                    current = current.getRightChild();
                } else {
                    System.out.println(current.getValue());
                    current = null;
                }
            }
        }
    }



	@Override
	public void insert(T t) {
		this.root = this.insert(this.root, t);
	}

	private IBinaryTreeNode<T> insert(IBinaryTreeNode<T> node, T t) {
		if (node == null) {
			IBinaryTreeNode<T> newNode = new BinaryTreeNode<>();
			newNode.setValue(t);
			return newNode;
		}
		if (t.compareTo(node.getValue()) < 0) {
			node.setLeftChild(this.insert(node.getLeftChild(), t));
		} else if (t.compareTo(node.getValue()) > 0) {
			node.setRightChild(this.insert(node.getRightChild(), t));
		}
		return node;
	}

	@Override
	public IBinaryTreeNode<T> getRootNode() {
		return this.root;
	}

	@Override
	public Iterator<T> iterator(TreeTraversalType traversalType) {
		switch (traversalType) {
		case PREORDER:
			return new PreorderIterator<T>(this);
		case INORDER:
		    return new InorderIterator<T>(this);
		case POSTORDER:
		    return new PostorderIterator<T>(this);
		case LEVELORDER:
		    return new LevelorderIterator<T>(this);
		}
		
		return null;
	}

}
