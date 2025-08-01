package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (element != null){
			if (tail == -1 || head == -1){
				array[++tail%(array.length - 1)] = element;
				head++;
			}
			else if (!isFull())
				array[++tail%(array.length - 1)] = element;
			else throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T resp = null;
		if(!isEmpty()){
			resp = array[head%(array.length - 1)];
			head++;
		} else throw new QueueUnderflowException();
		return resp;
	}

	@Override
	public T head() {
		T resp = null;
		if (isEmpty())
			resp = array[head];
		return resp;
	}

	@Override
	public boolean isEmpty() {
		boolean resp = false;
		if (tail == -1 || tail == -1) resp = true;
		else if (tail > head) resp = true;
		return resp;
	}

	@Override
	public boolean isFull() {
		boolean resp = false;
		if (tail%(array.length - 1) + 1 == head) resp = true;
		return resp;
	}

}
