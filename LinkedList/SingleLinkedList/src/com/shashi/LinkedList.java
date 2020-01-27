package com.shashi;

public class LinkedList{
    Node head;

    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void insertNode(int data){
        if(head == null){
            head = new Node(data);
        }else{
            Node newNode = new Node(data);
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void deleteNode(int key){
        Node temp = head;
        Node prev = head;
        if(head == null){
            System.out.println("List is empty.");
        }else{
            while(temp.data != key){
                prev = temp;
                if(temp.next == null){
                    System.out.println("Key is not present in list.");
                    break;
                }
                temp = temp.next;
            }
            if(temp == head){
                head = temp.next;
                temp.next = null;
            }
            if(temp.next == null){
                prev.next = null;
            }else{
               prev.next = temp.next;
               temp.next = null;
            }
        }
    }

    public void deleteNodeAtPos(int pos){
        //TODO delete pos=0 and pos > list.size
        Node temp = head;
        Node prev = head;
        if(head == null){
            System.out.println("List is empty.");
        }else{
            int count = 0;
            while(count < pos){
                prev = temp;
                temp = temp.next;
                count ++;
            }
            prev.next = temp.next;
            temp.next = null;
        }
    }

    public void findLength(){
        Node temp = head;
        int length = 1;
        while(temp.next != null){
            length++;
            temp = temp.next;
        }
        if(head == null){
            System.out.println("List is empty.");
        }else{
            System.out.println("Length of list is: "+ length);
        }
    }

    public void searchList(int key){
        Node temp = head;
        if(head == null){
            System.out.println("List is empty.");
        }else{
            while(temp.data != key){
                if(temp.next == null){
                    System.out.println("Key is not present in list.");
                    break;
                }
                temp = temp.next;
            }
            if(temp.data == key) {
                System.out.println("Key found: " + temp.data);
            }
        }
    }
    public void searchNodeAtPos(int pos){
        //TODO delete pos=0 and pos > list.size
        Node temp = head;
        int count = 0;
        if(head == null){
            System.out.println("List is empty.");
        }else{
            while(count < pos){
                if(temp.next == null){
                    System.out.println("Given position is greater than linked list length.");
                    return;
                }
                temp = temp.next;
                count ++;
            }
            System.out.println("Item at position: " + pos + " is " + temp.data );
        }
    }

    public void itemAtNthPosFromLast(int pos){
        Node temp = head;
        Node nthposfromlast = head;
        int count = 1;
        while(temp.next != null){
            if(count >= pos){
                nthposfromlast = nthposfromlast.next;
            }
            count++;
            temp = temp.next;
        }
        System.out.println("Item at position: " + pos +" from last node is " + nthposfromlast.data);
    }

    public void midNodeOfList(){
        Node temp = head;
        Node mid = head;
        int count = 1;
        while(temp.next != null){
            if(count % 2 == 0){
                mid = mid.next;
            }
            count++;
            temp = temp.next;
        }
        if(count % 2 == 0){
            System.out.println("Middle node data for given list is: "+ mid.next.data);
        }else {
            System.out.println("Middle node data for given list is: " + mid.data);
        }
    }

    public void countOccurenceOfKey(int key){
        Node temp = head;
        int count = 0;
        while(temp.next != null){
            if(temp.data == key){
                count++;
            }
            temp = temp.next;
        }
        System.out.println("No. of occurence of key: "+ key + " is " + count +" times.");
    }

    public void createLoopedList(){ //creating a looped linked list by pointing last node to head node.
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
    }

    public void detectLoopInList(){
        Node fast_ptr = head;
        Node slow_ptr = head;
        int count = 1;
        while(fast_ptr.next != null){
            if(count % 2 == 0){ //example condition to differentiate between the speed of both pointers
                slow_ptr = slow_ptr.next;
            }
            count++;
            fast_ptr = fast_ptr.next;
            if(fast_ptr == slow_ptr){
                System.out.println("Loop Detected in Linked list.");
                return;
            }
        }
        System.out.println("No loop present in the linked list.");
    }

    public void printList(){
        Node temp = head;
        while(temp.next != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print(temp.data + "\n");
    }

    public void lengthOfLoop(){
        Node temp = head;
        int count = 0;
        while(temp.next != null){

            temp = temp.next;
        }
    }

    public static void main(String args[]){
        LinkedList list = new LinkedList();
        list.insertNode(1);
        list.insertNode(2);
        list.insertNode(3);
        list.insertNode(4);
        list.insertNode(5);
        System.out.print("Original List: ");
        list.printList();

        //delete node from list
        /*list.deleteNode(4);
        System.out.print("List after deletion: ");
        list.printList();*/

        //delete node at a given position in list
        /*list.deleteNodeAtPos(1);
        System.out.print("List after deletion: ");
        list.printList();*/

        //delete whole linked list
        /*list.head = null; //unreferenced (remaining) list is automatically deleted by Garbage collection*/

        //find length of linked list
        /*list.findLength()*/;

        //search key in list
        /*list.searchList(2);*/

        //get Nth node in a given list
        /*list.searchNodeAtPos(3);*/

        //get Nth node from last in a given list
        /*list.itemAtNthPosFromLast(2);*/

        //find middle node of linked list
        /*list.midNodeOfList();*/

        //function that counts the number of times a given int occurs in a Linked List
        /*list.countOccurenceOfKey(2);*/

        //detect loop in linked list
        /*list.createLoopedList(); //creating a looped link list
        list.detectLoopInList();*/

        //find length of loop in linked list
        list.createLoopedList();
        list.lengthOfLoop();
    }
}
