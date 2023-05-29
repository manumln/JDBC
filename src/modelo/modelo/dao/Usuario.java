package modelo.modelo.dao;

import java.util.Objects;

public class Usuario {

    private int id_usuario;
    private String nombre;
    private String dni;
    private String direccion;
    private String telefono;
    private String email;
    private String rol;
    private String contrasenna;

    public Usuario(int id, String nombre, String dni, String direccion, String telefono, String email, String rol, String contrasenna) {
        this.id_usuario = id;
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.rol = rol;
        this.contrasenna = contrasenna;
    }

    public Usuario(String nombre, String dni, String direccion, String telefono, String email, String rol, String contrasenna) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.rol = rol;
        this.contrasenna = contrasenna;
    }

    public Usuario () {}

    public int getId_usuario() {
        return id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }


    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", id_usuario, nombre, dni, direccion, telefono, email, rol, contrasenna);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id_usuario == usuario.id_usuario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_usuario);
    }
}
