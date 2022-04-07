package oop.labor08.ex2;

import java.util.ArrayList;

public class StackInheritance extends ArrayList<Object> {
    private final int capacity;

    public StackInheritance(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull(){
        if (super.size() == capacity)
            return true;
        return false;
    }

    public boolean isEmpty(){
        if (super.size() == 0 )
            return true;
        return false;
    }

    public void push(Object o){
        if (!isFull())
            super.add(o);
        else
            System.out.println("Stack is full!");
    }

    public Object top(){
        if (!isEmpty()){
            return super.get(getSize() - 1);
        }
        else return null;
    }

    public void pop(){
        if (!isEmpty())
            super.remove(getSize() - 1);
    }

    public int getSize(){
        return super.size();
    }

}
