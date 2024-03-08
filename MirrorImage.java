package BinarySearchTree;

public class MirrorImage {
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
            root =  new Node(value);
            return root;
        }

        if(value < root.data) {
            root.left = insert(root.left, value);  
        }
        if(value > root.data) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static Node mirror(Node root) {
        if(root == null) {
            return null;
        } 
        Node leftSubtree = mirror(root.left);
        Node rightSubtree = mirror(root.right);

        root.left = rightSubtree;
        root.left = leftSubtree;

        return root;

    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
     
            int values [] = {8,5,3,1,4,6,10,11,14};
            Node root = null;
    
            for(int i = 0; i < values.length; i++) {
                root = insert(root, values[i]);
            }
    root = mirror(root);
    preOrder(root);
    }
}
