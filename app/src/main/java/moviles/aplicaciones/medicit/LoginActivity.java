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
        edtcontraseña=findViewById(R.id.edtcontraseña);



    }

public void Principal(View view){

    ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
    SQLiteDatabase db=conn.getWritableDatabase();
    int USUARIO_DNI = Integer.parseInt(edtusuario.getText().toString());
    String USUARIO_CONTRASENIA = edtcontraseña.getText().toString();
    fila = db.rawQuery( "SELECT dni,contrasenia,nombre,apellidopaterno,apellidomaterno FROM usuarios WHERE dni='"+USUARIO_DNI+"'AND contrasenia ='"+USUARIO_CONTRASENIA+"'",null);

    if(fila.moveToFirst()){
        int usuario=Integer.parseInt(fila.getString(0));
        System.out.println("usuario : "+usuario);
        String password=fila.getString(1);
        String DNIUSUARIO =Integer.toString(usuario);
        System.out.println("password : "+password);
        String nombre=fila.getString(2);
        System.out.println("nombre : "+nombre);
        String apellidopaterno=fila.getString(3);
        System.out.println("apellido paterno : "+apellidopaterno);
        String apellidomaterno=fila.getString(4);
        System.out.println("apellido materno : "+apellidomaterno);
        sharedPreferences=PreferenceManager.getDefaultSharedPreferences(this);
        Gdni=sharedPreferences.edit();
        Gdni.putString("USUARIO_DNI",DNIUSUARIO);
        Gdni.putString("USUARIO_NOMBRE",nombre);
        Gdni.putString("USUARIO_APATERNO",apellidopaterno);
        Gdni.putString("USUARIO_AMATERNO",apellidomaterno);
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
        Intent i =new Intent(this, Olvidemicontraseña.class);
        startActivity(i);
    }
    public void Registrar(View view){
        Intent i =new Intent(this, RegistrarActivity.class);
        startActivity(i);
    }

    public void Registrarmedico(View view){
        Intent i =new Intent(this, RegistrarMedio.class);
        startActivity(i);
    }


}
