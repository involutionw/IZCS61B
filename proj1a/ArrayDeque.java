public class ArrayDeque<T> {
    private T[] Array;
    private int size;
    private int length;
    private int nextFirst;
    private int nextLast;
    public ArrayDeque() {
        Array = (T[])new Object[8];
        size = 0;
        length = 8;
        nextFirst = 0;
        nextLast = 7;
    }

    private int minusOne(int x, int length) {
        if(x == 0) return length-1;
        else return x-1;
    }

    private int addOne(int x, int mod) {
        return (x+1) % mod;
    }

    /* 无需特判，因为expand时 F L一定相邻
     *
     */
    private void expand() {
        T[] a = (T[]) new Object[length*2];

        int ptr1 = minusOne(nextFirst, length*2);
        int ptr2 = minusOne(nextFirst, length);

        for(; ptr2 != nextLast; ) {
            a[ptr1] = Array[ptr2];
            ptr2 = minusOne(ptr2, length);
            if (ptr1 == 0) ptr1 = a.length - 1;
            else ptr1--;
        }
        nextLast = ptr1;
        Array = a;
        length = a.length;
    }

    private void shrink() {
        T[] a = (T[]) new Object[length / 2];

        int ptr1 = (length / 4) - 1;
        int ptr2 = minusOne(nextFirst, length);

        for(; ptr2 != nextLast; ) {
            a[ptr1] = Array[ptr2];
            ptr2 = minusOne(ptr2, length);
            if (ptr1 == 0) ptr1 = a.length - 1;
            else ptr1--;
        }
        nextLast = ptr1;
        nextFirst = length / 4;
        Array = a;
        length = a.length;
    }
    public void addFirst(T item) {
        if(size == length - 1) {
            expand();
        }
        Array[nextFirst] = item;
        nextFirst = addOne(nextFirst, length);
        size ++;
    }

    public void addLast(T item) {
        if(size == length - 1) {
            expand();
        }
        Array[nextLast] = item;
        nextLast = minusOne(nextLast, length);
        size ++;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int ponint = nextFirst-1;
        for(;ponint != nextLast; ponint = minusOne(ponint, length)) {
            System.out.println(Array[ponint]);
        }
    }

    public T removeFirst() {

        double usage = (1.0*size / length);
        if(length >= 16 && usage <= 0.25) {
            shrink();
        }
        if(size == 0) {
            return null;
        }
        nextFirst = minusOne(nextFirst, length);
        T tmp = Array[nextFirst];
        Array[nextFirst] = null;
        size --;
        return tmp;
    }

    public T removeLast() {

        double usage = (1.0*size / length);
        if(length >= 16 && usage <= 0.25) {
            shrink();
        }
        if(size == 0) {
            return null;
        }
        nextLast = addOne(nextLast, length);
        T tmp = Array[nextLast];
        Array[nextLast] = null;
        size --;
        return tmp;
    }

    public T get(int index) {
        if(index >= size) {
            return null;
        }
        int p = minusOne(nextFirst, length);
        for(int i = 0; i < index; i ++) {
            p = minusOne(p, length);
        }
        return Array[p];
    }

}
