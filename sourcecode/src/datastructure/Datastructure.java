package datastructure;

abstract class Datastructure {
	protected int size;
	protected int[] elements;
	int capacity;

	public Datastructure(int capa) {
		capacity = capa;
		size = 0;
		elements = new int[capacity];
	}

	public abstract void create(int capacity);

	protected abstract void insert(int element);

	public void sort() {
		System.out.println("Sort method not implemented");
	};

	public int find(int element) {
		System.out.println("find method not implemented");
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

	public abstract void display();
}
