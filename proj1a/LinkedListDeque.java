public class LinkedListDeque<T> {

    public static class Node<T> {
        T data;
        Node pre;
        Node next;

        public Node(T x, Node pre, Node next) {
            data = x;
            this.pre = pre;
            this.next = next;
        }

        public Node(T x) {
            data = x;
            pre = null;
            next = null;
        }
    }

    private Node Head, Tail;
    private int size = 0;
    public LinkedListDeque() {
        Head = new Node(null);
        Tail = new Node(null);
        Head.next = Tail;
        Tail.pre = Head;
    }

    public void addFirst(T item) {
        Node p = new Node(item);
        p.pre = Head;
        Head.next.pre = p;
        p.next = Head.next;
        Head.next = p;
        size ++;
    }

    public void addLast(T item) {
        Node p = new Node(item);
        p.next = Tail;
        Tail.pre.next = p;
        p.pre = Tail.pre;
        Tail.pre = p;
        size ++;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = Head.next;
        while(p != Tail) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    public T removeFirst() {
        Node p = Head.next;
        T removed = (T)new Object();
        if(p != Tail) {
            Head.next = p.next;
            p.next.pre = p.pre;
            p.pre = null;
            p.next = null;
            removed = (T)p.data;
        }
        size --;
        return removed;
    }

    public T removeLast() {
        Node p = Tail.pre;
        T removed = (T)new Object();
        if(p != Head) {
            Tail.pre = p.pre;
            p.pre.next = p.next;
            p.pre = null;
            p.next = null;
            removed = (T)p.data;
        }
        size --;
        return removed;
    }

    public T get(int index) {
        int count = 0;
        Node p = Head.next;
        T res = (T)new Object();
        while(count <index && p!=Tail) {
            p = p.next;
        }

        if(count != index || p == Tail) return null;
        else res = (T)p.data;
        return res;
    }

//    public T getRecursive(int index) {
//        if()
//    }
}
