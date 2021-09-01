import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testAB() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('A', 'B'));
    }

    @Test
    public void testAC() {
        assertFalse(offByOne.equalChars('a', 'c'));
        assertFalse(offByOne.equalChars('A', 'C'));
    }

    @Test
    public void testZA() {
        assertFalse(offByOne.equalChars('z', 'a'));
        assertFalse(offByOne.equalChars('Z', 'A'));
    }

    @Test
    public void testABB() {
        assertTrue(offByOne.equalChars('&', '%'));
    }

    @Test
    public void testAA() {
        assertFalse(offByOne.equalChars('a', 'A'));
    }

}
