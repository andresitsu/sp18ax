import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testAB() {
        assertTrue(offByOne.equalChars('a', 'b'));
    }

    @Test
    public void testAC() {
        assertFalse(offByOne.equalChars('a', 'c'));
    }

    @Test
    public void testZA() {
        assertFalse(offByOne.equalChars('z', 'a'));
    }
}
