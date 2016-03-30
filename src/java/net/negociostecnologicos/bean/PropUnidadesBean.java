/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.negociostecnologicos.bean;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import net.negociostecnologicos.dao.PropUnidadesDAO;
import net.negociostecnologicos.model.PropUnidades;

import net.negociostecnologicos.dao.RecibosDAO;
import net.negociostecnologicos.model.Recibos;

@ManagedBean
//@RequestScoped
@ViewScoped
public class PropUnidadesBean {

    public PropUnidades getPropUnidades() {
        return propUnidades;
    }

    public void setPropUnidades(PropUnidades propUnidades) {
        this.propUnidades = propUnidades;
    }

    public List<PropUnidades> getLstProUnidades() {
        return lstProUnidades;
    }

    public void setLstProUnidades(List<PropUnidades> lstProUnidades) {
        this.lstProUnidades = lstProUnidades;
    }
   
    
    private PropUnidades propUnidades = new PropUnidades();
    private List<PropUnidades>  lstProUnidades;

    public Recibos getRecibos() {
        return recibos;
    }

    public void setRecibos(Recibos recibos) {
        this.recibos = recibos;
    }

    public List<Recibos> getLstRecibos() {
        return lstRecibos;
    }

    public void setLstRecibos(List<Recibos> lstRecibos) {
        this.lstRecibos = lstRecibos;
    }

    private Recibos recibos = new Recibos();
    private List<Recibos> lstRecibos;
 
    //FACADE PARA LLAMAR AL METODO DE CONSULTAS
     public void consultar() throws Exception{ //va invocar los metodos de acceso DAO para poder hacer la insercion en la bd
        PropUnidadesDAO dao;//Instanciamos la clase DAO
        RecibosDAO daor;
        
        try {
            dao = new PropUnidadesDAO();
            daor = new RecibosDAO();
            //consulto la lista 
            lstProUnidades=dao.consultar(propUnidades);     //enviamos el objeto
            lstRecibos=daor.consultar(recibos);
            FacesMessage message =new FacesMessage("Exito, registro CONSULTADO");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
        }catch(Exception e){
            throw e;
        }
    }
    
     public void LeerCodigo(PropUnidades ser) throws Exception{
          PropUnidadesDAO dao;
          PropUnidades temp; //variable temporal
          try {
              dao = new PropUnidadesDAO();
              temp= dao.leerCodigo(ser);
              if (temp != null){
                  this.propUnidades=temp; //para si el envio fue correco tenga los datos correctos
              }
          }catch(Exception e){
              throw e;
          }
     }
    
    
}
