package moviles.aplicaciones.medicit.entidades;

import java.util.Date;

public class Cita {

    private int id;
    private String medico;
    private  int dni;
    private String precio;
    private String especialidad;
    private Date fecha;


    public Cita() {
    }

    public Cita(int id, String medico, int dni, String precio, String especialidad, Date fecha) {
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
