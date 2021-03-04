package com.itdotaer.queue;

import java.util.AbstractQueue;
import java.util.Iterator;

/**
 * CustomQueue
 *
 * @author jt_hu
 * @date 2021/3/2
 */
public class CustomQueue<E> extends AbstractQueue<E> {

    private final Object[] items;
    private int putIndex = 0;
    private int takeIndex = 0;
    private int count = 0;

    public CustomQueue(int capacity) {
        items = new Object[capacity];
    }

    /**
     * Returns an iterator over the elements contained in this collection.
     *
     * @return an iterator over the elements contained in this collection
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    /**
     * Inserts the specified element into this queue if it is possible to do
     * so immediately without violating capacity restrictions.
     * When using a capacity-restricted queue, this method is generally
     * preferable to {@link #add}, which can fail to insert an element only
     * by throwing an exception.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this queue, else
     * {@code false}
     * @throws ClassCastException       if the class of the specified element
     *                                  prevents it from being added to this queue
     * @throws NullPointerException     if the specified element is null and
     *                                  this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *                                  prevents it from being added to this queue
     */
    @Override
    public boolean offer(E e) {
        if (count >= items.length) {
            return false;
        }

        items[putIndex] = e;

        if (++putIndex == items.length) {
            putIndex = 0;
        }
        count++;

        return true;
    }

    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @Override
    public E poll() {
        if (count == 0) {
            return null;
        }

        Object e = items[takeIndex];
        if (++takeIndex == items.length) {
            takeIndex = 0;
        }
        count--;

        return (E) e;
    }

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @Override
    public E peek() {
        if (count == 0) {
            return null;
        }


        return (E) items[takeIndex];
    }
}
