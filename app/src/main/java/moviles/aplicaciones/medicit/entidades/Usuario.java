package moviles.aplicaciones.medicit.entidades;

import java.io.Serializable;
import java.util.Date;

public class Usuario  implements Serializable{
    private Integer dni;
    private String nombre;
    private String apellidopaterno;
    private String apellidomaterno;
    private String sexo;
    private Date fechadenacimiento;
    private String correo;
    private Integer celular;
    private String seguro;
    private String contrasenia;

    public Usuario(Integer dni, String nombre, String apellidopaterno, String apellidomaterno, String sexo, Date fechadenacimiento, String correo, Integer celular, String seguro, String contrasenia) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.sexo = sexo;
        this.fechadenacimiento = fechadenacimiento;
        this.correo = correo;
        this.celular = celular;
        this.seguro = seguro;
        this.contrasenia = contrasenia;
    }
    public Usuario(Integer dni, String nombre, String apellidopaterno, String apellidomaterno, String sexo, Date fechadenacimiento, String correo, Integer celular, String seguro) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.sexo = sexo;
        this.fechadenacimiento = fechadenacimiento;
        this.correo = correo;
        this.celular = celular;
        this.seguro = seguro;
    }
    public Usuario() {

    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
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

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
