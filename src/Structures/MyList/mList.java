package Structures.MyList;

public interface mList<T> {
    // Delete object from list with index
    public void delete(int index);

    // Find and Delete object from list
    public void delete(T object);

    // Add object to the end of the list
    public void push(T obj);

    // Add object to the index place
    public void insert(T obj, int index);

    // Delete and return object from the end of the list
    public T pop();

    // Checking the list for emptiness
    public boolean isEmpty();

    // Return the index of the object
    public int index(T obj);

    // Return the object by index
    public T find(int index);

    public T getHead();
    public T getTail();

    public void printAll();


}
