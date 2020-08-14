package moviles.aplicaciones.medicit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class DetallesCitaActivity extends AppCompatActivity {
    TextView medicoid,medicoespespecialidad,usuariodni,usuarioseguro,fecha;
    Button cancelarcita,home;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_cita);

        medicoid = findViewById(R.id.edtNombredelmedico);
        medicoespespecialidad = findViewById(R.id.edtEspecialidaddelmedico);
        usuariodni = findViewById(R.id.edtUsuarioDNI);
        usuarioseguro = findViewById(R.id.edtUsuarioseguro);
        fecha = findViewById(R.id.edtFechacita);
        cancelarcita =findViewById(R.id.btnCancelarcita);
        home=findViewById(R.id.btnVolverInicio);

        cancelarcita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Celular = getIntent().getStringExtra("CEL_MEDICO");
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+Celular));
                if (ActivityCompat.checkSelfPermission(DetallesCitaActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
                    return;
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DetallesCitaActivity.this,PrincipalActivity.class);
                startActivity(i);
            }
        });

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull((this.getApplicationContext())));
        String nombre=sharedPreferences.getString("USUARIO_NOMBRE","nombre defecto");
        String apellidopaterno=sharedPreferences.getString("USUARIO_APATERNO","nombre defecto");
        String apellidomaterno=sharedPreferences.getString("USUARIO_AMATERNO","nombre defecto");

        medicoid.setText(getIntent().getStringExtra("ID_MEDICO"));
        medicoespespecialidad.setText(getIntent().getStringExtra("ESP_MEDICO"));
        usuariodni.setText(nombre+" "+apellidopaterno+" "+apellidomaterno);
        usuarioseguro.setText(getIntent().getStringExtra("CIT_PRECIO"));
        fecha.setText(getIntent().getStringExtra("FEC_CITA"));

    }
}