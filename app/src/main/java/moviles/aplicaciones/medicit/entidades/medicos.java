package moviles.aplicaciones.medicit.entidades;

import java.util.Date;

public class medicos {
    private int id;
    private String nombre;
    private String apellidopaterno;
    private String apellidomaterno;
    private String especialidad;
    private String sexo;
    private Date fechadenacimiento;
    private String correo;
    private String direccion;
    private String celular;

    public medicos(int id, String nombre, String apellidopaterno, String apellidomaterno, String especialidad, String sexo, Date fechadenacimiento, String correo, String direccion, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.especialidad = especialidad;
        this.sexo = sexo;
        this.fechadenacimiento = fechadenacimiento;
        this.correo = correo;
        this.direccion = direccion;
        this.celular = celular;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechadenacimiento() {
        return fechadenacimiento;
    }

    public void setFechadenacimiento(Date fechadenacimiento) {
        this.fechadenacimiento = fechadenacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
