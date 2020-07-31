package moviles.aplicaciones.medicit.utilidades;

import java.util.Date;

public class Utilidades {

    //constantes compos tabla usuario
    public final static String TABLA_USUARIO = "usuarios";
    public final static String CAMPO_DNI = "dni";
    public final static String  CAMPO_NOMBRE= "nombre";
    public final static String CAMPO_APELLIDOPATERNO = "apellidopaterno";
    public final static String CAMPO_APELLIDOMATERNO = "apellidomaterno";
    public final static String CAMPO_SEXO = "sexo";
    public final static String CAMPO_FECHADENACIMIENTO = "fechadenacimiento";
    public final static String CAMPO_CORREO = "correo";
    public final static String CAMPO_CELULAR = "celular";
    public final static String CAMPO_SEGURO = "seguro";
    public final static String CAMPO_CONTRASENIA = "contrasenia";

    //constantes campos para tabla medicos

    public final static String TABLA_MEDICO = "medicos";
    public final static String MEDICO_ID = "id";
    public final static String MEDICO_NOMBRE= "nombre";
    public final static String MEDICO_APELLIDOPATERNO = "apellidopaterno";
    public final static String MEDICO_APELLIDOMATERNO = "apellidomaterno";
    public final static String MEDICO_ESPECIALIDAD = "especialidad";
    public final static String MEDICO_SEXO = "sexo";
    public final static String MEDICO_FECHADENACIMIENTO = "fechadenacimiento";
    public final static String MEDICO_DIRECCION = "direccion";
    public final static String MEDICO_CORREO = "correo";
    public final static String MEDICO_CELULAR = "celular";

    //constante para la tabla citas

    public final static String TABLA_CITA = "citas";
    public final static String CITA_ID = "id";
    public final static String CITA_DNI = "dni";
    public final static String CITA_NOMBRE= "nombre";
    public final static String CITA_ESPECIALIDAD = "especialidad";
    public final static String CITA_FECHA = "fecha";
    public final static String CITA_MEDICO = "medico";



    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+TABLA_USUARIO+"("+CAMPO_DNI+" INTEGER NOT NULL PRIMARY KEY, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_APELLIDOPATERNO+" TEXT, "+CAMPO_APELLIDOMATERNO+" TEXT, "+CAMPO_SEXO+" TEXT, "+CAMPO_FECHADENACIMIENTO+" DATE, "+CAMPO_CORREO+" TEXT, "+CAMPO_CELULAR+" INTEGER, "+CAMPO_SEGURO+" TEXT, "+CAMPO_CONTRASENIA+" TEXT)";
    public static final String CREAR_TABLA_MEDICO = "CREATE TABLE "+TABLA_MEDICO+"("+MEDICO_ID+" INTEGER PRIMARY KEY , "+MEDICO_NOMBRE+" TEXT, "+MEDICO_APELLIDOPATERNO+" TEXT, "+MEDICO_APELLIDOMATERNO+" TEXT, "+MEDICO_ESPECIALIDAD+" TEXT, "+MEDICO_SEXO+" TEXT, "+MEDICO_FECHADENACIMIENTO+" DATE, "+MEDICO_CORREO+" TEXT, "+MEDICO_DIRECCION+" TEXT, "+MEDICO_CELULAR+" INTEGER)";
    public static final String CREAR_TABLA_CITA = "CREATE TABLE "+TABLA_CITA+"("+CITA_ID+" INTEGER NOT NULL PRIMARY KEY, "+CITA_DNI+" INTEGER, "+CITA_NOMBRE+" TEXT, "+CITA_ESPECIALIDAD+" TEXT, "+CITA_FECHA+" DATE, "+CITA_MEDICO+" TEXT)";

}