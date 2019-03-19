package Heap;

/**constructor
 * we built this priority queue based on max heap and queue. 
 * define two pointers head and tail
 * @author Tong Cui
 *
 */
public class Priorityqueue {
	 private static int head = 0;
	 private static int tail = 0;
	 private static int[] priorityqueue = new int[50];

/**this maxheap function was written by myself when I was trying to implement heap sort a couple of weeks ago. I think it might be necessary to build a priority queue
 * the exchange function in it is directly called from Heapsort.java. 
 * @param priorityqueue
 * @param size
 * @param parent
 */
private static void maxheap(int[] priorityqueue, int size, int parent) {
	int left = parent * 2 + 1;
	int right = parent * 2 + 2;

	int larger = parent;
	if (left < size && priorityqueue[left] > priorityqueue[parent]) {
		larger = left;
	}

	if (right < size && priorityqueue[right] > priorityqueue[larger]) {
		larger = right;
	}

	if (parent != larger) {
		Heapsort.exchange(priorityqueue, parent, larger);
		maxheap(priorityqueue, size, larger);
	}
}

/** this function is used for making the entire array a max heap.
 * 
 * @param array
 */
private static void buildmaxheap(int[] array) {
	if (array == null || tail <= 1) {
		return;
	}

	int half = tail / 2;
	for (int i = half; i >= 0; i--) {
		maxheap(array, tail, i);
	}
}

/**this function is just the same as the enqueue operation in the procedure of implementing a queue. 
 * 
 * @param x
 * @return
 */
public static boolean MAXHEAPINSERT(int x) {
        
        	priorityqueue[tail] = x;
        	tail = tail+1;
        	return true;
        }

/**this function is used for getting the head of the priority queue. 
 * 
 * @return
 */
 public static int HEAPMAXIMUM() {
	    buildmaxheap(priorityqueue);
	    return priorityqueue[head];
}
 
/**this function is used for extracting the maximum of the queue, following the idea in CLRS textbook.
 * 
 * @return
 */
public static int HEAPEXTRACTMAXIMUM() {
	    
			int max = priorityqueue[head];
			priorityqueue[head]=priorityqueue[tail-1];
			tail--;
			buildmaxheap(priorityqueue);			

	    return max;
}

/**this function is used for getting any element we want in the queue.
 * 
 * @param i
 * @return
 */
public static int THEITHELEMENT(int i) {
    return (priorityqueue[i]);

}

/**this function is used for increasing one of the keys to a larger value, also following the idea in CLRS textbook.
 * 
 * @param i
 * @param k
 */
public static void HEAPINCREASEKEY(int i, int k) {
	if(k<THEITHELEMENT(i)) {
		System.out.println("new key is smaller than current key!");
	}
	else{
		priorityqueue[i]=k;
		buildmaxheap(priorityqueue);
	}
}

/**display all the elements of the queue
 * 
 */
public static void tostring() {

	for(int i = 0;i<tail-1;i++) {
		   System.out.print(THEITHELEMENT(i));
		   System.out.print(",");
	   }
	   System.out.println(THEITHELEMENT(tail-1));
	}

public static void main(String[] args) {
	   Priorityqueue priorityqueue = new Priorityqueue();
	   
	   MAXHEAPINSERT(2);
	   System.out.println("after inserting 2, the queue is:");
	   tostring();
	   MAXHEAPINSERT(11);
	   System.out.println("after inserting 11, the queue is:");
	   tostring();
	   MAXHEAPINSERT(145);
	   System.out.println("after inserting 145, the queue is:");
	   tostring();
	   MAXHEAPINSERT(64);
	   System.out.println("after inserting 64, the queue is:");
	   tostring();
	   MAXHEAPINSERT(88);
	   System.out.println("after inserting 88, the queue is:");
	   tostring();
	   MAXHEAPINSERT(81);
	   System.out.println("after inserting 81, the queue is:");
	   tostring();
	   MAXHEAPINSERT(25);
	   System.out.println("after inserting 25, the queue is:");
	   tostring();
	   
	   System.out.println("so the original queue is:");
	   
	   tostring();
	  
	   System.out.println("the maximum of the priority queue is:"+HEAPMAXIMUM());
	   
	   System.out.println("the priority queue is:");
	   
	   tostring();
	   
	   System.out.println("the extracted maximum is:"+HEAPEXTRACTMAXIMUM());
	   
	   System.out.println("after extracting the maximum and heapifying, the queue is:");
	   
	   tostring();
	   
	   HEAPINCREASEKEY(3, 1000) ;
	   
	   System.out.println("after increasing the fourth element 25 to 1000, the maximum of queue is:"+HEAPMAXIMUM());
	   
	   System.out.println("after increasing the fourth element 25 to 1000, the queue is:");
	   tostring();
}
}


