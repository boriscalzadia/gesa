
package net.negociostecnologicos.dao;

import java.sql.PreparedStatement;
import net.negociostecnologicos.model.Propietarios;


public class PropietariosDAO  extends DAO { //El extende solo sirve para heradar la clase de la conexion
   
    public void registrar (Propietarios pro) throws Exception{
        try{
            this.Conectar(); //con este me conecto
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO propietarios (nombres, apellidos, titulo, telefono, email) values (?,?,?,?,?)");
            st.setString(1, pro.getNombre());
            st.setString(2, pro.getApellidos());
            st.setString(3, pro.getTitulo());
            st.setString(4, pro.getTelefono());
            st.setString(5, pro.getEmail());
            st.executeUpdate();
        }catch(Exception e){
            throw e;
            
        }finally {
            this.Cerrar();
        }
        
    }
    
}
