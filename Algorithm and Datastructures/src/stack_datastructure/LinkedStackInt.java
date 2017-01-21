package stack_datastructure;

public interface LinkedStackInt<E> {
 
	int size();
    E peek(int element);
    E pop(int element);
    E flush();//Returnerar sista elementet
    
    
}
