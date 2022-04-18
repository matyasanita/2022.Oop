package oop.labor09.queue;

import java.util.Arrays;
import java.util.Objects;

public class CircularQueue implements IQueue{
    private final int CAPACITY;
    private Object[] items;
    private int front;
    private int rear;

    public CircularQueue(int CAPACITY) {
        this.CAPACITY = CAPACITY;
        items = new Object[CAPACITY];
        front = -1;
        rear = -1;
    }

    @Override
    public boolean isEmpty() {
        if (front == -1 && rear == -1)
            return true;
        return false;
    }

    @Override
    public boolean isFull() {
        if (front == 0 && rear == CAPACITY-1 || front - 1 == rear)
            return true;
        return false;
    }

    @Override
    public void enQueue(Object newObj) {
        if (isEmpty()){
            front = 0;
            rear = 0;
            items[front] = newObj;
        }
        else if (!isFull()){
            rear = (rear + 1) % CAPACITY;
            items[rear] = newObj;
        }
    }

    @Override
    public Object deQueue() {
        if (!isEmpty()){
            Object temp;
            temp = items[front];
            items[front] = 0;
            if (front == rear){
                front = -1;
                rear = -1;
            }
            else{
                front = ( front + 1 ) % CAPACITY;
            }
            return temp;
        }
        //System.out.println("Queue is empty!");
        return null;
    }

    @Override
    public void printQueue() {
        if (!isEmpty()){
            System.out.println("Circular queue:");
            for (int i = front; i != (rear + 1) % CAPACITY ; i = (i+1) % CAPACITY){
                System.out.println(items[i]);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CircularQueue that = (CircularQueue) o;

        int this_index = this.front, that_index = that.front;
        while( this_index != (this.rear + 1) % this.CAPACITY && that_index != (that.rear + 1) % CAPACITY ){
            if (! this.items[this_index].equals(that.items[that_index])){
                return false;
            }
            this_index = (this_index + 1) % this.CAPACITY;
            that_index = (that_index + 1) % that.CAPACITY;
        }
        return true;
    }

}
