package com.Tokenizacion.Steps;

import com.Tokenizacion.DTO.TokenDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemReader;

public class TokenProcessor implements ItemProcessor<FlatFileItemReader<TokenDTO>, TokenDTO> {

    private static final Logger log = LoggerFactory.getLogger(TokenProcessor.class);

    @Override
    public TokenDTO process(FlatFileItemReader<TokenDTO> tokenDTOFlatFileItemReader) throws Exception {

    }
}
