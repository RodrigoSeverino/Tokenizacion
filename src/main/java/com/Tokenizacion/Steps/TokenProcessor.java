package com.Tokenizacion.Steps;
import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import com.Tokenizacion.DTO.CardDTO;
import com.Tokenizacion.DTO.TokenDTO;
import com.Tokenizacion.Exceptions.CardNotFoundException;
import com.Tokenizacion.Exceptions.InvalidCardException;
public class TokenProcessor implements ItemProcessor<CardDTO, TokenDTO> {
    private static final int CARD_LENGHT = 16;
    private static final Logger log = LoggerFactory.getLogger(TokenProcessor.class);
    public TokenDTO process(CardDTO cardDTO) throws Exception {
        if (cardDTO.getCardNumber() == null)
            throw new CardNotFoundException("Tarjeta de credito no encontrada");
        if(cardDTO.getCardNumber().length() != CARD_LENGHT)
            throw new InvalidCardException("Tarjeta de crédito inválida");
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