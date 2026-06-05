class Node{
    int val;
    Node next;

    public Node(int val){
        this.val = val;
        this.next = null;
    }
}
class MyCircularDeque {
    Node head;
    Node front;
    Node rear;
    int size;
    int len;
    public MyCircularDeque(int k) {
        head = null;
        front = null;
        rear = null;
        size = k;
        len = 0;
    }
    
    public boolean insertFront(int value) {
        if(len==size){
            return false;
        }

        if(front==null){
            head = new Node(value);
            front = head;
            rear = head;
            len++;
        }
        else{
            Node newNode = new Node(value);
            newNode.next = front;
            front = newNode;
            len++;
        }
        return true;
    }
    
    public boolean insertLast(int value) {
        if(len==size) return false;

        if(front==null){
            head = new Node(value);
            front = head;
            rear = head;
            len++;
        }
        else{
            Node newNode = new Node(value);
            rear.next = newNode;
            rear = newNode;
            len++;
        }
        return true;
    }
    
    public boolean deleteFront() {
        if(len==0) return false;

        front = front.next;
        len--;

        if(len==0){
            front = null;
            rear = null;
        }

        return true;
    }
    
    public boolean deleteLast() {
        if(len==0) return false;
        if(len==1){
            front = null;
            rear = null;
            len--;
            return true;
        }

        Node newLast = front;
        while(newLast.next != rear){
            newLast = newLast.next;
        }
        newLast.next = null;
        rear = newLast;
        len--;

        if(len==0){
            front = null;
            rear = null;
        }

        return true;
    }
    
    public int getFront() {
        if(len==0) return -1;
        return front.val;
    }
    
    public int getRear() {
        if(len==0) return -1;
        return rear.val;
    }
    
    public boolean isEmpty() {
        return len==0;
    }
    
    public boolean isFull() {
        return len==size;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */