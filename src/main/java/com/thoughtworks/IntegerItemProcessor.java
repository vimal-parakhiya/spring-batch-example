package com.thoughtworks;

import org.springframework.batch.item.ItemProcessor;

/**
 * Created by vimalpar on 08/04/17.
 */
public class IntegerItemProcessor implements ItemProcessor<Integer,Integer> {
    public Integer process(Integer item) {
        return item + 1;
    }
}
