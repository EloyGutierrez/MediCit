package moviles.aplicaciones.medicit;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;

public class LoginActivity extends AppCompatActivity {
    EditText edtusuario, edtcontraseña;
    private Cursor fila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ConexionSQLiteHelper con = new ConexionSQLiteHelper(this,"db_medicos",null,1);

        edtusuario = findViewById(R.id.edtusuario);
        edtcontraseña=findViewById(R.id.edtcontraseña);



    }
public void Principal(View view){

    ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
    SQLiteDatabase db=conn.getWritableDatabase();
    int USUARIO_DNI = Integer.parseInt(edtusuario.getText().toString());
    String USUARIO_CONTRASENIA = edtcontraseña.getText().toString();
    System.out.println("usuario"+ USUARIO_DNI);
    System.out.println("password"+ USUARIO_CONTRASENIA);
    fila = db.rawQuery( "SELECT dni,contrasenia FROM usuarios WHERE dni='"+USUARIO_DNI+"'AND contrasenia ='"+USUARIO_CONTRASENIA+"'",null);


    if(fila.moveToFirst()){
        int usuario=Integer.parseInt(fila.getString(0));
        String password=fila.getString(1);
        System.out.println("usuario"+ usuario);
        System.out.println("password"+ password);

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
}
