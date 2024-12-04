package datastructure;

import java.util.ArrayList;
import java.util.List;

abstract class Datastructure {
	protected int size;
	protected List<Integer> elements;

	public Datastructure() {
		elements = new ArrayList<>();
		size = 0;
	}

	public abstract void create();

	protected abstract void insert(int element);

	public void sort() {
		System.out.println("Sort method not implemented");
	};

	public void find(int element) {
		System.out.println("find method not implemented");
	};

	protected abstract void delete(int element);

	public abstract void display();
}
