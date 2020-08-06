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
    fila = db.rawQuery( "SELECT dni,contrasenia FROM usuarios WHERE dni='"+USUARIO_DNI+"'AND contrasenia ='"+USUARIO_CONTRASENIA+"'",null);
    sharedPreferences=PreferenceManager.getDefaultSharedPreferences(this);
    Gdni=sharedPreferences.edit();
    System.out.println("el USUARIO_DNI es : " + USUARIO_DNI);
    try {
        Gdni.putInt("USUARIO_DNI",USUARIO_DNI);
        Gdni.apply();
        System.out.println("el Gdni es : " + Gdni.putInt("USUARIO_DNI",USUARIO_DNI));
    }catch (Exception e){
        e.printStackTrace();
    }
    if(fila.moveToFirst()){
        int usuario=Integer.parseInt(fila.getString(0));
        String password=fila.getString(1);

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
    public void guardarPreferencias(){

    }




    public void Olvidemicontraseña(View view){
        Intent i =new Intent(this, Olvidemicontraseña.class);
        startActivity(i);
    }
    public void Registrar(View view){
        Intent i =new Intent(this, RegistrarActivity.class);
        startActivity(i);
    }
}
