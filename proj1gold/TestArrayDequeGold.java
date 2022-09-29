import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void Tset() {
        StudentArrayDeque<Integer> stad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> stdArray = new ArrayDequeSolution<>();
        String log = "";
        for(int i = 0; i < 1000; i ++) {
            if(stdArray.size() == 0) {
                int number = StdRandom.uniform(1000);
                int which = StdRandom.uniform(2);
                if(which == 0) {
                    stad.addFirst(number);
                    stdArray.addFirst(number);
                    log = log + "addFirst(" + number  +")\n";
                }else {
                    stad.addLast(number);
                    stdArray.addLast(number);
                    log = log + "addLast(" + number  +")\n";
                }
            }else {
                int number, expect = 0, actual = 0;
                int op = StdRandom.uniform(4);
                switch(op) {
                    case 0:
                        expect = actual = number = StdRandom.uniform(1000);
                        stad.addFirst(number);
                        stdArray.addFirst(number);
                        log = log + "addFirst(" + number  +")\n";
                        break;
                    case 1:
                        expect = actual = number = StdRandom.uniform(1000);
                        stad.addLast(number);
                        stdArray.addLast(number);
                        log = log + "addLast(" + number  +")\n";
                        break;
                    case 2:
                        expect = stdArray.removeFirst();
                        actual = stad.removeFirst();
                        log = log + "removeFirst()\n";
                        break;
                    case 3:
                        expect = stdArray.removeLast();
                        actual = stad.removeLast();
                        log = log + "removeLast()\n";
                        break;
                }
                assertEquals(log, expect, actual);
            }
        }
    }
}
