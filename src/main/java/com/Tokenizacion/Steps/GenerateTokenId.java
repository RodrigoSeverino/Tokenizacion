package com.Tokenizacion.Steps;

import ch.qos.logback.core.subst.Token;
import com.Tokenizacion.DTO.TokenDTO;
import com.Tokenizacion.Listener.JobCompleteListener;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.Tokenizacion.DTO.CardDTO;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@AllArgsConstructor
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

    private final ItemStreamReader<CardDTO> cardDTOItemStreamReader;

    @Bean
    public FlatFileItemReader<CardDTO> reader(LineMapper<CardDTO> lineMapper){
        FlatFileItemReader<CardDTO> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("CDL_LoteTenisClub_2510_ConCDL_v1.txt"));
        reader.setLineMapper(lineMapper);
        return reader;
    }

    @Bean
    public JdbcBatchItemWriter<TokenDTO> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<TokenDTO>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO DA_Tokens (tokenId, status, fechaCreacion) VALUES (:tokenId, :status, :fechaCreacion)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<TokenDTO> writer){
        return stepBuilderFactory.get("step1")
                .<CardDTO, TokenDTO>chunk(10)
                .reader(reader((LineMapper<CardDTO>) cardDTOItemStreamReader))
                .processor(processor())
                .writer(writer)
                .build();
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