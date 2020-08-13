package moviles.aplicaciones.medicit;

import androidx.appcompat.app.AppCompatActivity;
import moviles.aplicaciones.medicit.entidades.Medicos;
import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;
import moviles.aplicaciones.medicit.utilidades.ListAdapter;
import moviles.aplicaciones.medicit.utilidades.Utilidades;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class SpidetucitaActivity extends AppCompatActivity  {
    Button btnfecha;
    Cursor filamedicos;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor Mdni;
    ListView listmed;
    ListAdapter myAdapter;
    List<Medicos> myList = new ArrayList<>();
    ArrayList<Medicos> listaMedicos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spidetucita);

        btnfecha = findViewById(R.id.btnFecha);
        listmed = findViewById(R.id.lvmedicos);

        listmed.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sharedPreferences= PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull((SpidetucitaActivity.this.getApplicationContext())));
                String DNI_USUARIO=sharedPreferences.getString("USUARIO_DNI","dni defecto");
                String SEG_USUARIO=sharedPreferences.getString("USUARIO_SEGURO","dni defecto");
                String FEC_CITA = btnfecha.getText().toString();


                Toast.makeText(SpidetucitaActivity.this,"Elemento clicado :  "+position,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SpidetucitaActivity.this,CitaActivity.class);
                intent.putExtra("DNI_MEDICO",myAdapter.getItem(position).getId());
                intent.putExtra("NOM_MEDICO",myAdapter.getItem(position).getNombre());
                intent.putExtra("APP_MEDICO",myAdapter.getItem(position).getApellidopaterno());
                intent.putExtra("APM_MEDICO",myAdapter.getItem(position).getApellidomaterno());
                intent.putExtra("DNI_USUARIO",DNI_USUARIO);
                intent.putExtra("ESP_MEDICO",myAdapter.getItem(position).getEspecialidad());
                intent.putExtra("SEG_USUARIO",SEG_USUARIO);
                intent.putExtra("FEC_CITA",FEC_CITA);
                intent.putExtra("CEL_MEDICO",myAdapter.getItem(position).getCelular());
                startActivity(intent);

            }
        });



        Calendar cal = Calendar.getInstance();
        int anio1 = cal.get(Calendar.YEAR);
        int mes1 = cal.get(Calendar.MONTH);
        int dia1 = cal.get(Calendar.DAY_OF_MONTH);
        final String fechahoy=dia1+"/"+mes1+"/"+anio1;
        btnfecha.setText("Hoy : "+fechahoy);
        listarmedicos();

        myAdapter = new ListAdapter(SpidetucitaActivity.this,R.layout.item_row,myList);
        listmed.setAdapter(myAdapter);


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
                        String fechacrearcita = btnfecha.getText().toString();
                        System.out.println("la fecha es: "+fechacrearcita);


                    }
                },anio,mes,dia);
                datePickerDialog.show();
            }
        });




    }

    public void listarmedicos() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_medicos", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        Medicos medico =null;
        listaMedicos =new ArrayList<Medicos>();

        //recibiendo los datos de la especialidad
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull((SpidetucitaActivity.this.getApplicationContext())));
        String ESPECIALIDAD = sharedPreferences.getString("PTC_ESPECIALIDAD", "especialidad defecto");

        filamedicos = db.rawQuery( "SELECT id,nombre,apellidopaterno,apellidomaterno,especialidad,celular FROM medicos WHERE especialidad='"+ESPECIALIDAD+"'",null);
        while (filamedicos.moveToNext()){
            medico = new Medicos();
            medico.setId(filamedicos.getString(0));
            medico.setNombre(filamedicos.getString(1));
            medico.setApellidopaterno(filamedicos.getString(2));
            medico.setApellidomaterno(filamedicos.getString(3));
            medico.setEspecialidad(filamedicos.getString(4));
            medico.setCelular(filamedicos.getString(5));
            listaMedicos.add(medico);
        }
        obtenerlista();
        System.out.println("se ejecuto listarmedico();");
    }

    private void obtenerlista() {
        for (int i=0; i<listaMedicos.size();i++){

            String IDMEDICO =listaMedicos.get(i).getId();
            myList.add(new Medicos(listaMedicos.get(i).getId(),listaMedicos.get(i).getNombre(),listaMedicos.get(i).getApellidopaterno(),listaMedicos.get(i).getApellidomaterno(),listaMedicos.get(i).getEspecialidad(),listaMedicos.get(i).getCelular()));

        }
    }




}