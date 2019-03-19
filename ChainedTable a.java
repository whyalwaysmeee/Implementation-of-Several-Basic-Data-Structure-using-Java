package Dictionary;

/***constructor
 * 
 * @author Tong Cui
 *
 */
public class ChainedTable1
{  private static ChainedHashNode1[ ] table;

/**
 * Initialize an empty ChainedTable with a specified table size.
 **/  
   public ChainedTable1(int tableSize)
   {
      if (tableSize <= 0)
	  throw new IllegalArgumentException("Table size must be positive.");
      table = new ChainedHashNode1[tableSize];
   }

   /**
   * Determines whether a specified key is in this ChainedTable.
   **/
   public boolean containsKey(Object key)
   {   ChainedHashNode1 a = table[hash(key)];
	   while(a != null) {
		   if (a.key.equals(key)) return true;
		   else a = a.link;
	   }
	   return false;
   }
  
   /** Retrieves an object for a specified key.
 * @return 
   **/
   public Object get(Object key)
   {   ChainedHashNode1 a = table[hash(key)];
	   while(a != null) {
		   if (a.key.equals(key)) return a;
		   else a = a.link;
	   }
      return null;
   }

   /***hash function， calculating the hash value of a key
    *    
    * @param key
    * @return
    */
   
   private static int hash(Object key)
   { if(Math.abs(key.hashCode( ))>=0) {
      return Math.abs(key.hashCode( )) % table.length;}
   else {return Math.abs(key.hashCode( )) % table.length+table.length;}
   }

   /**
   * Add a new element to this ChainedTable, using the specified key.  
   **/
   public Object insert(Object key, Object element)
   {  ChainedHashNode1 cursor = null;
      Object answer = null;
      ChainedHashNode1 a = table[hash(key)];
      while ( a != null) {
    	  if (a.key.equals(key)){
    		  cursor = a;
    		  break;
    	  }
    	  else a = a.link;
      }
      if (cursor == null){
    	 int i = hash(key);
	    cursor = new ChainedHashNode1( );
	    cursor.element = element;
	    cursor.key = key;
	    cursor.link = table[i];
	    table[i] = cursor;
      }
      else{answer = cursor.element;
           cursor.element = element;
      }
      return answer;
   }

   /**
   * Removes an object for a specified key.
   **/
   public Object remove(Object key)
   {  ChainedHashNode1 pre = table[hash(key)];//use node 'pre' to record the head node in this chain
      ChainedHashNode1 e = table[hash(key)];
	  while( e != null ) {
		  if (e.key.equals(key)) 
		  {
			  pre.link = e.link;
			  return null;
		  }
		  else {pre = e;
			    e = pre.link;
		  }
	  }
      return null;
   }

   /***get the length of a chain whose head node is t
    * 
    * @param t
    * @return
    */
   public static int getlength(ChainedHashNode1 t) {
	   int length = 0;
	   for (ChainedHashNode1 n = t ; n != null ; n = n.link) {//traversal the chain whose head node is t till the end. When we visit a new node, the value of length increase by 1.
		   length += 1;
	   }
	   return length;
   }
   
   /***get the max chain length in a table
    * 
    * @return
    */
   public static int maxChainLength() {
	   int max = 0;
	   int i = 0;
	   while(i<table.length) {
		   if(getlength(table[i])>max) {
			   max = getlength(table[i]);//if the length of current chain is larger than max, update the value of max
			   i++;
		   }
		   else {i++;}
	   }
	   return max;
   }

public static void averagemaxchainlength1() {
	int sumL = 0;
	for(int i = 1;i<=50;i++) {
		ChainedTable1 t= new ChainedTable1(47);//create a new table each time
		for(int j = 0;j<1000;j++) {
		t.insert(RandEx.getRandomIndex(1,Integer.MAX_VALUE-1),RandEx.getRandomIndex(1,Integer.MAX_VALUE-1));//put the random numbers into the table
	}
	sumL = sumL + maxChainLength();}
	double L = sumL / 50;
	System.out.println("The average largest chain length under case1 is:"+L);
}

public static void averagemaxchainlength2() {
	int sumL = 0;
	for(int i = 1;i<=50;i++) {
		ChainedTable1 t= new ChainedTable1(48);
		for(int j = 0;j<1000;j++) {
		t.insert(RandEx.getRandomIndex(1,Integer.MAX_VALUE-1),RandEx.getRandomIndex(1,Integer.MAX_VALUE-1));
	}
	sumL = sumL + maxChainLength();}
	double L = sumL / 50;
	System.out.println("The average largest chain length under case2 is:"+L);
}

public static void averagemaxchainlength3() {
	int sumL = 0;
	for(int i = 1;i<=50;i++) {
		ChainedTable1 t= new ChainedTable1(51); 
		for(int j = 0;j<1000;j++) {
		t.insert(RandEx.getRandomIndex(1,Integer.MAX_VALUE-1),RandEx.getRandomIndex(1,Integer.MAX_VALUE-1));
	}
	sumL = sumL + maxChainLength();}
	double L = sumL / 50;
	System.out.println("The average largest chain length under case3 is:"+L);
}

public static void averagemaxchainlength4() {
	int sumL = 0;
	for(int i = 1;i<=50;i++) {
		ChainedTable1 t= new ChainedTable1(64);
		for(int j = 0;j<1000;j++) {
		t.insert(RandEx.getRandomIndex(1,Integer.MAX_VALUE-1),RandEx.getRandomIndex(1,Integer.MAX_VALUE-1));
	}
	sumL = sumL + maxChainLength();}
	double L = sumL / 50;
	System.out.println("The average largest chain length under case4 is:"+L);
}
/***constructor of chain nodes
 * 
 * @author Tong Cui
 *
 */
class ChainedHashNode1
{Object element;
 Object key;
 ChainedHashNode1 link;
}

public static void main(String[] args) {
	 ChainedTable1 t= new ChainedTable1(47);
	 t.insert(1,1);
	 t.insert(2,2);
	 t.insert(3,3);
	 t.insert(4,4);
	 t.insert(5,5);
	 t.insert(6,6);
	 t.insert(7,7);
	 t.insert(8,8);
	 t.insert(9,9);
	 t.insert(0,0);
	 t.insert(47,47);
	 t.insert(94,94);
	 t.insert(141,141);
	 System.out.println("The largest chain length in the table is:"+maxChainLength());
	 System.out.println("The hashCode for 94 is:"+hash(94));
     System.out.print("The table contains 47:"+t.containsKey(47));
     System.out.print('\n');
     t.remove(1);
     t.remove(2);
     t.remove(47);
     System.out.println("After removing 1,2 and 47, the largest chain length in the table is:"+maxChainLength());
     System.out.print('\n');
     System.out.println("Task 3:");
     System.out.println("case1:(p=47)");
     averagemaxchainlength1();
     System.out.print('\n');
     System.out.println("Task 4:");
     System.out.println("case2:(p=48)");
     averagemaxchainlength2();
     System.out.println("case3:(p=51)");
     averagemaxchainlength3();
     System.out.println("case4:(p=64)");
     averagemaxchainlength4();
}
}