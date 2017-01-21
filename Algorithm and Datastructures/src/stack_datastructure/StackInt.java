package stack_datastructure;

public interface StackInt<E> {
	E push(E obj);
	E peek();
	E pop();
	boolean empty();
}
