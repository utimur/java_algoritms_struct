package Structures.MyList;

public class MyArrayList<T> implements mList {
    private T[] array;
    private int size;
    private int count;

    public MyArrayList() {
        count = 0;
        size = 2;
        this.array = (T[]) new Object[size];
    }

    @Override
    public void delete(int index) {

    }

    @Override
    public void delete(Object object) {

    }

    @Override
    public void push(Object obj) {
        array[count] = (T) obj;
        count++;
        if (count == size) {
            int newSize = (int)(size * 1.5);
            T[] temp = (T[]) new Object[newSize];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            array = temp;
            size = newSize;
        }
    }

    @Override
    public void addToStart(Object obj) {

    }

    @Override
    public void insert(Object obj, int index) {

    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public int index(Object obj) {
        return 0;
    }

    @Override
    public Object find(int index) {
        return array[index];
    }

    @Override
    public Object getHead() {
        return array[0];
    }

    @Override
    public Object getTail() {
        return array[count];
    }

    @Override
    public void printAll() {
        for (int i = 0; i<count; i++) {
            System.out.println(array[i]);
        }
    }

    @Override
    public void clear() {
        size = 2;
        count = 0;
        array = (T[]) new Object[size];
    }

    @Override
    public int length() {
        return count;
    }

    public int capacity() {
        return this.size;
    }
}
