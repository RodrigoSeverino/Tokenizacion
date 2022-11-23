package com.Tokenizacion.Steps;

import com.Tokenizacion.Listener.JobCompleteListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.Tokenizacion.DTO.CardDTO;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class GenerateTokenId {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;


    @Bean
    public TokenProcessor processor() {
        return new TokenProcessor();
    }


    @Bean
    public ItemStreamReader<CardDTO> reader(LineMapper<CardDTO> lineMapper){
        FlatFileItemReader<CardDTO> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("CDL_LoteTenisClub_2510_ConCDL_v1.txt"));
        reader.setLineMapper(lineMapper);
        return reader;
    }

    @Bean
    public Job tokenizacionMasiva(JobCompleteListener listener, Step step1) {
        return jobBuilderFactory.get("tokenizacionMasiva")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }
}