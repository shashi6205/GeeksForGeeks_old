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
            Node temp = new Node(0); //node creeated with dummy data which is not used
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

    public void swapKthNode(int pos){
        Node fast_ptr = head;
        Node slow_ptr = head; //will be pointing to Kth node from last node at the end of the while loop
        Node prevToKthNode = head;
        Node kthNode = head;
        Node prevToslow_ptr;
        int counter = 1;
        while(fast_ptr.next != null){
            if(counter >= pos){
                if(counter == pos){
                    prevToKthNode = fast_ptr.prev;
                    kthNode = fast_ptr;
                }
                slow_ptr = slow_ptr.next;
            }
            counter++;
            fast_ptr = fast_ptr.next;
        }
        prevToslow_ptr = slow_ptr.prev;

        if(pos > counter){
            System.out.println("The kth value given is outside the list.");
            return;
        }
        Node swapNode = new Node(0); //swap of node is done using a temporary node
        swapNode.next = slow_ptr.next;
        swapNode.prev = slow_ptr.prev;
        slow_ptr.next = kthNode.next;
        slow_ptr.prev = kthNode.prev;
        kthNode.next = swapNode.next;
        kthNode.prev = swapNode.prev;

        if(pos == 1){ //the case where the first node is swapped with last
            prevToslow_ptr.next = kthNode;
            head = fast_ptr;
            return;
        }
        if(pos == counter){ //when the last node is swapped with first i.e. K = length of list
            swapNode.prev = fast_ptr.prev;
            fast_ptr.prev = null;
            fast_ptr.next = slow_ptr.next;
            slow_ptr.next = null;
            slow_ptr.prev = swapNode.prev;
            swapNode.prev.next = slow_ptr;
            head = fast_ptr;
            return;
        }

        swapNode.next = prevToslow_ptr.next; //using temporary node to change links for the previous nodesof kth nodes
        prevToslow_ptr.next = prevToKthNode.next;
        prevToKthNode.next = swapNode.next;
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

        //Swap Kth node from beginning with Kth node from end in a Linked List
        dlist.swapKthNode(5);
        System.out.print("Swapped List: ");
        dlist.printList();
    }
}
