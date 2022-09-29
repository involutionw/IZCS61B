import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void Tset() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();

        for(int i = 0 ;i < 16; i ++) {
            sad.addFirst(i);
        }

        for(int i = 15; i >= 0; i--) {
            assertEquals(i,(int)sad.removeFirst());
        }

        for(int i = 0 ;i < 16; i ++) {
            sad.addLast(i);
        }
        for(int i = 15; i >= 0; i--) {
            int tmp = sad.removeLast();
            assertEquals("removeLest()\n expect " + i + " but get " + tmp, i, tmp);
        }
    }
}
