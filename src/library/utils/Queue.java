/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.utils;


/**
 *
 * @author usr
 */
public class Queue<T>  implements ArrayQueue<T>{

	private T[] data;
	private int size;
	private int front;
	private int rear;
	private int capacity;
	
	public Queue(int capacity) {
		this.capacity = capacity;
		this.data = (T[]) new Object[capacity];
		this.front = -1;
		this.rear = -1;
		this.size = 0;
	}
	
	@Override
	public boolean enqueue(T newElement) {
		
		if(rear >= capacity - 1) {
			return false;
		}
		
		if(front == -1) {
			front++;
		}
		rear++;
		data[rear] = newElement;
		size++;		
		return true;
	}

	@Override
	public T dequeue() {
		
		if(size == 0) {
			return null;
		}
		T toReturn = data[front];
		data[front] = null;
		front++;
		size--;
		return toReturn;
	}

	@Override
	public T peekFirst() {
		
		if(size == 0) {
			return null;
		}
		return data[front];
	}

	@Override
	public T peekLast() {
		if(size == 0) {
			return null;
		}
		return data[rear];
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean isEmpty() {

		if(size == 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		
		String toReturn = "[ ";
		
		for(int i = front; i <= rear; i++) {
			toReturn += data[i] + " ";
		}
		
		toReturn += "]";
		
		return toReturn;
	}

}