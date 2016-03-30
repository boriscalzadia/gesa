package net.negociostecnologicos.model;


public class Unidades {
    private int codigo;
    private String descripcion;
    private int nivel;
    private Propietarios propietario;
    private Condominios condominio;
    private String apto;

    public String getApto() {
        return apto;
    }

    public void setApto(String apto) {
        this.apto = apto;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Propietarios getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietarios propietario) {
        this.propietario = propietario;
    }

    public Condominios getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominios condominio) {
        this.condominio = condominio;
    }
    
}
