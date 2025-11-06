package estdatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Arbol binario con hilos inorden (Threaded Binary Tree)
 */
public class BinaryThreaded<E> extends BinaryTreeImp<E> implements Iterable<E> {

	/**
	 * For a given node, finds the right-most node in subtree and threads it back to
	 * node
	 * 
	 * @param subtree for which we will find the right-most node
	 * @param node    to be threaded
	 */
	private void setRightmostThread(BinaryThreaded<E> subtree, BinaryThreaded<E> node) {
		BinaryThreaded<E> rightmost = subtree;
		while (!rightmost.isRightThread && !rightmost.right().isEmpty()) {
			rightmost = (BinaryThreaded<E>) rightmost.right;
		}
		rightmost.right = node;
		rightmost.isRightThread = true;
	}

	/**
	 * For a given node, finds the left-most node in subtree and threads it back to
	 * node
	 * 
	 * @param subtree for which we will find the left-most node
	 * @param node    to be threaded
	 */
	private void setLeftmostThread(BinaryThreaded<E> subtree, BinaryThreaded<E> node) {
		BinaryThreaded<E> leftmost = subtree;
		while (!leftmost.isLeftThread && !leftmost.left().isEmpty()) {
			leftmost = (BinaryThreaded<E>) leftmost.left;
		}
		leftmost.left = node;
		leftmost.isLeftThread = true;
	}

	/**
	 * Returns the string representation of the nodes of the tree, traversed in
	 * inorder using threads and separated by a whitespace
	 * 
	 * @return the string representation of the tree
	 */
	public String inorder() {
		StringBuilder sb = new StringBuilder();
		BinaryThreaded<E> current = slideLeft();
		while (!current.isEmpty()) {
			sb.append(current.label + " ");
			if (current.isRightThread)
				current = (BinaryThreaded<E>) current.right;
			else {
				current = (BinaryThreaded<E>) current.right;
				if (!current.isEmpty())
					current = current.slideLeft();
			}
		}
		return sb.toString();
	}

	private BinaryThreaded<E> slideLeft() {
		BinaryThreaded<E> current = this;
		while (!current.left().isEmpty() && !current.isLeftThread) {
			current = (BinaryThreaded<E>) current.left;
		}
		return current;
	}
}
