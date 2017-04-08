package com.github.vp;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by vimalpar on 08/04/17.
 */
public class IntegerItemReader implements ItemReader<Integer> {
    private AtomicInteger count = new AtomicInteger(0);
    private int maxCount;

    public IntegerItemReader(int maxCount) {
        this.maxCount = maxCount;
    }

    public Integer read() {
        if(count.get() < maxCount) {
            return count.getAndIncrement();
        }
        return null;
    }
}
