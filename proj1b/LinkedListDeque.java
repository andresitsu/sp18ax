public class LinkedListDeque<T> implements Deque<T> {
    private class StuffNode {
        private StuffNode prev;
        private T item;
        private StuffNode next;
        public StuffNode(StuffNode p, T i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
        }
        public StuffNode(T i) {
            prev = null;
            item = i;
            next = null;
        }
    }

    private int sizeConstant;
    private StuffNode sentinel;

    public LinkedListDeque() {
        sentinel = new StuffNode(null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        sizeConstant = 0;
    }

    private void connectNodes(StuffNode a, StuffNode b) {
        a.next = b;
        b.prev = a;
    }

    private void insertNodeAs(StuffNode a, StuffNode b, StuffNode c) {
        connectNodes(a, b);
        connectNodes(b, c);
    }

    @Override
    public void addFirst(T f) {
        sizeConstant += 1;
        StuffNode newNode = new StuffNode(null, f, null);
        insertNodeAs(sentinel, newNode, sentinel.next);
    }

    @Override
    public void addLast(T item) {
        sizeConstant += 1;
        StuffNode newNode = new StuffNode(null, item, null);
        StuffNode lastNode = sentinel.prev;
        insertNodeAs(lastNode, newNode, sentinel);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return sizeConstant;
    }

    @Override
    public void printDeque() {
        StuffNode p = sentinel.next;
        while (p.next != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println(p.item);
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        StuffNode first = sentinel.next;
        T returnItem = first.item;
        StuffNode second = first.next;
        connectNodes(sentinel, second);
        sizeConstant -= 1;
        first = null;
        return returnItem;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        StuffNode last = sentinel.prev;
        T returnItem = last.item;
        connectNodes(last.prev, sentinel);
        sizeConstant -= 1;
        last = null;
        return returnItem;
    }

    @Override
    public T get(int index) {
        StuffNode p = sentinel.next;
        if (isEmpty()) {
            return null;
        }
        while (index != 0) {
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    private T getRecursiveHelper(int index, StuffNode n) {
        if (index == 0) {
            return n.item;
        }
        return getRecursiveHelper(index - 1, n.next);
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel.next);
    }
}
