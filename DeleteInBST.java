package BinarySearchTree;

public class DeleteInBST {

    static class Node{
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
        }
        if(root.data > value) {
            root.left = insert(root.left, value);
        }

        if(root.data < value) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Node delete(Node root, int val) {
        if(root.data < val) {
            root.right = delete(root.right, val);
        }
         else if(root.data > val) {
            root.left = delete(root.left, val);
        }

        else{
            if(root.left == null && root.right == null) {
            return null;
        }
        if(root.left == null) {
            return root.right;
        }
         else if(root.right == null) {
            return root.left;
        }
        Node IS = findInorderSuccessor(root.right);
        root.data = IS.data;
        root.right = delete(root.right, IS.data);
    }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
            while(root.left != null) {
                root = root.left;
            }
            return root;
    }
    public static void main(String[] args) {
        int value [] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i = 0; i < value.length; i++) {
            root = insert(root, value[i]);
        }

        inorder(root);

        root = delete(root, 5);
        System.out.println();

        inorder(root);
    }
}
