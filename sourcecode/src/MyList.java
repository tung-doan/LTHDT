public class MyList {
    private int size;  
    private int[] elements;
    private int numberOfElements; 

    // Constructor
    public MyList(int numberOfElements) {
        this.elements = new int[numberOfElements];
        this.size = 0;
    }

    // utility function
    public int getSize() {
        return size;
    }
    public boolean isEmpty(){
        return (size == 0);
    }

    // insert
    public void insertAt(int index, int element) {
        if (index < 0 || index > size) {
            System.out.println("Index out of bounds");
            return;
        }
        if (size == numberOfElements) {
            System.out.println("List is full");
            return;
        }
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }
    
    public void insert(int element) {
        if (size == numberOfElements) {
            System.out.println("List is full");
            return;
        }
        elements[size] = element;
        size++;
    }

    // remove
    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = 0;
        size--;
    }

    public void remove(int element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Element " + element + " not found");
            return;
        }
    }

    
//    @Override
    // display
    public String display() {
        StringBuilder builder = new StringBuilder();
        builder.append("List: ");
        for (int i = 0; i < size; i++) {
            builder.append(elements[i]);
            if (i < size - 1) { 
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    // sort
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    // find
}
