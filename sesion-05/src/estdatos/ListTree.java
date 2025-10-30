package estdatos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListTree<E> extends AbstractTree<E> {
	
	private E labelRoot;
	
	private ListTree<E> parent;
	
	private List<Tree<E>> children;
	
	public ListTree(E e, Tree<E>...trees) {
		this.labelRoot = e;
		children = new LinkedList<Tree<E>>();
		for(Tree<E> tree: trees) {
			ListTree<E> listTree = new ListTree<E>(tree);
			listTree.parent = this;
			children.add(tree);
		}
	}
	
	public ListTree(Tree<E> t) {
		this.labelRoot = t.label();
		this.children = new LinkedList<Tree<E>>();
		Iterator<Tree<E>> itr = t.childrenIterator();
		while(itr.hasNext()) {
			
			ListTree<E> listTree = new ListTree<E>(itr.next());
			
			listTree.parent = this;
			
			children.add(itr.next());
		}
		
	}
	
	public ListTree<E> parent() {
		return parent;
	}

	@Override
	public boolean isLeaf() {
		return children.size() == 0;
	}

	@Override
	public E label() {
		return labelRoot;
	}

	@Override
	public ChildrenIterator<Tree<E>> childrenIterator() {
		// TODO Auto-generated method stub
		return new ListChildrenIterator();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if(obj == null || !(obj instanceof ListTree e)) {
			return false;
		}
		
		if (!this.label().equals(e.label())) {
			return false;
		}
		
		Iterator<Tree<E>> itr1 = this.childrenIterator();
		Iterator<Tree<E>> itr2 = e.childrenIterator();
		
		while(itr1.hasNext() && itr2.hasNext()) {
			
			if (!itr1.next().equals(itr2.next())) {
				return false;
			}
			
		}
		
		return !itr1.hasNext() && !itr2.hasNext();
		
	}
	
	private class ListChildrenIterator implements ChildrenIterator<Tree<E>> {

		ListIterator<Tree<E>> itr;
		
		public ListChildrenIterator() {
			itr = children.listIterator();
		}
		
		@Override
		public boolean hasNext() {
			return itr.hasNext();
		}

		@Override
		public Tree<E> next() {
			return itr.next();
		}
		
		@Override
		public void remove() {
			itr.remove();
		}
		
		@Override
		public void add(Tree<E> e) {
			
			var tree = new ListTree<E>(e);
			tree.parent = ListTree.this;
			itr.add(e);
		}
		
		@Override
		public void set(Tree<E> e) {
			var tree = new ListTree<E>(e);
			tree.parent = ListTree.this;
			itr.set(e);
		}
		
	}

}
