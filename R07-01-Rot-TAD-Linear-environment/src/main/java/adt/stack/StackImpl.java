package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		T resp = null;
		if (!isEmpty()) resp = array[top];
		return resp;
	}

	@Override
	public boolean isEmpty() {
		boolean resp = false;
		if (this.top == -1) resp = true;
		return resp;
	}

	@Override
	public boolean isFull() {
		boolean resp = false;
		if (this.top == array.length - 1) resp = true;
		return resp;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (element != null){
			if (!isFull())
			array[++top] = element;
			else throw new StackOverflowException();
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T resp = null;
		if (!isEmpty()){
			resp = array[top];
			top--;
		} else throw new StackUnderflowException();
		return resp;
			
	}

}
