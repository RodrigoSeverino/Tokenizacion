package com.Tokenizacion.Mappers;

import com.Tokenizacion.DTO.TokenDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TokenFileRowMapper implements RowMapper<TokenDTO>{
    TokenDTO tokenDTO = new TokenDTO();

    public TokenDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        tokenDTO.setTokenId(rs.getString("tokenId"));
        tokenDTO.setStatus(rs.getString("status"));
        tokenDTO.setFechaCreacion(rs.getDate("created_date").toLocalDate());

        return tokenDTO;
    }
}
