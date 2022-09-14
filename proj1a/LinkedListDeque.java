public class LinkedListDeque<T> {

    public static class Node<T> {
        T data;
        Node per;
        Node next;

        public Node(T x, Node per, Node next) {
            data = x;
            this.per = per;
            this.next = next;
        }

        public Node(T x) {
            data = x;
            per = null;
            next = null;
        }
    }

    private Node sentinel;
    private int size = 0;
    public LinkedListDeque() {
        sentinel = new Node(null);
        sentinel.next = sentinel;
        sentinel.per = sentinel;
    }

    public void addFirst(T item) {
        Node p = new Node(item);
        p.per = sentinel;
        sentinel.next.per = p;
        p.next = sentinel.next;
        sentinel.next = p;
        size++;
    }

    public void addLast(T item) {
        Node p = new Node(item);
        p.next = sentinel;
        sentinel.per.next = p;
        p.per = sentinel.per;
        sentinel.per = p;
        size++;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    public T removeFirst() {
        Node p = sentinel.next;
        if (p == sentinel) {
            return null;
        }
        T removed = (T) new Object();
        if (p != sentinel) {
            sentinel.next = p.next;
            p.next.per = p.per;
            p.per = null;
            p.next = null;
            removed = (T) p.data;
        }
        size--;
        return removed;
    }

    public T removeLast() {
        Node p = sentinel.per;
        if (p == null) {
            return null;
        }
        T removed = (T) new Object();
        if (p != sentinel) {
            sentinel.per = p.per;
            p.per.next = p.next;
            p.per = null;
            p.next = null;
            removed = (T) p.data;
        }
        size--;
        return removed;
    }

    public T get(int index) {
        int count = 0;
        Node p = sentinel.next;
        T res = (T) new Object();
        while (count < index && p != sentinel) {
            p = p.next;
            count ++;
        }

        if (count != index || p == sentinel) {
            return null;
        } else {
            res = (T) p.data;
        }
        return res;
    }

    private T getRecursive(Node p, int index, int cnt) {
        if (index > size) {
            return null;
        }
        if (p == sentinel) {
            return null;
        }
        if (index == cnt) {
            return (T) p.data;
        }
        return getRecursive(p.next, index, cnt + 1);
    }
    public T getRecursive(int index) {
        return getRecursive(sentinel.next, index, 0);
    }
}
