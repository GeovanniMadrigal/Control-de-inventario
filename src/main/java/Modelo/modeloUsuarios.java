
package Modelo;

public class modeloUsuarios {
    //Atributos
    int IdUSUARIOS;
    String Nombre;
    String Contraseña;
    String NoTrabajador;
    
    //Constructor
    public  modeloUsuarios(){
    }
    
     public modeloUsuarios(int IdUSUARIOS, String Nombre, String Contraseña, String NoTrabajador) {
        this.IdUSUARIOS = IdUSUARIOS;
        this.Nombre = Nombre;
        this.Contraseña = Contraseña;
        this.NoTrabajador = NoTrabajador;
    }
    
    //getters y setters
    public int getIdUSUARIOS() {
        return IdUSUARIOS;
    }

    public void setIdUSUARIOS(int IdUSUARIOS) {
        this.IdUSUARIOS = IdUSUARIOS;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getNoTrabajador() {
        return NoTrabajador;
    }

    public void setNoTrabajador(String NoTrabajador) {
        this.NoTrabajador = NoTrabajador;
    }

}
