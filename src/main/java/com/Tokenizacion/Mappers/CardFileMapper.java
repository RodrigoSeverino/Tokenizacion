package com.Tokenizacion.Mappers;

import com.Tokenizacion.DTO.CardDTO;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CardFileMapper implements FieldSetMapper<CardDTO> {
    CardDTO cardDTO = new CardDTO();

    @Override
    public CardDTO mapFieldSet(FieldSet fieldSet) {
        cardDTO.setCardNumber(fieldSet.readString("cardNumber"));
        cardDTO.setExpiredDate(fieldSet.readString("expiredDate"));

        return cardDTO;
    }
}