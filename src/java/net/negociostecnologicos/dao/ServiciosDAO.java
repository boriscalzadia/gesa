
package net.negociostecnologicos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import net.negociostecnologicos.model.Servicios;

public class ServiciosDAO  extends DAO{
    
    //INGRESA SERVICIOS
    public void registrar(Servicios ser) throws Exception{ 
    
           try {
               this.Conectar(); 
                PreparedStatement st = this.getCn().prepareStatement("INSERT INTO cuentas (nombre, descripcion) VALUES (?,?)");
                 st.setString(1, ser.getServicio());
                 st.setString(2, ser.getDescripcion());
                 st.executeUpdate();
                 
           }catch(Exception e){
              throw e; 
           }
           finally{
                  this.Cerrar();
           }
       
    }
    
//CONSULTA SERVICIOS
    public List<Servicios> consultar() throws Exception{
        List <Servicios> consulta;
        ResultSet rs;
        
        try{
            
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT codigo, nombre, descripcion, fijo  from cuentas where codigoCondominio=1");
            rs = st.executeQuery();
            consulta = new ArrayList(); // lista declara antes que guardas en un arreglo los datos
            //tengo que recorrer los datos del resulset
            while (rs.next()){
                //Objeto de tipo Servicios 
                Servicios ser = new Servicios();
                ser.setCodigo(rs.getInt("codigo"));
                ser.setServicio(rs.getString("nombre"));
                ser.setDescripcion(rs.getString("descripcion"));
                ser.setFijo(rs.getString("fijo"));
                
                
                //Los objetos se agregan al arreglo consulta
                consulta.add(ser); 
            }
            
            
        }catch (Exception e){
            throw e;
        }finally{
            this.Cerrar();
        }
        return consulta;
    }
    //Vamos a obtener el ID del datatable 
    public Servicios leerCodigo(Servicios ser) throws Exception{
        //Creamos una varible de tipo Servicio
        Servicios sers;
        ResultSet rs; //necesitamos que se regrese

        try {
               this.Conectar(); 
                PreparedStatement st = this.getCn().prepareStatement("SELECT codigo, nombre, descripcion, fijo FROM cuentas WHERE codigo=?");
                 st.setInt(1, ser.getCodigo());
                 rs = st.executeQuery();
                 while (rs.next()){
                     sers= new Servicios();
                     sers.setCodigo(rs.getInt("codigo"));
                     sers.setServicio(rs.getString("nombre"));
                     sers.setDescripcion(rs.getString("descripcion"));
                     sers.setFijo(rs.getString("fijo"));
                     
                 }
                 
           }catch(Exception e){
              throw e; 
           }
           finally{
                  this.Cerrar();
           }
        return ser;
        
    }
    
 //MODIFICAR CUENTAS O SERVICIOS
    public void modificar(Servicios ser) throws Exception{ 
    
           try {
               this.Conectar(); 
                PreparedStatement st = this.getCn().prepareStatement("UPDATE cuentas SET nombre=? , descripcion=? WHERE codigo=? ");
                 st.setString(1, ser.getServicio());
                 st.setString(2, ser.getDescripcion());
                 st.setInt(3, ser.getCodigo());
                 st.executeUpdate();
                 
           }catch(Exception e){
              throw e; 
           }
           finally{
                  this.Cerrar();
           }
       
    }
    
    public void eliminar(Servicios ser) throws Exception{ 
    
           try {
               this.Conectar(); 
                PreparedStatement st = this.getCn().prepareStatement("DELETE FROM cuentas WHERE codigo=? ");
                 st.setInt(1, ser.getCodigo());
                 st.executeUpdate();
                 
           }catch(Exception e){
              throw e; 
           }
           finally{
                  this.Cerrar();
           }
       
    }
    
}
