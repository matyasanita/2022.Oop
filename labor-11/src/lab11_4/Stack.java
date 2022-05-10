package lab11_4;

import java.util.ArrayList;

public class Stack{
    private ArrayList<Object> items = new ArrayList<>();
    private final int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull(){
        if (items.size() == capacity)
            return true;
        return false;
    }

    public boolean isEmpty(){
        if (items.size() == 0 )
            return true;
        return false;
    }

    public void push(Object o) throws StackException{
        if (!isFull())
            items.add(o);
        else
            throw new StackException("Stack is full!");
    }

    public Object top() throws StackException{
        if (!isEmpty()){
            return items.get(getSize() - 1);
        }
        else
            throw new StackException("Stack is empty!");
    }

    public Object pop() throws StackException{
        Object temp = null;
        if (!isEmpty()) {
            temp = items.get(getSize() - 1);
            items.remove(getSize() - 1);
            return temp;
        }
        else
            throw new StackException("Stack is empty!");

    }

    public int getSize(){
        return items.size();
    }

}
