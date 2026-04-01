class MinStack {

    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;

    public MinStack() {
        head = new DoublyLinkedNode(0, Integer.MAX_VALUE);
        tail = head;
    }
    
    public void push(int val) {
        int min = Math.min(val, tail.min);
        DoublyLinkedNode node = new DoublyLinkedNode(val, min);

        tail.next = node;
        node.prev = tail;
        tail = node;
    }
    
    public void pop() {
        if(tail == head) return;

        tail = tail.prev;
        tail.next = null;
    }
    
    public int top() {
        return tail.val;
    }
    
    public int getMin() {
        return tail.min;
    }
}

class DoublyLinkedNode {
    int val;
    int min;
    DoublyLinkedNode prev;
    DoublyLinkedNode next;

    DoublyLinkedNode(int val, int min){
        this.val = val;
        this.min = min;
    }
}