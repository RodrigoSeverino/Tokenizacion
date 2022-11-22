package com.Tokenizacion.Steps;

import com.Tokenizacion.DTO.CardDTO;
import com.Tokenizacion.DTO.TokenDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class TokenProcessor implements ItemProcessor<CardDTO, TokenDTO> {

    private static final Logger log = LoggerFactory.getLogger(TokenProcessor.class);
    public TokenDTO process(CardDTO cardDTO) throws Exception {
        //Crear objeto TokenDTO
        TokenDTO tokenDTO = new TokenDTO();

        log.info("!--! Llamando Api Tokenizacion !--!");
        //Armar TokenDTO - status activo
        tokenDTO.setTokenId("312hdhqwueh21e7hsaduihe21uiqw");
        tokenDTO.setStatus("Activo");
        tokenDTO.setFechaCreacion(LocalDate.now());
        //retornar tokendto
		return tokenDTO;
    }
}
