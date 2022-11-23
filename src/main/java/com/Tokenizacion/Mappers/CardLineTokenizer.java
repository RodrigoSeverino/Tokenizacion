package com.Tokenizacion.Mappers;


import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CardLineTokenizer {

    @Bean
    public FixedLengthTokenizer createLineTokenizer() {
        final var lineTokenizer = new FixedLengthTokenizer();
        lineTokenizer.setNames("nroTarjeta", "FechaVencimiento");
        lineTokenizer.setColumns(new Range[]{new Range(1, 16), new Range(17, 23)});
        lineTokenizer.setStrict(false);
        return lineTokenizer;
    }
}

