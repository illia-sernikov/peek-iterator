package ua.sernikov;

import java.util.Iterator;

public class PeekIterator<T> implements Iterator<T> {
    private final Iterator<T> baseIterator;

    public PeekIterator(Iterator<T> baseIterator) {
        this.baseIterator = baseIterator;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

    public T peek() {
        return null;
    }
}
