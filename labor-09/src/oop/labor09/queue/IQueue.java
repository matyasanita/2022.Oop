package oop.labor09.queue;

public interface IQueue {
    boolean isEmpty();
    boolean isFull();
    void enQueue(Object newObj);
    Object deQueue();
    void printQueue();
}
