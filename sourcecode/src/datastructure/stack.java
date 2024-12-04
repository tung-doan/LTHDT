package datastructure;

class Stack extends Datastructure {
	private int top;

	public Stack() {
		super();
		this.top = -1;
	}

	@Override
	public void create() {
		elements.clear();
		size = 0;
		top = -1;
	}

	@Override
	protected void insert(int element) {
		elements.add(element);
		top++;
		size++;
	}

	@Override
	protected void delete(int element) {
		elements.remove(top);
		top--;
		size--;

	}

	@Override
	public void display() {

	}

	public void push(int element) {
		insert(element);
	}

	public void pop() {
		if (top == -1) {
			throw new IllegalStateException("Stack is empty");
		}
		delete(top);
	}

	public int peek() {
		if (top == -1) {
			throw new IllegalStateException("Stack is empty");
		}
		return elements.get(top);
	}

	public static void main(String args[]) {
		Stack stack = new Stack();
		stack.push(1);
		System.out.println(stack.peek());
		stack.push(2);
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
	}

}