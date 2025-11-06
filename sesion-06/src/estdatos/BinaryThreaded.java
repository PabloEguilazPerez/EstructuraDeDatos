package estdatos;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryThreaded<E> extends BinaryTreeImp<E> implements Iterable<E> {

    private boolean isRightThread;
    private boolean isLeftThread;

    private static final BinaryThreaded<?> EMPTY = new BinaryThreaded<>();

    public BinaryThreaded() {
        this.label = null;
        this.left = null;
        this.right = null;
        this.isLeftThread = false;
        this.isRightThread = false;
    }

    public BinaryThreaded(E e) {
        this(e, empty(), empty());
    }

    public BinaryThreaded(E e, BinaryTree<E> leftSubtree, BinaryTree<E> rightSubtree) {
        if (e == null) {
        	throw new NullPointerException();
        }
        
        this.label = e;

        if (leftSubtree == null || leftSubtree.isEmpty()) {
            this.left = empty();
            this.isLeftThread = true;
        } else {
            this.left = new BinaryThreaded<>(leftSubtree);
            setRightmostThread((BinaryThreaded<E>) this.left, this);
        }

        if (rightSubtree == null || rightSubtree.isEmpty()) {
            this.right = empty();
            this.isRightThread = true;
        } else {
            this.right = new BinaryThreaded<>(rightSubtree);
            setLeftmostThread((BinaryThreaded<E>) this.right, this);
        }
    }

    public BinaryThreaded(BinaryTree<E> bt) {
        this(bt.label(), bt.left(), bt.right());
    }


    private static <T> BinaryThreaded<T> empty() {
        return (BinaryThreaded<T>) EMPTY;
    }

    @Override
    public boolean isEmpty() {
        return this == EMPTY;
    }

    @Override
    public E label() {
        return isEmpty() ? null : label;
    }

    @Override
    public BinaryTree<E> left() {
        return isEmpty() ? null : (isLeftThread ? empty() : left);
    }

    @Override
    public BinaryTree<E> right() {
        return isEmpty() ? null : (isRightThread ? empty() : right);
    }

    private void setRightmostThread(BinaryThreaded<E> subtree, BinaryThreaded<E> node) {
        BinaryThreaded<E> rightmost = subtree;
        while (!rightmost.isRightThread && !rightmost.right().isEmpty()) {
            rightmost = (BinaryThreaded<E>) rightmost.right;
        }
        rightmost.right = node;
        rightmost.isRightThread = true;
    }

    private void setLeftmostThread(BinaryThreaded<E> subtree, BinaryThreaded<E> node) {
        BinaryThreaded<E> leftmost = subtree;
        while (!leftmost.isLeftThread && !leftmost.left().isEmpty()) {
            leftmost = (BinaryThreaded<E>) leftmost.left;
        }
        leftmost.left = node;
        leftmost.isLeftThread = true;
    }

    private BinaryThreaded<E> slideLeft() {
        BinaryThreaded<E> current = this;
        while (!current.left().isEmpty() && !current.isLeftThread) {
            current = (BinaryThreaded<E>) current.left;
        }
        return current;
    }

    public String inorder() {
        StringBuilder sb = new StringBuilder();
        BinaryThreaded<E> current = slideLeft();
        while (!current.isEmpty()) {
            sb.append(current.label).append(" ");
            if (current.isRightThread) {
                current = (BinaryThreaded<E>) current.right;
            } else {
                current = (BinaryThreaded<E>) current.right;
                if (!current.isEmpty()) {
                    current = current.slideLeft();
                }
            }
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
