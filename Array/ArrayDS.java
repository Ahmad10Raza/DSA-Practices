public class ArrayDS {
    private int[] array;
    private int size;

    public ArrayDS(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return array.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int element) {
        if (size == array.length) {
            resizeArray();
        }
        array[size] = element;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return array[index];
    }

    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        array[index] = element;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    private void resizeArray() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public static void main(String[] args) {
        ArrayDS array = new ArrayDS(5);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        System.out.println("Size: " + array.getSize());
        System.out.println("Capacity: " + array.getCapacity());
        System.out.println("Is empty: " + array.isEmpty());
        System.out.println("Element at index 2: " + array.get(2));
        array.set(2, 10);
        System.out.println("Element at index 2: " + array.get(2));
        array.remove(2);
        System.out.println("Size: " + array.getSize());
        System.out.println("Element at index 2: " + array.get(2));
    }
}