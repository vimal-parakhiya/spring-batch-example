package com.github.vp.config;

import com.github.vp.IntegerItemReader;
import com.github.vp.IntegerItemWriter;
import com.github.vp.IntegerItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by vimalpar on 08/04/17.
 */
@Configuration
public class JobConfiguration {
    @Bean
    public Job sampleJob(JobBuilderFactory jobBuilderFactory, Step step) {
        return jobBuilderFactory.get("sample-batch")
                .incrementer(new RunIdIncrementer())
                .flow(step)
                .end()
                .build();
    }

    @Bean
    public Step step(StepBuilderFactory stepBuilderFactory,
                     IntegerItemReader reader,
                     IntegerItemProcessor processor,
                     IntegerItemWriter writer) {
        return stepBuilderFactory.get("step1")
                .<Integer, Integer>chunk(25)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public IntegerItemReader reader() {
        return new IntegerItemReader(100);
    }

    @Bean
    public IntegerItemProcessor processor() {
        return new IntegerItemProcessor();
    }

    @Bean
    public IntegerItemWriter writer() {
        return new IntegerItemWriter();
    }
}
