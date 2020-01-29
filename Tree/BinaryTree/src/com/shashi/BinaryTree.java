package com.shashi;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public void insertNode(int data){
        if(root == null){
            root = new Node(data);
        }else{
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                Node temp = q.peek();
                q.remove();
                if(temp.left == null){
                    temp.left = new Node(data);
                    break;
                } else
                    q.add(temp.left);
                if(temp.right == null){
                    temp.right = new Node(data);
                    break;
                } else
                    q.add(temp.right);
            }
        }
    }

    public void printTree(){
        if(root == null){
            System.out.println("Tree is Empty.");
        }else{
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                Node temp = q.peek();
                System.out.print(temp.data + " ");
                q.remove();
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            System.out.println();
        }
    }

    public void levelOrderTraversal(){
        if(root == null){
            System.out.println("Tree is Empty.");
        }else{
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            System.out.print("Level order Traversal : ");
            while(!q.isEmpty()){
                Node temp = q.peek();
                System.out.print(temp.data + " ");
                q.remove();
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            System.out.println();
        }
    }

    public void inOrderTraversal(Node root){
        if(root != null){
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public void preOrderTraversal(Node root){
        if(root != null){
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void postOrderTraversal(Node root){
        if(root != null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    public int deepestNode(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp = root;
        Node prev = root;
        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();
            if(temp.left != null){
                prev = temp;
                q.add(temp.left);
            }
            if(temp.right != null){
                prev = temp;
                q.add(temp.right);
            }
        }
        if(prev.right == temp){
            prev.right = null;
        }else{
            prev.left = null;
        }
        return temp.data;
    }

    public void deleteNodeInTree(int key){
        int data = deepestNode();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.peek();
            q.remove();
            if(temp.left.data != key){
                q.add(temp.left);
            }else{
                temp.left.data = data;
                break;
            }
            if(temp.right.data != key){
                q.add(temp.right);
            }else{
                temp.right.data = data;
                break;
            }
        }
        printTree();
    }

    public static void main(String args[]){
        BinaryTree bTree = new BinaryTree();
        bTree.insertNode(1);
        bTree.insertNode(2);
        bTree.insertNode(3);
        bTree.insertNode(4);
        bTree.insertNode(5);
        System.out.print("Original Tree : ");
        bTree.printTree();

        /*bTree.levelOrderTraversal();
        System.out.print("InOrder Traversal : ");
        bTree.inOrderTraversal(bTree.root);
        System.out.print("\nPreOrder Traversal : ");
        bTree.preOrderTraversal(bTree.root);
        System.out.print("\nPostOrder Traversal : ");
        bTree.postOrderTraversal(bTree.root);*/

        //https://www.geeksforgeeks.org/deletion-binary-tree/
        System.out.print("Tree after deletion and replacing deepest node : ");
        bTree.deleteNodeInTree(2);
    }
}
