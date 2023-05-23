package modelo.dao;

public class Usuarios {
    private int id_usuario;
    private String dni;
    private String nombre;
    private int telefono;
    private String contrasenna;
    private String rol;

    public Usuarios(int id_usuario, String dni, String nombre, int telefono, String contrasenna, String rol) {
        this.id_usuario = id_usuario;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.contrasenna = contrasenna;
        this.rol = rol;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
