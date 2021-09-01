public class OffByN implements CharacterComparator {

    private int offNumber;

    public OffByN(int N) {
        offNumber = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return x - y == offNumber || y - x == offNumber;
    }

}
