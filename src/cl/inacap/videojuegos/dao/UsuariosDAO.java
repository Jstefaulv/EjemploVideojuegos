
package cl.inacap.videojuegos.dao;
import cl.inacap.videojuegos.utils.Conexion;
import cl.inacap.videojuegos.dto.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Johana
 */
public class UsuariosDAO extends Conexion{
    
    public void agregar(Usuario usuario){
        try{
            this.conectar();
            String sql="INSERT INTO usuarios "
                    + "(nombre,email,username,"
                    + "password,rol,estado) "
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement st=
                    this.conexion.prepareStatement(sql);
            st.setString(1,usuario.getNombre());
            st.setString(2,usuario.getEmail());
            st.setString(3,usuario.getUsername());
            st.setString(4,usuario.getPassword());
            st.setString(5,usuario.getRol());
            st.setString(6,usuario.getEstado());
            st.executeUpdate();
            
        }catch(Exception ex){
            System.out.println("Error:"+ex);
        }finally{
            this.desconectar();
        }
    }
    
    public List<Usuario> comprobarUsuario(){
        List<Usuario>usuarios=new ArrayList<>();
        try{
            this.conectar();
            String sql="SELECT username,password"
                    + " FROM usuarios";
            PreparedStatement st=
              this.conexion.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Usuario usuario=new Usuario();
                usuario.setUsername(rs.getString(1));
                usuario.setPassword(rs.getString(2));
                usuarios.add(usuario);
            }
            rs.close();
        }catch(Exception ex){
            System.out.println("Error: "+ex);
        }finally{
        this.desconectar();
    }
        return usuarios;
    }
}
