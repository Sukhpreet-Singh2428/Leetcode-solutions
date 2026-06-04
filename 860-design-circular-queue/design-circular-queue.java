class Node{
    int val;
    Node next;

    public Node(int val){
        this.val = val;
        this.next = null;
    }
}
class MyCircularQueue {
    Node head;
    Node front;
    Node rear;
    int size;
    int len;
    Node rearPrev;
    public MyCircularQueue(int k) {
        head = null;
        front = null;
        rear = null;
        size = k;
        len = 0;
    }
    
    public boolean enQueue(int value) {
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
            rear.next = newNode;
            rear = newNode;
            len++;
        }
        return true;
    }
    
    public boolean deQueue() {
        if(front==null || len==0){
            return false;
        }

        front = front.next;
        len--;

        if(len==0){
            front = null;
            rear = null;
        }
        
        return true;
    }
    
    public int Front() {
        if(front==null) return -1;
        return front.val;
    }
    
    public int Rear() {
        if(rear==null) return -1;
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
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */