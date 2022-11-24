package com.Tokenizacion.DTO;

import java.time.LocalDate;

public class TokenDTO {

    private String tokenId;
    private String status;
    private LocalDate fechaCreacion;

    public TokenDTO() {}

    public TokenDTO(String tokenId, String status, LocalDate fechaCreacion) {
        this.tokenId = tokenId;
        this.status = status;
        this.fechaCreacion = fechaCreacion;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "TokenDTO{" +
                "tokenId='" + tokenId + '\'' +
                ", status='" + status + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}