package com.Tokenizacion.Steps;

import com.Tokenizacion.DTO.CardDTO;
import com.Tokenizacion.DTO.TokenDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class TokenProcessor implements ItemProcessor<CardDTO, TokenDTO> {

    private static final Logger log = LoggerFactory.getLogger(TokenProcessor.class);

    @Override
    public TokenDTO process(CardDTO tarjetaDTO) throws Exception {
        //Crear objeto TokenDTO
        //Simular llamada a la api tokenizacion
        //Armar TokenDTO - status activo
        //retornar tokendto
    }
}
