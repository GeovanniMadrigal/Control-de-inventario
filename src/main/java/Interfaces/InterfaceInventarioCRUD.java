
package Interfaces;

import Modelo.modeloInventario;
import java.util.List;

public interface InterfaceInventarioCRUD {
    public List mostrarInventario();
    public modeloInventario mostrarProducto(int IdInventario);
    public boolean agregarProducto(modeloInventario modeloInventario);
    public boolean editarProduto(modeloInventario modeloInventario);
    public boolean eliminarProducto(int IdInventario);
    public int MaximoId();
}
