import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Gabriel Gil
 * @version: 12/13/24
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // Call the helper function for search
        return helpSearch(val, root);
    }

    public boolean helpSearch(int val, BSTNode n)
    {
        // Base case: if there is no node, return false
        if(n == null) {
            return false;
        }
        // If val matches the value of the node, return true as the value has been found
        if (val == n.getVal())
        {
            return true;
        }
        // If the value is less than the value of the node, search the let side of the tree calling helpSearch again
        // on the left side of the tree
        else if(val < n.getVal())
        {
           return helpSearch(val, n.getLeft());
        }
        // Otherwise, the value is on the right side of the tree, so search the right side of the tree calling
        // helpSearch again on the right side of the tree
        else
        {
            return helpSearch(val, n.getRight());
        }
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> inOrder = new ArrayList<BSTNode>();
        helpGetInorder(root, inOrder);
        return inOrder;
    }

    public void helpGetInorder(BSTNode n, ArrayList<BSTNode> inOrder){
        if(n == null)
        {
            return;
        }
        helpGetInorder(n.getLeft(), inOrder);
        inOrder.add(n);
        helpGetInorder(n.getRight(), inOrder);
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> preOrder = new ArrayList<BSTNode>();
        helpGetPreorder(root, preOrder);
        return preOrder;
    }

    public void helpGetPreorder(BSTNode n, ArrayList<BSTNode> preOrder)
    {
        if(n == null)
        {
            return;
        }
        preOrder.add(n);
        helpGetPreorder(n.getLeft(), preOrder);
        helpGetPreorder(n.getRight(), preOrder);
    }


    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> postOrder = new ArrayList<BSTNode>();
        helpGetPostorder(root, postOrder);
        return postOrder;
    }

    public void helpGetPostorder(BSTNode n, ArrayList<BSTNode> postOrder)
    {
        if(n == null)
        {
            return;
        }
        helpGetPostorder(n.getLeft(), postOrder);
        helpGetPostorder(n.getRight(), postOrder);
        postOrder.add(n);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        helpInsert(val, root);
    }

    public void helpInsert(int val, BSTNode n)
    {
        if(val == n.getVal())
        {
            return;
        }
        if(val < n.getVal())
        {
            if(n.getLeft() == null)
            {
                n.setLeft(new BSTNode(val));
                return;
            }
            helpInsert(val, n.getLeft());
        }
        else
        {
            if(n.getRight() == null)
            {
                n.setRight(new BSTNode(val));
                return;
            }
            helpInsert(val, n.getRight());
        }
    }


    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
