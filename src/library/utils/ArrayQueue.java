/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.utils;

/**
 *
 * @author Xiquinho
 */
public interface ArrayQueue <T> {

	/**
	 * Adds an element at the back of the queue
	 * 
	 * @param newElement
	 * @return false is capacity full
	 */
	public boolean enqueue(T newElement);
	
	/**
	 * Removes an element from the front of the queue
	 * @return null if queue is empty
	 */
	public T dequeue();
	
	/**
	 * First element of the queue without removing it
	 * @return null if empty
	 */
	public T peekFirst();
	
	/**
	 * Last element of the queue without removing it
	 * @return null if empty
	 */
	public T peekLast();
	
	/**
	 * Number of elements in the queue
	 * @return
	 */
	public int size();
	
	/**
	 * True if there is no elements in the queue
	 * @return
	 */
	public boolean isEmpty();
	
}

