
package net.negociostecnologicos.bean;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import net.negociostecnologicos.dao.ServiciosDAO;
import net.negociostecnologicos.model.Servicios;

@ManagedBean
//@RequestScoped
@ViewScoped 
public class ServiciosBean {
    
    private Servicios servicios = new Servicios();
    //Declaramos una variable de tipo lista tambien definimos los gets y set
    private List<Servicios> lstServicios;
 
     
    
    
    
    public List<Servicios> getLstServicios() {
        return lstServicios;
    }

    public void setLstServicios(List<Servicios> lstServicios) {
        this.lstServicios = lstServicios;
    }
    

    public Servicios getServicios() {
        return servicios;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }
    
    public void registrar() throws Exception{ 
        //va invocar los metodos de acceso DAO para poder hacer la insercion en la bd
        ServiciosDAO dao;//Instanciamos la clase DAO
        
        try {
            dao = new ServiciosDAO();
            dao.registrar(servicios);
            
            FacesMessage message =new FacesMessage("Exito, registro ingresado");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
        }catch(Exception e){
            throw e;
        }
    }
    //FACADE PARA LLAMAR AL METODO DE CONSULTAS
     public void consultar() throws Exception{ //va invocar los metodos de acceso DAO para poder hacer la insercion en la bd
        ServiciosDAO dao;//Instanciamos la clase DAO
        
        try {
            dao = new ServiciosDAO();
            //consulto la lista 
            lstServicios=dao.consultar();
            FacesMessage message =new FacesMessage("Exito, registro CONSULTADO");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
        }catch(Exception e){
            throw e;
        }
    }
     //METODO PARA INVOCAR A LO QUE DEFINIMOS EN E EL dao del id
     //al dar clic en modificar el objeto de la fila sera enviada a este metodo
     public void LeerCodigo(Servicios ser) throws Exception{
          ServiciosDAO dao;
          Servicios temp; //variable temporal
          try {
              dao = new ServiciosDAO();
              temp= dao.leerCodigo(ser);
              if (temp != null){
                  this.servicios=temp; //para si el envio fue correco tenga los datos correctos
              }
          }catch(Exception e){
              throw e;
          }
     }
    
public void modificar() throws Exception{ 
        //va invocar los metodos de acceso DAO para poder hacer la insercion en la bd
        ServiciosDAO dao;//Instanciamos la clase DAO
        
        try {
            dao = new ServiciosDAO();
            dao.modificar(servicios);
            //ACTUALIZAMOS LA PAGINA 
            this.consultar();
            
            FacesMessage message =new FacesMessage("Exito, registro ingresado");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
        }catch(Exception e){
            throw e;
        }
    }

public void eliminar(Servicios ser) throws Exception{ 
        //va invocar los metodos de acceso DAO para poder hacer la insercion en la bd
        ServiciosDAO dao;//Instanciamos la clase DAO
        
        try {
            dao = new ServiciosDAO();
            dao.eliminar(ser);
            //ACTUALIZAMOS LA PAGINA 
            this.consultar();
            
            FacesMessage message =new FacesMessage("Exito, registro Eliminado");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
        }catch(Exception e){
            throw e;
        }
    }



}
    
