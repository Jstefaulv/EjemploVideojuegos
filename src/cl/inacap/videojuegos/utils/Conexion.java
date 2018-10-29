
package cl.inacap.videojuegos.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private final String USER="root";
    private final String DATABASE="videojuegos";
    private final String PASSWORD="";
    private final String SERVIDOR="localhost";
    protected Connection conexion;
    
    public Connection getConexion(){
        return conexion;
    }
    
    public boolean conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String cadena="jdbc:mysql://"+SERVIDOR
                    +":3306/"+DATABASE;
            this.conexion=DriverManager.getConnection(
                    cadena,USER,PASSWORD);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    
    public void desconectar(){
        try{
            this.conexion.close();
        }catch(Exception ex){
            System.out.println("No se puede"
                    + " desconectar");
        }
    }
}
