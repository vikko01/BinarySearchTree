package BinarySearchTree;

public class SearchInBST {
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

        if(value < root.data) {
            root.left = insert(root.left, value);

        }

        if(value > root.data) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }
        if(root.data < key) {
            return search(root.right, key);
        } else {
            return search(root.left, key);
        }

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
        int values [] = {8,5,3,1,6,4,10,11,14};
        Node root = null;

        for(int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inorder(root);

       System.out.println();

        if(search(root, 50)) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }
        System.out.println();
    }
}
