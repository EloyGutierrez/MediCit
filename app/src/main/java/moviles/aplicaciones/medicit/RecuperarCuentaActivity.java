package moviles.aplicaciones.medicit;

import androidx.appcompat.app.AppCompatActivity;
import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RecuperarCuentaActivity extends AppCompatActivity {
    EditText edtusuario;
    Button btnBuscarUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_cuenta);

        edtusuario= findViewById(R.id.edtUusuario);
        btnBuscarUsuario = findViewById(R.id.btnBuscarUusuario);

        btnBuscarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BuscarUsuario();
            }
        });



    }

    public void BuscarUsuario(){

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();
        int USUARIO_DNI = Integer.parseInt(edtusuario.getText().toString());
        Cursor fila = db.rawQuery( "SELECT celular,correo FROM usuarios WHERE dni='"+USUARIO_DNI+"'",null);

        if(fila.moveToFirst()){
            int celular=Integer.parseInt(fila.getString(0));
            String correo =fila.getString(1);
            Intent intent = new Intent(this,Olvidemicontraseña.class);
            System.out.println("llego datos : "+correo+celular);
            intent.putExtra("USUARIO_CELULAR",celular);
            intent.putExtra("USUARIO_CORREO",correo);
            startActivity(intent);

        }else {
            Toast.makeText(getApplicationContext(),"USUARIO NO EXISTE",Toast.LENGTH_SHORT).show();

        }

}
}