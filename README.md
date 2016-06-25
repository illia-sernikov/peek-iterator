Implementation of Peek Iterator
===============================

Requirements:
-------------

1. PeekIterator class should be an implementation of **Iterator** interface.
2. The instance of PeekIterator can be initialized with **Iterator**.
3. Method _**remove**_ should throw UnsupportedOperationException.
4. PeekIterator class should have method _**peek**_.
5. Method _**peek**_ should return current element of Iterator without offset.
6. In case of method _**next**_ wasn't called, method _**peek**_ should return the first element of **Iterator**.
7. In case of the **Iterator** is empty, method _**peek**_ should throw NoSuchElementException.
8. In case of Iterator has **null**-elements, method _**peek**_ should return next element of **Iterator**.