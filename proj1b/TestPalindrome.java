import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
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
    public void testCat() {
        assertFalse(palindrome.isPalindrome("Cat"));
    }

    @Test
    public void testAbba() {
        assertTrue(palindrome.isPalindrome("abba"));
    }

    @Test
    public void testAba() {
        assertTrue(palindrome.isPalindrome("aba"));
    }

    @Test
    public void testAaa() {
        assertTrue(palindrome.isPalindrome("aaa"));
    }

    @Test
    public void testA() {
        assertTrue(palindrome.isPalindrome("A"));
    }

    @Test
    public void offOneTestFlake() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", cc));
    }
}
