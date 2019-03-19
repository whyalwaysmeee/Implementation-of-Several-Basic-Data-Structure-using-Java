package Heap;

public class Heapsort {
	 private static int head = 0;
	 private static int tail = 0;
	
	/** make one of the nodes and its children compose a small max heap of 3 or 2 elements
	 *  the exchange function will be explained later
	 *  the reason for calling "maxheap" function itself at the end(line 25) is that we need to maintain the small max heap still being a max heap, which we have built before
	 * @return
	 */
		private static void maxheap(int[] array, int size, int parent) {
			int left = parent * 2 + 1;
			int right = parent * 2 + 2;
 
			int larger = parent;
			if (left < size && array[left] > array[parent]) {
				larger = left;
			}
 
			if (right < size && array[right] > array[larger]) {
				larger = right;
			}
 
			if (parent != larger) {
				exchange(array, parent, larger);
				maxheap(array, size, larger);
			}
		}
		
	/** make the entire array a max heap, also a max-priority queue 	
	 * @param array
	 */
		private static void buildmaxheap(int[] array) {
			if (array == null || array.length <= 1) {
				return;
			}
 
			int half = array.length / 2;
			for (int i = half; i >= 0; i--) {
				maxheap(array, array.length, i);
			}
		}
	/** this function is used for exchanging two elements	
	 * @param array
	 * @param a
	 * @param b
	 */
		public static void exchange(int[] array, int a, int b) {
		    int temp = array[a];
		    array[a] = array[b];
		    array[b] = temp;
	        }
	/** to implement heapsort, first we build a max-priority queue, then exchange the first and last element in the array, and then call "maxheap" function to maintain the entire array(except the last element) still being a max-priority queue.
	 * do this procedure iteratively and eventually we get the sorted array. 	
	 * @param array
	 */
		public static void heapsort(int[] array) {
			if (array == null || array.length <= 1) {
				return;
			}
 
			buildmaxheap(array);
 
			for (int i = array.length - 1; i >= 1; i--) {
				exchange(array, 0, i);
				maxheap(array, i, 0);
			}
		}
		
		public static void tostring(int[] array)
		{
			for (int i = 0; i < array.length-1; i++) {
			    System.out.print(array[i]);
			    System.out.print(",");
			    }
			System.out.println(array[array.length-1]);
		}
	
		public static void main(String[] args) {
			
			int [] array = {34,52,16,77,84,4,6,99,300,1054,427};
			System.out.println("The original array is: ");
			
			tostring(array);
			
			buildmaxheap(array);
			
			System.out.println("The heap based priority queue is:");
			
			tostring(array);
			
			heapsort(array);
 
			System.out.println("After sorting:");
			
			tostring(array);
			}}

	
	
