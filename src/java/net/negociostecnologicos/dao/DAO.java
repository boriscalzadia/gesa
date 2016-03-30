
package net.negociostecnologicos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DAO {
    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
   public void Conectar() throws Exception{
      try {
          Class.forName("com.mysql.jdbc.Driver");
       cn = DriverManager.getConnection("jdbc:mysql://192.168.56.101:3306/sacdb?user=root&password=123456");
    
      }catch(ClassNotFoundException | SQLException e){
          throw e;
      }
    }
    
   public void Cerrar() throws SQLException{
       try {
            if (cn != null){
           if (cn.isClosed() == false){
               cn.close();
           }
       }
       }catch (Exception e){
           throw e;
        }
   }
       
      
 }

