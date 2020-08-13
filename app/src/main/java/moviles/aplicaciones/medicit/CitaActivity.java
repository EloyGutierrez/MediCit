package moviles.aplicaciones.medicit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import moviles.aplicaciones.medicit.interfaces.IComunicaFragments;
import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;
import moviles.aplicaciones.medicit.utilidades.Utilidades;

import android.Manifest;
import android.app.Activity;
import android.app.FragmentManagerNonConfig;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class CitaActivity extends AppCompatActivity {
    TextView medicoid,medicoespespecialidad,usuariodni,usuarioseguro,fecha;
    Button btnLllamar,btnRegistrar;
    SharedPreferences sharedPreferences;
    TextView detalles,dr,area,paciente,detalless,fechas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cita);
        medicoid = findViewById(R.id.edtNombredelmedico);
        medicoespespecialidad = findViewById(R.id.edtEspecialidaddelmedico);
        usuariodni = findViewById(R.id.edtUsuarioDNI);
        usuarioseguro = findViewById(R.id.edtUsuarioseguro);
        fecha = findViewById(R.id.edtFechacita);

        //nnose que hago

        detalles = findViewById(R.id.detalles);
        dr = findViewById(R.id.dr);
        area = findViewById(R.id.area);
        paciente = findViewById(R.id.paciente);
        detalless = findViewById(R.id.detalless);
        fechas = findViewById(R.id.fecha);

        btnLllamar=findViewById(R.id.btnCoordinarHora);
        btnRegistrar=findViewById(R.id.btnRegistraCita);
        //RECIBIENDO LOS DATOS DEL MEDICO
        String nombremedico=getIntent().getStringExtra("NOM_MEDICO");
        String apellidopaternomedico=getIntent().getStringExtra("APP_MEDICO");
        String apellidomaternomedico=getIntent().getStringExtra("APM_MEDICO");
        String dnimedico=getIntent().getStringExtra("DNI_MEDICO");

        //RECIBIENDO LOS DATOS DEL USUARIO
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull((this.getApplicationContext())));
        String dniusuario=sharedPreferences.getString("USUARIO_DNI","dni defecto");
        String nombreusuario=sharedPreferences.getString("USUARIO_NOMBRE","nombre defecto");
        String apellidopaternousuario=sharedPreferences.getString("USUARIO_APATERNO","nombre defecto");
        String apellidomaternousuario=sharedPreferences.getString("USUARIO_AMATERNO","nombre defecto");

        medicoid.setText(nombremedico+" "+apellidopaternomedico+" "+apellidomaternomedico);
        medicoespespecialidad.setText(getIntent().getStringExtra("ESP_MEDICO"));
        usuariodni.setText(nombreusuario+" "+apellidopaternousuario+" "+apellidomaternousuario);
        usuarioseguro.setText(getIntent().getStringExtra("SEG_USUARIO"));
        fecha.setText(getIntent().getStringExtra("FEC_CITA"));


        btnLllamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Celular = getIntent().getStringExtra("CEL_MEDICO");
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+Celular));
                if (ActivityCompat.checkSelfPermission(CitaActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
                    return;
                startActivity(intent);
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medicoid.setVisibility(View.GONE);
                medicoespespecialidad.setVisibility(View.GONE);
                usuariodni.setVisibility(View.GONE);
                usuarioseguro.setVisibility(View.GONE);
                fecha.setVisibility(View.GONE);
                btnLllamar.setVisibility(View.GONE);
                btnRegistrar.setVisibility(View.GONE);
                detalles.setVisibility(View.GONE);
                dr.setVisibility(View.GONE);
                area.setVisibility(View.GONE);
                paciente.setVisibility(View.GONE);
                detalless.setVisibility(View.GONE);
                fechas.setVisibility(View.GONE);

                crearCita();
                FragmentManager fm = getSupportFragmentManager();
                MiscitasFragment miscitasFragment= new MiscitasFragment();
                fm.beginTransaction().replace(R.id.citaprincipal,miscitasFragment).commit();

            }
        });
    }

    public void crearCita(){

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(CitaActivity.this,"bd_citas",null,1);

        //RECIBIENDO LOS DATOS DEL MEDICO
        String dnimedico=getIntent().getStringExtra("DNI_MEDICO");
        String especialidadmedico=getIntent().getStringExtra("ESP_MEDICO");
        String fecha=getIntent().getStringExtra("FEC_CITA");

        //RECIBIENDO LOS DATOS DEL USUARIO
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull((this.getApplicationContext())));
        String dniusuario=sharedPreferences.getString("USUARIO_DNI","dni defecto");
        String segurousuario=getIntent().getStringExtra("SEG_USUARIO");
        //abriendo la base de datos para editar
        SQLiteDatabase db=conn.getWritableDatabase();

        final ContentValues values=new ContentValues();
        values.put(Utilidades.CITA_DNI,dniusuario);
        values.put(Utilidades.CITA_MEDICO,dnimedico);
        values.put(Utilidades.CITA_PRECIO,segurousuario);
        values.put(Utilidades.CITA_ESPECIALIDAD,especialidadmedico);
        values.put(Utilidades.CITA_FECHA,fecha);
        Long idResultante=db.insert(Utilidades.TABLA_CITA,Utilidades.CITA_ID,values);
        Toast.makeText(getApplicationContext(),"Id Registro CITA: "+idResultante,Toast.LENGTH_SHORT).show();
        System.out.println(idResultante);
        System.out.println(values);
        db.close();
    }
}