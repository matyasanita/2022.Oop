package oop.labor09.queue;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListQueue implements IQueue{

    private final int CAPACITY;
    private ArrayList<Object> items = new ArrayList<>();

    public ArrayListQueue(int CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    @Override
    public boolean isEmpty() {
        return items.size() == 0;
    }

    @Override
    public boolean isFull() {
        return items.size() == CAPACITY;
    }

    @Override
    public void enQueue(Object newObj) {
        if (!isFull()){
            items.add(newObj);
        }
    }

    @Override
    public Object deQueue() {
        if (!isEmpty()){
            Object temp = items.get(0);
            items.remove(0);
            return temp;
        }
        else return null;
    }


    @Override
    public void printQueue() {
        if (!isEmpty()){
            System.out.println("ArrayList Queue:");
            for (Object o : items){
                System.out.println(o);
            }
        }
        /*else
            System.out.println("Queue is empty!");*/
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayListQueue that = (ArrayListQueue) o;
        if (this.items.size() != that.items.size()) return false;
        for (int i = 0 ; i < this.items.size() ; i++){
            //azert mert tobb fele objektum is lehet benne
            if ( ! this.items.get(i).equals(that.items.get(i)))  return false;
        }
        return true;
    }

}
