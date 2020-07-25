package moviles.aplicaciones.medicit;

import androidx.appcompat.app.AppCompatActivity;
import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;
import moviles.aplicaciones.medicit.utilidades.Utilidades;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity {
    Spinner combosexo,comboseguro;
    EditText edtdni, edtnombre, edtapellidopaterno, edtapellidomaterno, edtcorreo, edtcelular, edtcontrasenia, edtfechadenacimiento, edtcontraseniaa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        edtdni = findViewById(R.id.edtdni);
        edtnombre = findViewById(R.id.edtnombre);
        edtapellidopaterno = findViewById(R.id.edtapellidopaterno);
        edtapellidomaterno = findViewById(R.id.edtapellidomaterno);
        edtcorreo = findViewById(R.id.edtcorreo);
        edtcelular = findViewById(R.id.edtcelular);
        edtcontrasenia = findViewById(R.id.edtcontrasenia);
        edtcontraseniaa = findViewById(R.id.edtcontraseniaa);
        edtfechadenacimiento = findViewById(R.id.edtfechadenacimiento);
        combosexo = findViewById(R.id.idspinnerSexo);
        comboseguro = findViewById(R.id.idspinnerseguro);

        combosexo = findViewById(R.id.idspinnerSexo);
        comboseguro = findViewById(R.id.idspinnerseguro);

        //array para el spinner de sexo
        ArrayAdapter<CharSequence> sexoadapter= ArrayAdapter.createFromResource(this,R.array.combo_sexo,R.layout.spinner_item_estilos);
        combosexo.setAdapter(sexoadapter);
        //array para el spinner de seguro
        ArrayAdapter<CharSequence> seguroadapter= ArrayAdapter.createFromResource(this,R.array.combo_seguro,R.layout.spinner_item_estilos);
        comboseguro.setAdapter(seguroadapter);

    }


    public void Principal(View view){


        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
        ConexionSQLiteHelper con=new ConexionSQLiteHelper(this,"bd_medicos",null,1);

        //abriendo la base de datos para editar
        SQLiteDatabase db=conn.getWritableDatabase();
        SQLiteDatabase dbmedicos=con.getWritableDatabase();

        //insertando los datos del formulario a los campos de la base de datos
        final ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_DNI,edtdni.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,edtnombre.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDOPATERNO,edtapellidopaterno.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDOMATERNO,edtapellidomaterno.getText().toString());
        values.put(Utilidades.CAMPO_SEXO,combosexo.getItemAtPosition(combosexo.getSelectedItemPosition()).toString());
        values.put(Utilidades.CAMPO_FECHADENACIMIENTO,edtfechadenacimiento.getText().toString());
        values.put(Utilidades.CAMPO_CORREO,edtcorreo.getText().toString());
        values.put(Utilidades.CAMPO_CELULAR,edtcelular.getText().toString());
        values.put(Utilidades.CAMPO_SEGURO,comboseguro.getItemAtPosition(comboseguro.getSelectedItemPosition()).toString());
        values.put(Utilidades.CAMPO_CONTRASENIA,edtcontrasenia.getText().toString());


        final ContentValues valuesmedicos=new ContentValues();
        valuesmedicos.put(Utilidades.MEDICO_ID,edtdni.getText().toString());
        valuesmedicos.put(Utilidades.MEDICO_NOMBRE,edtnombre.getText().toString());
        valuesmedicos.put(Utilidades.MEDICO_APELLIDOPATERNO,edtapellidopaterno.getText().toString());
        valuesmedicos.put(Utilidades.MEDICO_APELLIDOMATERNO,edtapellidomaterno.getText().toString());
        valuesmedicos.put(Utilidades.MEDICO_ESPECIALIDAD,comboseguro.getItemAtPosition(comboseguro.getSelectedItemPosition()).toString());
        valuesmedicos.put(Utilidades.MEDICO_SEXO,combosexo.getItemAtPosition(combosexo.getSelectedItemPosition()).toString());
        valuesmedicos.put(Utilidades.MEDICO_FECHADENACIMIENTO,edtfechadenacimiento.getText().toString());
        valuesmedicos.put(Utilidades.MEDICO_CORREO,edtcorreo.getText().toString());
        valuesmedicos.put(Utilidades.MEDICO_DIRECCION,edtcontrasenia.getText().toString());
        valuesmedicos.put(Utilidades.MEDICO_CELULAR,edtcelular.getText().toString());

        //string para saber si las contraseñas son iguales vara validar
        String contra = edtcontrasenia.getText().toString();
        String contras = edtcontraseniaa.getText().toString();

        if(contra.equals(contras)){
            Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_DNI,values);
            Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
            System.out.println(idResultante);
            System.out.println(values);
            Intent i = new Intent(this,PrincipalActivity.class);
            startActivity(i);
            db.close();
        }else {
            Toast.makeText(getApplicationContext(),"LAS CONTRASEÑAS NO COINCIDEN: ",Toast.LENGTH_SHORT).show();
        }


    }
    }
