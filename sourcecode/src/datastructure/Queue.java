package datastructure;

public class Queue extends Datastructure{

    	private int front;
    	private int bottom;


    	public Queue(int capa) {
    		super(capa);
    		front = 0;
    		bottom = -1;

    	}
    	
    	@Override
    	public void create() {
    		elements = new int[capacity];
    		size = 0;
    		front = 0;
    		bottom = -1;
    	}
    	
    	@Override
    	protected void insert(int element) {
    		if (size == capacity) {
    			resize();
    		}
    		bottom = (bottom + 1) % capacity;
            elements[bottom] = element;
            size++;
    	}
	    
    	@Override
    	protected void delete(int element) {
    		if (size == 0) {
    			throw new IllegalStateException("Queue is empty");
    		}
    		front = (front + 1) % capacity;
    		size--;
    	}
    	
	    @Override
	    public void display() {
	        if (size == 0) {
	            System.out.println("Queue is empty.");
	        } else {
	            System.out.print("Queue: ");
	            int i = front;
	            int count = 0;
	            while (count < size) {
	                System.out.print(elements[i] + " ");
	                i = (i + 1) % capacity;
	                count++;
	            }
	            System.out.println();
	        }
	    }
	    
	    
	    public void enqueue(int element) {
	    	insert(element);
	    }

	    public void dequeue() {
	    	delete(front);
	    }

	    public int peek() {
	        if (size == 0) {
	        	throw new IllegalStateException("Queue is empty. Peek failed.");
	        }
	            return elements[front];
	    }

}