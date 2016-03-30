/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.negociostecnologicos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import net.negociostecnologicos.model.PropUnidades;

import net.negociostecnologicos.model.Recibos;


public class PropUnidadesDAO extends DAO{

    public List<PropUnidades> consultar(PropUnidades ser1)throws Exception{  //le agregamos un objeto
         List <PropUnidades> consulta;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT  apto, titulo, nombres, apellidos, telefono, email, codigo  from consulta_propietarios where apto=? ");
            st.setString(1, ser1.getApto());
            
       
          
            
            rs = st.executeQuery();
            consulta = new ArrayList(); // lista declara antes que guardas en un arreglo los datos
            //tengo que recorrer los datos del resulset
            while (rs.next()){
                //Objeto de tipo Servicios 
                PropUnidades ser = new PropUnidades();
                ser.setApto(rs.getString("apto"));
                ser.setTitulo(rs.getString("titulo"));
                ser.setNombres(rs.getString("nombres"));
                ser.setApellidos(rs.getString ("apellidos"));
                ser.setTelefono(rs.getString("telefono"));
                ser.setEmail(rs.getString("email"));
                
                
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
    
    public List<Recibos> consultar(Recibos ser2)throws Exception{  //le agregamos un objeto
         List <Recibos> consulta;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT  codigoUnidad, recibo, fechaPago, monto, referencia  from consulta_recibos  ");
               //  st.setInt(1, ser2.getCodigoUnidad());
                 //st.setString(1, ser1.getApto());
                  
          
            
            rs = st.executeQuery();
            consulta = new ArrayList(); // lista declara antes que guardas en un arreglo los datos
            //tengo que recorrer los datos del resulset
            while (rs.next()){
                //Objeto de tipo Servicios 
                Recibos ser = new Recibos();
                ser.setCodigoUnidad(rs.getInt("codigoUnidad"));
                ser.setRecibo(rs.getString("recibo"));
                ser.setFechaPago(rs.getDate("fechaPago"));
                ser.setMonto(rs.getDouble("monto"));
                ser.setReferencia(rs.getString("referencia"));
                
                
                
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
    public PropUnidades leerCodigo(PropUnidades ser) throws Exception{
        //Creamos una varible de tipo Servicio
        PropUnidades sers;
        ResultSet rs; //necesitamos que se regrese

        try {
               this.Conectar(); 
                PreparedStatement st = this.getCn().prepareStatement("SELECT  apto, titulo, nombres, apellidos, telefono, email, codigo  from consulta_propietarios WHERE apto=?");
                 st.setString(1, ser.getApto());
                 rs = st.executeQuery();
                 while (rs.next()){
                    sers= new PropUnidades();
                    
                    sers.setApto(rs.getString("apto"));
                    sers.setTitulo(rs.getString("titulo"));
                    sers.setNombres(rs.getString("nombres"));
                    sers.setApellidos(rs.getString ("apellidos"));
                    sers.setTelefono(rs.getString("telefono"));
                    sers.setEmail(rs.getString("email"));
                    sers.setCodigo(rs.getInt("codigo"));
                     
                 }
                 
           }catch(Exception e){
              throw e; 
           }
           finally{
                  this.Cerrar();
           }
        return ser;
        
    }
}
