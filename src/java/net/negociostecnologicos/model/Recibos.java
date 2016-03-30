
package net.negociostecnologicos.model;

import java.sql.Date;


public class Recibos {

    public int getCodigoUnidad() {
        return codigoUnidad;
    }

    public void setCodigoUnidad(int codigoUnidad) {
        this.codigoUnidad = codigoUnidad;
    }

    public String getRecibo() {
        return recibo;
    }

    public void setRecibo(String recibo) {
        this.recibo = recibo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    private int codigoUnidad;
    private String recibo;
    private double monto;
    private String referencia;
    private Date fechaPago;
    
    
    
}
