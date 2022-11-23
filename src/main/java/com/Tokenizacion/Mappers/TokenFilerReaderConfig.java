package com.Tokenizacion.Mappers;

import com.Tokenizacion.DTO.CardDTO;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

    @Configuration
    @AllArgsConstructor
    public class TokenFilerReaderConfig  {

        public static final String filename = "CDL_LoteTenisClub_2510_ConCDL_v1.txt";

        private final LineTokenizer lineTokenizer;
        private final CardFileMapper cardFileMapper;

        @Bean
        public ItemStreamReader<CardDTO> cardReader(){
            final var lineMapper = createLineMapper(lineTokenizer);
            return createReader(lineMapper);
        }

        public LineMapper<CardDTO> createLineMapper(LineTokenizer lineTokenizer) {
            final var mapper = new DefaultLineMapper<CardDTO>();
            mapper.setLineTokenizer(lineTokenizer);
            mapper.setFieldSetMapper(cardFileMapper);
            return mapper;
        }

        public ItemStreamReader<CardDTO> createReader(LineMapper<CardDTO> lineMapper) {
            FlatFileItemReader<CardDTO> reader = new FlatFileItemReader<>();
            reader.setResource(new ClassPathResource(TokenFilerReaderConfig.filename));
            reader.setLineMapper(lineMapper);
            return reader;
        }
    }
