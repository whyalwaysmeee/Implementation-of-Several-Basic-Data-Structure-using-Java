package Queue;

import java.util.Queue;
/** constructors
 * define a class IntQueue
 * define the length of array as a pre-set constant value MAXSIZE and set it to the value 52
 * define two pointers head and tail
 * define the number of elements in the queue
 * @param args
 */
public class IntQueue {
	 private int head = 0;
	 private int tail = 0;
	 private int MAXSIZE = 52;
	 private int[] queue = new int[MAXSIZE];
	 
/** calculate the length of the queue
 * 
 * @return
 */
public int length() {
	
	int numberofele =  (tail-head+MAXSIZE)% MAXSIZE;
    	return numberofele;
    }

/** judge whether the queue is empty or not
 * 
 * @return
 */
public boolean isEmpty() {
	if(head == tail) {
	return true;}
	else {
		return false;}
}

/**judge whether a queue is full or not
 * 
 * @param args
 */
public boolean isFull() {
	if((tail+1)%MAXSIZE == head){
		return true;}
		else {
			return false;}
		}

/** enqueue operation
 * we have to pay attention to the situation that the queue is full
 * @param args
 */
public boolean enqueue(int x) {
        if (isFull()) {
        	System.out.println("the queue is full!");
        	return false;
        }
        else {
        	queue[tail] = x;
        	tail = (tail+1)% MAXSIZE;
        	return true;
        }
        }

/** dequeue operation
 * 
 * @param args
 */
public boolean dequeue() {
	if (isEmpty()) {
		System.out.println("the queue is empty!");
		return false;
	}
	else {
		int y = queue[head];
		head = (head+1)% MAXSIZE;
		return true;
		}
	}

/** return the element on the head of the queue
 * 
 * @param args
 */
public int headelement() {
	return queue[head];
}

public static void main(String[] args) {
		  IntQueue queue = new IntQueue();
		  queue.enqueue(1);
		  System.out.println("head at the queue:" + queue.headelement());
		  queue.enqueue(2);
		  queue.enqueue(3);
		  queue.dequeue();
		  System.out.println("is queue empty? " + queue.isEmpty());
		  System.out.println("head at the queue:" + queue.headelement());
		 }
}
