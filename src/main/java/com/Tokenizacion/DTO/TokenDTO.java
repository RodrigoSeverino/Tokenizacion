package com.Tokenizacion.DTO;

import java.util.Date;

public class TokenDTO {

    private String tokenId;
    private String status;
    private Date fechaCreacion;

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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
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
