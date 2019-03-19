package Stack;

import java.util.Stack;

/** constructors
 * define a class IntStack
 * define the length of array as a pre-set constant value MAXSIZE and set it to the value 52
 * @param args
 */
public class IntStack {
	private final int MAXSIZE = 52;
	private int[] stack = new int[MAXSIZE];
	private int top = -1;

/** judge whether the stack is empty or not
 * @return
 */
public boolean isEmpty() {
	return top==-1;
	}

/** judge whether the stack is full or not
 * @return
 */
public boolean isFull() {
	return (top == MAXSIZE-1);
	}

/**push operation
 * if the stack is full, we cannot push anything into it and then just return false.
 * if the stack is not full, top = top + 1 and put x on the top position. 
 * @param x
 * @return
 */
public boolean push(int x) {
	if (top == MAXSIZE-1) {
		return false;
	}
	++top;
	stack[top]=x;
	return true;
	}
/** pop operation
 * if the stack is empty, we cannot pop anything from it and then just return false.
 * if the stack is not empty, we pop stack[top] and assign its value to y and then return true. 
 * @return
 */
public boolean pop(){
	if(top==-1) {
		System.out.println("the stack is empty!");
		return false;
	}
	int y = stack[top];
	top--;
	return true;
	
}
/** return the element on top
 * if the stack is empty, we cannot return anything.
 * if the stack is not empty, we just return stack[pop].
 * @return
 */
public int peek() {
	return stack[top];
	}

public int numberofele() {
	return (top+1);
}

public static void main(String[] args) {
	    IntStack stack = new IntStack();
	    stack.push(1);    // Insert 1 in the stack
	    stack.push(2);    // Insert 2 in the stack
	    stack.push(3);    // Insert 3 in the stack
	    stack.push(4);    // Insert 4 in the stack
	    System.out.println("the number of elements is: "+stack.numberofele());
	    System.out.println("peek at the stack:"+stack.peek());    // Prints the top of the stack ("D")
	    stack.pop();    // removing the top (4)
	    System.out.println("peek at the stack:"+stack.peek());
	    System.out.println("is stack full? "+stack.isFull());
	    System.out.println("is stack empty? " +stack.isEmpty());
	
	  }
}