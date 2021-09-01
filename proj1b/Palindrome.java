public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        char[] ch = word.toCharArray();
        Deque<Character> returnDeque = new LinkedListDeque<>();
        for (int i = 0; i < ch.length; i++) {
            returnDeque.addLast(ch[i]);
        }
        return returnDeque;
    }

    private boolean isParlindromeHelper(Deque<Character> d, CharacterComparator cc) {
        if (d.size() == 0 || d.size() == 1) {
            return true;
        }
        if (d.size() == 2) {
            return cc.equalChars(d.removeFirst(), d.removeLast());
        }
        if (!cc.equalChars(d.removeFirst(), d.removeLast())) {
            return false;
        }
        return isParlindromeHelper(d, cc);
    }

    public boolean isPalindrome(String word) {
        CharacterComparator equals = new ComparatorEquals();
        return isPalindrome(word, equals);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null) {
            return true;
        }
        Deque<Character> d = wordToDeque(word);
        return isParlindromeHelper(d, cc);
    }

}
