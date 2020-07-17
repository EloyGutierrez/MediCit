package moviles.aplicaciones.medicit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RegistrarActivity extends AppCompatActivity {
    Spinner combosexo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        combosexo = findViewById(R.id.idspinnerSexo);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.combo_sexo,R.layout.spinner_item_estilos);
        combosexo.setAdapter(adapter);


    }
}