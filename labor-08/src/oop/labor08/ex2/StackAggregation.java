package oop.labor08.ex2;

import java.util.ArrayList;

public class StackAggregation {
    private ArrayList<Object> items = new ArrayList<>();
    private final int capacity;

    public StackAggregation(int capacity) {
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

    public void push(Object o){
        if (!isFull())
            items.add(o);
        else
            System.out.println("Stack is full!");
    }

    public Object top(){
        if (!isEmpty()){
            return items.get(getSize() - 1);
        }
        else return null;
    }

    public void pop(){
        if (!isEmpty())
            items.remove(getSize() - 1);
    }

    public int getSize(){
        return items.size();
    }

}
