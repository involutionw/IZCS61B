public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> Words = new LinkedListDeque<>();

        for(int i = 0;i < word.length(); i ++) {
            char charat = word.charAt(i);
            Words.addLast(charat);
        }
        return Words;
    }

    private boolean isPalindromeRecursion(Deque<Character> words) {
        if(words.size() <= 1) {
            return true;
        }

        char left = words.removeFirst(), right = words.removeLast();
        if(left == right) {
            return isPalindromeRecursion(words);
        }else {
            return false;
        }
    }
    private boolean isPalindromeRecursion(Deque<Character> words, CharacterComparator cc) {
        if(words.size() <= 1) {
            return true;
        }

        char left = words.removeFirst(), right = words.removeLast();
        if(cc.equalChars(left, right)) {
            return isPalindromeRecursion(words);
        }else {
            return false;
        }
    }
    public boolean isPalindrome(String word) {
        Deque words = wordToDeque(word);
        boolean ans = isPalindromeRecursion(words);
        return ans;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque words = wordToDeque(word);
        boolean ans = isPalindromeRecursion(words, cc);
        return ans;
    }
}
