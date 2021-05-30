package de.unistuttgart.vis.dsass2021.ex04.p3;

import java.util.Iterator;
import java.util.Stack;
import java.util.Queue;


public class BinarySearchTree<T extends Comparable<T>> implements
		IBinarySearchTreeIterable<T> { 

	private volatile IBinaryTreeNode<T> root;

	public BinarySearchTree() {
		this.root = null;
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
	
	/*public void PostorderIterator(IBinaryTreeNode<T> n) {

        if (n == null) {
            return;
        }
        Stack<IBinaryTreeNode<T>> s = new Stack<IBinaryTreeNode<T>>();
        IBinaryTreeNode<T> current = n;
        while (current != null || !s.isEmpty()) {

            while (current != null) {
                current.isFirst = true;
                s.push(current);
                current = current.getLeftChild();
            }

            if (!s.empty()) {
                current = s.pop();

                if (current.isFirst) {
                    current.isFirst = false;
                    s.push(current);
                    current = current.getRightChild();
                } else {
                    System.out.println(current.getValue());
                    current = null;
                }
            }
        }
    }*/

	public void PostorderIterator(IBinaryTreeNode<T> n)  {         ////
		Stack<IBinaryTreeNode<T>> s = new Stack<IBinaryTreeNode<T>>();
		Stack<IBinaryTreeNode<T>> s2 = new Stack<IBinaryTreeNode<T>>();
		
		//s2.InitStack(20);
		if (n == null) {
			return;
		}
		IBinaryTreeNode<T> temp = null;
		temp = n;
		while (!s.isEmpty() || temp != null) {
			while (temp != null) {
				s2.push(temp); // 这行改变
				s2.push(temp);
				temp = temp.getRightChild(); // 这行改变
			}
			temp = s.pop();
			temp = temp.getLeftChild();
		}
		while (!s2.isEmpty()) { // 把第二个栈全部出栈打印
			temp = s2.pop();
			System.out.println(temp.getValue());

		}
	}

	public void LevelorderIterator(IBinaryTreeNode<T> n) {
		Queue<IBinaryTreeNode<T>> queue = new Queue<IBinaryTreeNode<T>>();
		IBinaryTreeNode<T> temp = null;
		queue.front = queue.rear = 0;
		if (n == null) {
			
			return;
		}
		queue.enterQueue(n);
		while (queue.front != queue.rear) {
			temp = queue.deleteQueue();
			System.out.println(temp.getValue());
			if (temp.getLeftChild() != null) {
				queue.enterQueue(temp.getLeftChild());
			}
			if (temp.getRightChild() != null) {
				queue.enterQueue(temp.getRightChild());
			}

		}
	}
	}


}
