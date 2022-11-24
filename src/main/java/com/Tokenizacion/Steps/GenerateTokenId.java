package com.Tokenizacion.Steps;
import javax.sql.DataSource;

import com.Tokenizacion.Listener.JobCompleteListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.Tokenizacion.DTO.CardDTO;
import com.Tokenizacion.DTO.TokenDTO;
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
    public static FlatFileItemReader<CardDTO> reader(){
        FlatFileItemReader<CardDTO> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("Cards.txt"));
        reader.setLineMapper(new DefaultLineMapper<>() {{
            setLineTokenizer(new FixedLengthTokenizer() {{
                setNames("nroTarjeta", "FechaVencimiento");
                setColumns(new Range[]{new Range(1, 16), new Range(17, 22)});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<CardDTO>() {{setTargetType(CardDTO.class);}}
            );
        }});
        reader.setLinesToSkip(1);
        reader.setMaxItemCount(18);
        return reader;
    }

    @Bean
    public JdbcBatchItemWriter<TokenDTO> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<TokenDTO>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO DA_Tokens (tokenId, status, created_date) VALUES (:tokenId, :status, :fechaCreacion)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<TokenDTO> writer){
        return stepBuilderFactory.get("step1")
                .<CardDTO, TokenDTO>chunk(10)
                .reader(reader())
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