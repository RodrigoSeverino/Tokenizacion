package com.Tokenizacion.Steps;

import com.Tokenizacion.DTO.CardDTO;
import com.Tokenizacion.Mappers.TokenFileRowMapper;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.core.io.ClassPathResource;

public class TokenIdReader {

    public static FlatFileItemReader<CardDTO> reader(){
        FlatFileItemReader<CardDTO> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("CDL_LoteTenisClub_2510_ConCDL_v1.txt"));
        reader.setLineMapper(new DefaultLineMapper<CardDTO>(){{
            setLineTokenizer(new FixedLengthTokenizer() {{
                setNames("nroTarjeta", "FechaVencimiento");
                setColumns(new Range[]{new Range(2,17), new Range(100,106)});
            }});
            setFieldSetMapper((FieldSetMapper<CardDTO>) new TokenFileRowMapper());
        }});
        return reader;
    }
}
