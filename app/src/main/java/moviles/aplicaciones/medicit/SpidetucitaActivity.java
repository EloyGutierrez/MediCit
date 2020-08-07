package moviles.aplicaciones.medicit;

import androidx.appcompat.app.AppCompatActivity;
import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;
import moviles.aplicaciones.medicit.utilidades.Utilidades;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Objects;

public class SpidetucitaActivity extends AppCompatActivity {
    Button btnfecha;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spidetucita);

        btnfecha = findViewById(R.id.btnFecha);
        Calendar cal = Calendar.getInstance();
        int anio1 = cal.get(Calendar.YEAR);
         int mes1 = cal.get(Calendar.MONTH);
        int dia1 = cal.get(Calendar.DAY_OF_MONTH);
        final String fechahoy=dia1+"/"+mes1+"/"+anio1;
        btnfecha.setText("Hoy : "+fechahoy);

        btnfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int anio = cal.get(Calendar.YEAR);
                final int mes = cal.get(Calendar.MONTH);
                int dia = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog= new DatePickerDialog(SpidetucitaActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    String fecha= dayOfMonth+"/"+month+"/"+year;
                        btnfecha.setText(fecha);
                        //recibiendo los datos de sharedpreference
                        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull((SpidetucitaActivity.this.getApplicationContext())));
                        String dni=sharedPreferences.getString("USUARIO_DNI","dni defecto");
                        String especialidad=sharedPreferences.getString("PTC_ESPECIALIDAD","especialidad defecto");
                        System.out.println("la especialidad Spidetucita : "+especialidad);
                        System.out.println("dni SpidetucitaActivity : " +dni);

                        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(SpidetucitaActivity.this,"bd_citas",null,1);

                        //abriendo la base de datos para editar
                        SQLiteDatabase db=conn.getWritableDatabase();
                        final ContentValues values=new ContentValues();
                        values.put(Utilidades.CITA_DNI,dni);
                        values.put(Utilidades.CITA_MEDICO,"mario garcia gallegos");
                        values.put(Utilidades.CITA_PRECIO,"18.00");
                        values.put(Utilidades.CITA_ESPECIALIDAD,"medicina");
                        values.put(Utilidades.CITA_FECHA,fecha);

                        Long idResultante=db.insert(Utilidades.TABLA_CITA,Utilidades.CITA_ID,values);
                        //Long idResultantemedicos=dbmedicos.insert(Utilidades.TABLA_MEDICO,Utilidades.MEDICO_ID,valuesmedicos);
                        Toast.makeText(getApplicationContext(),"Id Registro CITA: "+idResultante,Toast.LENGTH_SHORT).show();
                        //Toast.makeText(getApplicationContext(),"Id Registromedico: "+idResultantemedicos,Toast.LENGTH_SHORT).show();
                        System.out.println(idResultante);
                        System.out.println(values);
                        //  System.out.println(idResultantemedicos);
                        //System.out.println(valuesmedicos);

                        db.close();

                    }
                },anio,mes,dia);
                datePickerDialog.show();
            }
        });


    }

}