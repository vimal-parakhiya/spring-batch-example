package com.thoughtworks.config;

import com.thoughtworks.IntegerItemWriter;
import com.thoughtworks.IntegerItemProcessor;
import com.thoughtworks.IntegerItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by vimalpar on 08/04/17.
 */
@Configuration
public class JobConfiguration {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job sampleJob(Step step) {
        return jobBuilderFactory.get("sample-batch")
                .incrementer(new RunIdIncrementer())
                .flow(step)
                .end()
                .build();
    }

    @Bean
    public Step step() {
        return stepBuilderFactory.get("step1")
                .<Integer, Integer>chunk(25)
                .reader(new IntegerItemReader())
                .processor(new IntegerItemProcessor())
                .writer(new IntegerItemWriter())
                .build();
    }
}
