package datastructure;

import java.util.Random;
abstract class Datastructure {
	protected int size;
	protected int[] elements;
	int capacity;

	public Datastructure(int capa) {
		capacity = capa;
		size = 0;
		elements = new int[capacity];
	}

	public abstract void create();

	protected abstract void insert(int element);

	public void sort() {
		System.out.println("Sort method not implemented");
	};

	public int find(int element) {
		return -1;
	};

	protected abstract void delete(int element);

	protected void resize() {
		int newcapacity = capacity * 2;
		int[] newelements = new int[newcapacity];
		System.arraycopy(elements, 0, newelements, 0, size);
		elements = newelements;
		capacity = newcapacity;
	}

	public int[] getElements() {
		return elements;
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
	}
	public abstract void display();
}
