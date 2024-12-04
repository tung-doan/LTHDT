public class MyList {
    private int size;
    private int[] elements;
    private int numberOfElements;

    // constructor
    public MyList(int numberOfElements) {
        this.elements = new int[numberOfElements];
        this.size = 0;
        this.numberOfElements = numberOfElements;
    }

    // utility function
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // insert at index
    public void insertAt(int index, int element) {
        if (index < 0 || index > size) {
            System.out.println("Index " + index + " is out of bounds");
            return;
        }
        if (size == numberOfElements) {
            System.out.println("List is full, cannot insert element");
            return;
        }
        // dịch các phần tử sang phải để tạo chỗ cho phần tử mới
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    // insert at the end
    public void insert(int element) {
        if (size == numberOfElements) {
            System.out.println("List is full, cannot insert element");
            return;
        }
        elements[size] = element;
        size++;
    }

    // remove at index
    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index " + index + " is out of bounds");
            return;
        }
        // dịch các phẩn tử sang trái để đè lên các phần tử cũ và xoá phần tử cần xoá
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = 0; 
        size--;
    }

    // remove a matching element
    public void remove(int element) {
        int index = find(element);
        if (index == -1) {
            return;
        }
        removeAt(index);
    }

//Override    
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
        if (size <= 1) return; 
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
    public int find(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return i; // trả về vị trí tìm được phần tử
            }
        }
        System.out.println("Element " + element + " not found in the list");
        return -1; // không tìm thấy
    }
}
