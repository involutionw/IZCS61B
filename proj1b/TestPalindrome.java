import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String str1 = "asddsa";
        String str2 = "asddfdfgfgh";
        String str3 = "Asddas";

//        Deque d1 = palindrome.wordToDeque("asddas");
//        Deque d2 = palindrome.wordToDeque("asddfdfgfgh");

        boolean test1 = palindrome.isPalindrome(str1);
        boolean test2 = palindrome.isPalindrome(str2);
        boolean test3 = palindrome.isPalindrome(str3);

        assertTrue(test1);
        assertFalse(test2);
        assertFalse(test3);

        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("aba"));
        assertTrue(palindrome.isPalindrome("aaccbbbccaa"));

        assertFalse(palindrome.isPalindrome("ab"));
        assertFalse(palindrome.isPalindrome("ababba"));
    }

    @Test
    public void testIsOffByOnePalindrome() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertFalse(palindrome.isPalindrome("aba", cc));
    }

    //Uncomment this class once you've created your Palindrome class.
}