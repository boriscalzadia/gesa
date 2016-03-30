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
import net.negociostecnologicos.model.Recibos;

public class RecibosDAO extends DAO{
    
    public List<Recibos> consultar(Recibos ser1)throws Exception{  //le agregamos un objeto
         List <Recibos> consulta;
        ResultSet rs;
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT  codigoUnidad, recibo, fechaPago, monto, referencia  from consulta_recibos where codigoUnidad=? ");
                 st.setInt(1, ser1.getCodigoUnidad());
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
    
}
