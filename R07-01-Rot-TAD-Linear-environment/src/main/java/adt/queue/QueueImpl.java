package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		T resp = null;
		if (this.tail > -1)
			resp = array[0];
		return resp;
	}

	@Override
	public boolean isEmpty() {
		boolean resp = false;
		if (tail == -1) resp = true;
		return resp;
	}

	@Override
	public boolean isFull() {
		boolean resp = false;
		if (tail == array.length - 1) resp = true;
		return resp;
	}

	private void shiftLeft() {
		for (int i = 0; i < array.length - 1; i++)
			array[i] = array[i + 1];
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (element != null)
			if(!isFull()) 
				array[++tail] = element;
			else throw new QueueOverflowException();
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T resp = null;
		if (!isEmpty()){
			resp = array[0];
			shiftLeft();
			tail--;
		} else throw new QueueUnderflowException();
		return resp;
			
	}

}
