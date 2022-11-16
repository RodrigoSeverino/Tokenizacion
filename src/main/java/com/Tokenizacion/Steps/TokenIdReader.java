package com.Tokenizacion.Steps;

import com.Tokenizacion.DTO.TokenDTO;
import com.Tokenizacion.Mappers.TokenFileRowMapper;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.core.io.ClassPathResource;

public class TokenIdReader {

    public static FlatFileItemReader<TokenDTO> reader(){
        FlatFileItemReader<TokenDTO> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("CDL_LoteTenisClub_2510_ConCDL_v1.txt"));
        reader.setLineMapper(new DefaultLineMapper<TokenDTO>(){{
            setLineTokenizer(new FixedLengthTokenizer() {{
                setNames("nroTarjeta", "FechaVencimiento");
                setColumns(new Range[]{new Range(2,17), new Range(82,88)});
            }});
            setFieldSetMapper((FieldSetMapper<TokenDTO>) new TokenFileRowMapper());
        }});
        return reader;
    }
}
