package com.Tokenizacion.Steps;

import com.Tokenizacion.DTO.TokenDTO;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class GenerateTokenId {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step generateToken(JdbcBatchItemWriter<TokenDTO>){
        return stepBuilderFactory.get("generateToken")
                .<TokenDTO, TokenDTO>chunk(10)
                .reader(TokenIdReader.reader())
                .processor(processor())
                .writer(writer())
                .build();
    }
}
