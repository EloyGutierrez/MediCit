package moviles.aplicaciones.medicit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RegistrarActivity extends AppCompatActivity {
    Spinner combosexo,combomes,combodia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        combosexo = findViewById(R.id.idspinnerSexo);
        combomes = findViewById(R.id.idspinnermes);
        combodia = findViewById(R.id.idspinnerdia);
        //array para el spinner de sexo
        ArrayAdapter<CharSequence> sexoadapter= ArrayAdapter.createFromResource(this,R.array.combo_sexo,R.layout.spinner_item_estilos);
        combosexo.setAdapter(sexoadapter);
        //array para el spinner de mes
        ArrayAdapter<CharSequence> mesadapter= ArrayAdapter.createFromResource(this,R.array.combo_mes,R.layout.spinner_item_estilos);
        combomes.setAdapter(mesadapter);
        //array para el spinner de dia
        ArrayAdapter<CharSequence> diaadapter= ArrayAdapter.createFromResource(this,R.array.combo_dia,R.layout.spinner_item_estilos);
        combodia.setAdapter(diaadapter);

    }
}