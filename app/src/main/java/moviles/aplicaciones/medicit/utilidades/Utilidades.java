package moviles.aplicaciones.medicit.utilidades;

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




    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+TABLA_USUARIO+"("+CAMPO_DNI+" INTEGER, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_APELLIDOPATERNO+" TEXT, "+CAMPO_APELLIDOMATERNO+" TEXT, "+CAMPO_SEXO+" TEXT, "+CAMPO_FECHADENACIMIENTO+" DATE, "+CAMPO_CORREO+" TEXT, "+CAMPO_CELULAR+" INTEGER, "+CAMPO_SEGURO+" TEXT, "+CAMPO_CONTRASENIA+" TEXT)";

}