import java.io.*;
import java.util.*;

public class BSTree {
    Node root;

    class Node {
        private String owner;
        private int price;
        private int color;
        private Node left;
        private Node right;
    
        public Node(String owner, int price, int color) {
            this.owner = owner;
            this.price = price;
            this.color = color;
            this.left = null;
            this.right = null;
        }
    
        // Add getters for price and color
        public int getPrice() {
            return price;
        }
    
        public int getColor() {
            return color;
        }
    
        // Add setters for left and right
        public void setLeft(Node left) {
            this.left = left;
        }
    
        public void setRight(Node right) {
            this.right = right;
        }
        public String getInfo() {
            return String.format("(%s,%d,%d)", owner, price, color);
        }
        public void setColor(int color) {
            this.color = color;
        }
        
        
        // Rest of your Node class code...
    }


    class Queue {
        private LinkedList<Node> list = new LinkedList<Node>();

        public void enqueue(Node node) {
            list.addLast(node);
        }

        public Node dequeue() {
            return list.pollFirst();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }
    }
    // Default constructor
    BSTree() {
        this.root = null;
    }
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    public void clear() {
        this.root = null;
    }
    
    public void visit(Node p) {
        System.out.print("p.info: ");
        if(p != null) System.out.println(p.getInfo() + " ");
    }
    
    public void fvisit(Node p, RandomAccessFile f) throws Exception {
        if(p != null) 
            f.writeBytes(p.getInfo() + " ");
    }
    
