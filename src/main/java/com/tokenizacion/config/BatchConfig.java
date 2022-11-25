/*
package com.tokenizacion.config;

import com.tokenizacion.listener.JobCompleteListener;
import com.tokenizacion.steps.TokenProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    @Bean
    public TokenProcessor processor() {
        return new TokenProcessor();
    }


    @Bean
    public Job tokenizacionMasiva(
            JobCompleteListener listener, Step step1) {
        return jobBuilderFactory.get("tokenizacionMasiva")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }
}
*/
