package moviles.aplicaciones.medicit;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;
import moviles.aplicaciones.medicit.utilidades.Utilidades;

public class RegistrarMedico extends AppCompatActivity {
    Button registrarmedico;
    Spinner comboespecialidad,spinnersexo;
    EditText edtdni, edtnombre, edtapellidopaterno, edtapellidomaterno, edtsexo, edtfechadenacimiento,edtcorreo,edtdireccion, edtcelular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarmedico);
        registrarmedico=findViewById(R.id.btnregistrar);
        comboespecialidad = findViewById(R.id.idspinnerespecialidad);

        edtdni = findViewById(R.id.edtdni);
        edtnombre = findViewById(R.id.edtnombre);
        edtapellidopaterno = findViewById(R.id.edtapellidopaterno);
        edtapellidomaterno = findViewById(R.id.edtapellidomaterno);
        spinnersexo=findViewById(R.id.idspinnerSexo);
        edtfechadenacimiento = findViewById(R.id.edtfechadenacimiento);
        edtcorreo = findViewById(R.id.edtcorreo);
        edtdireccion=findViewById(R.id.edtdireccion);
        edtcelular = findViewById(R.id.edtcelular);

        ArrayAdapter<CharSequence> especialidadadapter= ArrayAdapter.createFromResource(this,R.array.combo_especialidad,R.layout.spinner_item_estilos);
        comboespecialidad.setAdapter(especialidadadapter);
        ArrayAdapter<CharSequence> sexo= ArrayAdapter.createFromResource(this,R.array.combo_sexo,R.layout.spinner_item_estilos);
        spinnersexo.setAdapter(sexo);

        registrarmedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConexionSQLiteHelper conn=new ConexionSQLiteHelper(RegistrarMedico.this,"bd_medicos",null,1);

                //abriendo la base de datos para editar
                SQLiteDatabase db=conn.getWritableDatabase();




                final ContentValues valuesmedicos=new ContentValues();
                valuesmedicos.put(Utilidades.MEDICO_ID,edtdni.getText().toString());
                valuesmedicos.put(Utilidades.MEDICO_NOMBRE,edtnombre.getText().toString());
                valuesmedicos.put(Utilidades.MEDICO_APELLIDOPATERNO,edtapellidopaterno.getText().toString());
                valuesmedicos.put(Utilidades.MEDICO_APELLIDOMATERNO,edtapellidomaterno.getText().toString());
                valuesmedicos.put(Utilidades.MEDICO_ESPECIALIDAD,comboespecialidad.getItemAtPosition(comboespecialidad.getSelectedItemPosition()).toString());
                valuesmedicos.put(Utilidades.MEDICO_SEXO,spinnersexo.getItemAtPosition(spinnersexo.getSelectedItemPosition()).toString());
                valuesmedicos.put(Utilidades.MEDICO_FECHADENACIMIENTO,edtfechadenacimiento.getText().toString());
                valuesmedicos.put(Utilidades.MEDICO_CORREO,edtcorreo.getText().toString());
                valuesmedicos.put(Utilidades.MEDICO_DIRECCION,edtdireccion.getText().toString());
                valuesmedicos.put(Utilidades.MEDICO_CELULAR,edtcelular.getText().toString());


                Long idResultante=db.insert(Utilidades.TABLA_MEDICO,Utilidades.MEDICO_ID,valuesmedicos);
                //Long idResultantemedicos=dbmedicos.insert(Utilidades.TABLA_MEDICO,Utilidades.MEDICO_ID,valuesmedicos);
                Toast.makeText(getApplicationContext(),"Id Registro medico: "+idResultante,Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(),"Id Registromedico: "+idResultantemedicos,Toast.LENGTH_SHORT).show();
                System.out.println(idResultante);
                System.out.println(valuesmedicos);
                System.out.println("los values son : "+valuesmedicos);
                db.close();
            }
        });



    }

}
