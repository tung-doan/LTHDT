package datastructure;

import java.util.Random;

public class Stack extends Datastructure {
	private int top;

	public Stack(int capa) {
		super(capa);
		top = -1;
	}

	public void create() {
		elements = new int[capacity];
		size = 0;
		top = -1;
	}

	protected void insert(int element) {
		if (size == capacity) {
			resize();
		}
		elements[++top] = element;
		size++;
	}

	protected void delete(int element) {
		throw new UnsupportedOperationException("Stack does not support deleting specific elements.");
	}

	protected void delete() {
		if (top == -1) {
			throw new IllegalStateException("Stack is empty");
		}
		top--;
		size--;
	}

	public void display() {
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				System.out.println(elements[i]);
			}
		}
	}

	public void push(int element) {
		insert(element);
	}

	public void pop() {
		delete();
	}

	public int getsize() {
		return size;
	}

	public int peek() {
		if (top == -1) {
			throw new IllegalStateException("Stack is empty");
		}
		return elements[top];
	}

	public void createRandom(int newSize) {
		if (newSize > capacity) {
			while (capacity < newSize) {
				resize();
			}
		}
		Random random = new Random();
		for (int i = 0; i < newSize; i++) {
			elements[i] = random.nextInt(100);
		}
		size = newSize;
		top = size - 1;
	}
}