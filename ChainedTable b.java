package Dictionary;
/***constructor
 * 
 * @author Tong Cui
 *
 */
public class ChainedTable
{  private static int tableSize;
   private static int size;
   private static ChainedHashNode[ ] table;
   /**
   * Initialize an empty ChainedTable with a specified table size.
   **/   
   public ChainedTable(int p)
   {  size = 0;
      tableSize = p;
      table = new ChainedHashNode[tableSize];
      for(int i = 0; i < tableSize;i++) { //reset the table, make sure that it is an empty table
    	  table[i] = null;
      }
   } 
/***get the size of the table
 * 
 * @return
 */
   public int getsize() {
	   return size;
   }
   
   /**
   * Determines whether a specified key is in this ChainedTable.
   **/
   public boolean containsKey(int key)
   {  int index = hash(key); //get the 'key''s hash code first
   if(table[index]==null) { //if there's no head node whose index is the 'key''s hash code, then 'key' is impossible to be contained in the table
	   return false;
   }
   else {
   ChainedHashNode link = table[index];//get the head node 'link' of the chain whose hash code is 'index'
   if(link.value != key) { //if 'key' is not the value of the head node in a chain
   while(link != null) //traversal the chain until we find it or figure out it does not exist
   {if(link.value == key) {
	   return true;
   }
   else {link = link.next;
   }	
   }return false;
   }
   else {return true;}
   }
   }
   
   /** Retrieves an object for a specified key.
 * @return 
   **/
   public int get(int key) {
   int index = hash(key);
    if(table[index] == null) {
    	return -1;
    }
    else {
    	ChainedHashNode link = table[index];
    	if(link.value != key) {
    	while(link != null) {
    		if(link.value == key) {return key;
    }
    		else {link = link.next;
   }
    	}return -1;
    }
    	else {return link.value;}
   }
   }
  
/***hash function， calculating the hash value of a key
 *    
 * @param key
 * @return
 */
   private static int hash(int key)
   {int h = 0;
   h = key % tableSize;
   if(h < 0) {
	   h = h + tableSize;
   }
   return h;
   }
   
   /**
   * Add a new element to this ChainedTable, using the specified key.  
   **/
   public void put(int key)
   { int index = hash(key);
     if(table[index] == null) {//if there is no node whose hash code is index, then 'key' will be the first one. It will also be the head node of the chain
    	table[index] = new ChainedHashNode(key);
         size++;}
     else {ChainedHashNode link = table[index];//find the chain that 'key' will be placed into. 
     while(link.next != null) {
    	 link = link.next;}
     link.next = new ChainedHashNode(key);
   } }
      
   /**
   * Removes an object for a specified key.
   **/
   @SuppressWarnings("null")
public void remove(int key)
   {
     int index = hash(key);
     if(table[index] != null) {
    	 ChainedHashNode p = null;
    	 ChainedHashNode link = table[index];//find the chain that 'key' is belong to
    	 if(link.value == key) {
    		 if(link.next == null) {
    		 link = link.next;
    		 size--;}//if the chain only has an element 'key', then after removing 'key', the size of the table should reduce by 1
    		 else {link = link.next;}}
    	 else {
    	 while(link.next != null && link.value != key) {
    		 p = link;
    		 link = link.next;
     if(link.value == key) {
    	 p.next = link.next;
    	 link = null;
    	 break;}
    	 }
     }
     }
     }

   /***get the length of a chain whose head node is link
    * 
    * @param link
    * @return
    */
public static int getlength(ChainedHashNode link) {
	int counter = 0;
	if(link == null) {
		return 0;
	}
	else {
	while(link != null) {//traversal the chain until the end
		counter +=1;
		link = link.next;
	}
	return counter;
}}

/***get the max chain length in a table
 * 
 * @return
 */
public static int maxChainLength() {
	int max = 0;
    int i = 0;
    while(i<tableSize) {
    	ChainedHashNode m = table[i];
    	int l = getlength(m);
    	if(l > max) {
    		max = l;
    		i++;
    	}
    	else {i++;}
    }
	return max;
}

/***get the average max chain length under case 1
 * 
 */
public static void averagemaxchainlength1() {
	int sumL = 0;
	for(int i = 1;i<=50;i++) {
		ChainedTable t= new ChainedTable(47);
		for(int j = 0;j<1000;j++) {
		t.put(RandEx.getRandomIndex(1,Integer.MAX_VALUE-1));
	}
	sumL = sumL + maxChainLength();}
	double L = sumL / 50;
	System.out.println("The average largest chain length under case1 is:"+L);
}

/***get the average max chain length under case 2
 * 
 */
public static void averagemaxchainlength2() {
	int sumL = 0;
	for(int i = 1;i<=50;i++) {
		ChainedTable t= new ChainedTable(64);
		for(int j = 0;j<1000;j++) {
		t.put(RandEx.getRandomIndex(1,Integer.MAX_VALUE-1));
	}
	sumL = sumL + maxChainLength();}
	double L = sumL / 50;
	System.out.println("The average largest chain length under case2 is:"+L);
}

/***constructor, creating chains
 * 
 * @author Tong Cui
 *
 */
class ChainedHashNode
{  
   int value;
   ChainedHashNode link;
   ChainedHashNode next;
   ChainedHashNode(int value){
	   this.value = value;
	   this.next = null;
   }
   } 

public static void main(String[] args) {
	 ChainedTable t= new ChainedTable(47);
	t.put(1);
	t.put(2);
	t.put(3);
	t.put(4);
	t.put(5);
	t.put(6);
	t.put(7);
	t.put(8);
	t.put(9);
	t.put(0);
	t.put(47);
	t.put(94);
	 System.out.println("The largest chain length in the table is:"+maxChainLength());
	 System.out.println("The hashCode for 5 is:"+hash(5));
     System.out.print("The table contains 47:"+t.containsKey(47));
     System.out.print('\n');
     t.remove(1);
     t.remove(2);
     t.remove(47);
     System.out.println("After removing 1,2 and 47, the largest chain length in the table is:"+maxChainLength());
     System.out.println("Task 5:");
     System.out.println("case 1(p = 47)");
     averagemaxchainlength1();
     System.out.println("case 2(p = 64)");
     averagemaxchainlength2();

}
} 





