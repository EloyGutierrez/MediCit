package moviles.aplicaciones.medicit;

import androidx.appcompat.app.AppCompatActivity;
import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;
import moviles.aplicaciones.medicit.utilidades.Utilidades;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity {
    Spinner combosexo,comboseguro;
    EditText edtdni, edtnombre, edtapellidopaterno, edtapellidomaterno, edtcorreo, edtcelular, edtcontrasenia, edtfechadenacimiento, edtcontraseniaa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        edtdni = findViewById(R.id.edtdni);
        edtnombre = findViewById(R.id.edtnombre);
        edtapellidopaterno = findViewById(R.id.edtapellidopaterno);
        edtapellidomaterno = findViewById(R.id.edtapellidomaterno);
        edtcorreo = findViewById(R.id.edtcorreo);
        edtcelular = findViewById(R.id.edtcelular);
        edtcontrasenia = findViewById(R.id.edtcontrasenia);
        edtcontraseniaa = findViewById(R.id.edtcontraseniaa);
        edtfechadenacimiento = findViewById(R.id.edtfechadenacimiento);
        combosexo = findViewById(R.id.idspinnerSexo);
        comboseguro = findViewById(R.id.idspinnerseguro);

        combosexo = findViewById(R.id.idspinnerSexo);
        comboseguro = findViewById(R.id.idspinnerseguro);
        //array para el spinner de sexo
        ArrayAdapter<CharSequence> sexoadapter= ArrayAdapter.createFromResource(this,R.array.combo_sexo,R.layout.spinner_item_estilos);
        combosexo.setAdapter(sexoadapter);
        //array para el spinner de seguro
        ArrayAdapter<CharSequence> seguroadapter= ArrayAdapter.createFromResource(this,R.array.combo_seguro,R.layout.spinner_item_estilos);
        comboseguro.setAdapter(seguroadapter);

    }
    public void Principal(View view){







    }
    }
