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

public class SpidetucitaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Button btnfecha;
    Cursor filamedicos;
    SharedPreferences sharedPreferences;
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



        Calendar cal = Calendar.getInstance();
        int anio1 = cal.get(Calendar.YEAR);
        int mes1 = cal.get(Calendar.MONTH);
        int dia1 = cal.get(Calendar.DAY_OF_MONTH);
        final String fechahoy=dia1+"/"+mes1+"/"+anio1;
        btnfecha.setText("Hoy : "+fechahoy);


        listarmedicos();;
        myAdapter=new ListAdapter(SpidetucitaActivity.this, R.layout.item_row,myList);
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
                        //listamedicos.setOnItemClickListener(SpidetucitaActivity.this);

                        // myList.add(new Medicos(808080,"Gaston","Meneces","Sicha","masculino","Odontologia","masculino",null,"gaston@gmail.com","av los laureles",95623));

                        // myAdapter=new ListAdapter(SpidetucitaActivity.this, R.layout.item_row,myList);
                        //listamedicos.setAdapter(myAdapter);
                    }
                },anio,mes,dia);
                datePickerDialog.show();
            }
        });




    }

    public void crearCita(){
        String fechacrearcita = btnfecha.getText().toString();
        System.out.println(fechacrearcita);

        //recibiendo los datos de sharedpreference dni
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull((SpidetucitaActivity.this.getApplicationContext())));
        String dni=sharedPreferences.getString("USUARIO_DNI","dni defecto");

        //recibiendo los datos de la especialidad
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
        values.put(Utilidades.CITA_ESPECIALIDAD,especialidad);
        values.put(Utilidades.CITA_FECHA,fechacrearcita);
        Long idResultante=db.insert(Utilidades.TABLA_CITA,Utilidades.CITA_ID,values);
        Toast.makeText(getApplicationContext(),"Id Registro CITA: "+idResultante,Toast.LENGTH_SHORT).show();
        System.out.println(idResultante);
        System.out.println(values);
        db.close();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public void listarmedicos() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_medicos", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        Medicos medico =null;
        listaMedicos =new ArrayList<Medicos>();

        //recibiendo los datos de la especialidad
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull((SpidetucitaActivity.this.getApplicationContext())));
        String ESPECIALIDAD = sharedPreferences.getString("PTC_ESPECIALIDAD", "especialidad defecto");

        filamedicos = db.rawQuery( "SELECT nombre,apellidopaterno,apellidomaterno,especialidad,celular FROM medicos WHERE especialidad='"+ESPECIALIDAD+"'",null);
        while (filamedicos.moveToNext()){
            medico = new Medicos();
            medico.setNombre(filamedicos.getString(0));
            medico.setApellidopaterno(filamedicos.getString(1));
            medico.setApellidomaterno(filamedicos.getString(2));
            medico.setEspecialidad(filamedicos.getString(3));
            medico.setCelular(filamedicos.getString(4));
            listaMedicos.add(medico);
        }
        obtenerlista();
        System.out.println("se ejecuto listarmedico();");
    }

    private void obtenerlista() {
        for (int i=0; i<listaMedicos.size();i++){
            String nombre =listaMedicos.get(i).getNombre();
            String apellidopaterno =listaMedicos.get(i).getApellidopaterno();
            String apellidomaterno =listaMedicos.get(i).getApellidomaterno();
            String especialidad =listaMedicos.get(i).getEspecialidad();
            String celular =listaMedicos.get(i).getCelular();
            myList.add(new Medicos(nombre,apellidopaterno,apellidomaterno,especialidad,celular));

        }
    }


}