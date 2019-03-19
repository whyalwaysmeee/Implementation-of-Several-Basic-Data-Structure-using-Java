package Dictionary;

public class BTNode {
/***constructor,creating nodes
* define left as a node's left child
* define right as a node's right child
* define data as a node's value
* @author Tong Cui
*
*/
private static class Node{
        private Node left = null;
        private Node right = null;
        private int data;
        public Node(int data){
            this.data = data;
        }}

/*** insert a node whose value is data
 * 
 * @param root
 * @param data
 * @return
 */
public static Node insert(Node root, int data) {
		if(root == null) {
			root = new Node(data);
		}//if the tree is empty, the node we want to insert will be the root node of the BST
		else if(data <= root.data) {
			root.left = insert(root.left,data);}//if the node we want to insert is not bigger than the root, put it on the left-hand side of the root node
		else {
			root.right = insert(root.right,data);//if the node we want to insert is bigger than the root, put it on the right-hand side of the root node
		}
		return root;
	}

/***create the BST,using insert function
 * in this function, I use an array to store all the elements we are going to insert into the BST.
 * creating a BST is just to insert elements into it constantly until all the elements are inserted. 
 * @param root
 * @param data
 * @return
 */
public static Node create(Node root, int[]data) {
        int i = 0;
        root = null;
        while(i < data.length) {
          root = insert(root, data[i]);
          i++;
          }
        return root;
    }

/***get the data of a node
 * 
 * @param root
 * @return
 */
public static int getData(Node root)   
{
   return root.data;
}

/***get the left child of a node
 * 
 * @param root
 * @return
 */
public static Node getLeft(Node root)
{
   return root.left;                                               
} 

/***get the right child of a node
 * 
 * @param root
 * @return
 */
public static Node getRight(Node root) 
{
   return root.right;
}

/***get the most left node
 * 
 * @param root
 * @return
 */
public static Node getLeftmostData(Node root)
{
   if (root.left == null)
      return root;
   else
      return getLeftmostData(root.left);
}

/***get the most right node
 * 
 * @param root
 * @return
 */
public static Node getRightmostData(Node root)
{
   if (root.right == null)
      return root;
   else
      return getRightmostData(root.right);
}

/***search an element whose value is equal to data, return itself
 * 
 * @param root
 * @param data
 * @return
 */

public static Node find(Node root, int data) {
	if(root == null) {
		return root;
	}
	if(data < root.data) {
		return find(root.left, data);} 
		else if(data > root.data) {
			return find(root.right, data);
		}
		else {return root;}
	}

/***search an element whose value is equal to data, return its parent
 * this function is of no practical use but it helps us when we want to delete a node
 * @param root
 * @param data
 * @return
 */
public static Node findparent(Node root, int data) {
	 Node p = null; 
	 if(data == root.data) {
		 return null;
	 }
	 else {
     while(root != null && root.data != data){ 
         p = root;
         if(data < root.data){
             root = root.left;
         }else{
             root = root.right;
         }
     }
 
     return p; 
 }
}

/***find p's child node whose value is equal to data
 * this function is of no practical use either but it helps us when we want to delete a node
 * @param root
 * @param p
 * @param data
 * @return
 */
public static Node findchild(Node root, Node p, int data){
    if(p == null){ 
        return root;
    }
    if(p.left == null && p.right == null){ 
        return null;
    }
    if(p.left != null && p.left.data == data){
        return p.left;
    }else{
        return p.right;
    }
}


/***find the minimum element in the BST
 * 
 * @param root
 * @return
 */
public static Node Min(Node root) {
	
	while(root.left != null) {
		root = root.left;
	}
	return root;
}

/***find the maximum element in the BST
 * 
 * @param root
 * @return
 */
public static Node Max(Node root) {

	while(root.right != null) {
		root = root.right;
	}
	return root;
	}

/***delete a element whose value is equal to data
 * when we want to delete a node m, we must consider the problem in 4 cases:
 * case 1. m is a leaf node
 * case 2. m has left child but no right child
 * case 3. m has right child but no left child
 * case 4. m has both left and right child
 * @param root
 * @param data
 */
public static Node delete(Node root, int data) {
    if (root == null) {
        return null;
    }
    Node p = findparent(root, data); //we use p as the node's parent node, which we want to delete
    Node c = null;
    c = findchild(root, p, data); //we use c as the node which we want to delete
    if (c == null) { 
        return root; 
    }//In each case, first we have to judge if the node we want to delete is a root node. Then we have to judge the node is a left child or a right child.
    if (c.left == null && c.right == null) { //case 1 
        if (c == root) { //if c is a root node, just delete it and do nothing more. 
            root = null;
            return root;
        }
        if (p.left != null && p.left.data == c.data) //if c is a left child
        	{ 
            p.left = null; //change p's left child to null
        } else { //if c is a right child
            p.right = null; //change p's right child to null
        }
        c = null; 
    } else if (c.left != null && c.right == null) { //case 2
        if (c == root) { //if it is a root node, then we delete it and its left child is the root now.
            root = c.left;
            return c.left;
        }
        if (p.left != null && p.left.data == c.data) { //if c is a left child
            p.left = c.left;// we delete c and then c's left child becomes p's left child
        } else { //if c is a right child
            p.right = c.left;// we delete c and then c's left child becomes p's right child
        }
    } else if (c.left == null && c.right != null) { // case 3 is similar to case 2
        if (c == root) { 
            root = c.right;
            return c.right;
        }
        if (p.left != null && p.left.data == c.data) {
            p.left = c.right;
        } else {
            p.right = c.right;
        }
    } else { //case 4 seems more complicated, but there are several ways to handle this case. Here I just pick up one of them. 
        Node n = c.right; //find c's right child n
        while (n.left != null) {//find the smallest element in the tree whose root node is n
            n = n.left;
        }
        delete(c, n.data);//delete the smallest node I mentioned above
        n.left = c.left; // let c's left child be n's left child
        n.right = c.right; //let c's right child be n's right child. 
        if (c == root) { 
            return n;
        }else{
            if (p.left != null && p.left.data == c.data) { //if c was p's left child, then n now becomes p's left child
                p.left = n;
            } else {//if c was p's right child, then n now becomes p's right child
                p.right = n; //Actually we switched c and the smallest node in the tree whose root node is c's right child, and then delete c. 
            }
        }
    }
    return root;
}

/***get the depth of the BST with recursion
 * @param root
 * @return
 */
public static int depth(Node root) {
	int leftdepth = 0;
	int rightdepth = 0;
	if(root == null) {
		return 0;
	}
	leftdepth = depth(root.left) +1;
	rightdepth = depth(root.right) +1;
	if(leftdepth >= rightdepth) {
		return leftdepth;
	}
	else {return rightdepth;}
}

/***do a pre-order traversal of the BST 
 * @param root
 */
public static void preorder(Node root) {
	if(root != null) {
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}
}

/***do an in-order traversal of the BST 
 * @param root
 */
public static void inorder(Node root){ 
    if(root != null){
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

/***do a post-order traversal of the BST 
 * @param args
 */
public static void postorder(Node root) {
	 if(root != null){
	    postorder(root.left);
	    postorder(root.right);
	    System.out.print(root.data + " "); 
	}
}

/***judge whether a node is a leaf node
 * @param root
 * @param data
 * @return
 */
public static boolean isLeaf(Node root, int data)
{  Node f = find(root,data);
   return (f.left == null) && (f.right == null);                                               
} 

/***replace the data of a node with a new data
 * @param root
 * @param original
 * @param current
 */
public static void setData(Node root, int originaldata, int newdata) {
	Node old = find(root, originaldata); //first we should find out the root we want to update
	old.data = newdata;
}

/***get the number of nodes in the BST
 * @param root
 * @return
 */
public static int treeSize(Node root)
{
   if (root == null)
      return 0;
   else
      return 1 + treeSize(root.left) + treeSize(root.right);
}

/*** calculate the average height of the BST in case1
 * @param root
 */
public static void averageheight1(Node root) {
	System.out.println("Case 1:");
	int sumH = 0;
    for(int i=1;i<=100;i++) {
    	int [] test = new int[1001]; // create a new array to store the random numbers we are going to insert into the BST
    	int height = 0;
    	test = RandEx.randPermute(1000); // put all 1000 random numbers into it
    	root = create(root, test); // create the BST
    	height = depth(root); // its height is equal to its depth
    	sumH = sumH + height;}
    double H = sumH/100.0;
    System.out.println("The average height for case 1 is:"+ H);
}

/***calculate the average height of the BSTin case2
 * @param root
 */
public static void averageheight2(Node root) {
	    System.out.println("Case 2:");
	    int sumH = 0;
	    int [] test = new int[1001]; // create a new array to store the random numbers we are going to insert into the BST
		int [] D = new int[101]; // create a new array D to store the values of nodes which we are going to delete from the BST or re-insert into the BST
	for(int b=1;b<=100;b++) {
		int height = 0;
		for(int v=0;v<100;v++) {
			D[v] = RandEx.getRandomIndex(1,1000); // put 100 numbers into D
		}
    	test = RandEx.randPermute(1000);// put all 1000 random numbers into it
    	root = create(root, test);// create the BST
    	int counter = 0; //set a counter to record how many nodes we will delete and re-insert 
    	for(int q=0;q<100;q++) {
    		for(int w=0;w<1000;w++) {
    			if(D[q] == test[w]) {
    				delete(root,test[w]); // delete the nodes which have the same value in both arrays
    				counter += 1;
    			}
    		}
    	}
    	if(counter != 0) {
    	for(int y=0;y<counter;y++) {
    		insert(root,D[y]);// if we delete n nodes from the BST, we have to re-insert n nodes into it
    	}
    	height = depth(root);
    	}
    	sumH = sumH + height;} 
    	double H = sumH/100.0;
    System.out.println("The average height for case 2 is:"+ H);
}

public static void main(String[] args) {
	int datas[] = new int[] {11,23,63,74,5,46,87,80,29,10};
	Node root = null;
	root = create(root, datas);
	
	System.out.println("The number of nodes in the BST is:"+treeSize(root));
	
	System.out.println("The minimum is:"+Min(root).data);
	
	System.out.println("The maximum is:"+Max(root).data);
	
	System.out.println("The data of this node is:"+getData(root));
	
	System.out.println("The left child of "+ root.data + " is:"+getLeft(root).data);
	
	System.out.println("The right child of "+ root.data + " is:"+getRight(root).data);
	
	System.out.println("The most left node is:"+ getLeftmostData(root).data);
	
	System.out.println("The most right node is:"+ getRightmostData(root).data);
	
	System.out.println("whether 29 is a leaf node:"+isLeaf(root,29));
	
	System.out.println("whether 5 is a leaf node:"+isLeaf(root,5));
	
	if(find(root,66) == null) {
		System.out.println("we can find 66 in the BST:"+false);
	}
	else {System.out.println("we can find 66 in the BST:"+true);
}
	
    if(find(root,46) == null) {
    	System.out.println("we can find 46 in the BST:"+false);
    }
    else {System.out.println("we can find 46 in the BST:"+true);
    }
    
    System.out.println("The depth of the BST is:"+depth(root));
    
    System.out.println("The inorder of the BST is:");
    
    inorder(root);
    
    System.out.print('\n');
    
    System.out.println("The preorder of the BST is:");
    
    preorder(root);
    
    setData(root, 23, 24);
    
    System.out.print('\n');
    
    System.out.println("After replace 23 with 24, the preorder of the BST is:");
    
    preorder(root);
    
    System.out.print('\n');
    
    System.out.println("The postorder of the BST is:");
    
    postorder(root);
    
    System.out.print('\n');
   
    delete(root,5);
    
    delete(root,63);
    
    delete(root,80);
    
    System.out.println("The inorder of the modified BST is:");
    inorder(root);
    
    System.out.print('\n');

    System.out.println("The depth of the modified BST is:"+depth(root));

    System.out.println("The number of nodes in the BST is:"+treeSize(root));
    
    System.out.print('\n');
    
    averageheight1(root);
    
    averageheight2(root);
}}

