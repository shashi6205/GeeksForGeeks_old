package com.shashi;

public class DoubleLinkedList {
    Node head;

    public class Node{
        int data;
        Node prev,next;
        public Node(int data){
            this.data = data;
            prev = next = null;
        }
    }

    public void insertNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public void deleteNode(int key){
        Node temp = head;
        Node prevNode = head;
        if(head == null){
            System.out.println("List is empty.");
        }else{
            while(temp.data != key){
                prevNode = temp;
                if(temp.next == null){
                    System.out.println("Key is not present in list.");
                    break;
                }
                temp = temp.next;
            }
            if(temp == head){
                head = temp.next;
                temp.next.prev = null;
                //temp.next = null;
            }
            if(temp.next == null){
                prevNode.next.prev = null;
                prevNode.next = null;
            }else{
                prevNode.next = temp.next;
                temp.next.prev = temp.prev;
                temp.next = null;
                temp.prev = null;
            }
        }
    }

    public void reverseList(){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }else{
            Node current = head;
            Node temp = new Node(0);
            while(current.next != null){
                temp.next = current.next;
                temp.prev = current.prev;
                current.next = temp.prev;
                current.prev = temp.next;
                current = temp.next;
            }
            temp.next = current.next;
            temp.prev = current.prev;
            current.next = temp.prev;
            current.prev = temp.next;
            head = current;
        }
    }

    public void printList(){
        Node temp = head;
        while(temp.next != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print(temp.data + "\n");
    }

    public static void main(String args[]){
        DoubleLinkedList dlist = new DoubleLinkedList();
        dlist.insertNode(1);
        dlist.insertNode(2);
        dlist.insertNode(3);
        dlist.insertNode(4);
        dlist.insertNode(5);
        System.out.print("Original List: ");
        dlist.printList();

        //delete a node from dlist
        /*dlist.deleteNode(5);
        System.out.print("List after deletion: ");
        dlist.printList();*/

        //reverse the dlist
        /*dlist.reverseList();
        System.out.print("Reversed List: ");
        dlist.printList();*/
    }
}
