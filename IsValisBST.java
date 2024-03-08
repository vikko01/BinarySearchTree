package BinarySearchTree;

public class IsValisBST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
        this.data = data;
        }
    }

    public static Node insert(Node root, int value) {
        if(root == null) {
            root = new Node(value);
            return root;
        }
        if(root.data < value) {
            root.right = insert(root.right, value);        
        }
        if(root.data > value) {
            root.left = insert(root.left, value);
        }
        return root;
    }

    public static boolean isValid(Node root, Node max, Node min) {
        if(root == null) {
            return true;
        }
        if(max != null && root.data >= max.data) {
            return false;
        } else if(min != null && root.data <= min.data) {
            return false;
        }
        return isValid(root.left, min, root) && isValid(root.right, max, root);
    }

    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        int values[] = {1,1,1};
        Node root = null;

        for(int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        
        inorder(root);
        System.out.println();

        if(isValid(root, null, null)) {
            System.out.println("Valid");
        } else {
            System.out.println("Not valid");
        }
    }
}
