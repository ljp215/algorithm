package com.zane.algorithm.leetcode;

import java.util.Iterator;

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a
 * PeekingIterator that support the peek() operation -- it essentially peek() at the element that
 * will be returned by the next call to next().
 * <p/>
 * Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
 * <p/>
 * Call next() gets you 1, the first element in the list.
 * <p/>
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * <p/>
 * You call next() the final time and it returns 3, the last element. Calling hasNext() after that
 * should return false.
 * <p/>
 * Show Hint
 * <p/>
 * <p/>
 * Author: luojinping
 * Date: 16/3/27
 * Time: 10:44
 */
public class PeekingIterator_284 implements Iterator<Integer> {
    Integer cache = null;
    Iterator<Integer> it;

    public PeekingIterator_284(Iterator<Integer> iterator) {
        // initialize any member here.
        this.it = iterator;
        cache = it.next();
    }

    // Returns the next element in the iteration without advancing the iterator.

    public Integer peek() {
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int ret = cache;
        if (it.hasNext()) {
            cache = it.next();
        } else {
            cache = null;
        }
        return ret;
    }

    @Override
    public boolean hasNext() {
        return (cache != null);
    }
}
