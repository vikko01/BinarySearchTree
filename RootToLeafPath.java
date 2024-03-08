package BinarySearchTree;
import java.util.*;

public class RootToLeafPath {
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
        if(root.data > value) {
           root.left = insert(root.left, value);
        } 
        if(root.data < value) {
            root.right = insert(root.right, value);
        } 
        return root;
    }

    public static void printPath(ArrayList<Integer> path) {
        for(int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }

    public static void printRootToLeafPath(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }
        path.add(root.data);

        if(root.left == null && root.right == null) {
            printPath(path);
        }

        printRootToLeafPath(root.left, path);
        printRootToLeafPath(root.right, path);
        path.remove(path.size()-1);
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
        int values[] = {8,5,3,6,10,11,14};
        Node root = null;

        for(int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        printRootToLeafPath(root, new ArrayList<>());
    }
}