    public void breadth(Node p, RandomAccessFile f) throws Exception {
        if(p == null) 
            return;
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while(!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r,f);
            
            if(r.left != null) 
                q.enqueue(r.left);
            
            if(r.right != null) 
                q.enqueue(r.right);
        }
    }
    
    public void preOrder(Node p, RandomAccessFile f) throws Exception {
        
        if(p == null) 
            return;
        
        fvisit(p,f);
        preOrder(p.left,f);
        preOrder(p.right,f);
    }
    
    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if(p == null) 
            return;
        
        inOrder(p.left,f);
        fvisit(p,f);
        inOrder(p.right,f);
    }
    
    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if(p == null) 
            return;
        
        postOrder(p.left,f);
        postOrder(p.right,f);
        fvisit(p,f);
     }

    /**
     * Do NOT modify this method
     * Load 3 lines of data from file: 
     *      line k (for owner), and
     *      line k+1 (for price), and
     *      line k+2 (for color)
     * 
     * @param k the k-th line where data is started to be loaded
     */
    void loadData(int k) {
        String [] a = Lib.readLineToStrArray("data.txt", k);
        int [] b = Lib.readLineToIntArray("data.txt", k+1);
        int [] c = Lib.readLineToIntArray("data.txt", k+2);
        
        int n = a.length;
        for(int i=0;i<n;i++) 
            insert(a[i],b[i],c[i]); // insert the new Node(a[i], b[i], c[i]) into the BST
    }

    /**
    * Luy y: 1. SV KHONG su dung tieng Viet co dau trong bai lam de tranh Error khi run chuong trinh.
    *        2. Neu khong tuan thu se nhan diem 0 (khong).
    * 
    * Question 2.1: use Bird’s price as the key attribute when building a BST.
    *               implement the 'insert' method that inserts a new Node into 
    *               the BST if the attribute 'Owner'of Bird does NOT start with 'B'.
    * The output of this method will be written into the file 'f1.txt'. 
    * Therefore you should open this file to see/test your code output.
    * Example: with the content given in the file 'data.txt', 
    *          the content of 'f1.txt' after insertion should be
    *           (A,7,9) (C,4,3) (D,8,6) (E,2,5) (Y,6,-7) (F,-6,7) 
    *           (F,-6,7) (E,2,5) (C,4,3) (Y,6,-7) (A,7,9) (D,8,6) 

    * @param xOwner the owner of the input Bird
    * @param xPrice the price of the input Bird
    * @param xColor the color of the input Bird
    */
    void insert(String xOwner, int xPrice, int xColor) {
                //---------------------------------------------------------------------------------------
        //------ Start your code here------------------------------------------------------------
        if (!xOwner.startsWith("B")) { // Insert only if the owner does not start with 'B'
            root = insertRecursive(root, xOwner, xPrice, xColor);
        }    
    }   
    private Node insertRecursive(Node current, String owner, int price, int color) {
        if (current == null) {
            return new Node(owner, price, color);
        }

        // Recursively insert into the left or right subtree based on price
        if (price < current.getPrice()) {
            current.left = insertRecursive(current.left, owner, price, color);
        } else if (price > current.getPrice()) {
            current.right = insertRecursive(current.right, owner, price, color);
        }

        return current;
    }
     
        
        //------ End your code here--------------------------------------------------------------
        //---------------------------------------------------------------------------------------
    
  
    /**
     * Do NOT modify this method
     * This is a helper method for writing data (node's info) stored in the BST to file 
     * @throws Exception 
     */
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
        breadth(root,f);
        f.writeBytes("\r\n");
        inOrder(root,f);
        f.writeBytes("\r\n");
        f.close();
    }  
  
    // This method is used for Question 2.2
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
        breadth(root,f);
        f.writeBytes("\r\n");
        
        /**
         * Question 2.2: Perform breadth-first-search on the BST, but ONLY visit nodes that has Bird's color less than 6.
         * Hint: This method is similar to the method 'breadth' (provided in this class already). You should create 
         * a new method which body is similar to 'breadth' for doing BFS but considering only color less than 6.
         * The output f2() will be written into the file 'f2.txt'. 
         * Therefore you should open this file to see/test your code output.
         * Example: With the data provided in 'data.txt', the content of 'f2.txt' after running this method is 
         *              (C,8,2) (D,6,1) (E,9,4) (F,2,3) (G,7,8) (H,1,7) (I,3,9) (J,5,5) (K,4,6) 
         *              (C,8,2) (D,6,1) (E,9,4) (F,2,3) (J,5,5)
         */
        //---------------------------------------------------------------------------------------
        //------ Start your code here------------------------------------------------------------
        breadthWithColorLimit(root, f, 6);
        
       
        
        
        
        //------ End your code here--------------------------------------------------------------
        //---------------------------------------------------------------------------------------
        
        f.writeBytes("\r\n");
        f.close();
    }  
    private void breadthWithColorLimit(Node root, RandomAccessFile f, int colorLimit) throws Exception {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node r;
        while (!q.isEmpty()) {
            r = q.poll();
            if (r != null) {
                if (r.getColor() < colorLimit) {
                    fvisit(r, f);
                }
        
                if (r.left != null)
                    q.add(r.left);
        
                if (r.right != null)
                    q.add(r.right);
            }
        }
    }

    // This method is used for Question 2.3
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        postOrder(root,f);
        f.writeBytes("\r\n");
        /**
         * Question 2.3: Insert into the current tree a new Bird which  
         * Onwer = 'V', price = 100-k, color = 2k, where k is height of the current tree before insertion 
         * Hint:  
         *      (1) Implement a method to calculate the tree's height
         *      (2) Insert the new Bird('V', 100-Tree Height, 2*Tree Height) into the current tree
         * The output f3() will be written into the file 'f3.txt'. 
         * Therefore you should open this file to see/test your code output.
         * Example: With the data provided in 'data.txt', the content of 'f3.txt' after running this method is 
         *       (H,1,7) (K,4,6) (J,5,5) (I,3,9) (F,2,3) (G,7,8) (D,6,1) (E,9,4) (C,8,2) 
         *       (H,1,7) (K,4,6) (J,5,5) (I,3,9) (F,2,3) (G,7,8) (D,6,1) (V,94,12) (E,9,4) (C,8,2)
         */
        //---------------------------------------------------------------------------------------
        //------ Start your code here------------------------------------------------------------
        int treeHeight = calculateTreeHeight(root);
        insert("V", 100 - treeHeight, 2 * treeHeight);
        
        
        
        //------ End your code here--------------------------------------------------------------
        //---------------------------------------------------------------------------------------
        
        postOrder(root,f);
        f.writeBytes("\r\n");
        f.close();
    }  
    private int calculateTreeHeight(Node node) {
        if (node == null)
            return 0;

        int leftHeight = calculateTreeHeight(node.left);
        int rightHeight = calculateTreeHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
    // This method is used for Question 2.4
    void f4() throws Exception {
        clear();
        loadData(13);;
        String fname = "f4.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        postOrder(root,f);
        f.writeBytes("\r\n");
        /**
         * Question 2.4: Reset the Bird's color of all leaf Nodes to 0
         * Hint: Leaf nodes have neither left child nor right child
         * The output f4() will be written into the file 'f4.txt'. 
         * Therefore you should open this file to see/test your code output.
         * Example: With the data provided in 'data.txt', the content of 'f4.txt' after running this method is 
         *      (H,1,7) (K,4,6) (J,5,5) (I,3,9) (F,2,3) (G,7,8) (D,6,1) (E,9,4) (C,8,2) 
         *      (H,1,0) (K,4,0) (J,5,5) (I,3,9) (F,2,3) (G,7,0) (D,6,1) (E,9,0) (C,8,2)   
         */
        //---------------------------------------------------------------------------------------
        //------ Start your code here------------------------------------------------------------
        resetLeafColors(root);
        
        //------ End your code here--------------------------------------------------------------
        //---------------------------------------------------------------------------------------
        postOrder(root,f);
        f.writeBytes("\r\n");
        f.close();
    }  
    private void resetLeafColors(Node node) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            node.setColor(0);
        }

        resetLeafColors(node.left);
        resetLeafColors(node.right);
    }
 }
