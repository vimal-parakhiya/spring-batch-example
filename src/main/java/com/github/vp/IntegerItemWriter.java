package com.github.vp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by vimalpar on 08/04/17.
 */
public class IntegerItemWriter implements ItemWriter<Integer> {
    private final static Logger LOG = LoggerFactory.getLogger(IntegerItemWriter.class);

    public void write(List<? extends Integer> items) {
        LOG.info("Processed Integers: {}", items);
    }
}
