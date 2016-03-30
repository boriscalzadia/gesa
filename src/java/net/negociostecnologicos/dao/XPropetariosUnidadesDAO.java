
package net.negociostecnologicos.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import net.negociostecnologicos.model.XPropietariosUnidades;


public class XPropetariosUnidadesDAO extends DAO{

    public List<XPropietariosUnidades> consultar(XPropietariosUnidades ser1) throws Exception{
        List <XPropietariosUnidades> consulta;
        ResultSet rs;
        
        try{
            
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT  apto, titulo, nombres, apellidos, telefono, codigo  from consulta_propietarios where apto=?");
            st.setString(1, ser1.getApto());
            st.setString(2, ser1.getTitulo());
            st.setString(3, ser1.getNombres());
            st.setString(4, ser1.getApellidos());
            st.setString(5, ser1.getTelefono());
            st.setInt(6, ser1.getCodigo());
            
            rs = st.executeQuery();
            consulta = new ArrayList(); // lista declara antes que guardas en un arreglo los datos
            //tengo que recorrer los datos del resulset
            while (rs.next()){
                //Objeto de tipo Servicios 
                XPropietariosUnidades ser = new XPropietariosUnidades();
                
                ser.setApto(rs.getString("apto"));
                ser.setTitulo(rs.getString("titulo"));
                ser.setApellidos(rs.getString("apellidos"));
                ser.setNombres(rs.getString("nombres"));
                ser.setTelefono(rs.getString("telefono"));
                ser.setCodigo(rs.getInt("codigo"));
                
                
                
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
