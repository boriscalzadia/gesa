package net.negociostecnologicos.bean;



import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import net.negociostecnologicos.dao.XPropetariosUnidadesDAO;
import net.negociostecnologicos.model.XPropietariosUnidades;

@ManagedBean
//@RequestScoped
@ViewScoped
public class XPropietariosUnidadesBean {

    private  XPropietariosUnidades propietariosUnidades = new XPropietariosUnidades();

    public XPropietariosUnidades getPropietariosUnidades() {
        return propietariosUnidades;
    }

    public void setPropietariosUnidades(XPropietariosUnidades propietariosUnidades) {
        this.propietariosUnidades = propietariosUnidades;
    }

    public List<XPropietariosUnidades> getLstPropietariosUnidades() {
        return lstPropietariosUnidades;
    }

    public void setLstPropietariosUnidades(List<XPropietariosUnidades> lstPropietariosUnidades) {
        this.lstPropietariosUnidades = lstPropietariosUnidades;
    }
    //Declaramos una variable de tipo lista tambien definimos los gets y set
    private List<XPropietariosUnidades> lstPropietariosUnidades;
    
    public void consultar() throws Exception{ //va invocar los metodos de acceso DAO para poder hacer la insercion en la bd
        XPropetariosUnidadesDAO dao;//Instanciamos la clase DAO
        
        try {
            dao = new XPropetariosUnidadesDAO();
            //consulto la lista 
            lstPropietariosUnidades=dao.consultar(propietariosUnidades);
            FacesMessage message =new FacesMessage("Exito, registro consultado");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
        }catch(Exception e){
            throw e;
        }
    }
    

    
    
    
    
}
