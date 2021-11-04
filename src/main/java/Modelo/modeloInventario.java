package Modelo;

public class modeloInventario {
    // Atributos
    int IdInventario;
    String Clave;
    String Descripcion;
    String Lote;
    String Caducidad;
    int Cantidad;

    //Constructor
    public modeloInventario(){
    }
    
    public modeloInventario(int IdInventario, String Clave, String Descripcion, String Lote, String Caducidad, int Cantidad) {
        this.IdInventario = IdInventario;
        this.Clave = Clave;
        this.Descripcion = Descripcion;
        this.Lote = Lote;
        this.Caducidad = Caducidad;
        this.Cantidad = Cantidad;
    }
    
    //getters y setters
    public int getIdInventario() {
        return IdInventario;
    }

    public void setIdInventario(int IdInventario) {
        this.IdInventario = IdInventario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getLote() {
        return Lote;
    }

    public void setLote(String Lote) {
        this.Lote = Lote;
    }

    public String getCaducidad() {
        return Caducidad;
    }

    public void setCaducidad(String Caducidad) {
        this.Caducidad = Caducidad;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    
}
