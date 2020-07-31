package moviles.aplicaciones.medicit.entidades;

import java.util.Date;

public class cita {

    private int id;
    private  int dni;
    private String nombre;
    private String especialidad;
    private String epecialidad;
    private Date fecha;
    private String medico;

    public cita(int id, int dni, String nombre, String especialidad, String epecialidad, Date fecha, String medico) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.epecialidad = epecialidad;
        this.fecha = fecha;
        this.medico = medico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEpecialidad() {
        return epecialidad;
    }

    public void setEpecialidad(String epecialidad) {
        this.epecialidad = epecialidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }
}
