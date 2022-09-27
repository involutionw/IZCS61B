public class OffByN implements CharacterComparator{

    private int N;

    public OffByN(int n) {
        N = n;
    }
    public boolean equalChars(char x, char y) {
        int diff = y-x;
        if(diff == N || diff == -N) {
            return true;
        }else {
            return false;
        }
    }
}
