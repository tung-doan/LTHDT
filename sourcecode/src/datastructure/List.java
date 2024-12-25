package datastructure;

import java.util.Random;

public class List extends Datastructure {

	// constructor
	public List(int capacity) {
		super(capacity);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isFull() {
		return size == capacity;
	}

	public int[] getElements() {
		return elements;
	}

	// insert at index
	public void insertAt(int index, int element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
		}
		if (isFull()) {
			resize();
		}
		// dịch các phần tử sang phải để tạo chỗ cho phần tử mới
		for (int i = size - 1; i >= index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;
		size++;
	}

	// delete at index
	public void deleteAt(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
		}
		// dịch các phẩn tử sang trái để đè lên các phần tử cũ và xoá phần tử cần xoá
		for (int i = index; i < size - 1; i++) {
			elements[i] = elements[i + 1];
		}
		elements[size - 1] = 0;
		size--;
	}

	@Override
	// create
	public void create() {
		elements = new int[capacity];
		size = 0;
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

	// insert at the end
	public void insert(int element) {
		if (isFull()) {
			resize();
		}
		elements[size] = element;
		size++;
	}

	// remove a matching element
	public void delete(int element) {
		int index = find(element);
		if (index == -1) {
			throw new IllegalArgumentException("Element " + element + " not found in the list");
		}
		deleteAt(index);
	}

	// display
	public void display() {
		System.out.print("List: ");
		for (int i = 0; i < size; i++) {
			System.out.print(elements[i] + " ");
		}
		System.out.println();
	}

	// sort
	public void sort(boolean ascending) {
		if (size <= 1) {
			return; 
		}
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				
				if ((ascending && elements[j] > elements[j + 1]) || 
					(!ascending && elements[j] < elements[j + 1])) {
					int temp = elements[j];
					elements[j] = elements[j + 1];
					elements[j + 1] = temp;
				}
			}
		}
	}

	// find
	public int find(int element) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == element) {
				return i;
			}
		}
		return -1;
	}
}