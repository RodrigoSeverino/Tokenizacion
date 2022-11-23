package com.Tokenizacion.Steps;
import javax.sql.DataSource;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.Tokenizacion.DTO.CardDTO;
import com.Tokenizacion.DTO.TokenDTO;
@Configuration
@EnableBatchProcessing
public class GenerateTokenId {
    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    @Bean
    public TokenProcessor processor() {
        return new TokenProcessor();
    }
    @Bean
    public Step generateToken(JdbcBatchItemWriter<TokenDTO> writer) throws Exception {
        return stepBuilderFactory.get("generateToken")
                .<CardDTO, TokenDTO>chunk(10)
                .reader(TokenIdReader.reader())
                .processor(processor())
                .writer(TokenWriter.writer((DataSource) writer))
                .build();
    }
}