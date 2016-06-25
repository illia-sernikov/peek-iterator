package ua.sernikov;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekIteratorTest {
    private Iterator<Element> baseIterator;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private enum Element {
        FIRST, SECOND, THIRD
    }

    @Before
    public void setUp() {
        baseIterator = Arrays.asList(Element.FIRST, Element.SECOND, Element.THIRD)
                             .iterator();
    }

    @Test
    public void methodRemoveShouldThrowUnsupportedOperationException() {
        exception.expect(UnsupportedOperationException.class);

        PeekIterator<Element> peekIterator = new PeekIterator<>(baseIterator);
        peekIterator.remove();
    }

    @Test
    public void setNullToConstructorShouldThrowIllegalArgumentException() {
        exception.expect(IllegalArgumentException.class);
        new PeekIterator<String>(null);
    }

    @Test
    public void methodPeekShouldThrowNoSuchElementExceptionForEmptyIterator() {
        exception.expect(NoSuchElementException.class);

        PeekIterator<String> peekIterator = new PeekIterator<>(Collections.emptyIterator());
        peekIterator.peek();
    }

    @Test
    public void methodPeekShouldReturnFirstElementWithoutCallMethodNext() {
        PeekIterator<Element> peekIterator = new PeekIterator<>(baseIterator);
        Element expectedElement = Element.FIRST;

        Element actualElement = peekIterator.peek();

        Assert.assertEquals(expectedElement, actualElement);
    }

    @Test
    public void methodPeekShouldReturnCurrentElementOfIterator() {
        PeekIterator<Element> peekIterator = new PeekIterator<>(baseIterator);
        Element expectedElement = Element.SECOND;

        peekIterator.next();
        peekIterator.peek();
        Element actualElement = peekIterator.peek();

        Assert.assertEquals(expectedElement, actualElement);
    }

    @Test
    public void methodPeekShouldSkipNullValues() {
        Iterator<Element> baseIterator = Arrays.asList(Element.FIRST, null, null, Element.SECOND, null)
                                               .iterator();
        PeekIterator<Element> peekIterator = new PeekIterator<>(baseIterator);
        Element expectedElement = Element.SECOND;

        peekIterator.next();
        peekIterator.next();
        Element actualElement = peekIterator.peek();

        Assert.assertEquals(expectedElement, actualElement);
    }

    @Test
    public void methodHasNextShouldNotChangeCurrentElement() {
        PeekIterator<Element> peekIterator = new PeekIterator<>(baseIterator);
        Element expectedElement = Element.FIRST;

        peekIterator.hasNext();
        peekIterator.hasNext();
        Element actualElement = peekIterator.peek();

        Assert.assertEquals(expectedElement, actualElement);
    }

    @Test
    public void methodHasNextShouldReturnFalseForEmptyIterator() {
        PeekIterator<String> peekIterator = new PeekIterator<>(Collections.emptyIterator());

        boolean hasNextElement = peekIterator.hasNext();

        Assert.assertFalse(hasNextElement);
    }

    @Test
    public void methodHasNextShouldReturnTrueForNotLastElement() {
        PeekIterator<Element> peekIterator = new PeekIterator<>(baseIterator);

        peekIterator.next();
        boolean hasNextElement = peekIterator.hasNext();

        Assert.assertTrue(hasNextElement);
    }
}