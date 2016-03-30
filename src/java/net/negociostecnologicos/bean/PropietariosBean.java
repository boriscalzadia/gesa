/*
 Bean que sirve para el patron de FACADE entre la logica del negocio y la  base
 */
package net.negociostecnologicos.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import net.negociostecnologicos.dao.PropietariosDAO;
import net.negociostecnologicos.model.Propietarios;

@ManagedBean
@RequestScoped
public class PropietariosBean {
    
    private Propietarios propietario = new Propietarios(); //propietario para obtener los valores de la clase Propietarios

    public Propietarios getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietarios propietario) {
        this.propietario = propietario;
    }
    
    public void registrar() throws Exception{ //va invocar los metodos de acceso DAO para poder hacer la insercion en la bd
        PropietariosDAO dao;//Instanciamos la clase DAO
        
        try {
            dao = new PropietariosDAO();
            dao.registrar(propietario);
            
            FacesMessage message =new FacesMessage("Exito, registro ingresado");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
        }catch(Exception e){
            throw e;
        }
        
    }
    
}
