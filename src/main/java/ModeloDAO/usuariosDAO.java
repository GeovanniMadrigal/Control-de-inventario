
package ModeloDAO;

import Configuracion.ConexionBD;
import Interfaces.interfaceUsuarioCRUD;
import Modelo.modeloUsuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class usuariosDAO implements interfaceUsuarioCRUD{
    ConexionBD conexionbd = new ConexionBD();
    Connection conexion;
    PreparedStatement PS;
    ResultSet RS;
    modeloUsuarios modeloUsuarios = new modeloUsuarios();

    @Override
    public List adquirirUsuarios() {
        ArrayList<modeloUsuarios> datosUsuario = new ArrayList<>();
        String sql="select * from usuarios"; 
        try {
            conexion=conexionbd.getConnection();
            PS=conexion.prepareStatement(sql);
            RS=PS.executeQuery();
            while(RS.next()){
                modeloUsuarios modeloUsuarios = new modeloUsuarios();
                modeloUsuarios.setIdUSUARIOS(RS.getInt("IdUSUARIOS")); 
                modeloUsuarios.setNombre(RS.getString("Nombre"));
                modeloUsuarios.setContraseña(RS.getString("Contraseña"));
                modeloUsuarios.setNoTrabajador(RS.getString("NoTrabajador")); 
                datosUsuario.add(modeloUsuarios);
            }
            System.out.println("--------------Aqui si entro----------");
        }catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return datosUsuario;
    }
    
   
    
}
