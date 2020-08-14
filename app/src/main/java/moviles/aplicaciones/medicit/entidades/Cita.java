package moviles.aplicaciones.medicit.entidades;

import java.util.Date;

public class Cita {

    private int id;
    private String medico;
    private String dni;
    private String precio;
    private String especialidad;
    private String fecha;


    public Cita() {
    }

    public Cita(String medico, String precio, String especialidad, String fecha) {
        this.medico = medico;
        this.precio = precio;
        this.especialidad = especialidad;
        this.fecha = fecha;
    }

    public Cita(int id, String medico, String dni, String precio, String especialidad, String fecha) {
        this.id = id;
        this.medico = medico;
        this.dni = dni;
        this.precio = precio;
        this.especialidad = especialidad;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
