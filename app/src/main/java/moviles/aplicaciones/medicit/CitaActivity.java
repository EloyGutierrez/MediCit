package moviles.aplicaciones.medicit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CitaActivity extends AppCompatActivity {
    TextView medicoid,medicoespespecialidad,usuariodni,usuarioseguro,fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cita);
        medicoid = findViewById(R.id.edtNombredelmedico);
        medicoespespecialidad = findViewById(R.id.edtEspecialidaddelmedico);
        usuariodni = findViewById(R.id.edtUsuarioDNI);
        usuarioseguro = findViewById(R.id.edtUsuarioseguro);
        fecha = findViewById(R.id.edtFechacita);
        medicoid.setText(getIntent().getStringExtra("DNI_MEDICO"));
        medicoespespecialidad.setText(getIntent().getStringExtra("ESP_MEDICO"));
        usuariodni.setText(getIntent().getStringExtra("DNI_USUARIO"));
        usuarioseguro.setText(getIntent().getStringExtra("SEG_USUARIO"));
        fecha.setText(getIntent().getStringExtra("FEC_CITA"));
    }
}