class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class MyHashSet {

    Node head = new Node(-1);
    Node temp;
    public MyHashSet() {
        temp = head;
    }
    
    public void add(int key) {
        if(contains(key)) return;
        Node newNode = new Node(key);
        temp.next = newNode;
        temp = newNode;
    }
    
    public void remove(int key) {
        Node current = head.next;
        Node prev = head;
        while(current != null){
            if(current.data == key){
                prev.next = current.next;
                if(current==temp){
                    temp = prev;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    
    public boolean contains(int key) {
        Node current = head.next;
        while(current != null){
            if(current.data == key){
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */