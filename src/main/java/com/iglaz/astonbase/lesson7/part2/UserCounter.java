package com.iglaz.astonbase.lesson7.part2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 9 -> ++
 * 9 -> 10 -> ++
 */
public class UserCounter {
    private AtomicInteger counter = new AtomicInteger();

    void increment() {
        counter.incrementAndGet();
    }

    public AtomicInteger getUserCounter() {
        return counter;
    }
}
