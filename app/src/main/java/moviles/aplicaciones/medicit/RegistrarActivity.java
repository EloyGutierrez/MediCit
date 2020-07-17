package moviles.aplicaciones.medicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RegistrarActivity extends AppCompatActivity {
    Spinner combosexo,combomes,combodia,comboseguro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        combosexo = findViewById(R.id.idspinnerSexo);
        combomes = findViewById(R.id.idspinnermes);
        combodia = findViewById(R.id.idspinnerdia);
        comboseguro = findViewById(R.id.idspinnerseguro);
        //array para el spinner de sexo
        ArrayAdapter<CharSequence> sexoadapter= ArrayAdapter.createFromResource(this,R.array.combo_sexo,R.layout.spinner_item_estilos);
        combosexo.setAdapter(sexoadapter);
        //array para el spinner de mes
        ArrayAdapter<CharSequence> mesadapter= ArrayAdapter.createFromResource(this,R.array.combo_mes,R.layout.spinner_item_estilos);
        combomes.setAdapter(mesadapter);
        //array para el spinner de dia
        ArrayAdapter<CharSequence> diaadapter= ArrayAdapter.createFromResource(this,R.array.combo_dia,R.layout.spinner_item_estilos);
        combodia.setAdapter(diaadapter);
        //array para el spinner de seguro
        ArrayAdapter<CharSequence> seguroadapter= ArrayAdapter.createFromResource(this,R.array.combo_seguro,R.layout.spinner_item_estilos);
        comboseguro.setAdapter(seguroadapter);

    }
    public void Principal(View view){
        Intent i =new Intent(this, PrincipalActivity.class);
        startActivity(i);
    }
}