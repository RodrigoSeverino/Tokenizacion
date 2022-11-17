package com.Tokenizacion.DTO;

public class CardDTO {
    private String nroTarjeta;
    private String fechaVencimiento;

    public String getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "TarjetaDTO{" +
                "nroTarjeta='" + nroTarjeta + '\'' +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                '}';
    }
}
