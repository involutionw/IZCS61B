public class ArrayDeque<T> {
    private T[] Array;
    private int size;
    private int nextFirst;
    private int nextLast;
    private double usage;
    public ArrayDeque() {
        Array = (T[])new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 7;
        usage = 0;
    }

    private void resize(int res) {
        T[] a = (T[]) new Object[res];
        int l = res-(Array.length-1-nextLast), r = Array.length-1-nextLast;
        System.arraycopy(Array, 0, a, 0, nextFirst);
        System.arraycopy(Array, nextLast+1, a, res-(Array.length-1-nextLast), Array.length-1-nextLast);
        Array = a;
        nextLast = l-1;
        updateusage();
    }
    private void checkSize(){
        if(size() == Array.length) {
            resize(Array.length * 2);
        }else if(Array.length>=100 && usage<=0.25) {
            resize(size()/2);
        }
    }

    private void checksentinel() {
        if(nextFirst < 0) nextFirst = Array.length-1;
        else if(nextFirst == Array.length) nextFirst = 0;

        if(nextLast == Array.length) nextLast = 0;
        else if(nextLast < 0) nextLast = Array.length-1;
    }
    private void updateusage() {
        usage = (double)size()/ Array.length;
    }

    public void addFirst(T item) {
        checkSize();
        Array[nextFirst] = item;
        nextFirst ++;
        size ++;
        checksentinel();
        updateusage();
    }

    public void addLast(T item) {
        checkSize();
        Array[nextLast] = item;
        nextLast --;
        size ++;
        checksentinel();
        updateusage();
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int ponint = nextFirst-1;
        for(;ponint != nextLast; ponint --) {
            if(ponint < 0) ponint = Array.length-1;
            System.out.println(Array[ponint]);
        }
    }

    public T removeFirst() {
        nextFirst --;
        checksentinel();
        T tmp = Array[nextFirst];
        Array[nextFirst] = null;
        size --;
        updateusage();

        return tmp;
    }

    public T removeLast() {
        nextLast ++;
        checksentinel();
        T tmp = Array[nextLast];
        Array[nextLast] = null;
        size --;
        updateusage();

        return tmp;
    }
}
