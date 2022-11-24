package com.Tokenizacion.Steps;

import com.Tokenizacion.DTO.TokenDTO;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;

import javax.sql.DataSource;


public class TokenWriter {

    public static JdbcBatchItemWriter<TokenDTO> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<TokenDTO>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO DA_Tokens (tokenId, status, created_date) VALUES (:tokenId, :status, :fechaCreacion)")
                .dataSource(dataSource)
                .build();
    }
}
