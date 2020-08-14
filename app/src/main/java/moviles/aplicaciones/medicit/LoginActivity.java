package moviles.aplicaciones.medicit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;
import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;
import moviles.aplicaciones.medicit.utilidades.Utilidades;

public class LoginActivity extends AppCompatActivity {
    EditText edtusuario, edtcontraseña;
    private Cursor fila;
    ConexionSQLiteHelper conn;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor Gdni;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        ConexionSQLiteHelper con = new ConexionSQLiteHelper(this,"db_medicos",null,1);
        conn = new ConexionSQLiteHelper(this,"db_usuarios",null,1);


        edtusuario = findViewById(R.id.edtusuario);
        edtcontraseña=findViewById(R.id.edtcontrasenia);



    }

    public void Principal(View view){

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();
        int USUARIO_DNI = Integer.parseInt(edtusuario.getText().toString());
        String USUARIO_CONTRASENIA = edtcontraseña.getText().toString();
        fila = db.rawQuery( "SELECT dni,contrasenia,nombre,apellidopaterno,apellidomaterno,sexo,fechadenacimiento,correo,celular,seguro FROM usuarios WHERE dni='"+USUARIO_DNI+"'AND contrasenia ='"+USUARIO_CONTRASENIA+"'",null);

        if(fila.moveToFirst()){
            int usuario=Integer.parseInt(fila.getString(0));
            String password=fila.getString(1);
            String DNIUSUARIO =Integer.toString(usuario);

            String nombre=fila.getString(2);
            String apellidopaterno=fila.getString(3);
            String apellidomaterno=fila.getString(4);
            String sexo=fila.getString(5);
            String fechadenacimiento=fila.getString(6);
            String correo= fila.getString(7);
            String celular=fila.getString(8);
            String seguro=fila.getString(9);
            sharedPreferences=PreferenceManager.getDefaultSharedPreferences(this);
            Gdni=sharedPreferences.edit();
            Gdni.putString("USUARIO_DNI",DNIUSUARIO);
            Gdni.putString("USUARIO_PASS",password);
            Gdni.putString("USUARIO_NOMBRE",nombre);
            Gdni.putString("USUARIO_APATERNO",apellidopaterno);
            Gdni.putString("USUARIO_AMATERNO",apellidomaterno);
            Gdni.putString("USUARIO_SEXO",sexo);
            Gdni.putString("USUARIO_FECHAN",fechadenacimiento);
            Gdni.putString("USUARIO_CORREO",correo);
            Gdni.putString("USUARIO_CELULAR",celular);
            Gdni.putString("USUARIO_SEGURO",seguro);
            Gdni.apply();

            if(USUARIO_DNI==usuario&&USUARIO_CONTRASENIA.equals(password)){



                Intent i =new Intent(this, PrincipalActivity.class);
                startActivity(i);
                edtusuario.setText("");
                edtcontraseña.setText("");


            }

        }else {
            Toast.makeText(getApplicationContext(),"USUARIO O CONSTRASEÑA INVALIDOS ",Toast.LENGTH_SHORT).show();

        }





    }

    public void Olvidemicontraseña(View view){
        Intent i =new Intent(this, RecuperarCuentaActivity.class);
        startActivity(i);
    }
    public void Registrar(View view){
        Intent i =new Intent(this, RegistrarActivity.class);
        startActivity(i);
    }
    public void Administrador(View view){
        int USUARIO_DNI = Integer.parseInt(edtusuario.getText().toString());
        String USUARIO_CONTRASENIA = edtcontraseña.getText().toString();
        if(USUARIO_DNI==404&&USUARIO_CONTRASENIA.equals("admin")){

            Intent i =new Intent(this, AdministradorActivity.class);
            startActivity(i);
            edtusuario.setText("");
            edtcontraseña.setText("");


        }else{
            Toast.makeText(getApplicationContext(),"ADMINISTRADOR O CONSTRASEÑA INVALIDOS ",Toast.LENGTH_SHORT).show();
        }

    }




}