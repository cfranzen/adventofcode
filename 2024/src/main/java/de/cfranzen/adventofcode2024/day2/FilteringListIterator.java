package de.cfranzen.adventofcode2024.day2;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class FilteringListIterator<E> implements ListIterator<E> {

    private final List<E> elements;

    private final int blockedIndex;

    private int nextIndex;

    public FilteringListIterator(final List<E> elements, final int blockedIndex) {
        this.elements = elements;
        this.blockedIndex = blockedIndex;
        this.nextIndex = (blockedIndex == 0) ? 1 : 0;
    }

    @Override
    public boolean hasNext() {
        return elements.size() > nextIndex;
    }

    @Override
    public E next() {
        if (elements.size() <= nextIndex) {
            throw new NoSuchElementException();
        }

        E element = elements.get(nextIndex);
        nextIndex = increaseIndex();
        return element;
    }

    @Override
    public boolean hasPrevious() {
        final var previousIndex = previousIndex();
        return previousIndex >= 0;
    }

    @Override
    public E previous() {
        final var previousIndex = decreaseIndex();
        E element = elements.get(previousIndex);
        nextIndex = previousIndex;
        return element;
    }

    @Override
    public int nextIndex() {
        return nextIndex;
    }

    @Override
    public int previousIndex() {
        return decreaseIndex();
    }

    private int decreaseIndex() {
        int previousIndex = nextIndex - 1;
        if (previousIndex == blockedIndex) {
            previousIndex--;
        }
        return previousIndex;
    }

    private int increaseIndex() {
        int newNextIndex = nextIndex + 1;
        if (newNextIndex == blockedIndex) {
            newNextIndex++;
        }
        return newNextIndex;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    @Override
    public void set(final E element) {
        throw new UnsupportedOperationException("Set not supported");
    }

    @Override
    public void add(final E element) {
        throw new UnsupportedOperationException("Add not supported");
    }
}
