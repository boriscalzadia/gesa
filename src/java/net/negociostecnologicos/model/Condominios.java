
package net.negociostecnologicos.model;


public class Condominios {

    private int codigo;
    private String condominio;
    private String municipio;
    private String departamento;
    private String direccion;
    private String telefono;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCondominio() {
        return condominio;
    }

    public void setCondominio(String condominio) {
        this.condominio = condominio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //Private double variable == es para precios 
    //Private date fecha 
    /*Cuando se tiene una llave foranea se declara tipo objeto 
    Private Persona persona(esta es la variable);
    */
}
