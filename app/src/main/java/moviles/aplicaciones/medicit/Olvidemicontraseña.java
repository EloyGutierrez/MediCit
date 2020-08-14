package moviles.aplicaciones.medicit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Olvidemicontraseña extends MainActivity {

    CheckBox checknumero,checkcorreo,checktengoproblemascomosiempre;
    Button continuar;
    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvidemicontrasena);

        checknumero=findViewById(R.id.checkBox);
        checkcorreo=findViewById(R.id.checkBox2);
        checktengoproblemascomosiempre=findViewById(R.id.checkBox3);

        continuar = findViewById(R.id.btnCContinuar);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"SE ENVIO NUEVA CONTRASEÑA",Toast.LENGTH_SHORT).show();
            }
        });

        checknumero.setText("Por SMS al número telefonico: "+getIntent().getStringExtra("USUARIO_CELULAR"));
        checkcorreo.setText("Por correo a la dirección: "+getIntent().getStringExtra("USUARIO_CORREO"));
        checktengoproblemascomosiempre.setText("Tengo problemas, no reconozco mis datos.");




    }
}
