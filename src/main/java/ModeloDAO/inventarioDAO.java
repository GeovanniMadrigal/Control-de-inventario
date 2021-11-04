
package ModeloDAO;

import Configuracion.ConexionBD;
import Modelo.modeloInventario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Interfaces.InterfaceInventarioCRUD;

public class inventarioDAO implements InterfaceInventarioCRUD{
    ConexionBD conexionbd = new ConexionBD();
    Connection conexion;
    PreparedStatement PS;
    ResultSet RS;
    modeloInventario modeloInventario = new modeloInventario();
    int idmax=0;
    
    @Override
    public List mostrarInventario() {
        ArrayList<modeloInventario> datosInventario = new ArrayList<>();
        String sql="select * from inventario"; 
        try {
            conexion=conexionbd.getConnection();
            PS=conexion.prepareStatement(sql);
            RS=PS.executeQuery();
            while(RS.next()){
                modeloInventario modeloInventario = new modeloInventario();
                modeloInventario.setIdInventario(RS.getInt("IdInventario")); 
                modeloInventario.setClave(RS.getString("Clave"));
                modeloInventario.setDescripcion(RS.getString("Descripcion"));
                modeloInventario.setLote(RS.getString("Lote"));
                modeloInventario.setCaducidad(RS.getString("Caducidad"));
                modeloInventario.setCantidad(RS.getInt("Cantidad"));
                datosInventario.add(modeloInventario);
            }
        }catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return datosInventario;
    }

    @Override
    public modeloInventario mostrarProducto(int IdInventario) {
         String sql="select * from inventario where IdInventario="+IdInventario; 
        try {
            conexion=conexionbd.getConnection();
            PS=conexion.prepareStatement(sql);
            RS=PS.executeQuery();
            while(RS.next()){                
                modeloInventario.setIdInventario(RS.getInt("IdInventario"));
                modeloInventario.setClave(RS.getString("Clave"));
                modeloInventario.setDescripcion(RS.getString("Descripcion"));
                modeloInventario.setLote(RS.getString("Lote"));
                modeloInventario.setCaducidad(RS.getString("Caducidad"));
                modeloInventario.setCantidad(RS.getInt("Cantidad"));            
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return modeloInventario;
    }

    @Override
    public boolean agregarProducto(modeloInventario modeloInventario) {
        String sql="INSERT INTO inventario (IdInventario,Clave,Descripcion,Lote,Caducidad,Cantidad) " + "values('"+modeloInventario.getIdInventario()+"','"+modeloInventario.getClave()+"','"+modeloInventario.getDescripcion()+"','"+modeloInventario.getLote()+"','"+modeloInventario.getCaducidad()+"','"+modeloInventario.getCantidad()+"')";
        try {
            conexion=conexionbd.getConnection();
            PS=conexion.prepareStatement(sql);
            PS.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
       return false;
    }

    @Override
    public boolean editarProduto(modeloInventario modeloInventario) {
        String sql = "update inventario set IdInventario='" + modeloInventario.getIdInventario() + "',Clave='" + modeloInventario.getClave() + "',Descripcion='" + modeloInventario.getDescripcion() + "',Lote='" + modeloInventario.getLote() + "',Caducidad='" + modeloInventario.getCaducidad() + "',Cantidad='" + modeloInventario.getCantidad() + "' where IdInventario=" + modeloInventario.getIdInventario();
         try {
            conexion=conexionbd.getConnection();
            PS=conexion.prepareStatement(sql);
            PS.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return false;
    }

    @Override
    public boolean eliminarProducto(int IdInventario) {
        String sql="delete from inventario where IdInventario=" + IdInventario;
        try {
            conexion=conexionbd.getConnection();
            PS=conexion.prepareStatement(sql);
            PS.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return false;
    }
    
    @Override
    public int MaximoId(){
        String sql="SELECT MAX(IdInventario) AS IdInventario FROM inventario";
        try {
            conexion=conexionbd.getConnection();
            PS=conexion.prepareStatement(sql);
            RS=PS.executeQuery();
            if (RS.next()) {
                idmax=RS.getInt(1);
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return idmax;
    }
}
